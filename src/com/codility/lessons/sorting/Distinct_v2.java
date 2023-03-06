package com.codility.lessons.sorting;

public class Distinct_v2 {

	public int solution(int[] A) {
		if(A.length == 0) {
			return 0;
		}else if(A.length == 1) {
			return 1;
		}
		int minValue = 1000001;
		int maxValue = -1000001;
		for(int i = 0; i < A.length; i++) {
			if(minValue > A[i]) {
				minValue = A[i];
			}
			if(maxValue < A[i]) {
				maxValue = A[i];
			}
		}
		

		int differentValues = 0;

		if(minValue < 0) {			
			boolean [] lessThanZeroValues = new boolean [1 + minValue * -1];			
			for(int i = 0; i < A.length; i++) {
				if(A[i] < 0 && !lessThanZeroValues[A[i] * -1]) {
					lessThanZeroValues[A[i] * -1] = true;	
					differentValues++;
				}
				
			}
		}
		if(maxValue >= 0) {
			boolean [] greaterThanZeroValues = new boolean [1 + maxValue];			
			for(int i = 0; i < A.length; i++) {
				if(A[i] >= 0 && !greaterThanZeroValues[A[i]]) {
					greaterThanZeroValues[A[i]] = true;	
					differentValues++;
				}				
			}
		}
		
		
		return differentValues;
	}
	
	
	//private static final int [] ARRAY = {2,1,1,2,3,1};
	//private static final int [] ARRAY = {2,1,1,2,3,1};
	//private static final int [] ARRAY = {0,0};
	//private static final int [] ARRAY = {0,1};
	//private static final int [] ARRAY = {1,0};
	//private static final int [] ARRAY = {1,1};
	private static final int [] ARRAY = {1,1,1};
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Distinct_v2 vDistinct = new Distinct_v2();
		System.out.println("\n " + vDistinct.solution(ARRAY));
	}

}
