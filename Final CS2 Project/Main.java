/**
 * @author NavySealsTeam5 or Jeremiah Giordano
 */
 
import java.util.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import java.io.*;

/**
 * Main is the main part of the program. if all the other files were the limbs, this would be the body that conects all of them.
 * This file allows the user to navigate through the workout tracking program. 
 */
public class Main{
	static int terminalLengthNorm = 120;
	static int terminalHiegthNorm = 29;
	static boolean screenClear = false;
	
	static Scanner mainScanner = new Scanner(System.in);
	static String input = "";
	
	static PersonObject user = new PersonObject();
	static Workout avaiableWorkouts = new Workout();
	static ExerciseSearchTree tree = new ExerciseSearchTree();
	static Challenges challengeMode = new Challenges();
	
	
	
	static Map<String, String> exerciseMap = new TreeMap<>();
		
	static int seed;
	static Random rand;
	/**
	 * main method used to start the program 
	 */
	public static void main(String[]args){
		if(args.length > 0){
			try{
				seed = Integer.parseInt(args[0]);
			}catch(NumberFormatException nfe){
				System.out.println("Seed is not a number");
				System.exit(0);
			}
			rand = new Random(seed);

		}else{
			rand = new Random();
		}
		
		challengeMode.rando = rand;
		loadStuff();
		welcome();
	}
	
	/**
	 * loadStuff i the method that calls all the methods which load previous stats back into the program. Hence, "loadStuff"
	 */
	public static void loadStuff(){
		//WKProgramControl.setWeeks();
		
		user.load();
		user.setInfo();
		//user.statsEachDay();
		
		exerciseMapMaker();
		
	}
	
	/**
	 * welcome is simply the method that greets the user nothing fancy going on here.
	 */
	private static void welcome(){//no need to comment on this in java doc
	//	SpecialFunctions.clearScreen();
		
		formatWordHiegthScreenAllingment((29 - 1) / 2);//make the words centered from the top of screen
		formatWordLengthScreenAllingment(spaceCalculator("Welcome to workout!"));//makes the words centered from the sides of screen
		
		System.out.println("!Welcome to workout!");
		
		SpecialFunctions.sleep(2000);
		SpecialFunctions.clearScreen();
		
		directory();		
	}
	
