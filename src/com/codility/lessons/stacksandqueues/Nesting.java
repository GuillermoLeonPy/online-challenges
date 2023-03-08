package com.codility.lessons.stacksandqueues;

import java.util.LinkedList;
import java.util.List;

public class Nesting {
	
	public int solution(String S) {
		if(S.length() <= 1) {
			return 1;
		}
		
		char [] A = S.toCharArray();
		List<String> stack = new LinkedList<>();
		boolean isOpenBracket = false;
		boolean isCloseBracket = false;
		char popElement = ' ';
		boolean isProperlyNested = true;
		int notBracketConsecutiveElementsCounter = 0;
		for(int i = 0; i < A.length; i++) {
			char element = A[i];
			isOpenBracket = isOpenBracket(element);
			isCloseBracket = isCloseBracket(element);
			if(isOpenBracket) {
				pushStack(stack, element);
			}else if(isCloseBracket && stack.size() == 0) {
				isProperlyNested = false;
				break;
			}else if(isCloseBracket) {
				popElement = popStack(stack);
				if(!matchBrackets(popElement, element)) {
					isProperlyNested = false;
					break;
				}
			}else {
				notBracketConsecutiveElementsCounter++;
				if(notBracketConsecutiveElementsCounter > 1) {
					isProperlyNested = false;
					break;
				}
			}
		}
		
		if(stack.size() > 0) {
			isProperlyNested = false;
		}
		
		
		return (isProperlyNested ? 1 : 0);
	}
	
	private boolean matchBrackets(char popFromStack, char currentElement) {
		if(!isOpenBracket(popFromStack) || !isCloseBracket(currentElement)) {
			return false;
		}else if(popFromStack == LEFT_PARENTHESIS_BRACKET && currentElement != RIGHT_PARENTHESIS_BRACKET) {
			return false;
		}else {
			return true;
		}
	}
	
	private boolean isOpenBracket(char element) {
		if(element == LEFT_PARENTHESIS_BRACKET) {
			return true;
		}else {
			return false;
		}
	}
	
	private boolean isCloseBracket(char element) {
		if(element == RIGHT_PARENTHESIS_BRACKET) {
			return true;
		}else {
			return false;
		}
	}	
	
	private void pushStack(List<String> stack, char element) {
		stack.add(String.valueOf(element));
	}
	
	private char popStack(List<String> stack) {		
		return stack.remove(stack.size() - 1).toCharArray()[0];
	}
	

	
	private static final char LEFT_PARENTHESIS_BRACKET = '(';
	private static final char RIGHT_PARENTHESIS_BRACKET = ')';
	
	//private static final String TEST_STRING_VALUE = "(()(())())";
	private static final String TEST_STRING_VALUE = "())";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Nesting vNesting = new Nesting();
		//vBrackets.testRightShift();
		//vBrackets.testLeftShift();
		System.out.println("\n " + vNesting.solution(TEST_STRING_VALUE));
	}

}
