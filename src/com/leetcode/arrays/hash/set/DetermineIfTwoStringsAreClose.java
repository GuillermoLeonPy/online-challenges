package com.leetcode.arrays.hash.set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetermineIfTwoStringsAreClose {

//	private static String STR_1 = "abbzzca";
//	private static String STR_2 = "babzzcz";
//	private static boolean CORRECT_ANSWER = false;
	
//	private static String STR_1 = "abc";
//	private static String STR_2 = "bca";
//	private static boolean CORRECT_ANSWER = true;
	
//	private static String STR_1 = "aa";
//	private static String STR_2 = "a";
//	private static boolean CORRECT_ANSWER = false;
	
//	private static String STR_1 = "cabbba";
//	private static String STR_2 = "abbccc";
//	private static boolean CORRECT_ANSWER = true;
	
//	private static String STR_1 = "aaabbbbccddeeeeefffff";
//	private static String STR_2 = "aaaaabbcccdddeeeeffff";
//	private static boolean CORRECT_ANSWER = false;
	
	private static String STR_1 = "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii";
	private static String STR_2 = "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii";
	private static boolean CORRECT_ANSWER = true;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] str1_chars = STR_1.toCharArray();
		Arrays.sort(str1_chars);
		char[] str2_chars = STR_2.toCharArray();
		Arrays.sort(str2_chars);
		System.out.println("sorted words \n\n w1: " + new String(str1_chars) + "\n w2: " + new String(str2_chars) + "\n\n" +
				(CORRECT_ANSWER == closeStrings(STR_1,STR_2) ? 
						"passed !" : 
							"not passed for \n" + STR_1 + "\n" + STR_2));
	}
	
    public static boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()){
            return false;
        }
        
        Map<Character,Integer> w1 = new HashMap<>();
        Map<Character,Integer> w2 = new HashMap<>();

        for(int i = 0; i < word1.length(); i++) {
        	Character c = word1.charAt(i);
        	w1.put(c, w1.getOrDefault(c, 0) + 1);
        	
        	c = word2.charAt(i);
        	w2.put(c, w2.getOrDefault(c, 0) + 1);
        }
        List<Integer> frequencyCharsW1 = new ArrayList<>();
        List<Integer> frequencyCharsW2 = new ArrayList<>();
        for(Character c : w1.keySet()) {
        	if(!w2.containsKey(c)) {
        		return false;
        	}else {        		
        		frequencyCharsW1.add(w1.get(c));
        		frequencyCharsW2.add(w2.get(c));
        	}        	
        }
        if(frequencyCharsW1.size() != frequencyCharsW2.size()) {
        	return false;
        }
        Collections.sort(frequencyCharsW1);
        Collections.sort(frequencyCharsW2);
        for(int i = 0; i < frequencyCharsW1.size(); i++) {
        	if(!frequencyCharsW1.get(i).equals(frequencyCharsW2.get(i))) {
        		return false;
        	}
        }
        
        return true;
    }

}
