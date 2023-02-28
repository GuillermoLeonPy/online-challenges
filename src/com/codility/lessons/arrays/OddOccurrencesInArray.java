package com.codility.lessons.arrays;

public class OddOccurrencesInArray {

	public int solution(int[] A) {
		return process(A);
	}
	
	private boolean [] getPairedIndexes(int[] A) {
		int arrayLength = A.length;
		boolean [] pairedIndexes = new boolean [arrayLength];		
		int pairedIndexsCounter = 0;
		int pairQty = (arrayLength - 1) / 2;
		for(int i = 0; i < arrayLength; i++) {	
			if(pairedIndexsCounter == pairQty)
				break;
			if(pairedIndexes[i])
				continue;
			for(int i2 = 0; i2 < arrayLength; i2++) {
				if(i == i2 || pairedIndexes[i] || pairedIndexes[i2])
					continue;
				if(A[i] == A[i2]) {
					pairedIndexes[i] = true;
					pairedIndexes[i2] = true;
					pairedIndexsCounter++;
					break;
				}
			}
		}		
		return pairedIndexes;
	}
	
	private int process(int[] A) {
		if(A.length == 1)return A[0];
		
		boolean [] pairedIndexes = getPairedIndexes(A);
		int unPairedValue = -1;
		for(int i = 0; i < pairedIndexes.length; i++) {
			if(!pairedIndexes[i]) {
				unPairedValue = A[i];
				break;
			}
		}
		printResults(A, pairedIndexes, unPairedValue);
		
		return unPairedValue;
	}
	
	
	private void printResults(int[] A, boolean [] pairedIndexes, int unPairedValue) {
		System.out.println("\n given the values array: " + getPrintableArray(A) 
		+ "\n the paired Indexes are: " + getPrintableArray(pairedIndexes)
		+ "\n the unpaired value is: " + unPairedValue);
	}
	
	
	private String getPrintableArray(boolean [] A) {
		StringBuilder sb = new StringBuilder();
		for(int i= 0; i < A.length; i++) {
			sb.append("" + A[i] + ( i  < A.length - 1 ? "," : ""));
		}
		return sb.toString();
	}
	
	private String getPrintableArray(int [] A) {
		StringBuilder sb = new StringBuilder();
		for(int i= 0; i < A.length; i++) {
			sb.append("" + A[i] + ( i  < A.length - 1 ? "," : ""));
		}
		return sb.toString();
	}
	
	private static final int [] CONSTANT = {9,3,9,3,9,9,7};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OddOccurrencesInArray vOddOccurrencesInArray = new OddOccurrencesInArray();
		System.out.println("\n" + vOddOccurrencesInArray.solution(CONSTANT));
		//System.out.println("\n" + vOddOccurrencesInArray.process(CONSTANT));
	}
}