	/**
	 * directory is a method used to determine where the user would like to go next in the program 
	 */
	public static void directory(){
		String input = "";
		
		while(!input.equals("back")){
			
			if(screenClear == true){//no significance in the program all screenClear is for is formating the screen to make it look nice.
				SpecialFunctions.clearScreen();
			}
			screenClear = false;
			
			System.out.println("The available functions are:\n\nNew Maxes\nCurrent Maxes\nAdd to totals\nCurrent Totals\nGet Date\nExercise Help");
			System.out.println("View Workouts\nCreate Workouts\nSearch For Exercise\nEasy Challenge\nMedium Challenge\nHard Challenge\nExtreme Challenge");
			System.out.println("Random Challenge\nI Need Motivation");
			System.out.println("\nWhere would you like to go?");
			
			input = userInput();
			
			System.out.println();
			
			if(input.equals("new maxes")){
				newMaxes();
			}
			
			else if(input.equals("current maxes")){
				currentMaxes();
			}
			
			else if(input.equals("new max")){
				newMaxes();
			}
			
			else if(input.equals("add to totals")){
				addTotals();
			}
			
			else if(input.equals("current totals")){
				currentTotals();
			}
			
			else if(input.equals("get date")){
				SpecialFunctions.clearScreen();
				System.out.println(dateInfo() + "\n");
			}
			
			else if(input.equals("exercise help")){
				mapSearch();
			}
			else if(input.equals("view workouts")){
				viewWorkouts();
			}
			else if(input.contains("create workout")){
				avaiableWorkouts.createWorkout();
			}
			else if(input.equals("search for exercise")){
				tree.navigateTree();
			}
			else if(input.equals("help")){
				System.out.println("The available functions are:\n\nNew Maxes\nCurrent Mazes\nAdd to totals\nCurrent Totals");
			}	
			else if(input.equals("easy challenge")){
				challengeMode.challenges("files\\challenges\\EasyChallenges.txt");
				challengeMode.startChallenges();
				screenClear = true;
			}		
			else if(input.equals("medium challenge")){
				challengeMode.challenges("files\\challenges\\MediumChallenges.txt");
				challengeMode.startChallenges();
				screenClear = true;
			}
			else if(input.equals("hards challenge")){
				challengeMode.challenges("files\\challenges\\HardChallenges.txt");
				challengeMode.startChallenges();
				screenClear = true;
			}
			else if(input.equals("extreme challenge")){
				challengeMode.challenges("files\\challenges\\ExtremeChallenges.txt");
				challengeMode.startChallenges();
				screenClear = true;
			}
			else if(input.equals("random challenge")){
				challengeMode.randomChallenges();
				challengeMode.startChallenges();
				screenClear = true;
			}
			
			
			//Easter egg dont actually try in program it is anti jerk software
			//I dont advise trying unless you want your ears to be permanently dead
			//I understand that this could potentially damage the ears but on the other hand-
			//I really wanted this feature, so for saftey reason, it is really hard to activate.
			else if(input.equals("this program sucks")){
				SpecialFunctions.clearScreen();
				System.out.println("No it doesnt.");
				input = userInput();
				
				if(input.equals("yes it does")){
					SpecialFunctions.clearScreen();
					System.out.println("Im warning you...");
					input = userInput();
					
					if(input.equals("fuck you")){
						
						SpecialFunctions.clearScreen();
						System.out.println("The programmer always gets the last laugh...");
						SpecialFunctions.sleep(3000);
						formatWordHiegthScreenAllingment((29 - 1) / 2);//make the words centered from the top of screen
						SpecialFunctions.playNoise("files\\sounds\\BASS.wav");
						SpecialFunctions.sleep(245000);
					}
				}
			}
			
			else if(input.equals("who am i")){
				SpecialFunctions.playNoise("files\\sounds\\whoAmI.wav");
				screenClear = true;
			}
			
			else if(input.equals("i need motivation")){
				SpecialFunctions.playNoise("files\\sounds\\rick.wav");
				screenClear = true;
			}
			
			else if(input.equals("good morning")){
				SpecialFunctions.playNoise("files\\sounds\\goodMorning.wav");
				screenClear = true;
			}
			
			else if(input.equals("i messed up")){
				SpecialFunctions.playNoise("files\\sounds\\fail.wav");
				screenClear = true;
			}
			
			else if(input.equals("this is going to take a while")){
				SpecialFunctions.playNoise("files\\sounds\\moments.wav");
				screenClear = true;
			}
			
			else if(input.equals("private access")){
				SpecialFunctions.playNoise("files\\sounds\\Denied.wav");
				screenClear = true;
			}
			
			else if(input.equals("hes dead")){
				SpecialFunctions.playNoise("files\\sounds\\Target.wav");
				screenClear = true;
			}
			
			else if(input.equals("who is he")){
				SpecialFunctions.playNoise("files\\sounds\\jeff.wav");
				screenClear = true;
			}				
			
			else if(!input.equals("back")){
				System.out.println("Not a Function");
				screenClear = true;
			}
			
		}
		
	}
	
	/**
	 * viewWorkouts is a method used for viewing the workouts that are included or made in the system
	 * 
	 */
	public static void viewWorkouts(){//done
		screenClear = true;
		while(!input.equals("exit")){
			avaiableWorkouts.avaiableWorkouts();
			
			System.out.println("Which of these workouts would you like to view? Or type \"exit\" to go back.");
			
			input = mainScanner.nextLine();
			avaiableWorkouts.chooseWorkout(input);
		}	
	}
	
