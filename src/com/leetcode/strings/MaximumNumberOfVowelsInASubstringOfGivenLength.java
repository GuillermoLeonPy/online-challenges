package com.leetcode.strings;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {

	private static String LETTERS = "weallloveyou";
	private static int K = 7;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxVowels(LETTERS, K));
		System.out.println(maxVowels2(LETTERS, K));
	}
	
    public static int maxVowels_non_optimal(String s, int k) {
        int count = 0, maxCount = 0, beginIndex = 0;
    	
        for(int i = k; i <= s.length(); i++) {
        	String tmp = s.substring(beginIndex, i);
        	tmp = tmp.replaceAll("[^aeiou]", "");
    		count = tmp.length();
    		if(count > maxCount) {
    			maxCount = count;
    		}
    		beginIndex++;
    	}
    	
    	return maxCount;
    }
    
    public static int maxVowels(String s, int k) {
        int n = s.length();
        int maxVowels = 0;
        int count = 0;

        int[] vowels = new int[128];
        vowels['a'] = 1;
        vowels['e'] = 1;
        vowels['i'] = 1;
        vowels['o'] = 1;
        vowels['u'] = 1;

        for (int i = 0; i < k; i++) {
            count += vowels[s.charAt(i)];
        }

        maxVowels = count;
        for (int i = k; i < n; i++) {
        	char newLetter = s.charAt(i);
        	char discardedLetter = s.charAt(i - k);
            count += vowels[newLetter] - vowels[discardedLetter];
            maxVowels = Math.max(maxVowels, count);
            //System.out.println(Arrays.toString(vowels));
            if (maxVowels == k) {
                return maxVowels; 
            }
        }
        return maxVowels;
    }
    
    public static int maxVowels2(String s, int k) {
    	
    	int count = 0;
    	for(int i = 0; i < k; i++) {
    		if(isVowel(s.charAt(i))) {
    			count++;
    		}
    	}
    	int maxCount = count;
    	for(int i = k; i < s.length(); i++) {
    		if(isVowel(s.charAt(i - k))) {
    			count--;
    		}
    		if(isVowel(s.charAt(i))) {
    			count++;
    		}
    		if(count > maxCount) {
    			maxCount = count;
    		}
    	}
    	
    	return maxCount;
    }
    
    public static boolean isVowel(char letter) {
    	return letter == 'a' || letter == 'e' || letter == 'i'
    			|| letter == 'o' || letter == 'u';
    }

}
