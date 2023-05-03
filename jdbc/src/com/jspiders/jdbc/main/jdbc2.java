package com.jspiders.jdbc.main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class jdbc2 {
	
	public static void main(String[] args) {
		
		
		try {
			
			//1
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/wejm4db","root","Kaushal@9158");
			
			//3
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from student");
			
			//4
			while (resultSet.next()) {System.out.println(resultSet.getInt(1)+"|"
					                                    +resultSet.getString(2)+"|"
					                                    +resultSet.getString(3));
				
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
		
		
	


