package notes;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student>{
	int age;
	String name;
	
	Student (int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public int compareTo(Student that) {
		return this.age - that.age;
	}
	
	public String toString() {
		return "Age: "+age+", Name: "+name;
	}
}

public class ComparatorUnderstanding {

	public static void main(String[] args) {
		
		Comparator<Integer> com = new Comparator<Integer> () {
			public int compare(Integer a, Integer b) {
				return a%10-b%10;
			}
		};
		
		List<Integer> list = Arrays.asList(43, 31, 72, 29);
		Collections.sort(list, com);
		System.out.println(list);
		
		
//======================================================================================
		Comparator<Student> comp = (a, b) ->  b.age-a.age;
		
		List<Student> students = Arrays.asList(new Student(14, "Naman"), new Student(16, "Misha"));
		Collections.sort(students);//Ascending order
		
		Collections.sort(students, comp); //Descending order
		for (Student st : students) {
			System.out.println(st);
		}
	}

}
