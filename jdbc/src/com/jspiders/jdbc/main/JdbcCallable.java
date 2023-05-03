package com.jspiders.jdbc.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcCallable {
	
	private static Connection connection;
	private static CallableStatement callableStatement;
	private static ResultSet resultSet;
	private static FileReader fileReader;
	private static Properties properties;
	private static String filePath="D:\\WEJM4\\jdbc\\resources\\db_info.Properties";
	
	
	public static void main(String[] args) {
		
		try {
			
			 fileReader=new FileReader(filePath);
			 properties=new Properties();
			 properties.load(fileReader);
			 
			 
			 Class.forName(properties.getProperty("driverPath"));
			 
			 connection=DriverManager.getConnection(properties.getProperty("dburl"),properties);
			 
			//String query1="call proc2()";
			 
			 callableStatement = connection.prepareCall(properties.getProperty("query1"));
			 
			 resultSet=callableStatement.executeQuery();
			 
			 
			 while (resultSet.next()) {
				 
				System.out.println(resultSet.getInt(1)+"|"
						          +resultSet.getString(2)+"|"
						          +resultSet.getString(3));
				
			}
			 
		} catch (SQLException|ClassNotFoundException|IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (connection !=null) {
					connection.close();
					}
				if (callableStatement !=null) {
					callableStatement.close();
			}
				if (resultSet !=null) {
					resultSet.close();
		}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	
	}

}
