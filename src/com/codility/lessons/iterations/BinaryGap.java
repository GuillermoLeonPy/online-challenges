package com.codility.lessons.iterations;

public class BinaryGap {

	public int solution(int N) {
		
		return mainProcess(N);
	}

	public int mainProcess(int N) {
		char[] binaryRepresentation = getBinaryRepresentation(N);
		int maxBinaryGap = 0;
		int binaryGapCount = 0;
		
		for(int i = 1; i < binaryRepresentation.length; i++) {
			//10000010001
			if((binaryRepresentation[i - 1] == '1' && binaryRepresentation[i] == '0') 
				|| 
			(binaryRepresentation[i - 1] == '0' && binaryRepresentation[i] == '0')) {
				binaryGapCount++;
			}else if(binaryRepresentation[i - 1] == '0' && binaryRepresentation[i] == '1') {
				if(maxBinaryGap < binaryGapCount) {
					maxBinaryGap = binaryGapCount;	
				}					
				binaryGapCount = 0;
			}					
		}
		return maxBinaryGap;
	}
	
	private char[] getBinaryRepresentation(int N) {
		return Integer.toBinaryString(N).toCharArray();
	}
	
	
	private void test_getBinaryRepresentation() {
		BinaryGap vBinaryGap = new BinaryGap();
		System.out.println("\n number: " + CONSTANT + "\n binary representation: " + String.valueOf(vBinaryGap.getBinaryRepresentation(CONSTANT)));
	}
	
	//private static final int CONSTANT = 1041;
	//private static final int CONSTANT = 15;
	//private static final int CONSTANT = 9;
	//private static final int CONSTANT = 529;
	//private static final int CONSTANT = 20;
	//private static final int CONSTANT = 32;
	private static final int CONSTANT = 5;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryGap vBinaryGap = new BinaryGap();
		//vBinaryGap.test_getBinaryRepresentation();
		System.out.println("\n for the binary: " + String.valueOf(vBinaryGap.getBinaryRepresentation(CONSTANT))
		+"\n the longest binary gap lenght is: " + vBinaryGap.solution(CONSTANT));		
		
	}
}
