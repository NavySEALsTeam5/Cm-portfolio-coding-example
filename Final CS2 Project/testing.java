
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   
import java.time.*; 


public class testing{
	static Map<String, String> exerciseMap = new TreeMap<>();
	
	private static int month;
	private static int day;
	private static int year;
	private static int dayOfWeek = 0;
	private static String weekDay = "";
	static String currentDate = "";
	
	public static void main(String[]args){
		//Scanner scan = new Scanner(System.in);
		//Workout workouts = new Workout();
		
		////workouts.avaiableWorkouts();
		////workouts.chooseWorkout(scan.nextLine());
		//workouts.createWorkout();
	
		//Challenges ch = new Challenges();
		
		//ch.challenges("files\\challenges\\EasyChallenges.txt");
		//ch.randomChallenges();
		//for(int i = 0; i < ch.numOfChallenges(); i++){
			//System.out.println(ch.challengeQueReader());
			//ch.challengeComplete();
		//}
		ExerciseSearchTree tree = new ExerciseSearchTree();
		ExerciseTreeNode node;
		node = tree.getRoot();
		
		node.printNodeChain();
		
		
	}

	//public static void setInfo(){
		//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); //retieves the current date from system 
		//LocalDateTime now = LocalDateTime.now();  
		
		//String timeStamp = dtf.format(now);
		
		//Date d = new Date();
		
		//dayOfWeek = d.getDay();
		//weekDay = SpecialFunctions.intToWeek(dayOfWeek);
				
		//year = Integer.parseInt(timeStamp.substring(0, 4));
		//month = Integer.parseInt(timeStamp.substring(5, 7));
		//day = Integer.parseInt(timeStamp.substring(8 , 10));
		//currentDate = year + " " + month + " " + day + " " + weekDay;
	//}
}
