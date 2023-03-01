package com.codility.lessons.countingelements;

public class MissingInteger {

	
	public int solution(int[] A) {
		return 0;
	}
	
	private int process(int[] A) {		
		//1, 3, 6, 4, 1, 2
		if(A.length == 1 && A[0] <= 0) {
			return 1;
		}else if (A.length == 1 && A[0]>1) {
			return A[0] - 1;
		}else if (A.length == 1) {
			return A[0] + 1;
		}
		
		int minValue = 100000;
		int maxValue = -100000;
		long summationA = 0;
		for(int i = 0; i < A.length; i++) {			
			if((minValue > A[i] || maxValue < A[i])) {
				summationA+=A[i];
				if(minValue > A[i]) {
					minValue = A[i];
				}
				if(maxValue < A[i]) {
					maxValue = A[i];
				}
			}else if(A[i] != minValue && A[i] != maxValue) {
				summationA+=A[i];
			}
		}
		if(minValue == 1) {//max >= 1
			long gaussSumMax = maxValue * (maxValue + 1) / 2;
			long result = gaussSumMax - summationA; 
			return (int) (result == 0 ? maxValue + 1 : result) ;
		/*}else if (minValue > 1) {max > 1
			long gaussSumMax = maxValue * (maxValue + 1) / 2;
			long gaussSumMin = (minValue-1) * (minValue) / 2;
			long gaussSum = gaussSumMax - gaussSumMin;
			long result = gaussSum - summationA;
			return (int)result;*/
		}else{
			return 1;
		}		
	}

	//1+3+6+4+2=16
	//21-16=5 
	
	
	//6*7/2 = 21
	//6+5+4+3+2+1=21
	
	
	//6+5+4= 15
	//3*4/2 = 6
	//6+5+4+3+2+1=21 - 6 = 15
	
	//private static final int[]  ARRAY = {1, 3, 6, 4, 1, 2};
	private static final int[]  ARRAY = {4, 5, 6, 2};
	//private static final int[]  ARRAY = {1, 2, 3};
	//private static final int[]  ARRAY = {-1, -3};
	//private static final int[]  ARRAY = {-1};
	//private static final int[]  ARRAY = {1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MissingInteger vMissingInteger = new MissingInteger();
		System.out.println("\n " + vMissingInteger.process(ARRAY));
		
	}

}
