package com.codility.lessons.sorting;

public class Distinct {

	
	public int solution(int[] A) {
		if(A.length == 0) {
			return 0;
		}else if(A.length == 1) {
			return 1;
		}
		
		int minValue = 10000001;
		int minValueIndex = 0;
		int temp = 0;
		for(int i = 0; i < A.length; i++) {
			minValueIndex = i;
			minValue = 10000001;
			for(int i2 = i; i2 < A.length; i2++) {
				if(minValue > A[i2]) {
					minValue = A[i2];
					minValueIndex = i2;
				}
			}
			if(minValueIndex == i) {
				continue;
			}else {
				temp = A[minValueIndex];
				A[minValueIndex] = A[i];
				A[i] = temp;
			}
		}
		
		int distinctElementsCounter = 0;
		for(int i = 0; i < A.length - 1; i++) {
			if(A[i] != A[i + 1]) {
				distinctElementsCounter++;
			}
		}
		
		
		
		return distinctElementsCounter + 1;
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
		Distinct vDistinct = new Distinct();
		System.out.println("\n " + vDistinct.solution(ARRAY));
	}

}
