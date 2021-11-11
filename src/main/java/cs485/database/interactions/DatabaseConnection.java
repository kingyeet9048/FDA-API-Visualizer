package cs485.database.interactions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cs485.preprocessing.DataCollector;
import cs485.preprocessing.Drug;
import cs485.preprocessing.Visit; 
public class DatabaseConnection{

	private final String url = "jdbc:mysql://localhost:3306";
	private Connection connection;
	private String username;
	private String password;
	private PreparedStatement preparedStatement;

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
	
	public boolean loadDatabase (Map<String, List<Visit>> map) {
		String insertIngredientQuery = "INSERT INTO FDA_Database.ingredients VALUES (?, ?, ?)";
		for (Map.Entry<String, List<Visit>> mapEntry : map.entrySet()) {
			String key = mapEntry.getKey();
			List<Visit> values = mapEntry.getValue();
			Map<String, Integer> atcCodesMap = new HashMap<String, Integer>();
			for (Visit visit : values) {
				for (Drug drug : visit.getDrug()) {
					if (drug.getAtcVetCode() == null) {
						continue;
					}
					if (drug.getAtcVetCode().equals("QA02BC01")) {
						System.out.println(drug.toString());
					}
					int current = atcCodesMap.getOrDefault(drug.getAtcVetCode(), 0);
					if (current == 0) {
						atcCodesMap.put(drug.getAtcVetCode(), 1);
					}
					else {
						atcCodesMap.put(drug.getAtcVetCode(), atcCodesMap.get(drug.getAtcVetCode()) + 1);
//						System.out.println(drug.toString());
					}
				}
			}
			System.out.println(atcCodesMap.toString());
		}
		return true;
	}
	
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
		connection.loadDatabase(dataCollector.getDowloadedData());
		connection.closeConnection();
	}

}
