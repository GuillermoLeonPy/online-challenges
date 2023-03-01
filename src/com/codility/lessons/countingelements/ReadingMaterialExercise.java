package com.codility.lessons.countingelements;

public class ReadingMaterialExercise {

	private boolean solution(int [] A, int [] B, int m) {
		long summationA = 0;
		long summationB = 0;
		for(int i = 0; i < A.length; i++) {
			summationA+=A[i];
			summationB+=B[i];
		}
		
		for(int i = 0; i < A.length; i++) {
			int tempA = A[i];
			for(int i2 = 0; i2 < A.length; i2++) {
				int tempB = B[i2];
				if((summationA - tempA  + tempB) == (summationB - tempB + tempA)) {
					printResult(i, tempA, i2, tempB);
					return true;
				}else if(tempA == tempB) {
					continue;
				}				
			}
		}
		return false;
		
	}
	
		
	private static final int[]  ARRAY_A = {1,2,3};//6
	private static final int[]  ARRAY_B = {5,0,5};//10
	//diff = 4
	
	private void printResult(int indexA, int indexA_cell_value, int indexB, int indexB_cell_value) {
		System.out.println("\n swapping the A[" + indexA + "] = " + indexA_cell_value + "; with the B[" + indexB + "] = " + indexB_cell_value );
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadingMaterialExercise vReadingMaterialExercise = new ReadingMaterialExercise();
		System.out.println("\n " + vReadingMaterialExercise.solution(ARRAY_A, ARRAY_B, 0));
		
	}

}
