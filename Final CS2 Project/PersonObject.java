/**
 * @author NavySealsTeam5 or Jeremiah Giordano
 */

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   
import java.time.*; 

/**
 * PersonObject is the state that contains all the information on maxes and totals, as well as the mean to save the stats.
 */
public class PersonObject{
	//	variables for workout total stats
//	+----------------------------------+
	int totalPushups = 0;
	int totalSquats =0;
	int totalPullUps =0;
	int totalDips =0;
	double totalHoursWorkedOut =0;
	double totalHoursOfWeights =0;
	double totalHoursOfCalistenics =0;
	int daysWorkout =0;
	
	double totalMiles =0;
	int totalWorkouts =0;
	
// 	+----------------------------------+
	
//	varables for workOutMaxes stats
//	+----------------------------------+
	double longestRun =0;
	double fastestMile =0;
	int maxPushUps =0;
	int maxSquats =0;
	int maxPullUps =0;
	int maxSitUps;
	int maxDeadLift =0;
	int maxCurl =0; 
	int maxOverHeadPress =0;
	int maxButterFly =0;
//	+----------------------------------+

//	each days totals
//+------------------------------------+	
	int daysPushups = 0;
	int daysSquats = 0;
	int daysPullUps = 0;
	int daysDips = 0;
	double daysHoursWorkedOut =0;
	double daysHoursOfWeights = 0;
	double daysHoursOfCalistenics =0;
	
	double daysMiles =0;
	int daysWorkouts =0;
//+------------------------------------+
		
//			Date variables
//+------------------------------------+
	private int month;
	private int day;
	private int year;
	private int weekNum;
	private int dayOfWeek = 0;
	private String weekDay = "";
	
	public String currentDate;
	
	/**
	 * load gets the current data for to set the user stats with. 
	 */
	public void load() {
		try{
			File file = new File("files\\Totals.txt");
			if(file.exists()){
				Scanner fileScanner = new Scanner(file);
				
				totalMiles = fileScanner.nextDouble();
				totalWorkouts = fileScanner.nextInt();
				totalPushups = fileScanner.nextInt();
				totalSquats = fileScanner.nextInt();
				totalPullUps = fileScanner.nextInt();
				totalDips = fileScanner.nextInt();
				totalHoursWorkedOut = fileScanner.nextDouble();
				totalHoursOfWeights = fileScanner.nextDouble();
				totalHoursOfCalistenics = fileScanner.nextDouble();
				daysWorkout = fileScanner.nextInt();
			}
		}
		catch(Exception e){
			System.out.println("exception caught");
			e.printStackTrace();
		}
		
		try{
			File file = new File("files\\Maxes.txt");
			
			if(file.exists()){
				Scanner fileScanner = new Scanner(file);
				
				longestRun = fileScanner.nextDouble();
				fastestMile = fileScanner.nextDouble();
				maxPushUps = fileScanner.nextInt();
				maxSquats = fileScanner.nextInt();
				maxPullUps = fileScanner.nextInt();
				maxSitUps = fileScanner.nextInt();
				maxDeadLift = fileScanner.nextInt();
				maxCurl = fileScanner.nextInt();
				maxButterFly = fileScanner.nextInt();
			}
			
		}
		catch(Exception e){
			System.out.println("exception caught");
			e.printStackTrace();
		}

	}
	
	/**
	 * saveTotals is a method that is used to save the totals to the user total file.
	 */
	public void saveTotals() {
		
		try{

		PrintStream out = new PrintStream(new File("files\\Totals.txt"));

		out.println(totalMiles);
		out.println(totalWorkouts);
		out.println(totalPushups);
		out.println(totalSquats);
		out.println(totalPullUps);
		out.println(totalDips);
		out.println(totalHoursWorkedOut);
		out.println(totalHoursOfWeights);
		out.println(totalHoursOfCalistenics);
		out.println(daysWorkout);
		
		}
		catch(FileNotFoundException fnfe){
			System.out.println("lol");
		}
		
	}
	
	/**
	 * saveMaxes is a method that prints the user;s maxes to the user maxes file
	 */
	public void saveMaxes(){
		try{

		PrintStream out = new PrintStream(new File("files\\Maxes.txt"));
	
		out.println(longestRun);
		out.println(fastestMile);
		out.println(maxPushUps);
		out.println(maxSquats);
		out.println(maxPullUps);
		out.println(maxSitUps);
		out.println(maxDeadLift);
		out.println(maxCurl);
		out.println(maxButterFly);	
		
		}
		catch(FileNotFoundException fnfe){
			System.out.println("lol");
		}
	}
	
