package com.leetcode.arrays;

public class LongestSubarrayOf1AfterDeletingOneElement {
	
	private static int[] ARRAY = {1,1,0,1};
	private static int CORRECT_ANSWER = 3;	
	
	//private static int[] ARRAY = {0,1,1,1,0,1,1,0,1};
	//private static int CORRECT_ANSWER = 5;
	
	//private static int[] ARRAY = {1,1,0,0,1,1,1,0,1};
	//private static int CORRECT_ANSWER = 4;
	
	//private static int[] ARRAY = {1,1,0,1};
	//private static int CORRECT_ANSWER = 3;
	
	//private static int[] ARRAY = {1,1,1};
	//private static int CORRECT_ANSWER = 2;
	
	//private static int[] ARRAY = {0,0,0};
	//private static int CORRECT_ANSWER = 0;
	
	//private static int[] ARRAY = {1,0,0,0,0};
	//private static int CORRECT_ANSWER = 1;
	
	//private static int[] ARRAY = {0,1,0,1,0};
	//private static int CORRECT_ANSWER = 2;
	
	//private static int[] ARRAY = {1,1,0,0,1,1,1,0,1};
	//private static int CORRECT_ANSWER = 4;
	
	//private static int[] ARRAY = {1,0,1,1,1,1,1,1,0,1,1,1,1,1};
	//private static int CORRECT_ANSWER = 11;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestSubarray(ARRAY));
		System.out.println(CORRECT_ANSWER);
	}
	

	public static int longestSubarray(int[] nums) {
		int L = 0, max = 0, zeroCount = 0;
		for(int R = 0; R < nums.length; R++) {
			if(nums[R] == 0) {
				zeroCount++;
				if(zeroCount > 1) {
					boolean flag = false;
					while(!flag && L < R) {
						flag = nums[L] == 0;
						L++;
					}
					zeroCount--;
				}				
			}
			max = Math.max(max, R - L + 1);
		}
		
		return max - 1;
	}

}
