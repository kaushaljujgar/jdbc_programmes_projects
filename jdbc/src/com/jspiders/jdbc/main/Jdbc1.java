package com.jspiders.jdbc.main;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Jdbc1 {
	
	
	
	
	public static void main(String[] args)  {
		
		
		
		
		try {
			//1 Load The Driver Class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2 OpenConnection
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/wejm4db?user=root&password=Kaushal@9158");
			
			//3 Create Or Prepare Statement-1-create 2-Execute
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from student");
			
			//4 process this result
			while (resultSet.next()) {System.out.println(resultSet.getInt(1)+"|"
					                                    +resultSet.getString(2)+"|"
					                                    +resultSet.getString(3));
					                                    
				
			}
			
			// 5 Close The Connection
						statement.close();
						connection.close();
						resultSet.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   
	}
}