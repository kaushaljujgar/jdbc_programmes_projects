package com.jspiders.jdbc.main; //Standardized Code
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcDelete{
	private static Connection connection;
	private static Statement statement;
	private static int result;
	private static FileReader fileReader;
	private static Properties Properties;
	private static String driverPath="com.mysql.cj.jdbc.Driver";
	private static String dburl="jdbc:mysql://localhost:3306/wejm4db";
	private static String filePath="D:\\WEJM4\\jdbc\\resources\\db_info.Properties";
	private static String query="delete from student where name='Roshini' ";

	public static void main(String[] args) {
		try {
			//1
			Class.forName(driverPath);
			//Loading The db_info File In FileReader Object
			FileReader fileReader=new FileReader(filePath);
			
			//Loading The File As Properties Of jdbc
			Properties properties=new Properties();
			properties.load(fileReader);
			
			//2
			Connection connection=DriverManager.getConnection(dburl,properties);
			                                                                                        //Reff Var Of Properties Class
			//3
			Statement statement=connection.createStatement();
			result=statement.executeUpdate(query);
			//4
			System.out.println(result+"row(s) affected");
				
				
		} catch (ClassNotFoundException|IOException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if (connection !=null) {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				if (statement !=null) {
					try {
						statement.close();
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
					
				}
				
			}
		
          }
	}
}
