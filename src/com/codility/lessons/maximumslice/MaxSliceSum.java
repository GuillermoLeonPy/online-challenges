package com.codility.lessons.maximumslice;

public class MaxSliceSum {
	
	public int solution(int[] A) {
		if(A.length == 1){
			return A[0];
		}else if (A.length == 2) {
			if(A[0] >= 0 && A[1] >= 0) {
				return A[0] + A[1];	
			}else {
				return A[0] > A[1] ? A[0] : A[1];
			}
			
		}
		
		int [] prefixSum = new int [A.length + 1];
		int maxElementValue = -1000001;
		for(int i = 0; i < A.length; i++) {
			prefixSum[i+1] = prefixSum[i] + A[i];
			if(maxElementValue < A[i]) {
				maxElementValue = A[i];
			}
		}
		
		if(maxElementValue < 0) {
			return maxElementValue;
		}
		
		int maxSum = 0;
		
		for(int i = 1; i < prefixSum.length; i++) {			
			for(int i2 = 0; i2 < i; i2++) {
				if(maxSum < prefixSum[i] - prefixSum[i2]) {
					maxSum = prefixSum[i] - prefixSum[i2];
				}
			}
		}
		
		return maxSum;
	}
	
	private static final int [] ARRAY = {5,-7,3,5,-2,4,-1};
	//private static final int [] ARRAY = {1,1,-1};
	//private static final int [] ARRAY = {3, -2, 1};
	//private static final int [] ARRAY = {-2, -2, -2};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxSliceSum vMaxSliceSum = new MaxSliceSum();
		System.out.println("\n" + vMaxSliceSum.solution(ARRAY));
	}

}
