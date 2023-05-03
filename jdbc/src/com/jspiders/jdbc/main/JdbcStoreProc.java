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

public class JdbcStoreProc {
	
	private static Connection connection;
	private static Statement statement;
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
			 
			 statement=connection.createStatement();
			 
			 resultSet=statement.executeQuery(properties.getProperty("query"));
			 
			 
			 while (resultSet.next()) {
				 Student student=new Student();
				 
				 student.setId(resultSet.getInt(1));
				 student.setName(resultSet.getString(2));
				 student.setStudentCol(resultSet.getString(3));
				 
				 System.out.println(student);
				
			}
			 
		} catch (SQLException|ClassNotFoundException|IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (connection !=null) {
					connection.close();
					}
				if (statement !=null) {
					statement.close();
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