	/**
	 * addTotals is a method that allows the user to add to the totals for each exercise
	 */
	public static void addTotals(){//done
		String input = "";
		screenClear = true;
		while(!input.equals("back")){
			input = "";
			
			SpecialFunctions.clearScreen();
			System.out.println("\nAvaiable totals:\n\nPush Ups\nSquats\nPulls Ups\nDips\nHours Worked Out\nHours Of Calistenics\nHours Of Weights\n" +
		"Miles Run\nWorkouts(i.e 1 sessions not 1 set)\n");
		
			System.out.println("\nWhere would you like to go?");
			input = userInput();
			
			try{
				switch(input){
					case "push ups":
						System.out.println("Your previous total for push ups was " + user.totalPushups + ".");
						user.daysPushups += totalEditor("push ups");		
						user.totalPushups += user.daysPushups;		
						break;
					
					
					case "squats":
						System.out.println("Your previous total for squats was " + user.totalSquats + ".");
						user.daysSquats += totalEditor("squats");
						user.totalSquats += user.daysSquats;
						break;

					
					case "pull ups":
						System.out.println("Your previous total for pull ups was " + user.totalPullUps + ".");
						user.daysPullUps += totalEditor("pull ups");
						user.totalPullUps += user.daysPullUps;
						break;
					
					case "dips":
						System.out.println("Your previous total for dips was " + user.totalDips + ".");
						user.daysDips += totalEditor("dips did");
						user.totalDips += user.daysDips;
						break;
						
					
					case "hours worked out":
						System.out.println("Your previous total hours of working out was " + user.totalPushups + " hrs.");
						user.daysHoursWorkedOut += dobTotalEditor("hours of working out");
						user.totalHoursWorkedOut += user.daysHoursWorkedOut;
						break;
					
					
					case "hours of weights":
						System.out.println("Your previous total hours of weights was " + user.totalHoursOfWeights + " hrs.");
						user.daysHoursOfWeights += dobTotalEditor("hours of weights");
						user.totalHoursOfWeights += user.daysHoursOfWeights;
						break;
					
					case "hours of calistenics":
						System.out.println("Your previous total hours of working out was " + user.totalHoursOfCalistenics + " hrs.");
						user.daysHoursOfCalistenics += dobTotalEditor("hours of calistenics");
						user.totalHoursOfCalistenics += user.daysHoursOfCalistenics;
						break;
					
					
					case "miles run":
						System.out.println("Your previous total miles run was " + user.totalMiles + ".");
						user.daysMiles += dobTotalEditor("miles");
						user.totalMiles += user.daysMiles;
						break;
					
					
					case "workouts":
						System.out.println("Your previous number of time worked out was " + user.totalWorkouts + " hrs.");
						user.daysWorkouts += totalEditor("totalWorkouts");
						user.totalWorkouts += user.daysWorkouts;
						break;
					
				}
				
				user.saveTotals();
				//user.statsEachDay();
				
			}
			catch(InputMismatchException e){
				System.out.println("\n\nInvalid input\n\n");
			}
			catch(NumberFormatException e){
				System.out.println("\n\nInvalid input\n\n");
			}
		}
	}
	
	/**
	 * totalEditor is a method that is simply to get amounts of total exercises the user did for the day
	 * and ensure that the number they inputed was correct
	 * 
	 * @param exercise is the exercise the user had selected to add to
	 * @return returns an int back to add totals
	 */
	public static int totalEditor(String exercise){
		int num = 0;
		
		String correct = "";
		
				
		while(!correct.equals("yes")){
			
			System.out.println("\nHow many " + exercise + " did you do today.\n");
			
			System.out.print(exercise.substring(0,1).toUpperCase() + exercise.substring(1, exercise.length()) + ": ");
			
			num = userInputNum();
			//I understand that negative input can be given. I left that so i could add negative in case i over add to my totals i can correct.
			System.out.println("You did " + num + " " + exercise + " today. Is this correct. Yes or no.");
			
			correct = mainScanner.next();
		}
		
		return num;
	}
		
	/**
	 * currentTotals is a method that prints the current totals to the screen
	 * the main purpose of this method is to allow the user ease of acces when trying to view there totals
	 */
	public static void currentTotals(){
		System.out.println("\nYour current totals:\nTotal dips: " + user.totalDips + "\nTotal Push Ups: " + user.totalPushups  + 
		"\nTotal Squats: " + user.totalSquats + "\nTotal Pull Ups: " + user.totalPullUps + "\nTotal Hours Worked Out: " + user.totalHoursWorkedOut +
		"\nTotal Hours of Calistenics: " + user.totalHoursOfCalistenics + "\nTotal hours of weights: " + user.totalHoursOfWeights +
		"\nTotal Miles run: " + user.totalMiles + "\nTotal Workouts: " + user.totalWorkouts + "\nTotal days workout: " + user.daysWorkout + "\n");
		
	}
	
