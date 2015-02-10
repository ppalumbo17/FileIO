import java.util.*;
import java.io.*;
public class ScoreTrakker {

	private ArrayList<Student> students = new ArrayList<Student>();
	private String[] files = {"scores.txt", "badscore.txt","nofile.txt"};

	public void loadDataFromFile(String filename) throws FileNotFoundException
	{
		FileReader reader = new FileReader(filename);	
		Scanner in = new Scanner(reader);
		while(in.hasNext()){
			String first = in.next();
			String last = in.next();
			String score = in.next();
			String name = first + " " + last;
			int scor = Integer.parseInt(score);
			students.add(new Student(name, scor));
		}
		in.close();
	}

	public void printInOrder(){
		Collections.sort(students);
		for(Student o: students){
			System.out.println(o);
		}
	}

	public void processFiles() throws FileNotFoundException{
		String scores = "scores.txt";
		loadDataFromFile(scores);
		printInOrder();
	}
	public static void main(String[] args) throws FileNotFoundException{
		ScoreTrakker score = new ScoreTrakker();
		score.processFiles();
	}


	//}


}
