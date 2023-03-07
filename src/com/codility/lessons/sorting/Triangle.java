package com.codility.lessons.sorting;

public class Triangle {

	public int solution(int[] A) {
		
		if(A.length < 3) {
			return 0;
		}
		
		mergeSort(A);
		// - 0 - 1 - 2 - 3 - 4 - 5 - 6
		//   *   *   *
		//       *   *   *
		//           *   *   *
		//               *   *   *
		//                   *   *   *
		int  [] P_Q_R_indexes = new int [3];
		boolean condition = true;
		long sum = 0;
		long sumA,sumB, toCompare = 0;
		for(int i2 = 0; i2 < A.length - 2 ; i2++) {
			
			P_Q_R_indexes[0] = i2;
			P_Q_R_indexes[1] = i2 + 1;
			P_Q_R_indexes[2] = i2 + 2;
			
			condition = true;
			for(int i = 0; i < 3; i++) {
				sumA = A[P_Q_R_indexes[0]];
				sumB = A[P_Q_R_indexes[1]];
				toCompare = A[P_Q_R_indexes[2]];
				sum = sumA + sumB;
				if(!(sum > toCompare)) {
					condition = false;
					break;
				}
				switchToTheLeftIndexes(P_Q_R_indexes);
			}
			if(condition) {
				return 1;
			}
		}		
		
		return 0;
	}
	
	private void switchToTheLeftIndexes(int [] P_Q_R_indexes) {
		int temp = 0;
		int temp2 = 0;
		boolean flag = false;
		for(int i = P_Q_R_indexes.length - 1; i >= 0; i--) {
			if(!flag) {
				temp = P_Q_R_indexes[i - 1];
				P_Q_R_indexes[i - 1] = P_Q_R_indexes[i];	
				flag = true;
			}else {
				if(i == 0) {
					P_Q_R_indexes[P_Q_R_indexes.length - 1] = temp; 
				}else {
					temp2 = P_Q_R_indexes[i - 1];
					P_Q_R_indexes[i - 1] = temp;
					temp = temp2;	
				}				
			}			
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
	
	
	private String getPrintableArray(int [] A) {
		StringBuilder sb = new StringBuilder();
		for(int i= 0; i < A.length; i++) {
			sb.append("" + A[i] + ( i  < A.length - 1 ? "," : ""));
		}
		return sb.toString();
	}
	
	private void test_switchToTheLeftIndexes(int [] A) {
		switchToTheLeftIndexes(A);
		System.out.println("\n " + getPrintableArray(A));
	}
	
	//private static final int [] ARRAY = {0,0,0};
	private static final int [] ARRAY = {2147483647,2147483647,2147483647};
	
	//private static final int [] ARRAY = {10,2,5,1,8,20};
	//1
	
	//private static final int [] ARRAY = {10,50,5,1};
	//0
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Triangle vTriangle = new Triangle();
		//vTriangle.test_switchToTheLeftIndexes(ARRAY);
		System.out.println("\n " + vTriangle.solution(ARRAY));
		
	}

}
