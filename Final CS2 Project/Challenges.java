/**
 * @author NavySealsTeam5 or Jeremiah Giordano
 */
import java.util.*;
import java.io.*;

/**
 * Challenges is the class in which all the random challenges are selected 
 * and put into an object that becomes accesable to the user.
 */
public class Challenges{
	private int numOfChallenges = 10;
	private int numOfSkippedChallenges;
	private int numOfCompletedChallenges;
	public Random rando;
	
	private File directory = new File("files\\challenges");
	private File[] files;
	
	private Queue<String> challengeQue = new LinkedList<>();
	
	
	Challenges(){
		files = directory.listFiles();
	}
	
	/**
	 * randomChallenges is a method that will randomly add avaiable challenges of random difficulty to the challenge que
	 */
	public void randomChallenges(){	
		challengeQue.clear();
		while(challengeQue.size() < 10){
			try{
				Scanner scan = new Scanner(files[rando.nextInt(files.length)]);//passes the scanner a random file to read
				int num = rando.nextInt(scan.nextInt() - 1);
				
				for(int i = 0; i < num; i++){
					scan.nextLine();
				}
				
				scan.next();
				
				challengeQue.add(scan.nextLine());
			}
			catch(FileNotFoundException e){
				
			}
		}
	}
	
	/**
	 * challenges is a method that will randomly add challenges to the que from a specific file 
	 */
	public void challenges(String file){
		challengeQue.clear();
		try{
			while(challengeQue.size() <= numOfChallenges){	
				Scanner scan = new Scanner(new File(file));
				int num = rando.nextInt(scan.nextInt() - 1);
				
				for(int i = 0; i < num; i++){
					scan.nextLine();
				}
				
				challengeQue.add(scan.nextLine());
			
			}
		}
		catch(FileNotFoundException e){				
		}
	}
	
	/**
	 * numOfChallenges is the method which returns to the user the num of challenges currently in
	 */
	public int numOfChallenges(){
		return numOfChallenges;
	}
	
	/**
	 * setNumOfChallenges allows any one who wants to adjust the number of challenges in the que to do so
	 */
	public void setNumOfChallenges(int num){
		numOfChallenges = num;
	}
	
	/**
	 * challengeQueReader simply gets whatever is at the front of the que and returns it to the user
	 */
	public String challengeQueReader(){
		return challengeQue.peek();
	}
	
	/**
	 * challengeComplete removes the front challenge and increases the num of completed challenges by one 
	 */
	private void challengeComplete(){
		numOfCompletedChallenges++;
		challengeQue.remove();
	}
	
	/**
	 * challengeComplete removes the front challenge and adjust the num of skipped challenges by one 
	 */
	private void skipChallenge(){
		challengeQue.remove();
		numOfSkippedChallenges++;
	}
	
	/**
	 * startChallenges allows the user to start the challenge process of going through the challenges in the que. 
	 * Basically what makes the object usable.
	 */
	public void startChallenges(){
		String input = "";
		Scanner scan = new Scanner(System.in);
		while(!input.equals("back")){
			SpecialFunctions.clearScreen();	
			System.out.println("Current challenge: " + challengeQue.peek() + "\n\nType \"skip\" to skip or \"complete\" to move on to the next challenge.");
			System.out.println("Or input \"back\" to leave\n\n");
			
			input = scan.nextLine();
			if(challengeQue.size() > 0){
				if(input.contains("complete")){
					this.challengeComplete();
				}
				
				else if(input.contains("skip")){
					this.skipChallenge();
				}
			}
			else{
				break;
			}
		}
		System.out.println("\n\nYou completed " + numOfCompletedChallenges + " challenges and skipped " + numOfSkippedChallenges + " challenges");
	}		

}
