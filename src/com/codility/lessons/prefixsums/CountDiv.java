package com.codility.lessons.prefixsums;

public class CountDiv {

	public int solution(int A, int B, int K) {
		return 0;
	}
	//1 2 3 4 5 6 7 8 9
	//2
	//  2   4   6   8
	//      4       8
	//11 12 13 14
	//1 2 3 4 5 6 7 8 9
	//  *   *   *   *
	//8 / 2 = 4
	//1 2 3 4 5 6 7 8 9
	//      *       *
	//8 / 4 = 2 
	private int process(int A, int B, int K) {		
		if((A == 0 && A == B) ) {
			return 1;
		}else if((A == B && A % K != 0)) {
			return 0;
		}else if((A == B && A % K == 0)) {
			return 1;
		}
		
		int counter = 0;
		
		if(A < K) {
			if(A == 0) {
				counter++;
			}
			A = K;
		}else {
			while(A % K != 0) {
				if(A + 1 > B) {
					break;
				}
				A++;				
			}			
		}
		
		while(B % K != 0) {
			if(B - 1 < A) {
				break;
			}
			B--;
		}
		return ((B-A)/K) + 1 + counter;
		
	}
	
	private static final int A_NUMBER = 11;
	private static final int B_NUMBER = 25;
	private static final int K_NUMBER = 7;
	/*
	private static final int A_NUMBER = 11;
	private static final int B_NUMBER = 14;
	private static final int K_NUMBER = 2;
	*/
	/*
	private static final int A_NUMBER = 6;
	private static final int B_NUMBER = 11;
	private static final int K_NUMBER = 2;
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDiv vCountDiv = new CountDiv();
		System.out.println("\n" + vCountDiv.process(A_NUMBER, B_NUMBER, K_NUMBER));
	}

}
