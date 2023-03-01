package com.codility.lessons.countingelements;

public class FrogRiverOne {

	
	public int solution(int X, int[] A) {
		return 0;
	}
	
	private int process(int X, int[] A) {
		if(A.length == 1 && (A[0] != 1 || X != 1)) {
			return -1;
		}else if(A.length == 1) {
			return 0;
		}
		
		int positionsCounter = 0;
		boolean [] positionsMark = new boolean [X];
		for(int i = 0; i < A.length; i++) {
			if(A[i] > 0  && A[i] <= X && !positionsMark[A[i]-1]) {
				positionsMark[A[i]-1] = true;
				positionsCounter++;
				if(positionsCounter == X) {
					return i;
				}					
			}			
		}
		return -1;
	}
	
	
	
	
	//private static final int[]  ARRAY_A = {1,3,1,4,2,3,5,4};
	private static final int[]  ARRAY_A = {1};
	private static final int GOAL_POSITION = 1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FrogRiverOne vFrogRiverOne = new FrogRiverOne();
		System.out.println("\n" + vFrogRiverOne.process(GOAL_POSITION, ARRAY_A));
	}

}
