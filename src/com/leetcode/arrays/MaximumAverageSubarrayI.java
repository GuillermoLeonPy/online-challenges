package com.leetcode.arrays;

public class MaximumAverageSubarrayI {

	private static int[] ARRAY = {1,12,-5,-6,50,3};	
	private static int K = 4;
	
	//private static int[] ARRAY = {5};	
	//private static int K = 1;
	
	//private static int[] ARRAY = {-1};	
	//private static int K = 1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findMaxAverage2(ARRAY, K));
	}
	
    public static double findMaxAverage(int[] nums, int k) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        double maxAverage = - Double.MAX_VALUE;
        double temp = 0d;

        for(int i = k-1; i < nums.length; i++){
            if(i - k < 0){
                temp = prefixSum[i] / (double)k;
            }else{
                temp = (prefixSum[i] - prefixSum[i - k]) / (double)k;
            }
            if(temp > maxAverage){
                maxAverage = temp;
            }
        }
        return maxAverage;
    }
    
    
    public static double findMaxAverage2(int[] nums, int k) {
        int sum = 0;
       for(int i = 0; i < k; i ++) 
           sum += nums[i];
       int maxSum = sum;
       for(int i = k; i < nums.length; i ++) {
           sum += nums[i] - nums[i - k];
           maxSum = Math.max(maxSum, sum);
       }
       return (double)maxSum / k;
    }
    
}
