package com.leetcode.arrays;

public class CanPlaceFlowers {

	public static int [] ARRAY = {1,2,3,4,5};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println(productExceptSelf2(ARRAY));

	
    }
	
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int pre[] = new int[n];
        int suff[] = new int[n];
        pre[0] = 1;
        suff[n - 1] = 1;
        
        for(int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        for(int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] * nums[i + 1];
        }
        
        int ans[] = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = pre[i] * suff[i];
        }
        return ans;
    }
    
    public static int[] productExceptSelf2(int[] nums) {
        int[] prefixProduct = new int [nums.length];
        int[] suffixProduct = new int [nums.length];
        prefixProduct[0] = 1;
        suffixProduct[nums.length - 1] = 1;
        for(int i = 1; i < nums.length; i++){
            prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
            suffixProduct[nums.length - 1 - i] = suffixProduct[nums.length - i] * nums[nums.length - i];
        }

        int[] result = new int [nums.length];
        for(int i = 0; i < nums.length; i++){
            result[i] = prefixProduct[i] * suffixProduct[i];
        }
        return result;
    }
}
