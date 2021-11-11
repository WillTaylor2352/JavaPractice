package main;

import java.util.*;

public class LetterCounter {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		String newString = myScanner.nextLine();
		newString = newString.toLowerCase();
		
		char[] stringArray = newString.toCharArray(); 
		Arrays.sort(stringArray);
		stringArray = String.valueOf(stringArray).trim().toCharArray();
		int[] myIntArray = new int[26];
		int i = 0;
		char[] myCharArray = new char[26];
		int j = 0;
		for (char c = 'a'; c<='z'; c++) {
			myCharArray[j] = c;
			j++;
		}
		for (char c = 'a'; c<='z'; c++) {
			for (char z : stringArray) {
				if (c == z)
					myIntArray[i]++;
			}
			i++;
		}
		System.out.println(Arrays.toString(myCharArray) + "\n" + Arrays.toString(myIntArray));
		
	}

}
