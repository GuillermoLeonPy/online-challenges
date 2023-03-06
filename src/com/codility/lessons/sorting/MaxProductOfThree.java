package com.codility.lessons.sorting;

public class MaxProductOfThree {

	
	public int solution(int [] A) {
		mergeSort(A);
		return returnMaxProduct(A);
	}
	
	private int returnMaxProduct(int [] A) {
		if(A[0] * A[A.length - 1] * A[1] > A[A.length - 1] * A[A.length - 2] * A[A.length - 3]) {
			return A[0] * A[A.length - 1] * A[1];
		}else {
			return A[A.length - 1] * A[A.length - 2] * A[A.length - 3];
		}
	}
	
	private void mergeSort(int[] A) {
		if(A.length == 1) {
			return;
		}
		
		int halfLeftSize = A.length / 2;
		int halfRightSize = A.length - halfLeftSize;
		int [] leftHalf = new int [halfLeftSize];
		int [] rightHalf = new int [halfRightSize];
		for(int i = 0; i < halfLeftSize; i++) {
			leftHalf[i] = A[i];
		}
		
		int rightHalfIndex = 0;
		for(int i = halfLeftSize; i < A.length; i++) {
			rightHalf[rightHalfIndex++] = A[i];
		}
		
		mergeSort(leftHalf);
		mergeSort(rightHalf);
		merge(leftHalf, rightHalf, A);
		
	}
	
	
	private void merge(int [] leftHalf, int [] rightHalf, int [] originalArray) {
		int originalArrayIndex = 0;
		int leftArrayIndex = 0;
		int rightArrayIndex = 0;
		while(leftArrayIndex < leftHalf.length && rightArrayIndex < rightHalf.length) {			
			if(leftHalf[leftArrayIndex] < rightHalf[rightArrayIndex]) {
				originalArray[originalArrayIndex++] = leftHalf[leftArrayIndex++];
			}else {
				originalArray[originalArrayIndex++] = rightHalf[rightArrayIndex++];
			}						
		}
		
		while(leftArrayIndex < leftHalf.length) {
			originalArray[originalArrayIndex++] = leftHalf[leftArrayIndex++];
		}
		
		while(rightArrayIndex < rightHalf.length) {
			originalArray[originalArrayIndex++] = rightHalf[rightArrayIndex++];
		}
	}
	
	private void testMergeSort(int [] A) {
		mergeSort(A);
		System.out.println("\n" + getPrintableArray(A));
	}
	
	private String getPrintableArray(int [] A) {
		StringBuilder sb = new StringBuilder();
		for(int i= 0; i < A.length; i++) {
			sb.append("" + A[i] + ( i  < A.length - 1 ? "," : ""));
		}
		return sb.toString();
	}
	/*
	private static final int [] ARRAY_ORIGINAL = {3,1,2};
	private static final int [] ARRAY_LEFT = {3};
	private static final int [] ARRAY_RIGHT = {1,2};
	*/
	private static final int [] ARRAY = {2,-7,5,-9,1,2,3};
	//315
	//private static final int [] ARRAY = {-4, -6, 3, 4, 5};
	//120
	
	//private static final int [] ARRAY = {-1,-3,0,-2,-1};
	//0
	//private static final int [] ARRAY = {-3,1,2,-2,5,6};
	//60
	//private static final int [] ARRAY = {2, 100, 3, -1000};
	//600
	//private static final int [] ARRAY = {4, 7, 3, 2, 1, -3, -5};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		MaxProductOfThree vMaxProductOfThree = new MaxProductOfThree();
		//vMaxProductOfThree.mergeSort(ARRAY_ORIGINAL);
		//vMaxProductOfThree.testMergeSort(ARRAY);
		//vMaxProductOfThree.merge(ARRAY_LEFT, ARRAY_RIGHT, ARRAY_ORIGINAL);
		System.out.println("\n" + vMaxProductOfThree.solution(ARRAY));
	}

}
