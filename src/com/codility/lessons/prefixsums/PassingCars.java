package com.codility.lessons.prefixsums;

public class PassingCars {

	public int solution(int[] A) {
		return 0;
	}
	
	private int process(int[] A) {
		if(A.length == 1) {
			return 0;
		}
		
		int countFactor = 0;		
		long sum = 0;
		for(int i = 0; i < A.length; i++) {
			if(A[i] == 0) {
				countFactor++;
				continue;
			}else {
				sum+= 1 * countFactor;
			}			
		}
		
		if(sum > 1000000000) {
			return -1;
		}
		return (int)sum;
	}
	
	
	//private static final int [] CONSTANT = {0,1,0,1,1};
	//private static final int [] CONSTANT = {0,1,0,1,1};
	//private static final int [] CONSTANT = {0,1};
	private static final int [] CONSTANT = {1,0};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PassingCars vPassingCars = new PassingCars();
		System.out.println("\n " + vPassingCars.process(CONSTANT));
	}

}