	/**
	 * newMaxes is method that help the user keep track and update there maxes
	 */
	public static void newMaxes(){//done
		String input = "";
		screenClear = true;
		
		while(!input.equals("back")){
			SpecialFunctions.clearScreen();
			System.out.println("Avaiable maxes:\nPush ups\nSit ups\nPull ups\nSquats\nLongest Run\nFastest mile\nDead lift\nCurl\nOver head press\nButterfly\n");
			
			System.out.println("\nWhat would you like to update? Or input \"back\" to go back");
			input = userInput();
			try{
				if(input.equals("push ups")){
					System.out.println("Your previous max number of push ups " + user.maxPushUps + ".");
					System.out.print("What is your new max for pushups: ");
					user.maxPushUps = userInputNum();
				}
				
				else if(input.equals("sit ups")){
					System.out.println("Your previous max number of situps was " + user.maxSitUps + ".");
					System.out.print("What is your new max for sit ups: ");
					user.maxSitUps = userInputNum();
				}
				
				else if(input.equals("pull ups")){
					System.out.println("Your previous max number of pull ups was " + user.maxPullUps + ".");
					System.out.print("What is your new max for pull ups: ");
					user.maxPullUps = userInputNum();
				}
				
				else if(input.equals("squats")){
					System.out.println("Your previous max number of squats was " + user.maxSquats + ".");
					System.out.print("What is your new max for squat: ");
					user.maxSquats = userInputNum();
				}
				
				else if(input.equals("longest run")){
					System.out.println("Your previous longest run was " + user.longestRun + ".");
					System.out.print("What is your new max for lonest run: ");
					user.longestRun = userInputDouble();
				}
				
				else if(input.equals("fastest mile")){
					System.out.println("Your previous fastest was " + user.fastestMile + ".");
					System.out.print("What is your new max for fastest mile: ");
					user.fastestMile = userInputDouble();
				}
				
				else if(input.equals("dead lift")){
					System.out.println("Your previous max dead lift was " + user.maxDeadLift + ".");
					System.out.print("What is your new max for dead lift: ");
					user.maxDeadLift = userInputNum();
				}
				
				else if(input.equals("curl")){
					System.out.println("Your previous max curl was " + user.maxCurl + ".");
					System.out.print("What is your new max for curl: ");
					user.maxCurl = userInputNum();
				}
				else if(input.equals("over head press")){
					System.out.println("Your previous max over head press was " + user.maxOverHeadPress + ".");
					System.out.print("What is your new max for over head press: ");
					user.maxOverHeadPress = userInputNum();
				}
				
				else if(input.equals("butterfly")){
					System.out.println("Your previous max butterfly was " + user.maxButterFly + ".");
					System.out.print("What is your new max for butterflys: ");
					user.maxButterFly = userInputNum();
				}
				
				user.saveMaxes();
				//user.statsEachDay();
			}
			catch(InputMismatchException e){
				System.out.println("\n\nInvalid input\n\n");
			}
			catch(NumberFormatException e){
				System.out.println("\n\nInvalid input\n\n");
			}
		}
			
	}
	
	/**
	 * currentMaxes is method that prints the user's current maxes to the screen
	 */
	public static void currentMaxes(){//done
		System.out.println("\nMax Push Ups: " + user.maxPushUps + "\nMax Sit Ups: " + user.maxSitUps + "\nMax Pulls Ups: " + user.maxPullUps +
		"\nMax Squats: " + user.maxSquats + "\nLongest Run: " + user.longestRun + "\nFastest Mile: " + user.fastestMile +
		"\nMax Dead Lift: " + user.maxDeadLift + "\nMax Curl: " + user.maxCurl + "\nMax Over Head Press: " + 
		user.maxOverHeadPress + "\nMax Butter Fly: " + user.maxButterFly);
	}
		
