package com.codility.lessons.stacksandqueues;

import java.util.LinkedList;
import java.util.List;

public class StoneWall {

	public int solution(int[] H) {
		if(H.length == 1) {
			return 1;
		}
		List<Integer> stack = new LinkedList<>();		
		int sumLessThanOrEqualElement = 0;
		int tempDifference = 0;
		int blockCounter = 0;
		for(int i = 0; i < H.length; i++) {
			if(i == 0) {
				pushStack(stack, H[i]);
				blockCounter++;
			}else {
				sumLessThanOrEqualElement = getStackSumByLessThanOrEqualLimit(H[i], stack);				
				if(H[i] == sumLessThanOrEqualElement) {
					continue;
				}else if(sumLessThanOrEqualElement == 0) {
					clearStackAndAddElement(stack, H[i]);
					blockCounter++;
				}else {//H[i] > sumLessThanOrEqualElement && sumLessThanOrEqualElement > 0 
					tempDifference = getTheDifference(H[i], sumLessThanOrEqualElement);
					pushStack(stack, tempDifference);
					blockCounter++;
				}
			}
			
		}
		
		return blockCounter;
	}
	
	private void clearStackAndAddElement(List<Integer> stack, int element) {
		clearStack(stack);
		pushStack(stack, element);
	}
	
	
	private int getTheDifference(int A, int B) {
		return A - B;
	}
	
	private void clearStack(List<Integer> stack) {
		stack.clear();
	}
	
	private void pushStack(List<Integer> stack, int element) {
		stack.add(element);
	}
	
	private int getStackSumByLessThanOrEqualLimit(int lessThanOrEqualLimit, List<Integer> stack) {
		if(lessThanOrEqualLimit == 0) {
			return stack.stream().mapToInt(Integer::intValue).sum();
		}else {
			int sum = 0;
			for(int element: stack) {
				sum+=element;
				if(sum == lessThanOrEqualLimit) {					
					break;
				}else if(sum > lessThanOrEqualLimit	) {					
					sum-=element;
					break;
				}
			}
			return sum;
		}		
	}	

	private static final int [] ARRAY = {8,8,5,7,9,8,7,4,8};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StoneWall vStoneWall = new StoneWall();
		System.out.println("\n" + vStoneWall.solution(ARRAY));
	}

}
