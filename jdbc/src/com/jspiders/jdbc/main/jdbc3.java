package com.jspiders.jdbc.main;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class jdbc3 {
	
           private static Properties properties;
           private static Connection connection;
           private static FileReader fileReader;
           private static String filePath="D:\\WEJM4\\jdbc\\resources\\db_info2.Properties";
           
            
	

	public static void main(String[] args) {
		
		try {

			//1
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			FileReader fileReader=new FileReader(filePath);
			properties=new Properties();
			properties.load(fileReader);
			
			//2
			Connection connection=DriverManager.getConnection(properties.getProperty("dburl"),properties);
			
			//3
			Statement statement=connection.createStatement();
			 ResultSet resultSet=statement.executeQuery(properties.getProperty("query1"));
			 
			 //4
			 while (resultSet.next()) {System.out.println(resultSet.getInt(1)+"|"
					                                     +resultSet.getString(2)+"|"
					                                     +resultSet.getString(3));
				
				
			}
			 //5
			 statement.close();
			 connection.close();
			 resultSet.close();
			 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	

}
