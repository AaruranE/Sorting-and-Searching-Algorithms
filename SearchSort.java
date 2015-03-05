/**
 * 
 */
import java.util.ArrayList; 
import java.lang.Integer;
/**
 * @author Aaruran
 *
 */
public class SearchSort {
	
	public static void main(String[] args)
	{
		int array_length = 10;
		int[] big_array_of_ints = new int[array_length];
		
		for(int i = 0 ; i<array_length; i++){
			big_array_of_ints[i] =(int)(Math.random()*100000); 
			System.out.println(big_array_of_ints[i]);
		}
		System.out.println();
		
		big_array_of_ints = mergeSort(big_array_of_ints);
		
		for(int i = 0; i < array_length; i++)
		{
			System.out.println(big_array_of_ints[i]);
		}
	}
	
	
	public static boolean sorted(int[] array)
	{
		for(int i = 0; i < array.length -1 ; i++)
		{
			if(array[i+1] < array[i])
				return false;
		}
		return true;
	}
	
	//returns the first index i in array where array[i] == key, or -1 if no such element 
	//exists
	public static int linearSearch(int key, int[] array){
		for(int i = 0; i<array.length; i++)
		{
			if(key == array[i])
				return i;
		}
		return -1;
	}

	//returns the first index i in array where array[i] == key, or -1 if no such element 
	//exists
	public static int linearSearch(double key, double[] array){
		for(int i = 0; i<array.length; i++)
		{
			if(key == array[i])
				return i;
		}
		return -1;
	}

	//returns the first index i in array where array[i] == key, or -1 if no such element 
	//exists
	public static int linearSearch(String key, String[] array){
		for(int i = 0; i<array.length; i++)
		{
			if(key.equals(array[i]))
				return i;
		}
		return -1;
	}
	
	public static int[] mergeSort(int[] array){
		if(array.length == 0 || array.length == 1)
			return array;
		
		int[] top = new int[(array.length + 1)/2];
		int[] bottom= new int[array.length - top.length];
		
		for(int i = 0; i < array.length; i++)
		{
			if(i%2 == 0)
				top[i/2]=array[i];
			else
				bottom[(i-1)/2] = array[i];
		}
		
		top = mergeSort(top);
		bottom = mergeSort(bottom);
		
		array = merge(top, bottom);
		return array; 
	}
	
	//consumes two sorted arrays (in ascending order)
	//and produces the merging of the sorted arrays
	private static int[] merge (int[] top, int[] bottom)
	{
		int[] array = new int[top.length + bottom.length];
		int topIndex = 0;
		int botIndex = 0;
		
		for(int i = 0; i < array.length; i++)
		{
			if(topIndex < top.length && botIndex < bottom.length) {
				if(top[topIndex] <= bottom[botIndex]) 
				{
					array[i] = top[topIndex];
					topIndex++;
				}
				else
				{
					array[i] = bottom[botIndex];
					botIndex++;
				}
			}
			else if (bottom.length == botIndex)
			{
				array[i] = top[topIndex];
				topIndex++;
			}
			else if(top.length == topIndex)
			{
				array[i] = bottom[botIndex];
				botIndex++;
			}
		}
		return array; 
	}

	//consumes an array of integers and implements the timSorting algorithm to sort all 
	//of the elements of the array
	public static int[] timSort(int[] array)
	{
		Integer[] array_0 = new Integer[array.length];
		
		for(int i = 0; i < array.length; i++) 
		{
			array_0[i] = new Integer(array[i]);
		}
		
		ArrayList<Integer> sorted = new ArrayList<Integer>();
		ArrayList<Integer> unsorted = new ArrayList<Integer>();
		 
		sorted.add(array_0[0]);
		
		for(int i = 1; i < array.length; i++)
		{
			if(array[i] >= array[i-1])
			{
				sorted.add(array_0[i]);
			}
			else{
				unsorted.add(array_0[i]);
			}
		}
		
		if(unsorted.isEmpty())
			return array;
		else
		{
			int[] unsorted_ints = new int[unsorted.size()];
			for(int i = 0; i< unsorted.size(); i++)
			{
				unsorted_ints[i] = (unsorted.get(i)).intValue();
			}
			unsorted_ints = mergeSort(unsorted_ints);
			
			int[] sorted_ints = new int[sorted.size()];
			for(int i = 0; i<sorted.size(); i++)
			{
				sorted_ints[i] = (sorted.get(i)).intValue();
			}
			return merge(unsorted_ints, sorted_ints);
		}
	}
	
}
