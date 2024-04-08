package com.leetcode.arrays.hash.set;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EqualRowAndColumnPairs {

	private static int[][] matrix = {{3,2,1},{1,7,6},{2,7,7}};
	private static int correct_answer = 1;
	
//	private static int[][] matrix = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
//	private static int correct_answer = 3;
	
//	private static int[][] matrix = {{11,1},{1,11}};
//	private static int correct_answer = 2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = equalPairs(matrix);
		System.out.println(
				result == correct_answer ? ""
				+ "Success!" : 
				"Error \n expected: " + correct_answer + "\n returned: " + result);
	}
	
    public static int equalPairs_non_optimal(int[][] grid) {
        Map<String,Integer> rows = new HashMap<>();
        Map<String,Integer> columns = new HashMap<>();
        StringBuilder rowBuilder = new StringBuilder();
        StringBuilder columnBuilder = new StringBuilder();
        int R = 0, C = 0;
        while(R < grid.length){
            C = 0;
            while(C < grid[0].length){
                rowBuilder.append(grid[R][C] + "-");
                columnBuilder.append(grid[C][R] + "-");
                C++;
            }
            rows.put(rowBuilder.toString(), rows.getOrDefault(rowBuilder.toString(), 0) + 1);
            columns.put(columnBuilder.toString(), columns.getOrDefault(columnBuilder.toString(), 0) + 1);
            rowBuilder = new StringBuilder();
            columnBuilder = new StringBuilder();
            R++;
        }

        int pairCount = 0;
        for(String row : rows.keySet()){
            pairCount += rows.getOrDefault(row,0) * columns.getOrDefault(row, 0);
        }

        return pairCount;
    }

    
    public static int equalPairs(int[][] grid) {
    	int [][] rotated = new int[grid.length][grid.length];
    	int result = 0;
    	for(int R = 0; R < grid.length; R++) {
    		for(int C = 0; C < grid[0].length; C++) {
    			rotated[C][R] = grid[R][C];
    		}   		
    	}
    	
    	for(int R_1 = 0; R_1 < grid.length; R_1++) {
    		for(int R_2 = 0; R_2 < grid.length; R_2++) {
    			result+= Arrays.equals(grid[R_1], rotated[R_2]) ? 1 : 0;
    		}
    	}
    	
    	return result;
    }
}
