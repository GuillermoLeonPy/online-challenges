package com.codility.lessons.timecomplexity;

public class TapeEquilibrium {

	public int solution(int[] A) {
		return process(A);
	}
	
	
	private int process(int[] A) {
		if(A.length == 2) {					
			return (A[0] - A[1] < 0 ? (A[0] - A[1]) * - 1 : A[0] - A[1]);
		}
		long [] sumByPosition = new long [A.length];
		
		for(int i = 0; i < A.length; i++) {
			if(i == 0) {
				sumByPosition[i]=A[i];	
			}else {
				sumByPosition[i] = sumByPosition[i - 1] + A[i];
			}
		}
		long total = sumByPosition[A.length - 1];
		long minDiff = 999999999;
		int loopLimit = total == 0 ? A.length - 1 : A.length; 
		for(int i = 0; i < loopLimit; i++) {
			long average_x_2 = sumByPosition[i] * 2;			
			long tempDiff = total - average_x_2;
			
			if(tempDiff < 0)
				tempDiff = tempDiff * -1;
			if(tempDiff < minDiff) {
				minDiff = tempDiff;
			}
		}
		
		return (int)minDiff;
		
	}

	
	//private static final int [] CONSTANT = {3,1,2,4,3};
	//private static final int [] CONSTANT = {7,3,1,2,4,3,5,8,3,9};
	//private static final int [] CONSTANT = {-1000, 1000};
	private static final int [] CONSTANT = {-10, -20, -30, -40, 100};
	//private static final int [] CONSTANT = {10, 20, 30, 40, 100};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TapeEquilibrium vTapeEquilibrium = new TapeEquilibrium();
		System.out.println("\n " + vTapeEquilibrium.process(CONSTANT));
		
	}

}
