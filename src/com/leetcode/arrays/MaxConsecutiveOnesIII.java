package com.leetcode.arrays;

public class MaxConsecutiveOnesIII {

	
	//private static int[] ARRAY = {1,1,1,0,0,0,1,1,1,1,0};	
	//private static int K = 2;
	
	private static int[] ARRAY = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};	
	private static int K = 3;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestOnes(ARRAY, K));
	}

    public static int longestOnes(int[] nums, int k) {
    	int L = 0, R = 0, zeroCount = 0, max = 0;
    	
    	while(R < nums.length) {
    		if(nums[R] == 0) {
    			zeroCount++;
    			if(zeroCount > k) {
    				while(zeroCount > k) {
    					if(nums[L] == 0) {
    						zeroCount--;
    					}
    					L++;
    				}    				
    			}
    		}
    		R++;
    		max = Math.max(max, R - L);
    	}
    	
    	return max;
    }
}
