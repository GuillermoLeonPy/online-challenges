package com.khan.achademy;

/* Returns either the index of the location in the array,
or -1 if the array did not contain the targetValue */

public class BinarySearch {
	
	//private static int [] array = {0,3,6,9,12,15,17,18,26,28,30,35,37};
	//private static int searchValue = 6;
	//private static int searchValue = 28;
	//private static int searchValue = 0;
	//private static int searchValue = 37;
	//private static int searchValue = 38;

	
	//private static int [] array = {0,3};
	//private static int searchValue = 3;
	//private static int searchValue = 0;
	
	private static int [] array = {0,3,4};
	//private static int searchValue = 0;
	private static int searchValue = 4;
	
	
	
	public static void main(String[] args) {
		System.out.println(search(array, 0, array.length - 1, searchValue));
	}
	
	private static int search(int [] sortedArray, int fromIndex, int toIndex, int targetValue) {
				
		if((fromIndex > toIndex) || sortedArray.length <= 1 ) {
			return -1;
		}
		
		int half = fromIndex + ((toIndex - fromIndex)/2);
		if(sortedArray[half] == targetValue) {
			return half;
		}else if (sortedArray[half] > targetValue) {
			return search(sortedArray, fromIndex, half - 1, targetValue);
		}else {
			return search(sortedArray, half + 1, toIndex, targetValue);
		}
	}
}
