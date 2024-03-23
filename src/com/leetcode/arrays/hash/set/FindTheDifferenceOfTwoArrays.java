package com.leetcode.arrays.hash.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindTheDifferenceOfTwoArrays {

	//private static int[] ARRAY_1 = {1,2,3};
	//private static int[] ARRAY_2 = {2,4,6};
	
	//private static int[] ARRAY_1 = {1,2,3,3};
	//private static int[] ARRAY_2 = {1,1,2,2};
	
	private static int[] ARRAY_1 = {-68,-80,-19,-94,82,21,-43};
	private static int[] ARRAY_2 = {-63};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(findDifference( ARRAY_1, ARRAY_2));
	}

	
	public static List<List<Integer>> findDifference_non_optimal(int[] nums1, int[] nums2) {
		Set<Integer> nums1_op1 = new HashSet<>();
		Set<Integer> nums1_op2 = new HashSet<>();
		for(int i = 0; i < nums1.length; i++){
			nums1_op1.add(nums1[i]);
			nums1_op2.add(nums1[i]);
        }
		
		Set<Integer> nums2_op1 = new HashSet<>();
		for(int i = 0; i < nums2.length; i++){
			nums2_op1.add(nums2[i]);
        }
		
		nums1_op1.removeAll(nums2_op1);
		nums2_op1.removeAll(nums1_op2);
				
		List<List<Integer>> r = new ArrayList<>();
		r.add(new ArrayList<>(nums1_op1));
		r.add(new ArrayList<>(nums2_op1));
		return r;
	}
	
	public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		result.add(new ArrayList<>());
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int nums1_index = 0, nums2_index = 0;
		while(nums1_index < nums1.length && nums2_index < nums2.length) {
			if(nums1[nums1_index] == nums2[nums2_index]) {
				int equalNum = nums1[nums1_index];
				while(nums1_index < nums1.length && nums1[nums1_index] == equalNum) {
					nums1_index++;
				}
				while(nums2_index < nums2.length && nums2[nums2_index] == equalNum) {
					nums2_index++;
				}
			}else if (nums1[nums1_index] < nums2[nums2_index]) {
				int num = nums1[nums1_index];
				result.get(0).add(nums1[nums1_index]);
				while(nums1_index < nums1.length && nums1[nums1_index] == num) {
					nums1_index++;
				}
			}else {
				int num = nums2[nums2_index];
				result.get(1).add(nums2[nums2_index]);
				while(nums2_index < nums2.length && nums2[nums2_index] == num) {
					nums2_index++;
				}
			}			
		}
		
		while(nums1_index < nums1.length) {
			int num = nums1[nums1_index++];
			result.get(0).add(num);
			while(nums1_index < nums1.length && nums1[nums1_index] == num) {
				nums1_index++;
			}			
		}
		
		while(nums2_index < nums2.length) {
			int num = nums2[nums2_index++];
			result.get(1).add(num);
			while(nums2_index < nums2.length && nums2[nums2_index] == num) {
				nums2_index++;
			}
		}
		
		return result;
	}
}
