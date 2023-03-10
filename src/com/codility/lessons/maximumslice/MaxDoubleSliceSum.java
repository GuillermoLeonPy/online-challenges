package com.codility.lessons.maximumslice;

public class MaxDoubleSliceSum {

	public int solution(int[] A) {
		if(A.length == 3) {
			return 0; 
		}else if (A.length == 4) {
			return A[1];
		}
		int [] prefixSum = getPrefixSum(A);		
		
		int max = 0;
		int tempPrefixSum = -10001;
		int substrahend = 0;
		for(int x = 0; x < prefixSum.length; x++) {
			for(int y = x + 1; y < prefixSum.length; y++) {
				for(int z = y + 1; z < prefixSum.length - 1; z++) {
					if(y - x == 1) {
						substrahend = prefixSum[y+1];
					}else if (y - x == 2 && z - y == 2) {
						substrahend = A[y] + A[x];
					}else if(z - y == 1) {
						substrahend = A[y] + prefixSum[x+1];
					}
					else {
						substrahend = A[y] + prefixSum[x+1];
					}
					tempPrefixSum = prefixSum[z] - substrahend;
					if(tempPrefixSum == 27) {
						System.out.println("\n " + x + ", " + y + ", " + z);
					}
					if(max < tempPrefixSum) {
						max = tempPrefixSum;
					}
				}
			}
		}		
		return max;
	}
	
	private int[] getPrefixSum(int[] A) {
		int [] prefixSum = new int [A.length + 1];
		for(int i = 0; i < A.length; i++) {
			prefixSum[i+1] = prefixSum[i] + A[i];
		}
		return prefixSum;
	}
	
	//private static final int [] ARRAY = {6, 1, 5, 6, 4, 2, 9, 4};
										//0 1  2  3  4  5  6  7 
	//private static final int [] ARRAY = {0, 10, -5, -2, 0};
	//private static final int [] ARRAY = {3,2,6,-1,4,5,-1,7};
	private static final int [] ARRAY = {5, 0, 1, 0, 5};//0-1-4 => 2 + 3 
	//private static final int [] ARRAY = {3,2,6,-1};
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxDoubleSliceSum vMaxDoubleSliceSum = new MaxDoubleSliceSum();
		System.out.println("\n" + vMaxDoubleSliceSum.solution(ARRAY));
	}

}
