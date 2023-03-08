package com.codility.lessons.stacksandqueues;

import java.util.LinkedList;
import java.util.List;

public class Fish {

	public int solution(int[] A, int[] B) {
		if(A.length == 1) {
			return 1;
		}
		List<Integer> upStreamStack = new LinkedList<>();
		List<Integer> downStreamStack = new LinkedList<>();
		
		for(int i = 0; i < A.length; i++) {
			if(i == 0) {
				if(B[i] == DOWN_STREAM_DIRECTION) {
					pushStack(downStreamStack, i);
					continue;
				}else {
					pushStack(upStreamStack, i);
					continue;
				}
			}else {
				if(B[i] == DOWN_STREAM_DIRECTION) {
					pushStack(downStreamStack, i);
				}else if(B[i] == UP_STREAM_DIRECTION && stackContainsElements(downStreamStack)) {
					while(stackContainsElements(downStreamStack)) {
						if(A[i] > A[getLastInElementFromStack(downStreamStack)]) {
							popStack(downStreamStack);
							if(!stackContainsElements(downStreamStack)) {
								pushStack(upStreamStack, i);
								break;
							}
						}else {
							break;
						}
					}					
				}else if(B[i] == UP_STREAM_DIRECTION) {
					pushStack(upStreamStack, i);
				}
			}
		}
		
		return upStreamStack.size() + downStreamStack.size();
	}
	
	private boolean stackContainsElements(List<Integer> stack) {
		return !stack.isEmpty();
	}
	
	private void pushStack(List<Integer> stack, int element) {
		stack.add(element);
	}
	
	private int popStack(List<Integer> stack) {
		return stack.remove(stack.size() - 1);
	}
	
	private int getLastInElementFromStack(List<Integer> stack) {
		return stack.get(stack.size() - 1);
	}
	
	
	private static final int DOWN_STREAM_DIRECTION = 1;
	private static final int UP_STREAM_DIRECTION = 0;

	
	private static final int [] A = {4,3,2,1,5};//result = 2
	private static final int [] B = {0,1,0,0,0};
	/*
	private static final int [] A = {4,3,2,1,5,7,6,8};//result = 
	private static final int [] B = {1,0,1,0,1,0,1,0};
	*/
	/*
	private static final int [] A = {4,5,2,6,5};
	private static final int [] B = {1,1,0,0,0};
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fish vFish = new Fish();
		System.out.println("\n" + vFish.solution(A, B));
	}

}
