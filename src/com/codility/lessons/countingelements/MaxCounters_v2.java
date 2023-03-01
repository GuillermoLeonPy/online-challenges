package com.codility.lessons.countingelements;

public class MaxCounters_v2 {

	private static final StringBuilder sb = new StringBuilder();
	
	
	private int[] process(int N, int[] A) {		
		int [] counters = new int [N];		
		int maxCounter = 0;
		int minCounter = 0;
		for(int i = 0; i < A.length; i++) {
			if(A[i] == N + 1) {
				minCounter = maxCounter;
			}else {
				if(counters[A[i] - 1] < minCounter) {
					counters[A[i] - 1] = minCounter;
				}
				counters[A[i] - 1]++;
				if(maxCounter < counters[A[i] - 1]) {
					maxCounter = counters[A[i] - 1];
				}
			}			
		}	
		
		for(int i = 0; i < counters.length; i++) {
			if(counters[i] < minCounter) {
				counters[i] = minCounter;
			}
		}
		setPrintableResult(counters);
		return counters;
	}
	
	
	private void setPrintableResult(int [] counters) {
		sb.append("\n" + getPrintableArray(counters));
	}
	
	private String getPrintableArray(int [] A) {
		StringBuilder sb = new StringBuilder();
		for(int i= 0; i < A.length; i++) {
			sb.append("" + A[i] + ( i  < A.length - 1 ? "," : ""));
		}
		return sb.toString();
	}	
	
	
	private static final int[]  ARRAY = {3,4,4,6,1,4,4};
	private static final int N = 5;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxCounters_v2 vMaxCounters = new MaxCounters_v2();
		vMaxCounters.process(N, ARRAY);
		System.out.println("\n" +sb.toString());
	}

}
