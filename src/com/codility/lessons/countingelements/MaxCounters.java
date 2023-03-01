package com.codility.lessons.countingelements;

public class MaxCounters {
	
	private static final StringBuilder sb = new StringBuilder();
	
	public int[] solution(int N, int[] A) {
		return new int[0];
	}
	
	private int[] process(int N, int[] A) {		
		int [] counters = new int [N];
		int counters_lenght = counters.length;
		int maxCounter = 0;
		int N_plus_one = N + 1;
		int tempIndex = 0;
		int tempMaxCounter = 0;
		for(int i = 0; i < A.length; i++) {
			if(A[i] == N_plus_one) {
				for(int i2 = 0; i2 < counters_lenght; i2++) {
					counters[i2] = maxCounter;
				}
			}else {
				tempIndex = A[i] - 1;
				tempMaxCounter = ++counters[tempIndex];
				if(maxCounter < tempMaxCounter) {
					maxCounter = tempMaxCounter;
				}
			}
			setPrintableResult(counters);
		}		
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
	
	//private static final int[]  ARRAY = {1};
	//private static final int N = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxCounters vMaxCounters = new MaxCounters();
		vMaxCounters.process(N, ARRAY);
		System.out.println("\n" +sb.toString());
	}

}
