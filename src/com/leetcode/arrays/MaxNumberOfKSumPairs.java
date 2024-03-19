package com.leetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKSumPairs {

	//private static int[] ARRAY = {1,2,3,4};
	//private static int K = 5;
	
	private static int[] ARRAY = {3,1,3,4,3};	
	private static int K = 6;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxOperations_non_optimal(ARRAY, K));
	}
	
	
    public static int maxOperations_non_optimal(int[] nums, int k) {
    	Map<Integer,Integer> ocurrences = new HashMap<Integer,Integer>();
    	
    	int complement = 0;
    	int counter = 0;
    	for(int i = 0; i < nums.length; i++) {
    		complement = k - nums[i];    		
    		if(ocurrences.getOrDefault(complement,0) > 0) {
    			ocurrences.put(complement, ocurrences.get(complement) - 1);
    			counter++;
    		}else {
    			ocurrences.put(nums[i], ocurrences.getOrDefault(nums[i], 0) + 1);
    		}
    	}    	
    	
    	return counter;
    }
    
    public static int maxOperations(int[] nums, int k) {
    	Arrays.sort(nums);
    	int L = 0, R = nums.length - 1, count = 0, tmp = 0;
    	while(L<R) {
    		tmp = nums[L] + nums[R];
    		if(tmp == k) {
    			count++;
    			L++;
    			R--;
    		}else if (tmp < k) {
    			L++;
    		}else {
    			R--;
    		}
    	}
    	return count;
    }
    
}
