package com.leetcode.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ProductOfArrayExceptSelf {

	private static int[] ARRAY = {1,2,3,4,5};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.stream(productExceptSelf(ARRAY)).boxed().collect(Collectors.toList()));
		System.out.println(Arrays.stream(productExceptSelfWithPreffixProcessing(ARRAY)).boxed().collect(Collectors.toList()));
	}

	public static int[] productExceptSelf(int[] nums) {
		int[] result = new int[nums.length];
		
		for(int i = 0; i < nums.length; i++) {
			result[i] = 1;
			for(int j = 0; j < nums.length; j++) {				
				if(i == j) {
					continue;
				}else {
					result[i] *= nums[j];	
				}				
			}
		}
		return result;
	}
	
	public static int[] productExceptSelfWithPreffixProcessing(int[] nums) {
		int [] preffixProduct = new int [nums.length];
		preffixProduct[0] = 1;
		int [] suffixProduct = new int [nums.length];
		suffixProduct[nums.length-1] = 1;
		for(int i = 1; i < nums.length; i++) {
			preffixProduct[i] = preffixProduct[i-1] * nums[i-1];
			suffixProduct[nums.length - 1 - i] = suffixProduct[nums.length - i] * nums[nums.length - i];
		}
		
		int[] result = new int[nums.length];
		for(int i = 0; i < nums.length; i++) {
			result[i] = preffixProduct[i] * suffixProduct[i];
		}
		return result;
	}
}
