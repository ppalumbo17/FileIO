import java.util.*;
import java.io.*;
public class ScoreTrakker {

	private ArrayList<Student> students; // = new ArrayList<Student>();
	private String[] files = {"scores.txt", "badscore.txt","nofile.txt", "badname.txt"};

	public void loadDataFromFile(String filename) throws Exception
	{
		students = new ArrayList<Student>();
		FileReader reader = new FileReader(filename);	
		Scanner in = new Scanner(reader);
		String score = null;
		String name = null;
		//String first = null;
		//String last = null;
		//int scor = 0;
		while(in.hasNext()){
			
			name = in.nextLine();
			//try{
			//first = in.next();
			//last = in.next();
			//name = first + " " + last;
			//}
			if(name.indexOf(" ")== -1){
				throw new Exception(name + " does not include a first and last name.");
				}
						
							
			try{
			score = in.nextLine();
			int scor = Integer.parseInt(score);
			students.add(new Student(name, scor));
			}
			catch(NumberFormatException n){
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

	public void processFiles() throws Exception{
		//String scores = "scores.txt";
		for(String s: files){
		try{
			loadDataFromFile(s);
			printInOrder();
		}
		catch(FileNotFoundException f){
			System.out.println("Cannot find specified file. \n");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		}
	}
	
	public static void main(String[] args) throws Exception{
		ScoreTrakker score = new ScoreTrakker();
		score.processFiles();
	}


	//}


}
