package com.codility.challenge.gameofcodes;

import java.util.LinkedList;
import java.util.List;

public class ThreeLettersBlocks {

	private List<String> betterResults = new LinkedList<>();
	
	public int solution(String S) {
		String result = process(S);
		printBetterResults();
		return result.length();
	}
	
	private void printBetterResults() {
		StringBuilder sb = new StringBuilder();
		for(String a: betterResults) {
			sb.append(a  + "\n");
		}		
		System.out.println("\n better results with length : " + betterResults.get(0).length() + "\n\n" + sb.toString());
	}
	
	private String process(String S) {
		char[] distinctCharacters = getDistinctCharacters(S, null);
		int betterLength = 0;
		
		for(char character : distinctCharacters) {			
			String newS_deletedMiddleCharacters = deleteMiddleCharacters(character, S);
			//String result = subProcess(newS_deletedMiddleCharacters, getNewDoNotProcessCharactersArrayByAddCharacter(character, null));
			String result = subProcess(newS_deletedMiddleCharacters, null);
			//aabxbaba
			if(result.length() > betterLength) {
				betterLength = result.length();
				betterResults.clear();
				betterResults.add(result);
			}else if (result.length() == betterLength) {
				betterResults.add(result);
			}
		}
		
		return betterResults.get(0);
	}
	
	private String subProcess(String S, char[] doNotProcessCharacters) {
		if(currentStringFormsAThreeLettersBlock(S)) {
			return S;
		}
		char[] distinctCharacters = getDistinctCharacters(S, doNotProcessCharacters);
		if(distinctCharacters.length == 0 && getDistinctCharacters(S).length == 3) {
			//aaacbba
			return deleteNonBlockGroupingCharacter(S);
		}
		else if(distinctCharacters.length == 0) {
			return "";
		}
		//aabbaba
		String better = null;
		char characterBetter = ' ';
		for(char character: distinctCharacters) {
			String newString = deleteMiddleCharacters(character, S);
			if(better == null || better.length() < newString.length()) {
				better = newString;
				characterBetter = character;
			}
		}
		return subProcess(better, getNewDoNotProcessCharactersArrayByAddCharacter(characterBetter, doNotProcessCharacters));
	}
	
	private String deleteNonBlockGroupingCharacter(String S) {
		//aaacbba
		char[] S_charArray = S.toCharArray();
		
		if(S_charArray[0] != S_charArray[1]) {
			return S.substring(1);
		}
		if(S_charArray[S_charArray.length - 1] != S_charArray[S_charArray.length - 2]) {
			return S.substring(0, S_charArray.length - 1);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<S_charArray.length; i++) {
			if (i > 0 && i < (S_charArray.length - 1)) {
				if((S_charArray[i] == S_charArray[i - 1] || S_charArray[i] == S_charArray[i + 1])) {
					sb.append(S_charArray[i]);
				}
			}else {
				sb.append(S_charArray[i]);
			}
		}
		
		return sb.toString();
	}	
	
	private boolean currentStringFormsAThreeLettersBlock(String S) {
		//aabbaa
		//aaacbba
		char[] S_charArray = S.toCharArray();
		int differenceConsecutiveCharacters = 0;
		for(int i = 1; i < S_charArray.length; i++) {
			if(S_charArray[i] != S_charArray[i - 1])
				differenceConsecutiveCharacters++;
		}
		if(differenceConsecutiveCharacters > 2)
			return false;
		else
			return true;
	}
	
	private char[] getNewDoNotProcessCharactersArrayByAddCharacter(char character, char[] characterArray) {
		String newString = (characterArray == null ? "" : String.valueOf(characterArray)) + String.valueOf(character);
		return newString.toCharArray();
	}
	
	
	private char [] getDistinctCharacters(String S, char[] doNotProcessCharacters) {
		if(doNotProcessCharacters == null) {
			return getDistinctCharacters(S);
		}
		for(char character:doNotProcessCharacters) {
			S = S.replaceAll(String.valueOf(character), "");
		}
		
		return getDistinctCharacters(S);
	}
	
	private char[] getDistinctCharacters(String S) {
		StringBuilder sb = new StringBuilder();
		char[] characters = S.toCharArray();
		for(int i = 0; i < characters.length; i++) {
			CharSequence charSequence = String.valueOf(characters[i]);
			if(!sb.toString().contains(charSequence)) {
					sb.append(characters[i]);	
			}
		}
		return sb.toString().toCharArray();
	}
	
