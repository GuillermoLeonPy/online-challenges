package com.leetcode.binary.search;

/*
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

 

Example 1:

Input: n = 5, bad = 4
Output: 4
Explanation:
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.
Example 2:

Input: n = 1, bad = 1
Output: 1
 

Constraints:

1 <= bad <= n <= 231 - 1
*/
public class VersionControl {

	private static int BAD_VERSION = 1;
	private static int INPUT = 3;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(firstBadVersion(INPUT));
	}

    public static int firstBadVersion(int n) {
        return process(1,n,n);
    }
    
    public static int process(int from, int to, int lastBad){
        if(from > to){
            return lastBad;
        }
        int half = from + ((to-from)/2);
        boolean isBad = isBadVersion(half);
        if(isBad){
            return process(from,half-1, half);
        }else{
            return process(half+1,to, lastBad);
        }
    }
    
    private static boolean isBadVersion(int i) {
    	return i >= BAD_VERSION;
    }
}
