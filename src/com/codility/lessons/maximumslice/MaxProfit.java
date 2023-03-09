package com.codility.lessons.maximumslice;

public class MaxProfit {

	public int solution(int[] A) {
		if(A.length <= 1) {
			return 0;
		}else if(A.length == 2) {
			return A[1] - A[0] > 0 ? A[1] - A[0] : 0;
		}
		
		int maxDiff = -200000;
		for(int i = 1; i < A.length; i++) {
			for(int i2 = 0; i2 < i; i2++) {
				if(A[i] - A[i2] > maxDiff) {
					maxDiff = A[i] - A[i2];	
				}				
			}
		}		
		return maxDiff > 0 ? maxDiff : 0;
	}
	
	//private static final int [] ARRAY = {23171,21011,21123,21366,21013,21367};
	//private static final int [] ARRAY = {1,2,3};
	private static final int [] ARRAY = {8, 9, 3, 6, 1, 2};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxProfit vMaxProfit = new MaxProfit();
		System.out.println("\n" + vMaxProfit.solution(ARRAY));
	}

}
