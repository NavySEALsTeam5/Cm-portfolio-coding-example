/**
 * @author NavySealsTeam5 or Jeremiah Giordano
 */

import java.util.*;

/**
 * The are custom nodes used to construct a tree
 */
public class ExerciseTreeNode{
	
	private String data = "";//basically the specific name of each node
	private String description = "";
	private List<ExerciseTreeNode> nodes;
	
	ExerciseTreeNode(){
		data = "";
		description = "";
		nodes =  new ArrayList<>();
	}
	
	/**
	 * getData is a method that gets the data of the node
	 * @return returns the data to the user
	 */
	public String getData(){
		return data;
	}
	
	/**
	 * amountOfChildren is a method used to tell the user how many children a node has
	 * @return returns the number of children to the user
	 */
	public int amountOfChildren(){
		return nodes.size();
	}
		
	/**
	 * getDescription is a method that gets the description of node
	 * @return returns the description to the user
	 */
	public String getDescription(){
		return description;
	}
	
	/**
	 * getNode is a method that allows the user to get a specific node from the nodes array
	 */
	public ExerciseTreeNode getNode(int i){
		return nodes.get(i);
	}
	
	/**
	 * addChild is a method that allows the user to add a node
	 */
	public void addChild(){
		ExerciseTreeNode node = new ExerciseTreeNode();
		nodes.add(node);
	}
	
	/**
	 * setData is a method that allows the user to set the data of the node
	 * 
	 */
	public void setData(String exercise){
		data = exercise;
	}
	
	/**
	 * setDescription allows the user to set the description of the node to what they please
	 */
	public void setDescription(String descript){
		description = descript;
	}
	
	/**
	 * getChildrenDescription is a method that retrieves all the data from the children and presents them in a list
	 * 
	 * @return returns a all the data from the children to give the users tehe avaiable options
	 */
	public String getChildrenDescription(){
		String description = "";
		ExerciseTreeNode temp;
		
		for(int i = 0; i < nodes.size() - 2; i++){
			temp = nodes.get(i);
			description = description + temp.getData() + "\n";
		}
			
		temp = nodes.get(nodes.size() - 1);
		description = description + "";
		
		return description;
	}	
	
	/**
	 * hasNoChildren is a method used for checking if a node has any children
	 * @return return true if ahs no children false if other wise
	 */
	public boolean hasNoChildren(){
		return nodes.size() == 0;
	}
	
	/**
	 * printChildren recursively prints all the node in a tree to the screen. 
	 * Used extensively in testing and makes the data structure usable in other programs.
	 */
	public void printChildren(){
		for(int i = 0; i < nodes.size(); i++){
			System.out.println(nodes.get(i).getData());
		}
	}
	
	/**
	 * toString is a method that prints all the nodes to the screen
	 */
	public void printNodeChain(){
		printNodeChainHelp(this);
	}
	
	private void printNodeChainHelp(ExerciseTreeNode node){
		System.out.println(node.getData() + ", ");
		if(node.amountOfChildren() == 0){
			//System.out.println("done");
			return;
		}
		
		//if(node == null){
			//return;
		//}
		for(int i = 0; i < node.amountOfChildren(); i++){
			printNodeChainHelp(node.getNode(i));
		}
	}
}
