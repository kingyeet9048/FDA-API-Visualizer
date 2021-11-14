package cs485.database.interactions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import cs485.preprocessing.*;

public class DatabaseConnection{

	private final String url = "jdbc:mysql://localhost:3306";
	private Connection connection;
	private String username;
	private String password;
	private PreparedStatement preparedStatement;
	List<String> addedIds = new ArrayList<>();
	List<String> addedDrugIds = new ArrayList<>();
	List<String> addedIngredientName = new ArrayList<>();
	List<String> addedVetCode = new LinkedList<>();
	List<String> names = new LinkedList<>();
	List<String> address = new LinkedList<>();
	List<String> vet = new LinkedList<>();
	List<String> org = new LinkedList<>();
	List<String> orgId = new LinkedList<>();
	List<String> appointmentID = new LinkedList<>();
	List<String> appointmentOutID = new LinkedList<>();
	List<String> recordID = new LinkedList<>();

	private List<String> addedOwnerID = new LinkedList<>();
	private List<String> addedAnimalID = new LinkedList<>();
	private List<String> addedVetID = new LinkedList<>();

	Map<String, String> anApp = new HashMap<>();
	Map<String, String> anAppOut = new HashMap<>();
	String[] loginIDS = new String[1000];
	

	public DatabaseConnection() {
	}
	
	public void newDatabaseConnection () {
		try {
			loadCredentials();
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			setConnection(DriverManager.getConnection(url, username, password));
			
		} catch (ClassNotFoundException e) {
			System.out.println("New connection cannot find driver...: " + e.getMessage());
		} catch (SQLException e1) {
			System.out.println("URL, username, or password incorrect. Please check and try again: " + e1.getMessage());
		}
	}

	public Connection getConnection() {
		return connection;
	}

