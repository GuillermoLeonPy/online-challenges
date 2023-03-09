package com.codility.lessons.leader;

import java.util.Stack;

public class EquiLeader {

	public int solution(int[] A) {
		if(A.length == 1) {
			return 0; 
		}else if (A.length == 2 && A[0] != A[1]) {
			return 0; 
		}
		int leader = findLeader(A);
		int countLeaderOcurrences = 0;
		int sequenceElementCount = 0;
		int potentialEquiLeaderCountLeaderOcurrences = 0;
		int potentialEquiLeaderSequenceCountElements = 0;
		Stack<Integer> equiLeaderIndexesStack = new Stack<>();
		for(int i = 0; i < A.length; i++) {
			if(A[i] == leader) {
				countLeaderOcurrences++;
			}
			sequenceElementCount++;
			if(countLeaderOcurrences > sequenceElementCount / 2) {
				//i+1 is a potential equiLeader
				potentialEquiLeaderCountLeaderOcurrences = 0;
				potentialEquiLeaderSequenceCountElements = (A.length - (i + 1));				
				for(int i2 = i + 1; i2 < A.length; i2++) {
					if(A[i2] == leader){
						potentialEquiLeaderCountLeaderOcurrences++;
					}
				}
				if(potentialEquiLeaderCountLeaderOcurrences > (potentialEquiLeaderSequenceCountElements / 2)) {
					equiLeaderIndexesStack.push(i);
				}
			}
		}
		
		printEquiLeaderIndexes(equiLeaderIndexesStack);
		return equiLeaderIndexesStack.size();
	}
	
	
	private int findLeader(int[] A) {
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < A.length; i++) {
			if(!stack.isEmpty() && stack.peek() != A[i]) {
				stack.pop();
			}else if(stack.isEmpty() || (!stack.isEmpty() && stack.peek() == A[i])){
				stack.push(A[i]);
			}			
		}	
		return stack.peek();
	}
	
	private void printEquiLeaderIndexes(Stack<Integer> stack) {
		System.out.println("\n" + stack);
	}
	
	
	private static final int [] ARRAY = {4,3,4,4,4,2};
	//private static final int [] ARRAY = {0,7,0,0,0,7,7,7,7,7};
	//private static final int [] ARRAY = {1,1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EquiLeader vEquiLeader = new EquiLeader();
		System.out.println("\n" + vEquiLeader.solution(ARRAY));
	}

}
