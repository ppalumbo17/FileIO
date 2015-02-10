import java.util.*;
public class Student implements Comparable<Student>{

	private String name;
	private int score;
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	
	public int compareTo(Student person)
	{
		return name.compareTo(person.name);
		
	}

	@Override
	public String toString() {
		return name + " " + score;
	}
	
	
}