package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindPivotIndex {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean allPass = true;
		for(TestCase test: testCases()) {
			int result = pivotIndex(test.test);
			if(test.correctAnswer != result) {
				System.err.println("\n test: "  + test.caseNumber
						+ "\n " + Arrays.stream(test.test).boxed().collect(Collectors.toList())
						+ "\n correct answer: " 
						+ test.correctAnswer + "\n result        : " 
						+ result);
				allPass = false;
			}
		}
		
		if(allPass) {
			System.out.println("all passed !");
		}
	}
	
    public static int pivotIndex(int[] nums) {

    	int[] leftSum = new int[nums.length];
    	leftSum[0] = nums[0];
    	int[] rigthSum = new int[nums.length];
    	rigthSum[nums.length - 1] = nums[nums.length - 1];
    	for(int i = 1; i < nums.length; i++) {
    		leftSum[i] = leftSum[i - 1] + nums[i];
    		rigthSum[nums.length - i - 1] = rigthSum[nums.length - i] + nums[nums.length - i - 1];
    	}
    	
    	for(int i = 0; i < nums.length; i++) {
    		if(leftSum[i] == rigthSum[i]){
    			return i;
    		}
    	}
    	
    	return -1;
    }
    
    public static int pivotIndex2(int[] nums) {
    	int sum = 0;
    	for(int num : nums) sum+=num;

    	int leftSum = 0;
    	for(int indx = 0 ; indx < nums.length; indx++){
    		int rightSum = sum - leftSum - nums[indx];
    		if(leftSum == rightSum) return indx;
    		leftSum += nums[indx];
    	}
    	return -1;
    }

    
    public static List<TestCase> testCases(){
    	List<TestCase> list = new ArrayList<>();
    	list.add(new TestCase(1,new int[]{1,7,3,6,5,6}, 3));
    	list.add(new TestCase(2, new int[]{1,2,3}, -1));
    	list.add(new TestCase(3, new int[]{2,1,-1}, 0));
    	list.add(new TestCase(4, new int[]{-1,-1,-1,-1,-1,-1}, -1));
    	list.add(new TestCase(5, new int[]{-1,-1,-1,-1,-1,0}, 2));
    	list.add(new TestCase(6, new int[]{-1,-1,-1,-1,-1,1}, -1));
    	list.add(new TestCase(7, new int[]{-1,-1,-1,-1,1,1}, -1));
    	list.add(new TestCase(8, new int[]{-1,-1,-1,0,1,1}, 0));
    	list.add(new TestCase(9, new int[]{-1,-1,0,0,-1,-1}, 2));
    	list.add(new TestCase(10, new int[]{-1,-1,1,1,0,0}, 4));
    	list.add(new TestCase(11, new int[]{-1,-1,0,1,1,0}, 5));
    	list.add(new TestCase(12, new int[]{-1,0,1,-1,-1,1}, 0));
    	list.add(new TestCase(13, new int[]{-1,1,-1,-1,0,1}, 0));
    	return list;
    }
    
    static class TestCase{
    	int caseNumber;
    	int[] test;
    	int correctAnswer;
    	
    	TestCase(int caseNumber, int[] test, int correctAnswer){
    		this.caseNumber = caseNumber;
    		this.test = test;
    		this.correctAnswer = correctAnswer;
    	}
    }
    
}
