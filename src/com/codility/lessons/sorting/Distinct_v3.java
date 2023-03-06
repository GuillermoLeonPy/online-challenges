package com.codility.lessons.sorting;

public class Distinct_v3 {

	public int solution(int[] A) {
		
		mergeSort(A, A.length);
		System.out.println("\n" + A);
		return 0;
	}
	
	public void mergeSort(int[] a, int n) {
	    if (n < 2) {
	        return;
	    }
	    int mid = n / 2;
	    int[] l = new int[mid];
	    int[] r = new int[n - mid];

	    for (int i = 0; i < mid; i++) {
	        l[i] = a[i];
	    }
	    for (int i = mid; i < n; i++) {
	        r[i - mid] = a[i];
	    }
	    mergeSort(l, mid);
	    mergeSort(r, n - mid);

	    merge(a, l, r, mid, n - mid);
	}
	
	public void merge(int[] a, int[] l, int[] r, int left, int right) {
			 
			    int i = 0, j = 0, k = 0;
			    while (i < left && j < right) {
			        if (l[i] <= r[j]) {
			            a[k++] = l[i++];
			        }
			        else {
			            a[k++] = r[j++];
			        }
			    }
			    while (i < left) {
			        a[k++] = l[i++];
			    }
			    while (j < right) {
			        a[k++] = r[j++];
			    }
	}
	
	private static final int [] ARRAY = {10, 6, 8, 5, 7, 3, 4};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Distinct_v3 vDistinct_v3 = new Distinct_v3();
		System.out.println("\n" + vDistinct_v3.solution(ARRAY));
	}

}
