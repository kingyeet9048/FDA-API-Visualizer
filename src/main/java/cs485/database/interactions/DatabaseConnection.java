package cs485.database.interactions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Map;

import cs485.preprocessing.Visit; 
public class DatabaseConnection{

	private final String url = "jdbc:mysql://localhost:3306";
	private Connection connection;
	private String username;
	private String password;

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
	
	public boolean loadDatabase (Map<String, Visit> visits) {
		// ingrediants 
			// needs
				// pk int
				//active ingredients string
				// dose string
		// Drug
			//needs
				// indredien
		return true;
	}
	
	public static void main(String args[]) {
		DatabaseConnection connection = new DatabaseConnection();
		connection.newDatabaseConnection();
		System.out.println(connection.isConnectionAlive());
		connection.closeConnection();
	}

}
