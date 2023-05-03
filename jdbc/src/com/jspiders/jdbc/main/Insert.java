package com.jspiders.jdbc.main; //Standardized Code
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Insert{
	
	private static Connection connection;
	private static Properties properties;
	private static FileReader fileReader;
	private static Statement statement;
	private static String filePath="D:\\WEJM4\\jdbc\\resources\\db_info2.Properties";
	private static int result;
	
	
	public static void main(String[] args) {
		
		try {
			//1
			Class.forName("com.mysql.cj.jdbc.Driver");
			fileReader=new FileReader(filePath);
			properties=new Properties();
			properties.load(fileReader);
			
			//2
			connection=DriverManager.getConnection(properties.getProperty("dburl"),properties);
			
			//3
			statement=connection.createStatement();
			result=statement.executeUpdate(properties.getProperty("query2"));
			
			//4
			System.out.println(result+"row(s) affected");
			
			//5
				
			statement.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
