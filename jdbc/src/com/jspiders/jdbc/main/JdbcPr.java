package com.jspiders.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;





public class JdbcPr {
	
	private static java.sql.CallableStatement statement;
	private static Connection connection;
	private static ResultSet resultSet;
	private static String query="call proc()";
	private static String driverPath="com.mysql.cj.jdbc.Driver";
	private static String dburl="jdbc:mysql://localhost:3306/wejm4db";
	private static String user="root";
	private static String password="Kaushal@9158";
	
	
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		
		
			
			
			
			try {
				Class.forName(driverPath);
				
				connection=DriverManager.getConnection(dburl,user,password);
				
				
			    statement=connection.prepareCall(query);
			    
			   
			   resultSet=statement.executeQuery();
			    
			    
			    
			    
			    
			   while (resultSet.next()) {
					System.out.println(resultSet.getInt(1)+"|"+
							           resultSet.getString(2)+"|"+
							           resultSet.getString(3)); 
				}
			   
			    
			    
			    statement.close();
			    connection.close();
			    //resultSet.close();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		
		
		
	}
	
	
	
	
	}
	
	
	

