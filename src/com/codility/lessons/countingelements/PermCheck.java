package com.codility.lessons.countingelements;

public class PermCheck {

	public int solution(int[] A) {
		return 0;
	}
	
	private int process(int[] A) {
		if(A.length == 1 && A[0] != 1) {
			return 0;
		}
		
		boolean [] marks = new boolean [A.length];
		int count = 0;
		for(int i = 0; i < A.length; i++) {			
			if(A[i] <= A.length && !marks[A[i] - 1]) {
				marks[A[i] - 1] = true;
				count++;
				if(count == A.length) {
					return 1;
				}
			}else if(A[i] > A.length) {
				break;
			}
		}
		return 0;
	}
	
	//private static final int[]  ARRAY = {4,1,3,2};
	private static final int[]  ARRAY = {4,1,3};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermCheck vPermCheck = new PermCheck();
		System.out.println("\n" + vPermCheck.process(ARRAY));
	}

}
