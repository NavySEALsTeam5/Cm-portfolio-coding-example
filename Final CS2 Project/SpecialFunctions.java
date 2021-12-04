/**
 * @author NavySealsTeam5 or Jeremiah Giordano
 */

import java.util.*;
import java.io.*;
import javax.sound.sampled.*;

/**
 * SpecialFunctions class is a collection of most of the oddball functions that are not nessacarry to the program.
 */
public class SpecialFunctions{
	/**
	 * clearScreen clears the terminal window of text
	 */
	public static void clearScreen() { // credit goes to adrian veliz for this line
		//try{//windows
			//new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		//} catch(Exception e){//mac and linux
			//try{
				//String term = System.getenv("TERM"); // https://docs.oracle.com/javase/8/docs/api/java/lang/System.html#getenv-java.lang.String-
				//if(term != null && !term.equals("dumb")){
					//new ProcessBuilder("clear").inheritIO().start().waitFor();
				//}
			//}catch(Exception e2){}
		//}
	}
	
	/**
	 * playNoise plays and any .wav file the user wishes
	 * fileName is the name of the file and the directory to the file from which the program resides in
	 */
	public static void playNoise(String fileName){
		
		try{
			//  This takes a music file, intializes it, and then plays it.
//			<---------------------------------------------------------------+
		File sound = new File(fileName);//                                  |
		AudioInputStream sound_1 = AudioSystem.getAudioInputStream(sound);//|
		Clip soundPlay = AudioSystem.getClip();//                           |
		soundPlay.open(sound_1);//                                          |
		//                                                                  |
		soundPlay.start();// <-- plays the sound                            |
//           <--------------------------------------------------------------+
		}
		
		catch(Exception e){
			
		}
	}
	
	
	/**
	 * sleep puts the program thread to sleep for a given amount of time
	 * @param sleepNumber is the number in microsecond for how long the program will be put to sleep for
	 */
	public static void sleep(int sleepNumber) { // controls the amount of time between printing the story line lines
		try{
			Thread.sleep(sleepNumber); //tells the thread how long to sleep for
		}
		catch(InterruptedException e){
		}

	}
	
	/**
	 * validDate is a method that is used to check wheather a given date is valid or not
	 * @param all parameters are parts of the date
	 * This method is currently not being used in program but keeping code for future reference
	 */
	public static void validDate(int year, int month, int day){
		if(month > 12 || month < 1)
			throw new IllegalArgumentException("invlaid month");
			
		if(day < 1)
			throw new IllegalArgumentException("There is no such thing as a negative day of the month.");
		
		if(month == 9 || month == 4 || month == 11 || month == 6){
			if(day > 30){
				throw new IllegalArgumentException("This month only has 30 days in it.");
			}
		}
		else if(month == 2 && (year % 4) == 0){//in case of leap year
			if(day > 29){
				throw new IllegalArgumentException("This month only has 29 days.");
			}
		}
		else if(month == 2 && (year % 4) != 0){//febuary
			if(day > 28){
				throw new IllegalArgumentException("This month only has 28 days.");
			}		
		}
		else{
			if(day > 31){
				throw new IllegalArgumentException("This month only has 31 days");	
			}
		}
	}
	
	/**
	 * monthToNum converts a string version of a month in to a numerical value of the month
	 * @param month is the month that is being converted
	 * @return return the int version of the month
	 */
	public static int monthToNum(String month){
		switch(month.toLowerCase()){
			case "january":
				return 1;
			case "february":
				return 2;
			case "march":
				return 3;
			case "april":
				return 4;
			case "may":
				return 5;
			case "june":
				return 6;
			case "july":
				return 7;
			case "august":
				return 8;
			case "september":
				return 9;
			case "october":
				return 10;
			case "november":
				return 11;
			case "december":
				return 12;		
		}
		return 0;
	}
	
	/**
	 * monthToString is a method that converts a numerical version of a month into a string version
	 * @param month is the numerical month that is being converted
	 * @return returns the string version of the numerical month
	 */
	public static String monthToString(int month){
		switch(month){
			case 1:
				return "January";
			case 2:
				return "February";
			case 3:
				return "March";
			case 4:
				return "April";
			case 5:
				return "May";
			case 6:
				return "June";
			case 7:
				return "July";
			case 8:
				return "August";
			case 9:
				return "September";
			case 10:
				return "October";
			case 11:
				return "November";
			case 12:
				return "December";
		}
		return "";
	}
	
	public static String intToWeek(int weekDay){
		switch(weekDay){
			case 0:
				return "Sunday";
			case 1:
				return "Monday";
			case 2:
				return "Tuesday";
			case 3: 
				return "Wensday";
			case 4:
				return "Thursday";
			case 5:
				return "Friday";
			case 6:
				return "Saturday";
			default:
				return "";
		}
	}
}
