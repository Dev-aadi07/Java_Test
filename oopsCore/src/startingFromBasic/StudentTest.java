package startingFromBasic;

class StudentTest {
	public static void main(String[] args) {
		Student s1 = new RegularStudent();
		Student s2 = new ScholarshipStudent();
//		RegularStudent s = (RegularStudent) new Student();
		
		try {
			s1.setMarks(80);
//			s2.setMarks(28, 20);
			System.out.println("Regular Student Grade: " + s1.calculateGrade());
			System.out.println("Scholarship Student Grade: " + s2.calculateGrade());
			
		} catch (InvalidMarksException e) {
			System.out.println("Error: "+e.getMessage());
			
		}  catch (MarksNotSetException e) {
			System.out.println("Error: "+e.getMessage());
		} finally {
			System.out.println("Excecution Completed");
		}
	}
}



abstract class Student {
	String name;
	private double marks = -1;
	
	public void setMarks(double mark) throws InvalidMarksException {
		if (mark>=0 && mark<=100) {
			marks = mark;			
		} else {
			throw new InvalidMarksException("Marks must be b/w 0 and 100.");
		}
	}
	
	public void setMarks(double mark, double bonus) throws InvalidMarksException {
		setMarks(mark + bonus); // reuse validation 
	}
	
	protected double getMarks() {
		if (marks == -1) {
			throw new MarksNotSetException("Marks not set yet");
		}
		return marks;
	}

	abstract char calculateGrade();
	
	void display() {
		System.out.println("Name: "+name);
		System.out.println("Marks: "+marks);
	}
}

class RegularStudent extends Student {

	@Override
	char calculateGrade() {
		double m = getMarks();
		if (m>=90) {
			return 'A';
		} else if (m>=75) {
			return 'B';
		}
		return 'C';
	}
	
}
class ScholarshipStudent extends Student {

	@Override
	char calculateGrade() {
		double m = getMarks();
		if (m>=85) {
			return 'A';
		} else if (m>=70) {
			return 'B';
		}
		return 'C';
	}	
}

//EXCEPTION CLASS
class InvalidMarksException extends Exception {
	public InvalidMarksException(String message) {
		super(message);
	}
}

class MarksNotSetException extends RuntimeException {
	public MarksNotSetException(String message) {
		super(message);
	}
}




