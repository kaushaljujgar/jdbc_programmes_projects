package com.jspiders.jdbc.main.task1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Task1 {
	private static Statement statement;
	private static Connection connection;
	private static ResultSet resultSet;
	private static int result;
	//private static String filePath="D:\\WEJM4\\jdbc\\resources\\db_infotask1.Properties";
	//private static FileReader fileReader;
	//private static Properties properties;
	
	         private static String query1 = "insert into employee3 values (1, 'Kaushal', 9584585248, 'WAKAD', 'PUNE')";
			 private static String query2 = "insert into employee3 values (2, 'Rahul', 84509823987, 'DANGE CHOUK', 'PUNE')";
			 private static String query3 = "insert into employee3 values (3, 'Suraj', 7690534720, 'BHOSRI', 'PUNE')";
			 private static String query4 = "insert into employee3 values (4, 'Akash', 8562309593, 'KALEWADI', 'PUNE')";
			 private static String query5 = "insert into employee3 values (5, 'Nitesh', 9977308756, 'KHARDI', 'PUNE')";
			 private static String query6 = "select * from employee3";
			 private static String query7 =  "update employee3 set empName = 'AALESH' where empId = 1";
			 private static String query8 = "update employee3 set empCity = 'BHOSRI' where empId = 2";
			 private static String query9 = "delete from employee where empId = 5";
			 private static String user = "root";
			 private static String password= "Kaushal@9158";
			 private static String driverPath = "com.mysql.cj.jdbc.Driver";
			 private static String dburl = "jdbc:mysql://localhost:3306/wejm4db";
	
	
	
	private static void openConnection() {
		
		
		try {
			Class.forName(driverPath);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			connection=DriverManager.getConnection(dburl);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			statement=connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static void closeConnection() throws SQLException {
		
		if (statement !=null) {
			statement.close();
			
		}
		if (connection !=null) {
			connection.close();
			
		}
		if (resultSet !=null) {
			resultSet.close();
			
		}
	}
	
	 public static void main(String[] args) throws SQLException {
			
		 openConnection();
		 
		 
		result=statement.executeUpdate(query1);
		
		 result=statement.executeUpdate(query2);
		 result=statement.executeUpdate(query3);
		 result=statement.executeUpdate(query4);
		 result=statement.executeUpdate(query5);
		 
		 resultSet=statement.executeQuery(query6);
		 
		 while(resultSet.next()) {System.out.println(resultSet.getInt(1)+"|"
				                                    +resultSet.getInt(2)+"|"
				                                    +resultSet.getInt(3)+"|"
				                                    +resultSet.getInt(4)+"|"
				                                    +resultSet.getInt(5));
		 }
		 
		 
		 result=statement.executeUpdate(query7);
		 result=statement.executeUpdate(query8);
		 
		 resultSet=statement.executeQuery(query6);
		 
		 while(resultSet.next()) {System.out.println(resultSet.getInt(1)+"|"
                 +resultSet.getInt(2)+"|"
                 +resultSet.getInt(3)+"|"
                 +resultSet.getInt(4)+"|"
                 +resultSet.getInt(5));
		 }
		 
		 result=statement.executeUpdate(query9);
		 
 resultSet=statement.executeQuery(query6);
		 
		 while(resultSet.next()) {System.out.println(resultSet.getInt(1)+"|"
                 +resultSet.getInt(2)+"|"
                 +resultSet.getInt(3)+"|"
                 +resultSet.getInt(4)+"|"
                 +resultSet.getInt(5));
		 
		 
			 
		 }
	}

	
	
		
		
	}
