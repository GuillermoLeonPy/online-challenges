package com.codility.lessons.maximumslice;

public class MaxSliceSum_v2 {

	public int solution(int[] A) {
		
		int maxPossibleSumAtIndex = A[0];
		int maxSumFromAllPossibilities = A[0];
		
		for(int i = 1; i < A.length; i++) {
			maxPossibleSumAtIndex = Math.max(A[i], maxPossibleSumAtIndex + A[i]);
			maxSumFromAllPossibilities = Math.max(maxSumFromAllPossibilities, maxPossibleSumAtIndex);
		}
		
		return maxSumFromAllPossibilities;
	}
	
	
	//private static final int [] ARRAY = {5,-7,3,5,-2,4,-1};
	//private static final int [] ARRAY = {-2, -2, -2};
	//private static final int [] ARRAY = {1,1,-1};
	private static final int [] ARRAY = {3,2,6,-1,4,5,-1,2};
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxSliceSum_v2 vMaxSliceSum = new MaxSliceSum_v2();
		System.out.println("\n" + vMaxSliceSum.solution(ARRAY));
	}

}
