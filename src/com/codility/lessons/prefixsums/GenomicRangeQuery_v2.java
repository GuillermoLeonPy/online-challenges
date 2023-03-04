package com.codility.lessons.prefixsums;

public class GenomicRangeQuery_v2 {

	public int[] solution(String S, int[] P, int[] Q) {
		char [] S_array = S.toCharArray();
		if(S_array.length == 1) {
			int[] result = new int[1];
			if(S_array[0] == 'A') {
				result[0] = 1;
			}else if(S_array[0] == 'C') {
				result[0] = 2;
			}else if(S_array[0] == 'G') {
				result[0] = 3;
			}else {
				result[0] = 4;
			}
			return result;
		}
		
		
		int [] minimalImpactFactor = new int [P.length];
		
		int [] A_mark = new int [S_array.length + 1];
		int [] C_mark = new int [S_array.length + 1];
		int [] G_mark = new int [S_array.length + 1];
		int [] T_mark = new int [S_array.length + 1];
		
		
		for(int i = 0; i < S_array.length; i++) {
			if(S_array[i] == 'A') {
				A_mark[i+1] = A_mark[i] + 1;
			}else {
				A_mark[i+1] = A_mark[i];
			}
			if(S_array[i] == 'C') {
				C_mark[i+1] = C_mark[i] + 1;
			}else {
				C_mark[i+1] = C_mark[i];
			}
			if(S_array[i] == 'G') {
				G_mark[i+1] = G_mark[i] + 1;
			}else {
				G_mark[i+1] = G_mark[i];
			}
			if(S_array[i] == 'T') {
				T_mark[i+1] = T_mark[i] + 1;
			}else {
				T_mark[i+1] = T_mark[i];
			}

		}

		//A, C, G, T
		//1, 2, 3, 4

		//	2,1,3,2,2,4,1
		//A	0,1,1,1,1,1,2
		//C 1,1,1,2,3,3,3
		//G 0,0,1,1,1,1,1
		//T 0,0,0,0,0,1,1

		
		for(int i = 0; i < P.length; i++) {
			if(A_mark[Q[i]+1] - A_mark[P[i]] > 0){
				minimalImpactFactor[i] = 1;
				continue;
			}else if(C_mark[Q[i]+1] - C_mark[P[i]] > 0) {
				minimalImpactFactor[i] = 2;
				continue;
			}else if(G_mark[Q[i]+1] - G_mark[P[i]] > 0) {
				minimalImpactFactor[i] = 3;
				continue;
			}else {
				minimalImpactFactor[i] = 4;
			}
		}
		return minimalImpactFactor;
	}


	
	private String getPrintableArray(int [] A) {
		StringBuilder sb = new StringBuilder();
		for(int i= 0; i < A.length; i++) {
			sb.append("" + A[i] + ( i  < A.length - 1 ? "," : ""));
		}
		return sb.toString();
	}
	/*
	private static final String CONSTANT = "CAGCCTA";
	private static final int [] P_ARRAY = {2,5,0};
	private static final int [] Q_ARRAY = {4,5,6};
	*/
	
	private static final String CONSTANT = "AC";
	private static final int [] P_ARRAY = {0,0,1};
	private static final int [] Q_ARRAY = {0,1,1};
	
	/*
	private static final String CONSTANT = "CC";
	private static final int [] P_ARRAY = {0,0,1};
	private static final int [] Q_ARRAY = {0,1,1};
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenomicRangeQuery_v2 vGenomicRangeQuery = new GenomicRangeQuery_v2();
		System.out.println("\n "+ vGenomicRangeQuery.getPrintableArray(vGenomicRangeQuery.solution(CONSTANT, P_ARRAY, Q_ARRAY)) );
	}

}
