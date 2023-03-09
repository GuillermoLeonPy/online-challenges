package com.codility.lessons.maximumslice;

public class MaximumSliceTechnique {

	public int solution_O_n_time(int[] A) {
		int r = A[0];
		int t = A[0];
		int n = A.length;
		for (int i = 1; i < n; i++) {
			t = Math.max(A[i], t + A[i]);
			r = Math.max(r, t);
		}
		return r;
	}
	
	
	public int solution_0_n2_time(int[] A) {
		int [] prefixSum = new int [A.length + 1];
		for(int i = 0; i < A.length; i++) {
			prefixSum[i+1] = prefixSum[i] + A[i];
		}
		
		int max = 0;
		int tempDiff = 0;
		for(int i = 1; i < prefixSum.length; i++) {
			for(int i2 = i; i2 < prefixSum.length - 1; i2++) {
				tempDiff = prefixSum[i2 + 1] - prefixSum[i];
				max = Math.max(max, tempDiff);
			}
		}		
		return max;
	}
	
	
	private static final int [] ARRAY = {5,-7,3,5,-2,4,-1};
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumSliceTechnique vMaximumSliceTechnique = new MaximumSliceTechnique();
		//System.out.println("\n" + vMaximumSliceTechnique.solution_O_n_time(ARRAY));
		System.out.println("\n" + vMaximumSliceTechnique.solution_0_n2_time(ARRAY));
	}

}
