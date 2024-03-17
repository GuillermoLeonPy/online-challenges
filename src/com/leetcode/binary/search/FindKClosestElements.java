package com.leetcode.binary.search;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {

/*
	private static int [] ARR= {1,2,3,4,5};
	private static int X = 3;
	private static int K = 4;
	*/
	
	/*
	private static int [] ARR= {0,1,1,1,2,3,6,7,8,9};
	private static int X = 4;
	private static int K = 9;
	*/
	
	
	private static int [] ARR= {0,0,1,2,3,3,4,7,7,8};
	private static int K = 3;
	private static int X = 5;
	/*
	*/
	
	/*
	private static int [] ARR= {-7,-5,-2,0,2,4,6,7,9,15};
	private static int K = 4;
	private static int X = 1;
		
	*/
	
	/*
	private static int [] ARR= {-7,-5,-2,0,2,4,6,7,9,15};
	private static int K = 4;
	private static int X = -9
	*/
	
	/*
	private static int [] ARR= {-7,-5,-2,0,2,4,6,7,9,15};
	private static int K = 4;
	private static int X = 17
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findClosestElements(ARR, K, X).stream().forEach(System.out::println);
	}

	public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int size = arr.length;

        int left = 0;
        int right = size - k;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
	}
}
