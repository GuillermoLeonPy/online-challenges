package com.codility.challenge.carolofthecode;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Tom is decorating the pavement in his garden with N square tiles. 
 * Each tile is divided into four triangles of different colors (white - 'W', red - 'R', green - 'G' and blue - 'B'). 
 * A tile is described as a string of four characters denoting respectively, the color of the upper, right, bottom and left triangle. 
 * For example, the tile in the figure below is described as "WRGB".
 * Tom arranged the tiles in a row and decided to rotate some of them to obtain a pretty sequence. He considers a sequence of tiles pretty if each pair of adjacent tiles shares one side of the same color.

Write a function:

class Solution { public int solution(String[] A); }

that, given an array A of N strings, representing the sequence of tiles, returns the minimum number of 90-degree rotations (clockwise or counter-clockwise) 
that Tom has to perform.


Examples


1. Given A = ["RGBW", "GBRW"], the function should return 1.

Tom can rotate the second tile counter-clockwise once to obtain a pretty sequence

2. Given A = ["WBGR", "WBGR", "WRGB", "WRGB", "RBGW"], the function should return 4.

Tom can obtain a pretty sequence by rotating the first and third tiles counter-clockwise and the second and fourth tiles clockwise.

3. Given A = ["RBGW", "GBRW", "RWGB", "GBRW"], the function should return 2.

Tom can rotate the first tile clockwise twice to obtain a pretty sequence.

4. Given A = ["GBRW", "RBGW", "BWGR", "BRGW"], the function should return 2.

Tom can rotate the first two tiles clockwise to obtain a pretty sequence.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
string representing a tile has 4 letters (exactly one occurrence of 'R', 'G', 'B' and 'W').

https://app.codility.com/programmers/task/pretty_tiling/

 * @author test-user
 *
 */
public class PrettyTiling {

	public PrettyTiling() {
		// TODO Auto-generated constructor stub
	}
	private int numberOfTalesLeftToMove = 0;
	private int numberOf90DegreesRotationsPerformed = 0;
	private List<String> fixedTalesArray = new LinkedList<>();
	
	
	public int solution(String[] A) {
		int better_numberOf90DegreesRotationsPerformed = 999999999;
		List<String> betterTalesArray = new LinkedList<>();
		for(int i = 0; i < 4; i++) {
			String[] tempA = Arrays.asList(A).toArray(new String[0]);
			int minimunNumberOfPreProccessedRotation = 0;
			if(i > 0) {
				//rotate once the first tale
				char[] firstTale = tempA[0].toCharArray();
				for(int b = 0; b < i; b++)
					rotateClockWise(firstTale, 0, ' ');
				
				minimunNumberOfPreProccessedRotation = rotateTaleByColor(firstTale[3], tempA[0].toCharArray());
				tempA[0] = String.valueOf(firstTale);				
			}
			
			numberOfTalesLeftToMove = 0;
			numberOf90DegreesRotationsPerformed = 0;	
			fixedTalesArray.clear();
			getNumberOf90DegreesRotationsPerformed(tempA);
			numberOf90DegreesRotationsPerformed += minimunNumberOfPreProccessedRotation;
			if(numberOf90DegreesRotationsPerformed < better_numberOf90DegreesRotationsPerformed) {
				better_numberOf90DegreesRotationsPerformed = numberOf90DegreesRotationsPerformed;
				betterTalesArray.clear();
				betterTalesArray.addAll(new LinkedList<>(fixedTalesArray));
			}
		}
		fixedTalesArray.clear();
		fixedTalesArray.addAll(betterTalesArray);
		return better_numberOf90DegreesRotationsPerformed;
	}
	
	private int getNumberOf90DegreesRotationsPerformed(String[] A) {
		numberOfTalesLeftToMove = A.length;
		int numberOfChecksCounter = 0;
		while(numberOfTalesLeftToMove > 0) {
			if(numberOfChecksCounter == 0) {
				//only for the first time two tales are checked
				char[] t1 = A[numberOfChecksCounter].toCharArray();
				char[] t2 = A[numberOfChecksCounter + 1].toCharArray();
				numberOf90DegreesRotationsPerformed += rotateTales(t1, t2);
				A[numberOfChecksCounter] = String.valueOf(t1);
				A[numberOfChecksCounter + 1] = String.valueOf(t2);
				numberOfTalesLeftToMove-=2;
			}else {
				char[] tN = A[numberOfChecksCounter + 1].toCharArray();
				char color = A[numberOfChecksCounter].toCharArray()[1];
				numberOf90DegreesRotationsPerformed += rotateTaleByColor(color, tN);				
				A[numberOfChecksCounter + 1] = String.valueOf(tN);
				numberOfTalesLeftToMove-=1;				
			}
			numberOfChecksCounter++;
		}
		return numberOf90DegreesRotationsPerformed;		
	}
	
