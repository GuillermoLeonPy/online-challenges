package com.codility.lessons.timecomplexity;

public class PermMissingElem {

	public int solution(int[] A) {
		return process(A);
	}
	
	private int process(int []A) {
		if(A.length == 0) 
			return 1;
		
		long n_plus_one = A.length + 1;
		long shouldBe = n_plus_one * (n_plus_one + 1) / 2;		
		for(int i = 0; i < A.length; i++) {
			shouldBe-=A[i];
		}
		
		return (int)shouldBe;
	}
	
	private static final int [] CONSTANT = {2,3,1,5};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermMissingElem vPermMissingElem = new PermMissingElem();
		vPermMissingElem.solution(CONSTANT);
	}

}
