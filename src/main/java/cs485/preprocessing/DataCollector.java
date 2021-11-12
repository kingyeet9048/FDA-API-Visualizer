/**
 *
 */
package cs485.preprocessing;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;

/**
 * @author rp5626vi
 *
 */
public class DataCollector {

	private Map<String, List<Visit>> dowloadedData = new HashMap<>();
	private String[] links;

	/**
	 * @param links
	 */
	public DataCollector(String[] links) {
		// TODO Auto-generated constructor stub
		System.out.println("Pair each link to a hashmap entry");
		for (String string : links) {
			dowloadedData.put(string, null);
		}
		this.links = links;
	}

	/**
	 * @return
	 * @throws IOException
	 */
	public Map<String, List<Visit>> fetchSaveData() throws IOException {
		System.out.println("Starting Data Fetch...");
		for (Map.Entry<String, List<Visit>> mapEntry : dowloadedData.entrySet()) {
			String key = mapEntry.getKey();
			System.out.println(key.toString() + " is the first link");
			URL url = new URL(key);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			InputStream in = connection.getInputStream();
			ZipInputStream zipIn = new ZipInputStream(in);
			ZipEntry entry = zipIn.getNextEntry();
			System.out.println("Downloaded Zipped Folder...");

			Gson gson = new Gson();
			while (entry != null) {
				System.out.print("Unzipping and peaking folder --- ");
				System.out.println(entry.getName());
				if (!entry.isDirectory()) {
					// if the entry is a file, extracts it
					System.out.println("No folder found. Found file instead. Opening Content...");
					JsonReader jsonReader = new JsonReader(new InputStreamReader(zipIn));
					JsonObject jsonObject = new JsonParser().parse(jsonReader).getAsJsonObject();
					JsonElement eJsonElement = jsonObject.get("results");
					System.out.println("Found the results element...");
					List<Visit> visit = new ArrayList<>();
					JsonArray jArray = eJsonElement.getAsJsonArray();
					for (int i = 0; i < jArray.size(); i += 1) {
						try {
							visit.add(gson.fromJson(jArray.get(i), Visit.class));

						} catch (IllegalStateException | JsonSyntaxException e) {
							continue;
						}
					}
					dowloadedData.put(key, visit);
					System.out.println(
							"Added and put visit list into hashmap. Will continue to next link if one exisits...");

				}
				zipIn.closeEntry();
				entry = zipIn.getNextEntry();

			}
		}
		System.out.println("Finished with all the links. Printing first element content of hashmap: "
				+ dowloadedData.get(links[0]).get(0).toString());
		return dowloadedData;
	}

	/**
	 * @return
	 */
	public Map<String, List<Visit>> getDowloadedData() {
		return dowloadedData;
	}

	/**
	 * @param dowloadedData
	 */
	public void setDowloadedData(Map<String, List<Visit>> dowloadedData) {
		this.dowloadedData = dowloadedData;
	}

	/**
	 * @return
	 */
	public String[] getLinks() {
		return links;
	}

	/**
	 * @param links
	 */
	public void setLinks(String[] links) {
		this.links = links;
	}

