
import java.util.*;
/**
 * This class contains a variety of sorting methods and a searching method.
 * Basically intro to algorithms and recursion.
 * 
 * 2 of these methods big O is n * n
 * 2 of the methods big O is n* log (n)
 * 
 * @author NavySEALsTeam5 or Jeremiah Giordano
 */
 
public class Algorithms{
	
	public static void main(String[]args){
		
		int[] ary = {1, 5, 4, 2, 3};
		List<Integer> list2 = new ArrayList<>(List.of(5, 4, 3, 2, 1));
		//System.out.println(Arrays.toString(ary));
		//System.out.println(binarySearch(list2, -1));
		//System.out.println(list2);
		//bubbleSort(ary);
		//selectionSort(ary);
		System.out.println(quickSort(list2));
		//binarySearch
	
	}
	
	 /**
	 * This method does a binary search of a list of integers. 
	 * 
	 * @param list is the list being searched
	 * @param search is the item being looked for in the list
	 * @throws throws an illegal argument exception when list size is 0 or list is null
	 * @return boolean of true if item is in the list returns false if not
	 */
	public static boolean binarySearch(List<Integer> list, int search){
		
		if(list == null)//crap case
			throw new IllegalArgumentException("list size was zero or no list was passed");
		
		List<Integer> list2 = new ArrayList<Integer>(quickSort(list));
		
		System.out.println(list2 + "\n");//debugging
		
		
		int high = list2.size() - 1;
		int low = 0;
		
		
		int middle = 0;
		
		if(list2.size() % 2 !=0) //checks to see if list is odd
			middle = (list2.size() / 2 + 1);//calculates middle
			
		else{ //if list is even
			middle = (list2.size() / 2);//calculates middle
		}
		
		for(int i = 0; i < list2.size(); i++){
			
			System.out.println("middle " + list2.get(middle) + " " + search + " search");
			 
			if(list2.get(middle) == search){//base case
				return true;
			}
			
			
			if(list2.get(middle) < search){//if greater than case
				
				System.out.println("less than");//debugging
				
				low = middle;
			
//				Calculates mid point works for even and odd sized list
//+---------------------------------------------------------------+
				if(list2.size() % 2 !=0) // if list is odd size
					middle = (high - low) / 2 + 1;
					
				else{//if list is even size
					middle = (high - low) / 2 ;
				}
//+---------------------------------------------------------------+
				
			}
			
			if(list2.get(middle) > search){//if less than case
				
				System.out.println("more than");//debugging
				high = middle;
				
//				Calculates mid point works for even and odd sized list
//+---------------------------------------------------------------+
				if(list2.size() % 2 !=0) // if list is odd size
					middle = (high - low) / 2 + 1;
					
				else{//if list is even size
					middle = (high - low) / 2 ;
				}
//+---------------------------------------------------------------+
			}
		}
		return false;		
	}

	/**
	 * This method is a method that sorts a list using a quick sort algorithm
	 * The big O of this is n * log(n)
	 * Modified to use a random pivot
	 * 
	 * @param list is the list being sorted
	 * @return returns sorted list
	 */
	public static List<Integer> quickSort(List<Integer> list){
		Random rando = new Random();
		
		if(list == null)//crap case
			throw new IllegalArgumentException("null list");
			
		if(list.size() <=1){ //base case
			return list;
		}
		
		List<Integer> list2 = new ArrayList<>(list);
		
		Integer pivot = list2.remove(rando.nextInt(list2.size())); //pivot
		
		
		//elements used for divide and conquer style sort
		List<Integer> left = new ArrayList<>();
		List<Integer> right= new ArrayList<>();
		
		Iterator<Integer> itr = list2.iterator();
		
		while(itr.hasNext()){
			
			Integer element = itr.next();
			
			//compares element and see if it greater or less than pivot 
			//then adds based on this information
			
			if(element.compareTo(pivot) <=0){
				left.add(element);
			}else{
				right.add(element);
			}
		}
		
		//recursive part of method
//+----------------------------------+
		left = quickSort(left);
		left.add(pivot);
		right = quickSort(right);
		left.addAll(right);
//+----------------------------------+

		return left;
		
	}
	
	/**
	 * selectionSort is a method that sorts a collection using a selction sort algorithm
	 * This method is modified to sort using max int instead of the minimum.
	 * Big O is n * n
	 * 
	 * @param list is the list being sorted
	 * @return returns sorted list
	 */
	public static List<Integer> selectionSort(List<Integer> ary){
	
		if(ary == null)//crap case
			throw new IllegalArgumentException("null list passed");
			
		for(int i = ary.size()  -1; i > 0;i--){//changed to iterate backwards so list will appear in acsending order
			
			int maxIndex = i;
			
			for(int j = i; j >= 0;j--){// n comparisons, n -1 comparisons, n-2 comparisons... n
				
				if(ary.get(j) > ary.get(maxIndex)){//changed to compare to max index instead of minimum
					maxIndex = j;
				}
			}
			ary = swap(ary, i, maxIndex);
			//System.out.println(Arrays.toString(ary));
		}
		System.out.println("\n" + ary);
		
		return ary;

	}
	
	/**
	 * This method is a method that sorts a collection using a selction sort algorithm
	 * This method is modified to sort using max int instead of the minimum.
	 * Big O is n * n
	 * 
	 * @param list is the list being sorted
	 * @return returns sorted list
	 */
	public static List<Integer> bubbleSort(List<Integer> ary){
		boolean swapMade = false;
		if(ary == null)//crap case
			throw new IllegalArgumentException("null list passed");
			
		for(int i = 0; i < ary.size(); i++){
			swapMade = false;
			
			for(int j = 0; j < ary.size() - 1; j++){	
									
				if(ary.get(j) < ary.get(j + 1)){//compares to integer next in list.
					ary = swap(ary, j, j + 1);//if greater than move one up
					swapMade = true;
				}

			}
			
			if(swapMade == false){// checks to see if a change was made
				break;
			}

			System.out.println(ary);
		}	
		System.out.println(ary);
		
		return ary; //
	}
	
	private static List<Integer> swap(List<Integer> ary, int i, int j){
		int temp = ary.get(j);
		ary.set(j, ary.get(i));
		ary.set(i, temp);
		System.out.print("x");
		
		return ary;
		
	}

}
