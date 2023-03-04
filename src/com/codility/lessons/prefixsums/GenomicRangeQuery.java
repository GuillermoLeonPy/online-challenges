package com.codility.lessons.prefixsums;

public class GenomicRangeQuery {

	public int[] solution(String S, int[] P, int[] Q) {
		return new int [0];
	}
	
	//A, C, G, T
	//1, 2, 3, 4
	private int[] process(String S, int[] P, int[] Q) {
		char [] arrayS = S.toCharArray();
		if(arrayS.length == 1) {
			int[] result = new int[1];
			result[0] = getImpactByLetter(arrayS[0]);
			return result;
		}
		int minimalImpact = 5;
		int letterImpact = 0;
		int[] minimalImpactArrayResult = new int[P.length];
		for(int i = 0; i < P.length; i++) {
			minimalImpact = 5;
			for(int i2 = P[i]; i2 <= Q[i]; i2++) {
				letterImpact = getImpactByLetter(arrayS[i2]);
				if(letterImpact == 1) {
					minimalImpactArrayResult[i] = 1;
					break;
				}
				if(letterImpact < minimalImpact) {
					minimalImpact = letterImpact;
					minimalImpactArrayResult[i] = minimalImpact;
				}
			}			
		}
		return minimalImpactArrayResult;
	}
	
	
	private int getImpactByLetter(char letter) {		
		if(letter == 'A') {
			return 1;
		}else if(letter == 'C') {
			return 2;
		}else if(letter == 'G') {
			return 3;
		}else {
			return 4;
		}
	}
	
	private String getPrintableArray(int [] A) {
		StringBuilder sb = new StringBuilder();
		for(int i= 0; i < A.length; i++) {
			sb.append("" + A[i] + ( i  < A.length - 1 ? "," : ""));
		}
		return sb.toString();
	}
	
	private static final String CONSTANT = "CAGCCTA";
	private static final int [] P_ARRAY = {2,5,0};
	private static final int [] Q_ARRAY = {4,5,6};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenomicRangeQuery vGenomicRangeQuery = new GenomicRangeQuery();
		System.out.println("\n "+ vGenomicRangeQuery.getPrintableArray(vGenomicRangeQuery.process(CONSTANT, P_ARRAY, Q_ARRAY)) );
	}

}
