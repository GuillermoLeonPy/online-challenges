package com.codility.lessons.timecomplexity;

public class ReadingMaterialExcercise {

	private int solution(int n) {
		return n * (n + 1) / 2;
	}
	
	private int slowSolution(int n) {
		int result = 1;
		for(int i = 2; i < n; i++) {
			result+=i;
		}
		
		return result+=n;
	}
	
	private final static int CONSTANT = 3;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadingMaterialExcercise vReadingMaterialExcercise = new ReadingMaterialExcercise();
		System.out.println("\n the value: " + CONSTANT + "\n 1+2... +" + CONSTANT + " = " + vReadingMaterialExcercise.slowSolution(CONSTANT));
		System.out.println("\n the value: " + CONSTANT + "\n 1+2... +" + CONSTANT + " = " + vReadingMaterialExcercise.solution(CONSTANT));
	}

}
