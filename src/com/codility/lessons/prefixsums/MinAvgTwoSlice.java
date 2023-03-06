package com.codility.lessons.prefixsums;

public class MinAvgTwoSlice {

	public int solution(int[] A) {
		return 0;
	}
	
	private int process(int[] A) {
		if(A.length == 2) {
			return 0;
		}
		//   4, 4,  3,  2,  2,  5,  8
		//   *  *   *   *
		//   *  *   *	X
		//   *  *   X   X
		//   X  *   *   X
		//   X  X   *   *
		//   X  *   *   *
		//0, 4, 8, 11, 13, 15, 20, 28
		//i = 3
		//13 	-> 0+1+2+3		
		//11	-> 0+1+2		->  
		//8 	-> 0+1			-> 
		//7		->   1+2		-> 0+1+2-0
		//5		->     2+3		-> 0+1+2+3-0+1
		//9		->   1+2+3		-> 0+1+2+3-0
		int [] sum = new int [A.length + 1];

		for(int i = 0; i < A.length; i++) {
			sum[i + 1] = sum[i] + A[i];			
		}
		
		/*
		 * https://codesays.com/2014/solution-to-min-avg-two-slice-by-codility/
		 * 
		 * https://github.com/Mickey0521/Codility/blob/master/MinAvgTwoSlice.java
		 * 
		 * https://github.com/peshrus/codility/blob/master/src/main/java/com/codility/lessons/lesson05/MinAvgTwoSlice.java
		 * 
		 * 
		 * */
		
		
		return 0;
	}
	
	//private static final int [] ARRAY = {4,2,2,5,1,5,8};
	//private static final int [] ARRAY = {4,4,2,2,8,5,8};
	//private static final int [] ARRAY = {4,4,3,2,2,5,8};
	//private static final int [] ARRAY = {4,2,2,5,-1,-1,8};
	private static final int [] ARRAY = {-3, -5, -8, -4, -10};
	//private static final int [] ARRAY = {-3, 5, -8, -1, 10, 2, -3};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinAvgTwoSlice vMinAvgTwoSlice = new MinAvgTwoSlice();
		System.out.println("\n" + vMinAvgTwoSlice.process(ARRAY));
	}

}
