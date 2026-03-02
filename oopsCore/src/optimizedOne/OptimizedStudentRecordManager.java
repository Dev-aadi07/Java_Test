package optimizedOne;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//===================ENTITY================
class Student {
	//===============PRIVATE MEMBERS=======
	private String name;
	private int id;
	private int marks;
	
	//==================CONSTRUCTOR/INITIALIZING=====================
	Student(String name, int id, int marks) {
		this.name = name;
		this.id = id;
		this.marks = marks;
	}
	
//=========================================PUBLIC GETTER/SETTER=================================================
	
	//============================NAME GETTER/SETTER====================
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//============================ID GETTER/SETTER======================
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//===========================MARK GETTER/SETTER======================
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	//==========================OVERRIDING toString()=====================
	//overriding it so that when we will call sop(st) it will print this rather than that reference/address
	public String toString() {
		return "ID: "+id+", NAME: "+name+", MARKS: "+marks;
	}
}


//========================SERVICE/LOGIC CODE===================================
class OptimizedStudentManager {
	private Map<Integer, Student> students;
	
	//=====================INITIALIZING MAP====================================
	OptimizedStudentManager() {
		students = new HashMap<>();
	}
	
	//=====================ADDING/CREATE LOGIC=================================
	public boolean addStudents(Student s) {
		if (students.containsKey(s.getId())) {
			return false;
		}
		students.put(s.getId(), s);
		return true;
	}
	
	//======================SEARCH BY ID LOGIC==================================
	public Student searchById(int id) {
		
		if (students.containsKey(id)) {
			return students.get(id);
		}
		return null;
	}
	
	//=======================UPDATE MARKS LOGIC==================================
	public boolean updateMarks(int id, int mark) {
		if (searchById(id) != null) {
			students.get(id).setMarks(mark);
			return true;
		}
		return false;
	}
	
	//========================DELETE STUDENT LOGIC================================
	public boolean deleteStudent(int id) {
		if (searchById(id) != null) {
			students.remove(id);
			return true;
		}
		return false;
	}
	
	//=======================DISPLAY STUDENT DATABASE LOGIC========================
	public void display() {
		if (students.isEmpty()) {
			System.out.println("\nDatabase is empty.");
		} else {
			System.out.println("\nStudents Record");
			
			for (Student st : students.values()) {
				System.out.println(st);
			}
		}
	}
	
}

//===================================UI/CONTROLLER====================================
public class OptimizedStudentRecordManager {
	
	static OptimizedStudentManager sm = new OptimizedStudentManager();
	static Scanner sc = new Scanner(System.in);
	
	//=====================ADDING STUDENT METHOD================================
	public static void addingStudent() {
		
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Marks: ");
		int mark = sc.nextInt();
		sc.nextLine();
		
		boolean added = sm.addStudents(new Student(name, id, mark));
		if(added) {
			System.out.println("Student added successfully.");
		} else {
			System.out.println("Student with this Id already exist.");			
		}	
	}
	
	//==============================SEARCH BY ID METHOD======================================
	public static void searchingById() {
		System.out.println("ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		Student found = sm.searchById(id);
		if(found != null) {
			System.out.println(found);
		} else {
			System.out.println("No Student with this id.");
		}
	}
	
	//==============================UPDATING MARKS METHOD====================================
	public static void updatingMarks() {
		
		System.out.print("ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Marks: ");
		int mark = sc.nextInt();
		sc.nextLine();
		
		boolean updated = sm.updateMarks(id, mark);
		if (updated) {
			System.out.println("Marks updated successfully.");
		} else {
			System.out.println("No Student with this ID.");			
		}
	}
	
	//===============================REMOVING STUDENT METHOD==================================
	public static void deletingStudent() {
		System.out.print("ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		boolean deleted = sm.deleteStudent(id);
		if (deleted) {
			System.out.println("Student with ID:"+id+" removed successfully.");
		} else {
			System.out.println("No Student with ID:"+id+" exist.");
			
		}
	}

	public static void main(String[] args) {
		while (true) {
			System.out.println("\nOPTIONS");
			System.out.println("1. Add Student");
			System.out.println("2. Search By Id");
			System.out.println("3. Update Marks");
			System.out.println("4. Delete Student");
			System.out.println("5. Display");
			System.out.println("6. Exit");
			
			System.out.print("Enter Choice: ");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				addingStudent();
				break;
			case 2:
				searchingById();
				break;
			case 3:
				updatingMarks();
				break;
			case 4:
				deletingStudent();
				break;
			case 5:
				sm.display();
				break;
			case 6:
				System.out.println("Exiting...");
				return;
			default:
				System.out.println("Invalid choice. Try again");				
			}
			
		}
	}

}
