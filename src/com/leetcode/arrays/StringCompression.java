package com.leetcode.arrays;

public class StringCompression {
	//public static char [] ARRAY = {'a','a','b','b','c','c','c'};
	//public static char [] ARRAY = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
	public static char [] ARRAY = {'a','b','c','d','e','f','f','g','h','h','i','i','j'};
	//public static char [] ARRAY = {'a'};
	//public static char [] ARRAY = {'a','a'};
	//public static char [] ARRAY = {'a','b'};
	//public static char [] ARRAY = {'a','a','a'};
	//public static char [] ARRAY = {'a','b','c'};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(compress(ARRAY));
	}
	
	
    public static int compress(char[] chars) {
        int charCounter = 1;
        int lastOccupiedIndex = 0;
        for(int i = 1; i < chars.length; i++){
            if(chars[i] == chars[i-1]){
            	charCounter++;
            }else{                
                chars[lastOccupiedIndex++] = chars[i-1];
                if(charCounter > 1) {
                	char[] tmp = ("" + charCounter).toCharArray();
                	for(int k = 0; k < tmp.length; k++) {
                		chars[lastOccupiedIndex++] = tmp[k];
                	}
                }                
                charCounter=1;
            }
        }
        chars[lastOccupiedIndex++]=chars[chars.length-1];
        if(charCounter > 1) {
        	char[] tmp = ("" + charCounter).toCharArray();
        	for(int k = 0; k < tmp.length; k++) {
        		chars[lastOccupiedIndex++] = tmp[k];
        	}        	
        }
        
        System.out.println(new String(chars).substring(0, lastOccupiedIndex));
        return lastOccupiedIndex;
    }
}
