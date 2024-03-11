package com.leetcode.binary.search;

import java.util.ArrayList;
import java.util.List;

public class SearchForARange {
	
	//private static int [] NUMS = {5,7,7,8,8,10};
	//private static int TARGET = 8;
	//private static int TARGET = 6;
	
	//private static int [] NUMS = {};
	//private static int TARGET = 0;
	
	//private static int [] NUMS = {2,2};
	//private static int TARGET = 2;

	//private static int [] NUMS = {1,3};
	//private static int TARGET = 1;
	
	private static int [] NUMS = {3,3,3};
	private static int TARGET = 3;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] result = searchRange(NUMS, TARGET);
		System.out.println(result[0] + ", " + result[1]);
	}

	
    public static int[] searchRange(int[] nums, int target) {
    	if(nums.length == 0) {
    		return new int[] {-1,-1};
    	}
    	
    	return searchRange(nums, 0, nums.length - 1, target);
    }
    
    public static int[] searchRange(int[] nums, int from, int to, int target){
    	if(to - from < 2) {
    		if(nums[from] == target && nums[to] == target) {
    			return new int[] {from,to};
    		}else if(nums[from] != target && nums[to] == target) {
    			return new int[] {to,to};
    		}else if(nums[from] == target && nums[to] != target){
    			return new int[] {from,from};
    		}else {
    			return new int[] {-1, -1};
    		}
    	}
    	
    	int half = (from + to) / 2;
    	if(nums[half] == target) {
    		List<Integer> result = new ArrayList<>();
    		for(int i = half; i <= to; i++) {
    			if(nums[i] == target) {
    				result.add(i);
    			}else {
    				break;
    			}
    		}
    		for(int i = half; i >= from; i--) {
    			if(nums[i] == target) {
    				result.add(0,i);    			
    			}else {
    				break;
    			}
    		}
    		return new int [] {result.get(0),result.get(result.size() - 1)};
    	}else if (nums[half] > target) {
    		return searchRange(nums, from, half-1, target);
    	}else {
    		return searchRange(nums, half+1, to, target);
    	}    	
    }
}
