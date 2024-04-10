package com.leetcode.strings;

import java.util.Stack;

public class DecodeString {

//	private static String S = "3[a2[c]]";
//	private static String Output = "accaccacc";
//	private static String S = "3[a]2[bc]";
//	private static String Output = "aaabcbc";
//	private static String S = "2[abc]3[cd]ef";
//	private static String Output = "abcabccdcdcdef";
	private static String S = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
	private static String Output = "zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String result =  decodeString_recursive(S);
		System.out.println("O: " + S +"\n\nR: " + result + "\nE: " + Output + "\n\n " + (!result.equals(Output) ? "Error" : "Success"));
	}
	
	//3[a]2[bc]
	static String decodeString(String s) {
		Stack<Integer> counts = new Stack<>();
        Stack<String> letters = new Stack<>();
        String lettersBuilder = "";
        int index = 0;
        while(index < s.length()) {
        	if(Character.isDigit( s.charAt(index))) {
        		String numberBuilder = "";
        		while(Character.isDigit( s.charAt(index))) {
        			numberBuilder+=(s.charAt(index++));
        		}
        		counts.push(Integer.parseInt(numberBuilder));
        	}else if(s.charAt(index) == '[') {        		
        		letters.push(lettersBuilder);        		
        		lettersBuilder = "";
        		index++;
        	}else if(s.charAt(index) == ']') {
        		int repeat = counts.pop();
        		String lettersPeak = letters.pop();
        		lettersBuilder = lettersPeak + lettersBuilder.repeat(repeat);
        		index++;
        	}else {
        		lettersBuilder+=s.charAt(index);
        		index++;
        	}
        }
		 
        return lettersBuilder;
    }
	
	//3[a]2[bc]
	//3[z]2[2[y]pq4[2[jk]e1[f]]]ef
	static int index = 0;
    public static String decodeString_recursive(String s) {
    	StringBuilder result = new StringBuilder();
    	int repeat = 0;
    	while(index < s.length()) {
    		if(Character.isDigit(s.charAt(index))) {
    			StringBuilder numberBuilder = new StringBuilder();
    			while(Character.isDigit(s.charAt(index))) {
    				numberBuilder.append(s.charAt(index++));
    			}
    			repeat = Integer.parseInt(numberBuilder.toString());
    		}else if (s.charAt(index) == '[') {
    			index++;
    			result.append(processInnerBracker(s).repeat(repeat));
    		}else {
    			result.append(s.charAt(index++));
    		}
    	}
        return result.toString();
    }
    
    public static String processInnerBracker(String s) {
    	StringBuilder sb = new StringBuilder();
    	int repeat = 0;
    	while(s.charAt(index)!= ']') {
    		if(s.charAt(index) == '[') {
    			index++;
    			sb.append(processInnerBracker(s).repeat(repeat));
    		}else if(Character.isDigit(s.charAt(index))) {
    			StringBuilder numberBuilder = new StringBuilder();
    			while(Character.isDigit(s.charAt(index))) {
    				numberBuilder.append(s.charAt(index++));
    			}
    			repeat = Integer.parseInt(numberBuilder.toString());
    		}else {
    			sb.append(s.charAt(index++));
    		}
    	}
    	index++;
    	return sb.toString();
    }

}


