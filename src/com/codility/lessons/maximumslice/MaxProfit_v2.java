package com.codility.lessons.maximumslice;

public class MaxProfit_v2 {
	
	public int solution(int[] A) {
		if(A.length <= 1) {
			return 0;
		}else if(A.length == 2) {
			return A[1] - A[0] > 0 ? A[1] - A[0] : 0;
		}
		int max = 0;
		int maxIndex = 0;
		int min = 200000;
		int minIndex = 0;
		int maxDiference = 0;
		for(int i = 0; i < A.length; i++) {
			if(A[i] < min) {				
				min = A[i];
				minIndex = i;
				if(maxIndex < minIndex) {
					max = min;
					maxIndex = minIndex;					
					continue;
				}
			}
			if(A[i] > max) {
				max = A[i];
				maxIndex = i;
				if(maxDiference < max - min) {
					maxDiference = max - min;
				}
			}			
		}
		
		
		return maxDiference > 0 ? maxDiference : 0;	
				
	}
	
	private static final int [] ARRAY = {23171,21011,21123,21366,21013,21367};
	//private static final int [] ARRAY = {8, 9, 3, 6, 1, 2};
	
	public static void main(String[] args) {
		MaxProfit_v2 vMaxProfit = new MaxProfit_v2();
		System.out.println("\n" + vMaxProfit.solution(ARRAY));
	}
}
