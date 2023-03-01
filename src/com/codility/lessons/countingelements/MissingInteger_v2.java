package com.codility.lessons.countingelements;

import java.util.HashSet;
import java.util.Set;

public class MissingInteger_v2 {

	
	public int solution(int[] A) {
		return 0;
	}
	
	private int process(int[] A) {		
        if(A.length ==0){
            return 1;
        }
        

        Set<Integer> set = new HashSet<Integer>();
        
        // 
        for(int i=0; i< A.length; i++){
        	set.add(A[i]);
        }
        

        for(int i=1; i<= A.length; i++){
            if(set.contains(i) != true)
                return i;
        }

        return A.length+1;		
	}

	//1+3+6+4+2=16
	//21-16=5 
	
	
	//6*7/2 = 21
	//6+5+4+3+2+1=21
	
	
	//6+5+4= 15
	//3*4/2 = 6
	//6+5+4+3+2+1=21 - 6 = 15
	
	private static final int[]  ARRAY = {1, 3, 6, 4, 1, 2};
	//private static final int[]  ARRAY = {4, 5, 6, 2};
	//private static final int[]  ARRAY = {1, 2, 3};
	//private static final int[]  ARRAY = {-1, -3};
	//private static final int[]  ARRAY = {-1};
	//private static final int[]  ARRAY = {1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MissingInteger_v2 vMissingInteger = new MissingInteger_v2();
		System.out.println("\n " + vMissingInteger.process(ARRAY));
		
	}

}
