package com.jspiders.jdbc.main;

public class Student {
	
	private static int Id;
	private static String Name;
	private static String StudentCol;
	public static int getId() {
		return Id;
	}
	public static void setId(int id) {
		Id = id;
	}
	public static String getName() {
		return Name;
	}
	public static void setName(String name) {
		Name = name;
	}
	public static String getStudentCol() {
		return StudentCol;
	}
	public static void setStudentCol(String studentCol) {
		StudentCol = studentCol;
	}
	
	
	public String toString() {
		return "Students[id="+Id+",name="+Name+",studentcol="+StudentCol+"]";
		
	}

}