	public static void main(String args[]) {
		DataCollector dataCollector = new DataCollector(new String[] {
				"https://download.open.fda.gov/animalandveterinary/event/2021q1/animalandveterinary-event-0001-of-0001.json.zip",
				"https://download.open.fda.gov/animalandveterinary/event/2021q2/animalandveterinary-event-0001-of-0001.json.zip" });
		try {
			dataCollector.fetchSaveData();
			Map<String, List<Visit>> allVisitsMap = dataCollector.getDowloadedData();
			
			// types of animals present in database
			for (Map.Entry<String, List<Visit>> mapEntry : allVisitsMap.entrySet()) {
				String key = mapEntry.getKey();
				List<Visit> values = mapEntry.getValue();
				Map<String, Integer> animalTypes = new TreeMap<>();
				Map<String, Integer> brandNames = new TreeMap<>();
				Map<String, Integer> outcomeTypes = new TreeMap<>();
				Map<String, Integer> routes = new TreeMap<String, Integer>();
				Map<String, Integer> numAffected = new TreeMap<>();
				Map<String, Integer> organizationsMap = new TreeMap<>();
				Map<String, Integer> healthMap = new TreeMap<>();
				
				System.err.printf("\n\nSummery For %s: \n", key);
				
				// all visits
				for (Visit visit : values) {
					// current vist
					Animal currentAnimal = visit.getAnimal();
					if (currentAnimal != null) {
						int animalCount = animalTypes.getOrDefault(currentAnimal.getSpecies(), 0);
						if (animalCount == 0) {
							animalTypes.put(currentAnimal.getSpecies(), 1);
						}
						else {
							animalTypes.put(currentAnimal.getSpecies(), animalCount + 1);
						}
					}
					List<Drug> drugs = visit.getDrug();
					if (drugs != null) {
						for (Drug drug : drugs) {
							if (drug.getAdministeredBy() == null) {
								continue;
							}
							int brandCount = brandNames.getOrDefault(drug.getAdministeredBy(), 0);
							if (brandCount == 0) {
								brandNames.put(drug.getAdministeredBy(), 1);
							}
							else {
								brandNames.put(drug.getAdministeredBy(), brandCount + 1);

							}
						}
						for (Drug drug : drugs) {
							if (drug.getRoute() == null) {
								continue;
							}
							int routeCount = routes.getOrDefault(drug.getRoute(), 0);
							if (routeCount == 0) {
								routes.put(drug.getRoute(), 1);
							}
							else {
								routes.put(drug.getRoute(), routeCount + 1);

							}
						}
					}
					List<Outcome> outcomes = visit.getOutcome();
					if (outcomes != null) {
						for (Outcome out : outcomes) {
							int outcomeCount = outcomeTypes.getOrDefault(out.getMedicalStatus(), 0);
							if (outcomeCount == 0) {
								outcomeTypes.put(out.getMedicalStatus(), 1);
							}
							else {
								outcomeTypes.put(out.getMedicalStatus(), outcomeCount + 1);
							}
							int numCount = numAffected.getOrDefault(out.getNumberOfAnimalsAffected(), 0);
							if (numCount == 0) {
								numAffected.put(out.getNumberOfAnimalsAffected(), 1);
							}
							else {
								numAffected.put(out.getNumberOfAnimalsAffected(), numCount + 1);
							}
						}
					}
					HealthAssessmentPriorToExposure health = visit.getHealthAssessmentPriorToExposure();
					if (health != null) {
						if (health.getCondition() == null) {
							continue;
						}
						int healthCount = healthMap.getOrDefault(health.getCondition(), 0);
						if (healthCount == 0) {
							healthMap.put(health.getCondition(), 1);
						}
						else {
							healthMap.put(health.getCondition(), healthCount + 1);

						}
					}
					Receiver receiver = visit.getReceiver();
					if (receiver != null) {
						if (receiver.getOrganization() == null) {
							continue;
						}
						int receiverCount = organizationsMap.getOrDefault(receiver.getOrganization(), 0);
						if (receiverCount == 0) {
							organizationsMap.put(receiver.getOrganization(), 1);
						}
						else {
							organizationsMap.put(receiver.getOrganization(), receiverCount + 1);
						}
					}
				}
				System.out.printf("Number of Records (Vets visits): \n%d\n", values.size());
				System.out.printf("Animal Counts: \n%s\n", animalTypes.toString());
				System.out.printf("Drug Administration Distribution: \n%s\n", brandNames.toString());
				System.out.printf("How the drug was taken distribution (Route): \n%s\n", routes.toString());
				System.out.printf("Outcome Distribution: \n%s\n", outcomeTypes.toString());
				System.out.printf("Number of Animals Affected in a visit at a time: \n%s\n", numAffected.toString());
				System.out.printf("Health Assesment Prior to Exposure Distribution: \n%s\n", healthMap.toString());
				System.out.printf("Organization Distribution: \n%s\n", organizationsMap.toString());
			}			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
