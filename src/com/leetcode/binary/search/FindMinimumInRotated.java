package com.leetcode.binary.search;

public class FindMinimumInRotated {

	//private static int [] NUMS = {3,4,5,6,1,2};
	//private static int [] NUMS = {11,13,15,17};
	//private static int [] NUMS = {0};
	//private static int [] NUMS = {0,1};
	//private static int [] NUMS = {1,0};
	//private static int [] NUMS = {3,1,2};
	//private static int [] NUMS = {2,3,1};
	private static int [] NUMS = {5,1,2,3,4};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findMin(NUMS));
	}
	
	public static int findMin(int[] nums) {

		return findMin(nums,0,nums.length-1);
    }
	
	public static int findMin(int[] nums, int from, int to) {
		if(nums.length == 1) {
			return nums[0];
		}else if (to - from == 1) {
			return Math.min(nums[from], nums[to]);
		}
		
		int half = (from + to) / 2;
		if(nums[half] > nums[to]) {
			return findMin(nums,half,to);
		}else if(nums[from] > nums[half]){
			return findMin(nums,from,half);
		}
		return Math.min(nums[half], nums[from]);
    }

}
