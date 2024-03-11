package com.leetcode.binary.search;

public class PeakElement {

	private static int[] NUMS = {1,2,1,3,5,6,4};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findPeakElement(NUMS,0,NUMS.length - 1));
	}

    public static int findPeakElement(int[] nums, int from, int to) {
    	if(from >= to) {
    		return from;
    	}
    	int half = (from + to) / 2;
    	if(nums[half] < nums[half + 1]) {
    		return findPeakElement(nums, half + 1, to);
    	}else {
    		return findPeakElement(nums, from, half);
    	}
   }
}