	private boolean hasCharactersInTheMiddle(char character, String S) {
		int firstIndex = getFirstSignificantIndex(character, S);
		int secondIndex = S.indexOf(character, firstIndex + 1);
		return (secondIndex == -1 || (secondIndex  == firstIndex + 1) ? false : true);
	}
	
	private int getFirstSignificantIndex(char character, String S) {
		int firstIndex = S.indexOf(character);
		char [] S_charArray = S.toCharArray();
		int newFirstIndex = firstIndex;
		for(int i = firstIndex + 1; i < S_charArray.length; i++) {
			if(S_charArray[i] == character)
				newFirstIndex = i;
			else
				return newFirstIndex;
		}
		return firstIndex;
	}
	
	private String deleteMiddleCharacters(char character, String S) {
		if(hasCharactersInTheMiddle(character, S)) {
			//delete
			int firstIndex = getFirstSignificantIndex(character, S);
			int secondIndex = S.indexOf(character, firstIndex + 1);
			char[] S_char = S.toCharArray();
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < S_char.length; i++) {
				if(!(i > firstIndex && i < secondIndex)) {
					sb.append(S_char[i]);
				}
			}
				
			return sb.toString();
		}else {
			//return without modify
			return S;	
		}
		
	}
	
	
	//private static final String CONSTANT_S = "atheaxbtheb";
	//private static final String CONSTANT_S = "aabacbba";
	//private static final String CONSTANT_S = "aabxbaba";
	//private static final String CONSTANT_S = "xxxyxxyyyxyyy";
	//private static final String CONSTANT_S = "abc";
	//private static final String CONSTANT_S = "aac";
	private static final String CONSTANT_S = "acc";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeLettersBlocks vThreeLettersBlocks = new ThreeLettersBlocks();
		//vThreeLettersBlocks.test_currentStringFormsAThreeLettersBlock();
		vThreeLettersBlocks.solution(CONSTANT_S);
	}
	
	/* ######################## */
	
	private void test_deleteMiddleCharacters() {
		//final String CONSTANT = "aaaxxxxxaafffffffaa";		
		final String CONSTANT = "aaaxaafffffffaa";
		//final String CONSTANT = "atheaxbtheb";
		//final String CONSTANT = "axbtheb";
		final char CHARACTER = 'b';
		System.out.println("\n original: " + CONSTANT + "\n deleted: " + deleteMiddleCharacters(CHARACTER, CONSTANT));
	}
	
	private void test_getDistinctCharacters() {
		//final String CONSTANT = "aaaxxxxxaafffffffaa";		
		final String CONSTANT = "aaaxaafffffffaa";
		//final String CONSTANT = "atheaxbtheb";
		char[] carrArray = getDistinctCharacters(CONSTANT);
		System.out.println("\n original: " + CONSTANT + "\n distinct characters: " + String.valueOf(carrArray));
	}

	private void test_getDistinctCharacters_doNotProcessCharacters() {
		//char[] doNotProcessCharacters = {'a','f'};
		char[] doNotProcessCharacters = {'a','t','h'};
		//final String CONSTANT = "aaaxxxxxaafffffffaa";		
		//final String CONSTANT = "aaaxaafffffffaa";
		final String CONSTANT = "atheaxbtheb";
		char[] carrArray = getDistinctCharacters(CONSTANT, doNotProcessCharacters);
		System.out.println("\n original: " + CONSTANT + "\n distinct characters: " + String.valueOf(carrArray));
	}
	
	private void test_currentStringFormsAThreeLettersBlock() {
		//final String CONSTANT = "axxaafa";
		//final String CONSTANT = "axxaaf";
		//final String CONSTANT = "aabbaa";
		final String CONSTANT = "aaacbba";
		System.out.println("\n original: " + CONSTANT + "\n is a three letters block ? : " + currentStringFormsAThreeLettersBlock(CONSTANT));
		
	}
	
	private void test_deleteNonBlockGroupingCharacter() {
		//final String CONSTANT = "aaacbba";
		final String CONSTANT = "aaacbb";
		System.out.println("\n original: " + CONSTANT + "\n deleted non block grouping character: " + deleteNonBlockGroupingCharacter(CONSTANT));
	}
}
