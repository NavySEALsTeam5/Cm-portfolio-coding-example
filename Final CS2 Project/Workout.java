/**
 * @author NavySealsTeam5 or Jeremiah Giordano
 */

import java.io.*;
import java.util.*;
import java.net.*;

/**
 * Workout is the class/object in which workouts are both created and viewed.
 */
public class Workout{
	static File directory = new File("files\\AvaiableWorkouts");
	static File[] files;
	
	static int numOfWorkouts = 0;
	
	Workout(){
		files = directory.listFiles();
		
	}
	
	/**
	 * avaiableWorkouts is a method used to list any saved workout that is on the computer.
	 */
	public static void avaiableWorkouts(){
		for(File file: files){
			try{
				Scanner scan = new Scanner(file);
				
				System.out.println(scan.nextLine());
			}
			catch(FileNotFoundException e){
				
			}
		}
		System.out.println();
		
	}
	
	/**
	 * chooseWorkout is a program that allows the user to view a wrokout
	 * @param workout is the string used to store the choice that equates to the workout the user wants. 
	 */
	public static void chooseWorkout(String workout){
		SpecialFunctions.clearScreen();
		System.out.println(workout);
		
		workout = workout.toLowerCase();
		for(File file: files){
			try{
				Scanner scan = new Scanner(file);
				
				String workoutName = scan.nextLine();				
				workoutName = workoutName.toLowerCase();
				
				if(workoutName.equals(workout)){
					while(scan.hasNextLine()){
						System.out.println(scan.nextLine());
					}
					
					break;
				}
				
				//System.out.println(scan.nextLine());
			}
			catch(FileNotFoundException e){
				
			}
		}
		
		System.out.println();
	}
	
	/**
	 * createWorkout is used to create new workout that can be used in workout program or just read in general.
	 */
	public static void createWorkout(){
		Scanner scan = new Scanner(System.in);
		String workoutName = "";
		String fileName = "";
		String input = "";
		
		System.out.println("What would you like the name of your workout to be?\n");
		
		workoutName = scan.nextLine();	
		fileName =  "files\\AvaiableWorkouts\\" + workoutName + ".txt";
		
		try{	
			PrintStream out = new PrintStream(new File(fileName));
		
			out.println(workoutName + "\n");
			
			for(;;){
				System.out.println("What is the next exercise? If no more exercises type \"none\".");
				input = scan.nextLine();
				
				if(input.equals("none")){
					break;
				}
				out.println(input);
			}
		}
		catch(FileNotFoundException e){
		}
	}
	
	

}
