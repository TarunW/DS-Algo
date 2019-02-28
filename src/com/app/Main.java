package com.app;

public class Main {

	public static void main(String[] args) {

		int n = 5;
		

		printStar2(n);
		
		// printStar1(n);

	}

	private static void printStar2(int n) {

		int k = n+3;
		// number of rows
		for (int i = 1; i <= n; i++) {
			
			//number of spaces before star
			for(int s=1; s < i; s++){
				System.out.print(" ");
			}
			
			// number of stars in each rows
			for (int j = k; j >= 0; j--) {
				System.out.print("*");
			}
			k= k-2;						
			System.out.println("");
		}

	}

	private static void printStar1(int n) {
		int k = 1, s = n;
		// number of rows
		for (int i = 1; i <= n; i++) {

			// space before first start in every row
			for (int m = 1; m <= s; m++) {
				System.out.print(" ");
			}

			// number of stars in each rows
			for (int j = 1; j <= k; j++) {
				System.out.print("*");
			}
			// every row will have 2 more * than previous row.
			k = k + 2;
			// decrement number of space for nextNode row
			s = s - 1;
			System.out.println();
		}
	}
}