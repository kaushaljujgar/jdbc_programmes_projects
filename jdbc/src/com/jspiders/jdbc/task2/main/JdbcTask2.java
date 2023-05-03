package com.jspiders.jdbc.task2.main;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;



public class JdbcTask2 {
	

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static int result;
	private static FileReader fileReader;
	private static Properties properties;

	private static String filePath="D:\\WEJM4\\jdbc\\resources\\db_infoprepst.Properties";
    private static Scanner scanner=new Scanner(System.in);
    private static String driverPath = "com.mysql.cj.jdbc.Driver";
	private static ResultSet resultSet;
    
    
	public static void openConnection() {
		try {
			fileReader=new FileReader(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		properties=new Properties();
		try {
			properties.load(fileReader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Class.forName(driverPath);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			connection=DriverManager.getConnection(properties.getProperty("dburl"),properties);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void closeConnection() {
		
		try {
			if (connection != null) {
				connection.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			/*if (scanner != null) {
				scanner.close();
			}*/
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void addSong()   {
		System.out.println("How Many Songs You Want To Add");
		int input=scanner.nextInt();
		 for(int i=1;i<=input;i++) {
			 openConnection();
				
				try {
					preparedStatement=connection.prepareStatement(properties.getProperty("query"));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					

					System.out.println("Enter Id Of Song");
					int Id=scanner.nextInt();
					preparedStatement.setInt(1,Id);
					
					System.out.println("Enter Name Of Song");
					String Name=scanner.next();
					preparedStatement.setString(2,Name);
					
					System.out.println("Enter Movie Of Songt");
					String Movie=scanner.next();
					preparedStatement.setString(3,Movie);
					
					System.out.println("Enter Singer Of Song");
					String Singer=scanner.next();
					preparedStatement.setString(4,Singer);
					
					System.out.println("Enter Lyricist Of Song");
					String Lyricist=scanner.next();
					preparedStatement.setString(5,Lyricist);
					
					System.out.println("Enter Duration Of Song");
					String Duration=scanner.next();
					preparedStatement.setString(6,Duration);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				try {
					result=preparedStatement.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(result+"Song Added Sucesssfully");
				
				closeConnection();
		 }
	}
	
	public static void removeSong() {
		
		openConnection();
		
		try {
			preparedStatement=connection.prepareStatement(properties.getProperty("query1"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Enter Id Of Song");
		int Id=scanner.nextInt();
		try {
			preparedStatement.setInt(1,Id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			result=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result+"Song Deleted Succesfully");
		
		
	}
	
	public static void editSongName()  {
		
		openConnection();

		System.out.println("Enter Name Of Song ");
		String Name=scanner.next();
		
		System.out.println("Enter Id  Of Song ");
		int Id =scanner.nextInt();
		
	    
	   
		
		
		
		
		try {
			preparedStatement=connection.prepareStatement(properties.getProperty("query2"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			
			preparedStatement.setString(1,Name);
			preparedStatement.setInt(2,Id);
			
		
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		try {
			result=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result+"Song name Edited Succesfully");
		
		closeConnection();
	}  
	
	
public static void editSongMovie()  {
		
		openConnection();

		System.out.println("Enter Movie Of Song ");
		String Name=scanner.next();
		
		System.out.println("Enter Id  Of Song ");
		int Id =scanner.nextInt();
		
	    
	   
		
		
		
		
		try {
			preparedStatement=connection.prepareStatement(properties.getProperty("query3"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			
			preparedStatement.setString(1,Name);
			preparedStatement.setInt(2,Id);
			
		
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		try {
			result=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result+"Song Movie Edited Succesfully");
		
		closeConnection();
	}  
	

public static void editSongSinger()  {
	
	openConnection();

	System.out.println("Enter Name Of Singer Of Song ");
	String Name=scanner.next();
	
	System.out.println("Enter Id  Of Song ");
	int Id =scanner.nextInt();
	
    
   
	
	
	
	
	try {
		preparedStatement=connection.prepareStatement(properties.getProperty("query4"));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	try {
		
		preparedStatement.setString(1,Name);
		preparedStatement.setInt(2,Id);
		
	
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	try {
		result=preparedStatement.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(result+"Song Singer Edited Succesfully");
	
	closeConnection();
}  
	

public static void editSongLyricist()  {
	
	openConnection();

	System.out.println("Enter Name Of Lyricist Of Song ");
	String Name=scanner.next();
	
	System.out.println("Enter Id  Of Song ");
	int Id =scanner.nextInt();
	
    
   
	
	
	
	
	try {
		preparedStatement=connection.prepareStatement(properties.getProperty("query5"));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	try {
		
		preparedStatement.setString(1,Name);
		preparedStatement.setInt(2,Id);
		
	
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	try {
		result=preparedStatement.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(result+"Song Lyricist Edited Succesfully");
	
	closeConnection();
}  
		
		
	
	
	
	
	
	
	
public static void editSongDuration()  {
		
		openConnection();

		System.out.println("Enter Duration Of Song ");
		String Name=scanner.next();
		
		System.out.println("Enter Id  Of Song ");
		int Id =scanner.nextInt();
		
	    
	   
		
		
		
		
		try {
			preparedStatement=connection.prepareStatement(properties.getProperty("query6"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			
			preparedStatement.setString(1,Name);
			preparedStatement.setInt(2,Id);
			
		
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		try {
			result=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result+"Song Duration Edited Succesfully");
		
		closeConnection();
	} 

public static void addOrRemo(){
	System.out.println("-----Menu-----");
	System.out.println("1.Add Song");
	System.out.println("2.Remove  Song");
	System.out.println("3.Back");
    System.out.println("----Choose The Option-------");
    int ip2=scanner.nextInt();
    switch (ip2)
	  {
	  case 1:{
		addSong();
		MusicPlayer.menu();
		break;
	  }
	  case 2:{
    removeSong();
    break;
	  }
	  case 3:{
		back();
		break;
	  }
	  
		
	}
}

public static void playSong(){
		System.out.println("-----Menu-----");
		System.out.println("1.Play All Songs");
		System.out.println("2.Choose Songs");
		//System.out.println("3.Shuffle");
		System.out.println("3.Back");
      System.out.println("----Choose The Option-------");
      int ip3=scanner.nextInt();
		switch (ip3)
	  {
	  case 1:{
		playAllSongs();
		
	  break;
	  }
	  
	  case 2:{
	 chooseSongs();
	  break;
	  }
	  
	  //case 3:{
		//shuffle();
		// break;

	 // }
	 
	case 3:{
		 back();
	  break;
	  }
	  
	  
		
	}
}
	

 public static void back() {
		MusicPlayer.menu();
		
	}

 
 public static void exit(){
		MusicPlayer.bool=false;
		System.out.println("You Are Exited Succesfully");
		
	}
 
 public static void editSong(){
	
	 
		  System.out.println("1.Edit Name Of Song");
			System.out.println("2.Edit Movie Of Song"); 
			System.out.println("3.Edit Singer Of Song");
			System.out.println("4.Edit Lyricist Of A Song");
			System.out.println("5.Edit Duration Of A Song");
				int choose=scanner.nextInt();
		  switch(choose)
		  {
		  case 1:{
			  editSongName();
			
			break;
		  }
		  
		  case 2:{
			  editSongMovie();;
			break;
		  }
		  
		  case 3:{
			  editSongSinger();
			break;
		  }
		  
		  case 4:{
			  editSongLyricist();
			break;
		  }
		  case 5:{
			  editSongDuration();
			
		  }
		  
		 
		  }
	  }
	
 
 public static void playAllSongs() {
 	    displayAllSongs();
		}
 
 public static void chooseSongs() {
 	System.out.println("Choose Song Which You Want");
	 displayAllSongs();
		}
   public static void displayAllSongs()  {
	   openConnection();
	   try {
		preparedStatement=connection.prepareStatement(properties.getProperty("query7"));
		resultSet=preparedStatement.executeQuery();
		while (resultSet.next()) {System.out.println(resultSet.getInt(1)+"|"
				                                    +resultSet.getString(2)+"|"
				                                    +resultSet.getString(3)+"|"
				                                    +resultSet.getString(4)+"|"
				                                    +resultSet.getString(5)+"|"
				                                    +resultSet.getString(6));
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
	
	
	
	

}
