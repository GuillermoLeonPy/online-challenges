package com.codility.lessons.arrays;

/**
 * https://stackoverflow.com/questions/1991380/what-does-the-operator-do-in-java
 * you can use this operator to do a lot of programming tricks like
 * 
 * If you have an array with all numbers repeating even number of times except one which
 * repeats odd number of times you can find that by XORing all elements.
 * 
 * https://github.com/hlltarakci/codility_practice_sessions/blob/master/arrays/OddOccurrencesInArray.java
 * https://github.com/Mickey0521/Codility/blob/master/OddOccurrencesInArray.java
 * 
 * @author test-user
 *
 */
public class OddOccurrencesInArray_v2 {
	
    public int solution(int[] A) {
        // write your code in Java SE 8
        
        // Using the concept of "XOR" (^)
        // when there is a pair A and B 
        // A^B will be zero 
        // A^B^C (where C is not paired), 
        // then A^B^C = C
        
        // special case
        if(A.length == 0)
            return 0;
        
        int unpaired = A[0]; // initial        
        
        for(int i=1; i< A.length; i++){
        	int value = A[i];
        	System.out.println("\n unpaired: " + Integer.toBinaryString(unpaired) + "\n array[" + i + "]: " + Integer.toBinaryString(value));        	
            unpaired = unpaired ^ value; // xor
            System.out.println("\n unpaired result: " + Integer.toBinaryString(unpaired));
        }
        
        return unpaired; // return the unpaired value
    }
	
	

	
	private static final int [] CONSTANT = {9,3,9,3,9,9,7};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OddOccurrencesInArray_v2 vOddOccurrencesInArray = new OddOccurrencesInArray_v2();
		System.out.println("\n" + vOddOccurrencesInArray.solution(CONSTANT));
	}

}
