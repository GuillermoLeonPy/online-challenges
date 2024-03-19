package com.leetcode.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MoveZeroes {

	//private static int[] ARRAY = {0};
	//private static int[] ARRAY = {0,1};
	//private static int[] ARRAY = {0,1,0,3,12};
	//private static int[] ARRAY = {0,1,0,2,3,0,0,0,0,4,0,0,0,5,0};
	//private static int[] ARRAY = {1,0,0,2,3,0,0,0,0,4,0,0,0,5,0,6};
	//private static int[] ARRAY = {0,1,0};
	//private static int[] ARRAY = {1,0,0};
	//private static int[] ARRAY = {1,0,1};
	private static int[] ARRAY = {1,1,1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		moveZeroes(ARRAY);
		System.out.println(Arrays.stream(ARRAY).boxed().collect(Collectors.toList()));
		
	}

    public static void moveZeroes(int[] nums) {
        int i = 0;
        int zeroCount = 0;
        int zeroGlobalCount = 0;
        while(i < nums.length){
            if(nums[i] == 0){
                zeroCount++;                
            }else{
            	zeroGlobalCount+=zeroCount;
                nums[i-zeroGlobalCount] = nums[i];
                zeroCount = 0;
            }
            i++;
        }
        zeroGlobalCount+=zeroCount;
        i = nums.length - zeroGlobalCount;
        while(i < nums.length ) {
        	nums[i++] = 0;
        }
    }
}