	private void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	private void loadCredentials () {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(".env")));
			username = reader.readLine();
			password = reader.readLine();
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Cannot read .env file...: " + e.getMessage());
		}
	}
	
	public boolean isConnectionAlive() {
		try {
			return !connection.isClosed();
		} catch (SQLException e) {
			System.out.println("Connection error. No connection to read. Please make a new connection first: " + e.getMessage());
		}
		return false;
	}
	
	public boolean closeConnection () {
		try {
			connection.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Could not close the connection for some reason: " + e.getMessage());
		}
		return false;
	}
	
	public boolean checkCredentials (String username, String password) {
		String query = "SELECT username, passwords, isActive FROM FDA_Database.Login WHERE username = ? and passwords = ?";
		
		try {
			preparedStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet set = preparedStatement.executeQuery();
			set.last();
			int rowNumber = set.getRow();
			if (rowNumber > 0) {
				set.first();
				String isActive = set.getString(3);
				if (isActive.equals("1")) {
					set.close();
					return true;
				}
				else {
					set.close();
					return false;
				}
			}
			else {
				set.close();
				return false;
			}
		} catch (SQLException e) {
			System.out.printf("Something went wrong...: %s", e.getMessage());
			return false;
		}

	}
	
	public String getNewID (List<String> ids) {
		String uniqueID;
		while (true) {
			uniqueID = UUID.randomUUID().toString().substring(0, 18);
			if (ids.contains(uniqueID)) {
				continue;
			}
			else {
				break;
			}
		}
		return uniqueID;
	}
	
	private String addIngredients (ActiveIngredient ingredient) throws SQLException {
		String insertIngredientQuery = "INSERT INTO FDA_Database.ingredients VALUES (?, ?, ?)";
		String getIngredientID = "SELECT In_id FROM FDA_Database.ingredients WHERE Active_ingredients = ?";
		preparedStatement = connection.prepareStatement(getIngredientID, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		preparedStatement.setString(1, ingredient.getName());
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		resultSet.last();
		int rowNumber = resultSet.getRow();
		if (rowNumber > 0) {
			resultSet.first();
			String idString = resultSet.getString(1);
			resultSet.close();
			return idString;
		}
		else {
			StringBuilder builder = new StringBuilder();
			String id = getNewID(addedIds);
			String name = ingredient.getName();
			builder.append(ingredient.getDose().getDenominator() + " ");
			builder.append(ingredient.getDose().getDenominatorUnit() + " ");
			builder.append(ingredient.getDose().getNumerator() + " ");
			builder.append(ingredient.getDose().getNumeratorUnit() + " ");
			String dose = builder.toString().trim();
			preparedStatement = connection.prepareStatement(insertIngredientQuery);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, dose);
			preparedStatement.executeUpdate();
			addedIds.add(id);
			addedIngredientName.add(name);
			return id;
		}
	}
	
	public void addDrug (List<Drug> drugs) throws SQLException {
		String insertDrug = "INSERT INTO FDA_Database.Drug VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String insertDrugIngredients = "INSERT INTO FDA_Database.Drug_ingredient VALUES (?, ?)";
		String insertExposure = "INSERT INTO FDA_Database.Exposure VALUES (?, ?, ?)";

		for (Drug drug : drugs) {
			// check to see if the atc vet code is contained within the list
			// if it is, continue, aready processed it. 
			if (addedVetCode.contains(drug.getAtcVetCode())) {
				continue;
			}
			// add a new drug...
			preparedStatement = connection.prepareStatement(insertDrug);
			String drugId = getNewID(addedDrugIds);
			preparedStatement.setString(1, drugId);
			preparedStatement.setString(2, drug.getLotNumber());
			preparedStatement.setString(3, drug.getAdministeredBy());
			preparedStatement.setString(4, drug.getRoute());
			preparedStatement.setString(5, drug.getUsedAccordingToLabel());
			preparedStatement.setString(6, drug.getBrandName());
			preparedStatement.setString(7, drug.getDosageForm());
			preparedStatement.setString(8, drug.getManufacturer().getName() + " " + drug.getManufacturer().getRegistrationNumber());
			preparedStatement.setString(9, drug.getAtcVetCode());
			preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement(insertExposure);
			preparedStatement.setString(1, drugId);
			preparedStatement.setString(2, drug.getFirstExposureDate());
			preparedStatement.setString(3, drug.getLastExposureDate());
			preparedStatement.executeUpdate();
			for (ActiveIngredient ingredient : drug.getActiveIngredients()) {
				if (ingredient.getName() == null) {
					continue;
				}
				String id = addIngredients(ingredient);
				preparedStatement = connection.prepareStatement(insertDrugIngredients);
				preparedStatement.setString(1, drugId);
				preparedStatement.setString(2, id);
				preparedStatement.executeUpdate();
			}
			addedVetCode.add(drug.getAtcVetCode());
			addedDrugIds.add(drugId);

		}
		
	}
	
	public void addOwners () throws IOException, SQLException {
		BufferedReader namesReader = new BufferedReader(new FileReader (new File("names.txt")));
		BufferedReader addressReader = new BufferedReader(new FileReader(new File("address.txt")));
		
		String line = namesReader.readLine();
		while (line != null) {
			if (!names.contains(line)) {
				names.add(line);
			}
			line = namesReader.readLine();
		}
		line = addressReader.readLine();
		while (line != null) {
			if (line.contains("address1")) {
				line = line.replace("address1 ", "");
				if (!address.contains(line)) {
					address.add(line);
				}
			}
			line = addressReader.readLine();
		}
		namesReader.close();
		addressReader.close();
		String insertOwner = "INSERT INTO FDA_Database.Owners VALUES (?, ?, ?)";
		int counter = 0;
		for (String name : names) {
			preparedStatement = connection.prepareStatement(insertOwner);
			String id = getNewID(addedOwnerID);
			preparedStatement.setString(1, id);
			if (counter >= address.size()) {
				counter = 0;
			}
			preparedStatement.setString(2, address.get(counter));
			preparedStatement.setString(3, name);
			preparedStatement.executeUpdate();
			counter++;
			addedOwnerID.add(id);
		}
	}
	
	public void addAnimal (Animal animal) throws SQLException {
		String insertAnimal = "INSERT INTO FDA_Database.Animal VALUES (?, ?, ?, ?, ?, ? ,?)";
		preparedStatement = connection.prepareStatement(insertAnimal);
		String id = getNewID(addedAnimalID );
		preparedStatement.setString(1, id);
		preparedStatement.setString(2, animal.getSpecies());
		preparedStatement.setString(3, animal.getGender());
		preparedStatement.setString(4, animal.getReproductiveStatus());
		preparedStatement.setString(5, animal.getFemaleAnimalPhysiologicalStatus());
		preparedStatement.setString(6, animal.getAge().getQualifier());
		preparedStatement.setString(7, animal.getWeight() != null ? animal.getWeight().getQualifier() + " " + animal.getWeight().getUnit() : null);
		preparedStatement.executeUpdate();
		addedAnimalID.add(id);
		
	}
	
	public void addVet () throws IOException, SQLException {
		System.out.println("Adding Vets...");
		BufferedReader vetReader = new BufferedReader(new FileReader(new File("vet.txt")));
		
		String line = vetReader.readLine();
		while (line != null) {
			if (!vet.contains(line)) {
				vet.add(line);
			}
			line = vetReader.readLine();
		}
		
		for (String vet : vet) {
			String insertVet = "INSERT INTO FDA_Database.Vet VALUES (?, ?)";
			
			preparedStatement = connection.prepareStatement(insertVet);
			String id = getNewID(addedVetID);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, vet);
			preparedStatement.executeUpdate();
			addedVetID.add(id);
		}
		vetReader.close();
	}
	
	public void addOrganization (Receiver receiver) throws SQLException {
		if (!org.contains(receiver.getOrganization()) && receiver.getOrganization() != null) {
			String insertOrg = "INSERT INTO FDA_Database.Organizations VALUES (?, ?, ?)";
			preparedStatement = connection.prepareStatement(insertOrg);
			String id = getNewID(orgId);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, receiver.getStreetAddress() + " "+ receiver.getCity() + " " + receiver.getCountry() + " " + receiver.getState() + " " + receiver.getPostalCode());
			preparedStatement.setString(3, receiver.getOrganization());
			preparedStatement.executeUpdate();
			org.add(receiver.getOrganization());
			orgId.add(id);
		}
	}
	
	public void addAppointment (Visit visit) throws SQLException {
		String insertAppoint = "INSERT INTO FDA_Database.Appointment VALUES(?, ?, ?)";
		preparedStatement = connection.prepareStatement(insertAppoint);
		String id = getNewID(appointmentID);
		preparedStatement.setString(1, id);
		Random rand = new Random();
		int randomNumber = rand.nextInt(addedVetID.size());
		preparedStatement.setString(2, addedVetID.get(randomNumber));
		preparedStatement.setString(3, visit.getOnsetDate());
		preparedStatement.executeUpdate();
		appointmentID.add(id);
	}
	
	public void addAppointmentOUt (Visit visit) throws SQLException {
		String insertAppoint = "INSERT INTO FDA_Database.Appointment_Outcome VALUES(?, ?, ?)";
		preparedStatement = connection.prepareStatement(insertAppoint);
		String id = getNewID(appointmentOutID);
		preparedStatement.setString(1, id);
		preparedStatement.setString(2, visit.getOutcome() != null ? visit.getOutcome().get(0).getMedicalStatus() : null);
		preparedStatement.setString(3, visit.getOutcome() != null ? visit.getOutcome().get(0).getNumberOfAnimalsAffected() : null);
		preparedStatement.executeUpdate();
		appointmentOutID.add(id);
	}
	
	public boolean checkAnimal(Map<String, String> checking, String animal, String idToCheck) {
		for (String ids : checking.get(animal).split(" ")) {
			if (ids.equals(idToCheck)) {
				return true;
			}
		}
		return false;
	}
	
	public void addAnimalAsso () throws SQLException {
		String insertAppAnimal = "INSERT INTO FDA_Database.Appointment_Animals VALUES(?, ?)";
		String insertAnimalOut = "INSERT INTO FDA_Database.Animal_Outcome VALUES(?, ?)";
		String insertRecordAnimal = "INSERT INTO FDA_Database.Animals_in_Records VALUES(?, ?)";

		System.out.println("Adding Animal Associations...");
		Map<String, String> recordAnimals = new HashMap<>();
		
		for (int i = 0; i < 100; i++) {
			Random random = new Random();
			String currentAnimal = addedAnimalID.get(random.nextInt(addedAnimalID.size()));
			boolean isThere = anApp.getOrDefault(currentAnimal, null) != null || anAppOut.getOrDefault(currentAnimal, null) != null;
			if (isThere) {
				int randomAppointment = random.nextInt(appointmentID.size());
				int randomAppOut = random.nextInt(appointmentOutID.size());
				String appID = appointmentID.get(randomAppointment);
				String appOutID = appointmentOutID.get(randomAppOut);
				while (true) {
					if (checkAnimal(anApp, currentAnimal, appID)) {
						randomAppointment = random.nextInt(appointmentID.size());
						appID = appointmentID.get(randomAppointment);
						continue;
					}
					else {
						break;
					}
				}
				while (true) {
					if (checkAnimal(anAppOut, currentAnimal, appOutID)) {
						randomAppOut = random.nextInt(appointmentOutID.size());
						appOutID = appointmentOutID.get(randomAppOut);
						continue;
					}
					else {
						break;
					}
				}
				preparedStatement = connection.prepareStatement(insertAppAnimal);
				preparedStatement.setString(1, appID);
				preparedStatement.setString(2, currentAnimal);
				preparedStatement.executeUpdate();
				preparedStatement = connection.prepareStatement(insertAnimalOut);
				preparedStatement.setString(1, appOutID);
				preparedStatement.setString(2, currentAnimal);
				preparedStatement.executeUpdate();
				anApp.put(currentAnimal, anApp.get(currentAnimal) + " " + appID);
				anAppOut.put(currentAnimal, anAppOut.get(currentAnimal) + " " + anAppOut);
			}
			else {
				int randomAppointment = random.nextInt(appointmentID.size());
				int randomAppOut = random.nextInt(appointmentOutID.size());
				String appID = appointmentID.get(randomAppointment);
				String appOutID = appointmentOutID.get(randomAppOut);
				preparedStatement = connection.prepareStatement(insertAppAnimal);
				preparedStatement.setString(1, appID);
				preparedStatement.setString(2, currentAnimal);
				preparedStatement.executeUpdate();
				preparedStatement = connection.prepareStatement(insertAnimalOut);
				preparedStatement.setString(1, appOutID);
				preparedStatement.setString(2, currentAnimal);
				preparedStatement.executeUpdate();
				anApp.put(currentAnimal, appID);
				anAppOut.put(currentAnimal, appOutID);
			}
			if (recordAnimals.getOrDefault(currentAnimal, null) != null) {
				int randomRecord = random.nextInt(recordID.size());
				String currentRecordID = recordID.get(randomRecord);
				while (true) {
					if (checkAnimal(recordAnimals, currentAnimal, currentRecordID)) {
						randomRecord = random.nextInt(recordID.size());
						currentRecordID = recordID.get(randomRecord);
						continue;
					}
					else {
						break;
					}
				}
				preparedStatement = connection.prepareStatement(insertRecordAnimal);
				preparedStatement.setString(1, currentRecordID);
				preparedStatement.setString(2, currentAnimal);
				preparedStatement.executeUpdate();
				recordAnimals.put(currentAnimal, recordAnimals.get(currentAnimal) + " " + currentRecordID);
			}
			else {
				int randomRecord = random.nextInt(recordID.size());
				String currentRecordID = recordID.get(randomRecord);
				preparedStatement = connection.prepareStatement(insertRecordAnimal);
				preparedStatement.setString(1, currentRecordID);
				preparedStatement.setString(2, currentAnimal);
				preparedStatement.executeUpdate();
				recordAnimals.put(currentAnimal, currentRecordID);
			}
		}
		
	}
	
	public void addLogin () throws SQLException {
		String insertLogin = "INSERT INTO FDA_Database.Login VALUES(?, ?, ?)";
		System.out.println("Adding login info...");
		loginIDS = new String[vet.size()];
		for (int i = 0; i < vet.size(); i++) {
			preparedStatement = connection.prepareStatement(insertLogin);
			String id = getNewID(addedDrugIds);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, getNewID(addedDrugIds));
			preparedStatement.setString(3, getNewID(addedDrugIds).substring(0, 7));
			preparedStatement.executeUpdate();
			loginIDS[i] = id;
		}
	}
	
	public void addVetCred () throws SQLException {
		String insertLogin = "INSERT INTO FDA_Database.OR_Vet_Login VALUES(?, ?, ?, ?)";
		int counter = 0;
		System.out.println("Adding Vet Cred..");
		for (String vet : addedVetID) {
			preparedStatement = connection.prepareStatement(insertLogin);
			String id = getNewID(new ArrayList<String>());
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, orgId.get(0));
			preparedStatement.setString(3, vet);
			preparedStatement.setString(4, loginIDS[counter]);
			preparedStatement.executeUpdate();
			counter++;
		}
	}
	
	public void addRecords () throws SQLException {
		String insertLogin = "INSERT INTO FDA_Database.Records VALUES(?, ?, ?)";
		int counter = 0;
		System.out.println("Adding Records...");
		for (String owner : addedOwnerID) {
			preparedStatement = connection.prepareStatement(insertLogin);
			String id = getNewID(recordID);
			preparedStatement.setString(1, id);
			if (counter >= addedVetID.size()) {
				counter = 0;
			}
			preparedStatement.setString(2, addedVetID.get(counter));
			preparedStatement.setString(3, owner);
			preparedStatement.executeUpdate();
			counter++;
			recordID.add(id);
		}
	}
	
	public void addDrugsInRecords () throws SQLException {
		System.out.println("Adding Drugs to Records...");
		for (String drugID : addedDrugIds) {
			Random random = new Random();
			int randomNumber = random.nextInt(recordID.size());
			String currentRecord = recordID.get(randomNumber);
			preparedStatement = connection.prepareStatement("INSERT INTO FDA_Database.Drugs_in_Records VALUES (?, ?)");
			preparedStatement.setString(1, currentRecord);
			preparedStatement.setString(2, drugID);
			preparedStatement.executeUpdate();
		}
	}
	
	public boolean loadDatabase (Map<String, List<Visit>> map) throws SQLException, IOException {
		addVet();
		addOwners();
		addLogin();
		for (Map.Entry<String, List<Visit>> mapEntry : map.entrySet()) {
			List<Visit> values = mapEntry.getValue();
			for (Visit visit : values) {
				addAppointment(visit);
				addAppointmentOUt(visit);
				if (visit.getReceiver() != null) {
					addOrganization(visit.getReceiver());
				}
				addDrug(visit.getDrug());
				if (visit.getAnimal() != null) {
					addAnimal(visit.getAnimal());
				}
			}
		}
		addVetCred();
		addRecords();
		addDrugsInRecords();
		addAnimalAsso();
		return true;
	}
	
	/**
	 * Run this as a java program to laod data into your database....
	 * @param args
	 */
	public static void main(String args[]) {
		DataCollector dataCollector = new DataCollector(new String[] {
				"https://download.open.fda.gov/animalandveterinary/event/2021q1/animalandveterinary-event-0001-of-0001.json.zip",
				"https://download.open.fda.gov/animalandveterinary/event/2021q2/animalandveterinary-event-0001-of-0001.json.zip" });
		try {
			dataCollector.fetchSaveData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DatabaseConnection connection = new DatabaseConnection();
		connection.newDatabaseConnection();
		System.out.println(connection.isConnectionAlive());
		try {
			connection.loadDatabase(dataCollector.getDowloadedData());
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection.closeConnection();
	}

}
