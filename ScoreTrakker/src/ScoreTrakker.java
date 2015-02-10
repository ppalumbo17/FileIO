import java.util.*;
import java.io.*;
public class ScoreTrakker {

	private ArrayList<Student> students; // = new ArrayList<Student>();
	private String[] files = {"scores.txt", "badscore.txt","nofile.txt"};

	public void loadDataFromFile(String filename) throws FileNotFoundException
	{
		students = new ArrayList<Student>();
		FileReader reader = new FileReader(filename);	
		Scanner in = new Scanner(reader);
		String score = null;
		String name = null;
		//int scor = 0;
		while(in.hasNext()){
			
			String first = in.next();
			String last = in.next();
			name = first + " " + last;
			try{
			score = in.next();
			int scor = Integer.parseInt(score);
			students.add(new Student(name, scor));
			}
			catch(NumberFormatException e){
				System.out.println("Error, non numeric value for " + name +" score: "+ score + " must be number. \n");
				name = null;
				//scor = 0;
				
			}
			
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
		//String scores = "scores.txt";
		for(String s: files){
		try{
			loadDataFromFile(s);
			printInOrder();
		}
		catch(FileNotFoundException e){
			System.out.println("Cannot find specified file. \n");
		}
		}
	}
	public static void main(String[] args) throws FileNotFoundException{
		ScoreTrakker score = new ScoreTrakker();
		score.processFiles();
	}


	//}


}