	/**
	 * statsEachDay is method thats prints the users stats for the day to the stats each day file
	 */
	public void statsEachDay(){
		boolean currentDateFound = false;
		int fileSize = 0;
		int fileWords = 0;
		int wordsUntilAppend = 0;
		String date = "";
		
		try{	
			
			Scanner scan = new Scanner(new File("files\\StatsPerDay.txt"));//scans txt file will stats for each
			
			while(scan.hasNextLine()){
				
				date = scan.nextLine();							
				fileWords += wordCounter(date);					
				fileSize++;
				
				if(date.contains(currentDate)){//for overwriting data in file if current date is found
					
					//System.out.println("date found");
					
					date = scan.nextLine();//gets data which is found on the line after the date
					
					currentDateFound = true;//boolean saying that the current date was found in the file
					
					Scanner dataScanner = new Scanner(date);
					
			//		 Contains code for extracting information
			//+------------------------------------------------+
					dataScanner.next();
					daysDips += dataScanner.nextInt();
					daysPushups +=  dataScanner.nextInt();
					daysPullUps += dataScanner.nextInt();
					daysSquats += dataScanner.nextInt();
					daysHoursOfCalistenics += dataScanner.nextDouble();
					daysHoursOfWeights += dataScanner.nextDouble();
					daysHoursWorkedOut += dataScanner.nextDouble();
					daysMiles += dataScanner.nextDouble();
					daysWorkouts += dataScanner.nextInt();	
			//+------------------------------------------------+
				}
			}
			
			//System.out.println("past while loop");
			//System.out.println(fileWords);
			
			if(currentDateFound == true){
				updateEntry(fileWords);
				return;
					
			}
			
			else if(currentDateFound == false){
				newEntry(fileWords);
			}		
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
	
	}
	
	/**
	 * update entry is a method used to overwrite existing data in the file in which the user stats have been stored
	 */
	private void updateEntry(int fileWords){
		//System.out.println("inside file append");
		
		try{
			RandomAccessFile raf = new RandomAccessFile("files\\StatsPerDay.txt", "rw");
		
			raf.seek(fileWords - 13 + offSetCalculator());//moves the pointer 17 to the right so date does not get deleted

			String data = "data " + daysDips + " " + daysPushups + " " + daysPullUps + " " + daysSquats + " " + 
			daysHoursOfCalistenics + " " + daysHoursOfWeights + " " + daysHoursWorkedOut + " " + daysMiles + " " + daysWorkouts;
			
			raf.writeBytes(data);
			raf.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * offSetCalculator is a method used to tell the  
	 */
	private int offSetCalculator(){
		File file = new File("files\\StatsPerDay.txt");
		List<String> list = new ArrayList<>();
		
		try{
			Scanner scan = new Scanner(file);
			
			while(scan.hasNextLine()){
				list.add(scan.nextLine());
			}
			
		}
		catch(FileNotFoundException e){
		}
		
		return list.get(list.size() - 1).length();
	}
	
	/**
	 * newEntry is a method that adds a new entry to the txt file in which the users info has been stored
	 */
	private void newEntry(int fileWords){
		//System.out.println("new entry");
		
		//formatting what is about to be printed
		String data = "date " + year + " " + month + " " + day + " " + weekDay + " " + "\n" + "data " + daysDips + " " + 
		daysPushups + " " + daysPullUps + " " + daysSquats + " " + daysHoursOfCalistenics + 
		" " + daysHoursOfWeights + " " + daysHoursWorkedOut + " " + daysMiles + " " + daysWorkouts;
		
		try{
			RandomAccessFile raf = new RandomAccessFile("files\\StatsPerDay.txt", "rw");
		
			raf.seek(fileWords);//moves the pointer to the line withdate on it
		
			raf.writeBytes(data);
			raf.close();
			
			//System.out.println(data);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * wordCounter counts the number words in a given string.
	 * Used mainly to determine where the pointer should be for the random access file.
	 */
	private int wordCounter(String words){//counts the number of words in document
		int wordAmount = 0;
		Scanner scan = new Scanner(words);
		
		//counts words
		while(scan.hasNext()){
			scan.next();
			wordAmount++;
		}
		
		return wordAmount;
	}
	
	/**
	 * setInfo sets the date of the object to the current date in real life.
	 */
	public void setInfo(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); //retieves the current date from system 
		LocalDateTime now = LocalDateTime.now();  
		
		String timeStamp = dtf.format(now);
		
		Date dayOfWeekgetter = new Date();//day of week not included in above method so used a second one		
		dayOfWeek = dayOfWeekgetter.getDay();
		
		weekDay = SpecialFunctions.intToWeek(dayOfWeek);
				
		year = Integer.parseInt(timeStamp.substring(0, 4));
		month = Integer.parseInt(timeStamp.substring(5, 7));
		day = Integer.parseInt(timeStamp.substring(8 , 10));
		currentDate = year + " " + month + " " + day + " " + weekDay;
	}

}
