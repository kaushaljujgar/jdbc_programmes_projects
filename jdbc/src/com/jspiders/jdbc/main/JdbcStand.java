package com.jspiders.jdbc.main; //Standardized Code
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcStand{
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static FileReader fileReader;
	private static Properties Properties;
	private static String driverPath="com.mysql.cj.jdbc.Driver";
	private static String dburl="jdbc:mysql://localhost:3306/wejm4db";
	private static String filePath="D:\\WEJM4\\jdbc\\resources\\db_info.Properties";
	private static String query="select * from student";

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
			ResultSet resultSet=statement.executeQuery(query);
			//4
			while (resultSet.next()) {System.out.println(resultSet.getInt(1)+"|"
					                                    +resultSet.getString(2)+"|"
					                                    +resultSet.getString(3));
				
			}
				
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
					if (resultSet !=null) {
						try {
							resultSet.close();
						} catch (SQLException e2) {
							e2.printStackTrace();
						}
				
			}
		}
	}

		}
	}
}