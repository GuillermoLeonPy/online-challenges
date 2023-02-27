package com.codility.lessons.arrays;

public class CyclicRotation {

	public int[] solution(int[] A, int K) {
		
		return processRecursiveMain(A, K);
		//return process(A, K);
	}
	
	private int[] process(int[] A, int K) {
		int tempValueStore = 0;
		int tempValueStore2 = 0;
		if(A.length == 1)return A;
		for(int kcounter = 0; kcounter < K; kcounter++) {
			for(int i = 0; i < A.length; i++) {
				if(i > 0 && i < A.length - 1) {
					tempValueStore2 = A[i + 1];
					A[i + 1] = tempValueStore;
					tempValueStore = tempValueStore2;
				}else if(i == A.length - 1) {
					A[0] = tempValueStore;
				}
				else {
					tempValueStore = A[i + 1];
					A[i + 1] = A[i];	
				}			
			}
			tempValueStore = 0;
			tempValueStore2 = 0;
		}	
		return A;
	}
	
	private int[] processRecursiveMain(int[] A, int K) {
		for(int i = 0; i < K; i++) {
			processRecursive(A, 0, 0);
		}
		return A;
	}
	
	private void processRecursive(int[] A, int temp, int indexCounter) {
		if(indexCounter == A.length - 1) {
			A[0] = temp;
		}else {
			temp = A[indexCounter + 1];
			A[indexCounter + 1] = A[indexCounter];
			processRecursive(A, temp, indexCounter++);
		}
	}
	
	private static final int [] CONSTANT = {0,1,2,3,4,5,6,7,8,9};
	//private static final int [] CONSTANT = {1000};
	private static final int NUMBER_OF_TIMES_TO_SHIFT = 1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CyclicRotation vCyclicRotation = new CyclicRotation();
		System.out.println("\n original array: " + vCyclicRotation.getPrintableArray(CONSTANT) 
		+ "\n right shifted array: " + vCyclicRotation.getPrintableArray(vCyclicRotation.process(CONSTANT, NUMBER_OF_TIMES_TO_SHIFT)));
		
	}
	
	private String getPrintableArray(int [] A) {
		StringBuilder sb = new StringBuilder();
		for(int i= 0; i < A.length; i++) {
			sb.append("" + A[i] + ( i  < A.length - 1 ? "," : ""));
		}
		return sb.toString();
	}

}