	//WRGB
	private int rotateTaleByColor(char color, char [] tN) {		
		char [] temp_tN =  Arrays.copyOf(tN, tN.length);
		int clockWiseCounter = 0;		
		while(color != temp_tN[3]) {
			rotateClockWise(temp_tN, 0, ' ');
			clockWiseCounter++;
		}		
		
		int counterClockWiseCounter = 0;
		while(color != tN[3]) {
			rotateCounterClockWise(tN, 0, ' ');
			counterClockWiseCounter++;
		}
		fixedTalesArray.add(String.valueOf(tN));
		
		return (clockWiseCounter < counterClockWiseCounter ? clockWiseCounter : counterClockWiseCounter);
	}
	//"WBGR", "WBGR"
	private int rotateTales(char [] t1, char [] t2) {		
		if(t1[1] == t2[3]) {
			//already pretty
			fixedTalesArray.add(String.valueOf(t1));
			fixedTalesArray.add(String.valueOf(t2));
			return 0;	
		}else if(t1[1] == t2[0] || t1[1] == t2[2] || t2[3] == t1[0] || t2[3] == t1[2]){
			//one rotation needed
			if(t1[1] == t2[0]) {
				rotateCounterClockWise(t2, 0, ' ');
			}else if(t1[1] == t2[2]) {
				rotateClockWise(t2, 0, ' ');
			}else if (t2[3] == t1[0]) {
				rotateClockWise(t1, 0, ' ');
			}else {//t2[3] == t1[2]
				rotateCounterClockWise(t1, 0, ' ');
			}
			fixedTalesArray.add(String.valueOf(t1));
			fixedTalesArray.add(String.valueOf(t2));
			return 1;
		}else {
			//two rotation of one tale needed
			for(int i = 0; i < 2; i++) {
				rotateClockWise(t2, 0, ' ');
			}				
			fixedTalesArray.add(String.valueOf(t1));
			fixedTalesArray.add(String.valueOf(t2));
			return 2;
		}		 
	}
	

	
	private void rotateClockWise(char [] tale, int count, char tempPrev) {
		if(count == 0) {
			char temp = tale[count + 1];
			tale[count + 1] = tale[count];
			rotateClockWise(tale, count + 1, temp);
		}else if(count == tale.length - 1) {			
			tale[0] = tempPrev;
		}else {
			char temp = tale[count + 1];
			tale[count + 1] = tempPrev;
			rotateClockWise(tale, count+1, temp);
		}	
	}
	
	private void rotateCounterClockWise(char [] tale, int count, char tempPrev) {
		if(count == 0) {
			char temp = tale[tale.length - 2];
			tale[tale.length - 2] = tale[tale.length - 1];
			rotateCounterClockWise(tale, count + 1, temp);
		}else if(count == tale.length - 1) {			
			tale[tale.length - 1] = tempPrev;
		}else {
			char temp = tale[tale.length - (count + 2)];
			tale[tale.length - (count + 2)] = tempPrev;
			rotateCounterClockWise(tale, count + 1, temp);
		}	
	}
	
	
	
	
	
	/*char [] a = {'1','2','3','4','5','6','7','8','9','x'};
	new PrettyTiling().rotateCounterClockWise(a,0,' ');
	for(int i = 0; i < a.length; i++) {
		System.out.println(String.valueOf(a[i]));
	}*/
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrettyTiling pT  = new PrettyTiling();
		String[] tales =  { "RGBW", "GBRW" };
		//String[] tales =  { "WBGR", "WBGR", "WRGB", "WRGB", "RBGW" };
		//String[] tales =  { "RBGW", "GBRW", "RWGB", "GBRW" };
		//String[] tales =  { "GBRW", "RBGW", "BWGR", "BRGW" };
		int rotationQty = pT.solution(tales);
		System.out.println(rotationQty + "\n" + pT.fixedTalesArray);

	}

}
