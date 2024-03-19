package com.leetcode.arrays;

public class ContainerWithMostWater {

	private static int[] ARRAY = {1,8,6,2,5,4,8,3,7};
	//private static int[] ARRAY = {1,1};
	//private static int[] ARRAY = {4,3,2,1,4};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxArea(ARRAY));
	}

    public static int maxArea(int[] height) {

    	int temp = 0, maxArea = 0, L = 0, R = height.length - 1;
    	
    	while(L < R) {
    		temp = Math.min(height[L], height[R]) * (R - L);
    		if(temp > maxArea) {
    			maxArea = temp;
    		}
    		
    		if(height[L] < height[R]) {
    			L++;
    		}else if (height[L] > height[R]) {
    			R--;
    		}else {
    			L++;
    			R--;
    		}
    	}
    	return maxArea;
    }
}
