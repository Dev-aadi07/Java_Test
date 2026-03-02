package againStarting;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
	private String name;
	private int id;
	private int marks;
	
	Student(String name, int id, int marks) {
		this.name = name;
		this.id = id;
		this.marks = marks;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
	
	public int getMarks() {
		return marks;
	}
	
	public void setMarks(int mark) {
		this.marks = mark;
	}
	
	public String toString() {
		return "ID: " + id + ", Name: "+name+", Marks: "+marks;
	}
	
}

//================================== Service/Logic Code ====================================================
class StudentManager {
	
		private ArrayList<Student> students;
		
		public StudentManager () {
			students = new ArrayList<>(); //initializing here
		}
		
		//==============================CREATE LOGIC===========================================
		public boolean addStudent(Student s) {
			if (searchById(s.getId()) != null) {
				return false;  //id already exists
			}
			students.add(s);
			return true;
		}
		
		//===================================SEARCH BY ID LOGIC=================================
		public Student searchById(int id) {
			
			for (Student st : students) {
				if (st.getId() == id) {
					return st;
				}
			}
			return null;
		}
		
		//=============================UPDATE LOGIC===============================
		public boolean updateMarks(int id, int marks) {
			Student st = searchById(id);
			if (st!=null) {
				st.setMarks(marks);
				return true;
			}			
			return false;
		}
		
		
		//============================DELETE LOGIC===================================
		public boolean deleteStudent(int id) {
			Student st = searchById(id);
			if (st != null) {
				students.remove(st);
				return true;
			}
			return false;
		}
		
		
		//============================DISPLAY/READ LOGIC======================================
		public void displayAll() {
			System.out.println("===================Students Database=================\n");
			if (students.isEmpty()) System.out.println("No students available");
			
			for (Student st : students) {
				System.out.println(st);
			}
		}
}


//=====================================UI/Controller============================================================
public class StudentRecordManager {
	
	static StudentManager sm = new StudentManager();
	static Scanner sc = new Scanner(System.in);
	
//===================================ADDING STUDENT METHOD======================================================
	public static void addStudent() {
		
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Marks: ");
		int mark = sc.nextInt();
		sc.nextLine();
		
		boolean added = sm.addStudent(new Student(name, id, mark));
		if (added) {
			System.out.println("Student added successfully");
		} else {
			System.out.println("Student with this ID already exist.");
		}
	}
	
//====================================SEARCHING BY ID METHOD====================================================
	public static void searchByID() {
		
		System.out.println("Id to search: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		Student found = sm.searchById(id);
		if (found != null) System.out.println(found);
		else System.out.println("Cannot find any Student with this id.");
	}
	
	
//======================================UPDATING MARKS METHOD===================================================
	public static void updateMarks() {
		
		System.out.print("Id: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Marks: ");
		int mark = sc.nextInt();
		sc.nextLine();
		
		boolean isUpdate = sm.updateMarks(id, mark);
		if (isUpdate) {
			System.out.println("Marks Updated Successfully");
		} else {
			System.out.println("No student with this id.");
		}
	}
	
//======================================DELETING STUDENT METHOD==================================================
	public static void removeStudent() {
		
		System.out.print("ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		boolean deleted = sm.deleteStudent(id);
		if (deleted) {
			System.out.println("Student removed successfully");
		} else {
			System.out.println("No Student with this ID.");
		}
	}

//============================================PSVM BLOCK========================================================
	public static void main(String[] args) {
		
		while (true) {
			
			//add menu here
			System.out.println("\nOptions: ");
			System.out.println("1. Add Student");
			System.out.println("2. Search by ID");
			System.out.println("3. Update Marks");
			System.out.println("4. Remove Student");
			System.out.println("5. Display all");
			System.out.println("6. Exit\n");
			
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			sc.nextLine(); //buffer 
			
			switch (choice) {
			case 1: 
				addStudent();
				break;
			case 2:
				searchByID();
				break;
			case 3:
				updateMarks();
				break;
			case 4: 
				removeStudent();
				break;
			case 5:
				sm.displayAll();
				break;
			case 6:
				System.out.println("Exiting...");
			    return;
			default:
				System.out.println("Invalid choice. Try again.");
			}
		}
	}

}
