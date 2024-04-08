package com.leetcode.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class AsteroidCollision {

//	private static int[] ARRAY = {5,10,-5};
//	private static int[] CORRECT_ANSWER = {5,10};
	
//	private static int[] ARRAY = {10,2,-5};
//	private static int[] CORRECT_ANSWER = {10};
	
//	private static int[] ARRAY = {-2,-1,1,2};
//	private static int[] CORRECT_ANSWER = {-2,-1,1,2};
	
//	private static int[] ARRAY = {-2,-2,1,-2};
//	private static int[] CORRECT_ANSWER = {-2,-2,-2};
	
//	private static int[] ARRAY = {8,-8};
//	private static int[] CORRECT_ANSWER = {};
	
//	private static int[] ARRAY = {-1,5,-2,0,0,4,-1,0,2};
//	private static int[] CORRECT_ANSWER = {-1,5,4,2};
	
//	private static int[] ARRAY = {-2,-2,1,-1};
//	private static int[] CORRECT_ANSWER = {-2,-2};
	
	private static int[] ARRAY = {1,-2,-2,-2};
	private static int[] CORRECT_ANSWER = {-2,-2,-2};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] result = asteroidCollision(ARRAY);
		
		System.out.println(Arrays.equals(CORRECT_ANSWER, result) ?
				"success !"
				: "error \n returned: " + Arrays.stream(result).boxed().collect(Collectors.toList())
				+"\n expected: " + Arrays.stream(CORRECT_ANSWER).boxed().collect(Collectors.toList()));
	}
	
	
    public static int[] asteroidCollision_non_optimal(int[] asteroids) {
    	List<Integer> list = new ArrayList<>();
    	for(int i = 0; i < asteroids.length; i++) {
    		list.add(asteroids[i]);
    	}
    	
    	for(int i = 0; i < asteroids.length; i++) {
    		boolean exit = list.size() < 2;
    		int index = 0;
    		while(!exit) {
    			if(collision(list.get(index), list.get(index + 1))) {
    				if(deleteBoth(list.get(index), list.get(index + 1))) {
    					list.remove(index);
    					list.remove(index);
    				}else if(deleteRigth(list.get(index), list.get(index + 1))){
    					list.remove(index+1);
    				}else {
    					list.remove(index);
    				}    				
    				index = 0;
    			}else {
    				index++;
    			}    			
    			if(index >= list.size() - 1) {
    				exit = true;
    			}
    		}
    		if(list.size() < 2) {
    			break;
    		}
    	}
    	int[] result = new int[list.size()];
    	for(int i = 0; i < result.length; i++) {
    		result[i] = list.get(i);
    	}
    	
        return result;
    }
    
    private static boolean collision(int left, int rigth) {
    	if((rigth < 0 && left < 0) 
    			|| (rigth > 0 && left > 0)
    			|| (rigth > left)) {
    		return false;
    	}
    	
    	return true;
    }
    
    private static boolean deleteRigth(int left, int rigth) {
    	return left > Math.abs(rigth);
    }
    
    private static boolean deleteBoth(int left, int rigth) {
    	return left + rigth == 0;
    }
    
    public static int[] asteroidCollision(int[] asteroids) {
    	
    	Stack<Integer> stack = new Stack<>();
    	for(int i = 0; i < asteroids.length; i++) {
    		if(stack.isEmpty() || asteroids[i] > 0) {
    			stack.push(asteroids[i]);
    		}else {
    			while(true) {    				
    				int stackPeek = stack.peek();
    				if(stackPeek < 0) {
    					stack.push(asteroids[i]);
    					break;
    				}else if(stackPeek > 0) {
    					if(asteroids[i] + stackPeek == 0) {
    						stack.pop();
    						break;
    					}else if(asteroids[i] + stackPeek < 0) {
    						stack.pop();
    						if(stack.isEmpty()) {
    							stack.push(asteroids[i]);
    							break;
    						}
    					}else {
    						break;
    					}    					   					
    				}
    			}
    		}
    	}
    	
    	int [] result = new int[stack.size()];

    	for(int i = result.length - 1; i >= 0; i--) {
    		result[i] = stack.pop();
    	}
        return result;
    }
}
