/**
 * @author NavySealsTeam5 or Jeremiah Giordano
 */

import java.io.*;
import java.util.*;

/**
 * This is the class used to construct and navigate the tree created with the nodes
 */
public class ExerciseSearchTree{
	ExerciseTreeNode root;
	ExerciseTreeNode weights;
	ExerciseTreeNode bodyExercise;
	
	ExerciseTreeNode weightArms;
	ExerciseTreeNode weightLegs;
	ExerciseTreeNode weightBack;
	
	ExerciseTreeNode arms;
	ExerciseTreeNode legs;
	ExerciseTreeNode back;
	ExerciseTreeNode abbs;
	
	ExerciseSearchTree(){
		root = new ExerciseTreeNode();
		buildTree();
	}
	
	public void buildTree(){
		root.addChild();
		root.addChild();
		
		weights = root.getNode(0);
		bodyExercise = root.getNode(1);
		
		weights.setData("weight training");
		bodyExercise.setData("calistenics");
		
		weights.addChild();
		weights.addChild();
		weights.addChild();
		
		weightArms = weights.getNode(0);
		weightArms.setData("arms");
		weightLegs = weights.getNode(1);
		weightLegs.setData("legs");
		weightBack = weights.getNode(2);
		weightBack.setData("back");
		
		
		bodyExercise.addChild();
		bodyExercise.addChild();
		bodyExercise.addChild();
		bodyExercise.addChild();
		
		arms = bodyExercise.getNode(0);
		arms.setData("arms");
		legs = bodyExercise.getNode(1);
		legs.setData("legs");
		back = bodyExercise.getNode(2);
		back.setData("back");
		abbs = bodyExercise.getNode(3);
		abbs.setData("abbs");
		
		buildLeaves();
	}
	
	/**
	 * buildLeaves adds all the leaves onto the tree.
	 * The leaves are basically any exercise I have listed in the exercise files.
	 */
	private void buildLeaves(){//method is used to add all the exercises to the tree
		String exerciseName = "";
		String exerciseType = "";
		
		String description = "";
		String nextWord = "";
		
		String[] strFiles = new String[2];
		strFiles[0] = "files\\BodyWeightExercises.txt";
		strFiles[1] = "files\\WeightExercises.txt";
		
		ExerciseTreeNode temp = new ExerciseTreeNode();
		
		for(int i = 0; i < 2; i++){
			try{
				Scanner scan = new Scanner(new File(strFiles[i]));
				
				while(scan.hasNext()){
					
					exerciseName = scan.nextLine();
					
					if(exerciseName.equals("")){
						exerciseName = scan.nextLine();
					}
					exerciseType = scan.nextLine();
					
					if(exerciseType.equals("")){
						exerciseType = scan.nextLine();
					}
					while(!nextWord.contains("|")){
						nextWord = scan.next();//scans for each word in the description of the exercise
						
						if(!nextWord.contains("|")){//guarentees line does not show in description
							description = description + " " + nextWord;
						}	
					}
					
					if(exerciseType.equals("arms") && i == 1){
						weightArms.addChild();			
						temp = weightArms.getNode(weightArms.amountOfChildren() - 1);
					}
					
					else if(exerciseType.equals("legs") && i == 1){
						weightLegs.addChild();			
						temp = weightLegs.getNode(weightLegs.amountOfChildren() - 1);
					}
					
					else if(exerciseType.equals("back") && i == 1){
						weightBack.addChild();			
						temp = weightBack.getNode(weightBack.amountOfChildren() - 1);
					}	
					
					//body exercise nodes
					//+--------------------------------------------+
					
					else if(exerciseType.equals("arms") && i == 0){
						arms.addChild();			
						temp = arms.getNode(arms.amountOfChildren() - 1);
					}		
					
					else if(exerciseType.equals("legs") && i == 0){
						legs.addChild();			
						temp = legs.getNode(legs.amountOfChildren() - 1);
					}	
					
					else if(exerciseType.equals("back") && i == 0){
						back.addChild();			
						temp = back.getNode(back.amountOfChildren() - 1);
					}	
					
					else if(exerciseType.equals("abs") && i == 0){
						abbs.addChild();			
						temp = abbs.getNode(abbs.amountOfChildren() - 1);
					}	
						//System.out.println(exerciseName + "\n");
						//System.out.println(exerciseType + "\n");
						//System.out.println(description  + "\n");
						
						temp.setData(exerciseName);
						temp.setDescription(description);	
						
						nextWord = "";
						description = "";
				}
			}
			catch(FileNotFoundException e){
				
			}	
		}	
	}
	
	/**
	 * navigateTree is a method used to navigate the tree, helping the use find an exercise that suits them.
	 */
	public void navigateTree(){
		String navigate = "";
		Scanner scan = new Scanner(System.in);
		
		ExerciseTreeNode temp = root;
		ExerciseTreeNode choice = new ExerciseTreeNode();
		
		System.out.println("What kind of exercise are you looking for?");
		
		
		
		while(!navigate.equals("exit")){
			temp.printChildren();
			
			System.out.println();
			
			navigate = scan.nextLine();
			
			System.out.println();
			
			for(int i = 0; i < temp.amountOfChildren(); i++){
				choice = temp.getNode(i);
				
				if(navigate.equals(choice.getData()) && !choice.hasNoChildren()){
					temp = choice;
					break;
				}
				else if(navigate.equals(choice.getData()) && choice.hasNoChildren()){
					System.out.println(choice.getDescription());
					System.out.println();
					temp = root;
					break;
				}
			}

		}
		
	}
	
	/**
	 * getRoot is used to obviously return the root of the tree to the user. Used for testing.
	 */
	public ExerciseTreeNode getRoot(){
		return root;
	}
}
