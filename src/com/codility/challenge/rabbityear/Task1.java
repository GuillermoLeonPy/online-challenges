package com.codility.challenge.rabbityear;
/**
 * 
 * 
 * There are N people sitting at a round table, having dinner. 
 * They are numbered from 0 to N-1 in clockwise order. 
 * Initially, each person has a dish on the table in front of them. Person number K does not like the taste of A[K], 
 * but has a dish of taste B[K]. We want every person to have a dish of a taste that they do not dislike, i.e. A[K] ≠ B[K] 
 * for each K from 0 to N-1.
 * In order to achieve this, you can rotate the whole table clockwise by one position any number of times. 
 * Rotating the table corresponds to moving the last element of B to the beginning. 
 * For example, given A = [3, 6, 4, 5] and B = [2, 6, 3, 5], if we rotate the table once, we would obtain B = [5, 2, 6, 3].
 * Find the minimum number of table rotations that need to be performed in order to satisfy every person.
 * 
 * 
 * https://app.codility.com/programmers/challenges/year_of_the_rabbit_2023/
 * 
 * 
 * @author test-user
 *
 */
public class Task1 {

	public Task1() {
		// TODO Auto-generated constructor stub
	}
	
	private int numberOfTimesToRotate = 0;

    public int solution(int[] A, int[] B) {
        // Implement your solution here
        while(!numberOfTimesIdentified(A,B)){

        }
        
        return numberOfTimesToRotate;
    }

    private boolean numberOfTimesIdentified(int[] A, int[] B){
        if(numberOfTimesToRotate == A.length) {
        	numberOfTimesToRotate = -1;
        }else {
        	for(int i = 0; i < A.length; i++){
                if(A[i]==B[i]) {
                	rotateArrayB(B);
                	return false;
                }            
            }	
        }    	        
        return true;
    }

    private void rotateArrayB(int[] B){
    	int temp=0;
    	int temp2 = 0;
    	for(int i = 0 ; i < B.length; i++) {    		
    		if(i == 0) {
    			temp = B[i];
    			B[i] = B[B.length - 1];
        	}else {
        		temp2 = B[i];
        		B[i] = temp;
        		temp = temp2;
        	}
        	
        }    	
        numberOfTimesToRotate++;
    }

    public static void main(String[] args) {
		int [] arrayA = {1, 1, 1, 1};
		int [] arrayB = {1, 2, 3, 4};
		Task1 t1 = new Task1();
		int result = t1.solution(arrayA, arrayB);
		System.out.println("## result: " + result);
	}    
}
