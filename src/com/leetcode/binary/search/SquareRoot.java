package com.leetcode.binary.search;

public class SquareRoot {

	//private static int value = 10;
	//private static int value = 8;
	//private static int value = 36;
	private static int value = 2147395599;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(mySqrt(value));
	}
	
    public static int mySqrt(int x) {
        long result = search(0l,(long)x / 2,(long) x);
        return (result * result) > (long)x ? (int)(result - 1) : (int)result ;
    }
    
    public static long search(long from, long to, long target){
        if(target <= 1) {
    		return target;
    	}
        if(from > to) {
    		return to;
    	}
        long half = from + ((to - from) / 2);
        if(half * half > target){
            if(((half - 1) * (half - 1)) < target){
                return half - 1;
            }
            return search(from, half - 1, target);
        }else if (half * half < target){
            if(((half + 1) * (half + 1)) > target){
                return half + 1;
            }
            return search(half + 1, to, target);
        }else{
            return half;
        }
    }

}
