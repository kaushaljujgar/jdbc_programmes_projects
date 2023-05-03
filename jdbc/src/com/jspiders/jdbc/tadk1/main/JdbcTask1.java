package com.jspiders.jdbc.tadk1.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcTask1 {
	
	private static Connection connection;
	private static Statement statement;
	private static int result;
	private static ResultSet resultSet;
	private static FileReader fileReader;
	private static Properties properties;
	private static String filePath;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		
		try {
			filePath = "D:\\WEJM4\\jdbc\\resources\\db_infoTask1.Properties";
			
			fileReader = new FileReader(filePath);
			
			properties = new Properties();
			
			properties.load(fileReader);
			
			Class.forName(properties.getProperty("driverPath"));
			
			connection = DriverManager.getConnection(properties.getProperty("dburl"),properties);
			
			statement = connection.createStatement();
			
//			FOR CREATE TABLE
			result = statement.executeUpdate(properties.getProperty("createTable"));
			System.out.println(result + " row(s) affected");
			
//			FOR INSERT FIRST VALUE
            result = statement.executeUpdate(properties.getProperty("insertValueOne"));
			System.out.println(result + " row(s) affected");
			
//			FOR INSERT SECOUD VALUE
			 result = statement.executeUpdate(properties.getProperty("insertValueTwo"));
			System.out.println(result + " row(s) affected");
			
//			FOR INSERT THERD VALUE
			result = statement.executeUpdate(properties.getProperty("insertValueThree"));
			System.out.println(result + " row(s) affected");
			
//			FOR INSERT FOURTH VALUE
			result = statement.executeUpdate(properties.getProperty("insertValueFour"));
			System.out.println(result + " row(s) affected");
			
//			FOR INSERT FIFTH VALUE
			result = statement.executeUpdate(properties.getProperty("insertValueFive"));
			System.out.println(result + " row(s) affected");
			
			
			resultSet = statement.executeQuery(properties.getProperty("showData"));
			 while(resultSet.next()) {
				 System.out.println(resultSet.getString(1) + " | "
						 + resultSet.getString(2) + " | "
						 + resultSet.getString(3) + " | "
						 + resultSet.getString(4) + " | "
						 + resultSet.getString(5));
			 }
			 
//			 FOR UPDATE FIRST RECORD
			 result = statement.executeUpdate(properties.getProperty("updateValueFirst"));
			System.out.println(result + " row(s) affected");
				
//			 FOR UPDATE SECOUND RECORD
			 result = statement.executeUpdate(properties.getProperty("updateValueFSecound"));
			System.out.println(result + " row(s) affected");
			
			resultSet = statement.executeQuery(properties.getProperty("showData"));
			 while(resultSet.next()) {
				 System.out.println(resultSet.getString(1) + " | "
						 + resultSet.getString(2) + " | "
						 + resultSet.getString(3) + " | "
						 + resultSet.getString(4) + " | "
						 + resultSet.getString(5));
			 }
			 
//			 FOR DELETE ONE RECORD
			 result = statement.executeUpdate(properties.getProperty("deleteValue"));
			System.out.println(result + " row(s) affected");
			
			resultSet = statement.executeQuery(properties.getProperty("showData"));
			 while(resultSet.next()) {
				 System.out.println(resultSet.getString(1) + " | "
						 + resultSet.getString(2) + " | "
						 + resultSet.getString(3) + " | "
						 + resultSet.getString(4) + " | "
						 + resultSet.getString(5));
			 }
			 
			 
//			
			 
			 
		} catch (IOException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			
				try {
					if (connection != null) {
					connection.close();
					}
					if (statement != null) {
						statement.close();
						
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}


