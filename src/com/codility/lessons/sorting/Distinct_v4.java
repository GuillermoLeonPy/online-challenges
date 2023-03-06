package com.codility.lessons.sorting;

public class Distinct_v4 {

	public int solution(int[] A) {
		return 0;
	}
	
	private int [] sort(int[] A) {
		
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
		int [] new_A = new int [A.length];
		int new_A_lastInputindex = 0;
		if(minValue < 0) {
			int [] lessThanZeroValues = new int [1 + minValue * -1];
			for(int i = 0; i < A.length; i++) {
				if(A[i] < 0) {
					lessThanZeroValues[A[i] * -1]++;					
				}
			}
			for(int i = lessThanZeroValues.length - 1; i >=0; i--) {
				if(lessThanZeroValues[i] > 0) {
					for(int i2 = 0; i2 < lessThanZeroValues[i]; i2++) {
						new_A[new_A_lastInputindex] = i * -1;
						new_A_lastInputindex++;
					}
				}
			}
		}
		if(maxValue >= 0) {
			int [] greaterThanZeroValues = new int [maxValue == 0 ? 1 : maxValue + 1];
			for(int i = 0; i < A.length; i++) {
				if(A[i]>=0) {
					greaterThanZeroValues[A[i]]++;
				}
			}
			
			for(int i = 0; i < greaterThanZeroValues.length; i++) {
				if(greaterThanZeroValues[i] > 0) {
					for(int i2 = 0; i2 < greaterThanZeroValues[i]; i2++) {
						new_A[new_A_lastInputindex] = i;
						new_A_lastInputindex++;
					}
				}
			}
		}
		
		return new_A;
	}
	
	
	private String getPrintableArray(int [] A) {
		StringBuilder sb = new StringBuilder();
		for(int i= 0; i < A.length; i++) {
			sb.append("" + A[i] + ( i  < A.length - 1 ? "," : ""));
		}
		return sb.toString();
	}
	
	//private static final int [] ARRAY = {10, 6, 8, 5, 7, 3, 4};
	//private static final int [] ARRAY = {-10, 6, 8, 5, -7, 3, 4,-1};
	//private static final int [] ARRAY = {0,-10, 6, 8, 5, -7, 0, 3, 4,-1, 0};
	private static final int [] ARRAY = {0,0};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Distinct_v4 vDistinct_v4 = new Distinct_v4();
		System.out.println("\n" + vDistinct_v4.getPrintableArray(vDistinct_v4.sort(ARRAY)));
	}

}
