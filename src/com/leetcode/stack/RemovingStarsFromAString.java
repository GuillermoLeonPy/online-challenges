package com.leetcode.stack;

import java.util.Stack;

public class RemovingStarsFromAString {

//	private static String S = "leet**cod*e";
//	private static String CORRECT_ANSWER = "lecoe";
	
	private static String S = "leet**cod*e";
	private static String CORRECT_ANSWER = "lecoe";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String result = removeStars(S);
		System.out.println(
				result.equals(CORRECT_ANSWER) ? 
						"success !" 
						: "error \n\n   string: " + S + "\n expected: " + CORRECT_ANSWER);
	}
	
	
	public static String removeStars(String s) {
		Stack<Character> stack = new Stack<>();
		int skipCounter = 0;
		for(int i = s.length() - 1; i >= 0; i--) {
			char symbol = s.charAt(i);
			if(symbol == '*') {				
				skipCounter++;
			}else if(skipCounter > 0){
				skipCounter--;				
			}else {
				stack.push(symbol);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}
}
