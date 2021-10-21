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
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

/**
 * @author rp5626vi
 *
 */
public class DataCollector {
	private Map<String, List<Visit>> dowloadedData = new HashMap<>();

	/**
	 * 
	 */
	public DataCollector(String[] links) {
		// TODO Auto-generated constructor stub
		for (String string : links) {
			dowloadedData.put(string, null);
		}
	}

	public void fetchSaveData() throws IOException {
		for (Map.Entry<String, List<Visit>> mapEntry : dowloadedData.entrySet()) {
			String key = mapEntry.getKey();
//			ZipFile val = entry.getValue();
			
			URL url = new URL(key);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			InputStream in = connection.getInputStream();
			ZipInputStream zipIn = new ZipInputStream(in);
			ZipEntry entry = zipIn.getNextEntry();
			
			Gson gson = new Gson();
			while (entry != null) {

				System.out.println(entry.getName());
				if (!entry.isDirectory()) {
					// if the entry is a file, extracts it
					System.out.println("===File===");
					JsonReader jsonReader = new JsonReader(new InputStreamReader(zipIn));
					JsonObject jsonObject = new JsonParser().parse(jsonReader).getAsJsonObject();
					JsonElement eJsonElement = jsonObject.get("results");
					List<Visit> visit = new ArrayList<>();
					JsonArray jArray = eJsonElement.getAsJsonArray();
					for (int i = 0; i < jArray.size(); i+=2) {
						visit.add(gson.fromJson(jArray.get(i), Visit.class));
					}
					dowloadedData.put(key, visit);
					
				} else {
					System.out.println("===Directory===");
				}
				zipIn.closeEntry();
				entry = zipIn.getNextEntry();

			}
			
			
			
		}
	}
	
	public static void main (String args[]) {
		DataCollector dataCollector = new DataCollector(new String[] {
				"https://download.open.fda.gov/animalandveterinary/event/2021q1/animalandveterinary-event-0001-of-0001.json.zip",
				"https://download.open.fda.gov/animalandveterinary/event/2021q2/animalandveterinary-event-0001-of-0001.json.zip"});
		try {
			dataCollector.fetchSaveData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
