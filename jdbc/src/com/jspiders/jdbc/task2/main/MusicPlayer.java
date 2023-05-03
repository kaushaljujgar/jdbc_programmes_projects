package com.jspiders.jdbc.task2.main;

import java.util.Scanner;



public class MusicPlayer {
	
	MusicPlayer musicPlayer=new MusicPlayer();
	
	static Scanner scanner=new Scanner(System.in);
	
	public static boolean bool=true;
	
	
	public static void menu() {
		
			  //for changing the option we must have o use while loop.
			  while(bool){ 
				  System.out.println("1.Add/Remove Song");
					System.out.println("2.Play Song"); 
					System.out.println("3.Edit Song");
					System.out.println("4.Exit");
					int ip=scanner.nextInt();
				  switch(ip)
				  {
				  case 1:{
					  JdbcTask2.addOrRemo();
					
					break;
				  }
				  
				  case 2:{
					  JdbcTask2.playSong();
					  break;
				  }
				  
				  case 3:{
					  JdbcTask2.editSong();
					  break;
				  }
				  
				  case 4:{
					  JdbcTask2.exit();
					  break;
				  }
				 
				  }
			  }
		}
		 
	
	 public static void main(String[] args) {
			menu();
			
			
			
		}
}