	/**
	 * dobTotalEditor is a variation of the method total editor but does doubles instead of ints
	 * 
	 * @param exercise is the exercise the user was adding to
	 * @return returns a the value or amount of exercise the user did
	 */
	public static double dobTotalEditor(String exercise){
		double num = 0;		
		String correct = "";
				
		while(!correct.equals("yes")){
			
			System.out.println("\nHow many " + exercise + " did you do today.\n");
			
			System.out.print(exercise.substring(0,1).toUpperCase() + exercise.substring(1, exercise.length()) + ": ");
			
			num = Double.parseDouble(mainScanner.next());
			//I understand that negative input can be given. I left that so i could add negative in case i over add to my totals i can correct.
			System.out.println("You did " + num + " " + exercise + " today. Is this correct. Yes or no.");
			
			correct = mainScanner.next();
		}
		
		return num;
	}
	
// This method is here so my code looked cleaner. so instead of advancing scanner I call this instead.
	private static String userInput() {
		input = mainScanner.nextLine();	
		return input.toLowerCase();
	}
	
	/**
	 * userInputNum is method used to ask the user for a number
	 * 
	 * @return returns the user number back to the program
	 */
	public static int userInputNum(){
		int num = 0;
		num = mainScanner.nextInt();
		
		return num;
	}
	
	/**
	 * userInputDouble is a method used to ask the user for a double
	 * 
	 * @return returns the double the user gave back to the program
	 */
	public static double userInputDouble(){
		double num = 0;
		num = Double.parseDouble(mainScanner.next());
		
		return num;
	}
	
//*note* cant remember why this method is in here but it is so ima leave it.
	private static String dateInfo(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		
		String timeStamp = dtf.format(now);
		
		return timeStamp;
	}
	
	//simply for making the screen look pretty
	private static void formatWordLengthScreenAllingment(int spaceAmount){ //prints a certain amount of spaces to the screen
		
		for(int j = 0; j < spaceAmount; j++){
			System.out.print(" ");
				
		}	
	}
	
	//making the screen look pretty
	private static void formatWordHiegthScreenAllingment(int spaceAmount){ //print a certain amount of lines to the screen
		
		for(int j = 0; j < spaceAmount; j++){
			System.out.print("\n");
		}		
	}
	
	//making the screen look pretty
	private static int spaceCalculator(String calculation){
		int lengthString = calculation.length();
		
		int spaceAmount = 120; //length of terminal
		spaceAmount = spaceAmount - lengthString;//compensates for string length by removing the amount from the terminal length
		spaceAmount = spaceAmount / 2; //what ever is left is divded by two so there is an equal amount of spcaces on each side
		
		return spaceAmount;
	}
	
	/**
	 * exerciseMapMaker is used to create the map of exercises and there descriptions so they are accessable in the program.
	 */
	public static void exerciseMapMaker(){
		String[] strFiles = new String[2];
		strFiles[0] = "files\\BodyWeightExercises.txt";
		strFiles[1] = "files\\WeightExercises.txt";
		try{
			for(int i = 0; i < 2; i++){
				File file = new File(strFiles[i]);
				
				Scanner scan = new Scanner(file);
							
				String exerciseType = "";
				String description = "";
				String nextWord = "";
				
				while(scan.hasNext()){
					exerciseType = scan.nextLine().trim();//obtains the exercise
					
					if(exerciseType.equals("")){
						exerciseType = scan.nextLine();
					}
					
					scan.nextLine();
					//System.out.println(exerciseType);
					
					while(!nextWord.contains("|")){
						nextWord = scan.next();//scans for each word in the description of the exercise
						
						if(!nextWord.contains("|")){//guarentees line does not show in description
							description = description + " " + nextWord;
						}	
					}
					
					exerciseMap.put(exerciseType, description);//builds map
					
					
					exerciseType = "";
					nextWord = "";
					description = "";
				}
				
			//	System.out.println(exerciseMap);
			}
		}
		catch(FileNotFoundException e){
			System.out.println("file not found");
		}
	}
	
	/**
	 * mapSearch is method designed to allow the user to find a exercise they need help with in the map in which they are stored
	 */
	public static void mapSearch(){
		String input = "";
		while(!input.equals("back")){
			System.out.println(exerciseMap.keySet() + "\n");
			System.out.println("What exercise do you need help with?\n");
			
			input = mainScanner.nextLine();
			
			if(exerciseMap.containsKey(input)){
				SpecialFunctions.clearScreen();
				System.out.println(input + "\n\n" + exerciseMap.get(input) + "\n\n");
			}
			
			else{
				SpecialFunctions.clearScreen();
				System.out.println("\nThis exercise currently has no information aviable about it.\n");
			}
		}
	}
		
}
