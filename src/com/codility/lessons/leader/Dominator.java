package com.codility.lessons.leader;

import java.util.Stack;

public class Dominator {
	
	public int solution(int[] A) {
		if(A.length == 0) {
			return -1;
		}else if(A.length == 1) {
			return 0;
		}else if(A.length == 2) {
			return (A[0] == A[1] ? 0 : -1);
		}
		
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < A.length; i++) {
			if(i == 0) {
				stack.push(A[i]);
			}else {
				if(!stack.isEmpty() && !(stack.peek() == A[i])) {
					stack.pop();
				}else {
					stack.push(A[i]);
				}
			}
		}
		
		if(stack.isEmpty()) {
			return -1;
		}
		
		int candidate = stack.peek();
		int counter = 0;
		int lastIndex = 0;
		for(int i = 0; i < A.length; i++) {
			if(A[i] == candidate) {				
				counter++;
				lastIndex = i;
			}
		}
		
		
		
		return (A.length / 2) < counter ? lastIndex : -1;
	}
	
	
	//private static final int [] ARRAY = {3,4,3,2,3,-1,3,3};
	//private static final int [] ARRAY = {3,3,3,0,0,0,3};
	private static final int [] ARRAY = {3,0,1,2,4,5,3};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dominator vDominator = new Dominator();
		System.out.println("\n" + vDominator.solution(ARRAY));
	}

}
