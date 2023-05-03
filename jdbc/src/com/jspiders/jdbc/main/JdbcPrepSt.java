package com.jspiders.jdbc.main;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class JdbcPrepSt {
	
	
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static int result;
	private static FileReader fileReader;
	private static Properties properties;

	private static String filePath="D:\\WEJM4\\jdbc\\resources\\db_infoprepst.Properties";
    private static Scanner scanner=new Scanner(System.in);
    
    public static void main(String[] args) {
    	
    	try {
			
    		fileReader=new FileReader(filePath);
    		properties=new Properties();
    		properties.load(fileReader);
    		
    		Class.forName(properties.getProperty("driverPath"));
    		
    		connection=DriverManager.getConnection(properties.getProperty("dburl"),properties);
    		
    		preparedStatement=connection.prepareStatement(properties.getProperty("query"));
    		
    		
    		System.out.println("Enter Id Of Student");
    		
    		
    		
    		int Id=scanner.nextInt();
    		preparedStatement.setInt(1,Id);
    		
    		System.out.println("Enter Name Of Student");
    		String Name=scanner.next();
    		preparedStatement.setString(2,Name);
    		
    		System.out.println("Enter Studentno. Of Student");
    		String Studentno=scanner.next();
    		preparedStatement.setString(3,Studentno);
    		
    		result=preparedStatement.executeUpdate();
    		
    		
    		
    		System.out.println(result+"row(s) affected");
    		
    		
    		
		} catch (SQLException|ClassNotFoundException|IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (scanner != null) {
					scanner.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
