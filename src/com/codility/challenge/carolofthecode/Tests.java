package com.codility.challenge.carolofthecode;

import java.util.Arrays;

public class Tests {

	private static final boolean USE_COPY_ARRAY = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [] tN = {'1','2','3','4','5','6','7','8','9','0'};
		char [] temp_tN =  Arrays.copyOf(tN, tN.length);
		test(USE_COPY_ARRAY ? temp_tN : tN);
		for(int i = 0; i < tN.length; i++) {
			System.out.println(tN[i]);
		}
	}
	
	private static void test(char [] tN) {
		char [] temp_tN = tN;
		temp_tN[0] = 'x';
		temp_tN[1] = 'Y';
	}

}
