package com.codility.lessons.timecomplexity;

public class FrogJmp {

	public int solution(int X, int Y, int D) {		
		int diff = Y - X;		
		if(diff % D != 0) {
			return (diff / D) + 1;
		}
		return (diff / D);
	}
	
	private final static int CONSTANT_INITIAL_POSITION = 10;
	private final static int CONSTANT_GOAL_POSITION = 85;
	private final static int CONSTANT_JUMP_DISTANCE = 30;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FrogJmp vFrogJmp = new FrogJmp();
		System.out.println("\n initial position: " + CONSTANT_INITIAL_POSITION 
						 + "\n goal position: " + CONSTANT_GOAL_POSITION 
						 + "\n required jumps: " + vFrogJmp.solution(CONSTANT_INITIAL_POSITION, CONSTANT_GOAL_POSITION, CONSTANT_JUMP_DISTANCE));
	}

}
