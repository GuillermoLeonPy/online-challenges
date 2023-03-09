package com.codility.lessons.leader;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class EquiLeader_v2 {

	public int solution(int[] A) {
		if(A.length == 1) {
			return 0; 
		}else if (A.length == 2 && A[0] != A[1]) {
			return 0; 
		}
		int [] leader = findLeader(A);
		if(leader[0] == -1 && leader[1] == -1) {
			return 0;
		}
		
		int leaderOcurrencesCount = 0;
		int elementsToTheRightSide = 0;
		int leadersCountToTheRightSide = 0;
		Stack<Integer> equiLeaderIndexes = new Stack<>();		
		for(int i = 0; i < A.length; i++) {
			if(A[i] == leader[0]) {
				leaderOcurrencesCount++;
			}
			if(leaderOcurrencesCount > ((i + 1) / 2)) {
				elementsToTheRightSide = A.length - (i + 1);
				leadersCountToTheRightSide = leader[1] - leaderOcurrencesCount;
				if(leadersCountToTheRightSide > (elementsToTheRightSide) / 2) {
					equiLeaderIndexes.push(i);
				}
			}
		}
		
		printEquiLeaderIndexes(equiLeaderIndexes);
		return equiLeaderIndexes.size();
	}
	
	
	private int [] findLeader(int[] A) {
		Map<Integer,Integer> elementsCount = new HashMap<>();
		for(int i = 0; i < A.length; i++) {
			if(elementsCount.containsKey(A[i])) {
				elementsCount.put(A[i], elementsCount.get(A[i]) + 1);
			}else {
				elementsCount.put(A[i], 1);
			}
		}
		int maxOcurrences = 0;
		int maxOcurrencesValue = 0;
		for(int i : elementsCount.keySet()) {
			if(elementsCount.get(i) > maxOcurrences) {
				maxOcurrences = elementsCount.get(i);
				maxOcurrencesValue = i;
			}
		}
		int [] result = new int [2];
		if(maxOcurrences > (A.length / 2)) {			
			result[0] = maxOcurrencesValue;
			result[1] = maxOcurrences;
		}else {
			result[0] = -1;
			result[1] = -1;			
		}
		return result;
	}
	
	private void printEquiLeaderIndexes(Stack<Integer> stack) {
		System.out.println("\n" + stack);
	}
	
	//private static final int [] ARRAY = {4,3,4,4,4,2};
	private static final int [] ARRAY = {0,7,0,0,0,7,7,7,7,7};
	//private static final int [] ARRAY = {1,1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EquiLeader_v2 vEquiLeader = new EquiLeader_v2();
		System.out.println("\n" + vEquiLeader.solution(ARRAY));
	}

}
