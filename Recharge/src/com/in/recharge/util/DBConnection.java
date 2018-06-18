package com.in.recharge.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.in.recharge.exception.*;

public class DBConnection {
	
	private static Properties properties= new Properties();
	private static Connection connection;

	public static Connection getConnection() throws RechargeException{
		
		try {
			InputStream inputStream =new FileInputStream("Resources/jdbc.properties");
			properties.load(inputStream);
			String url=properties.getProperty("dburl");
			String user=properties.getProperty("username");
			String password=properties.getProperty("password");
			inputStream.close();
			
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver()); 
			connection = DriverManager.getConnection(url, user, password);
			
		} catch (FileNotFoundException e2) {
			throw new RechargeException("Could not Find properties file to connect to database.");
		} catch (IOException e) {
			throw new RechargeException("Could not read the database details from properties file.");
		} catch (SQLException e) {
			throw new RechargeException("Database connection problem.");
		}
		
		return connection;
	
	}

} 


