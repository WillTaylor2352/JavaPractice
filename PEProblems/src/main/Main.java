package main;
import java.util.*;

public class Main {
	public static void main(String[] args) 
	{
		
	}
		
		/*
		Scanner s = new Scanner(System.in);
		try {
			System.out.println("enter 2 numbers to add together:");
			int i = s.nextInt();
			int j = s.nextInt();
			
			System.out.println(i+j);
		}
		catch(Exception e) {
			System.out.println("wrong stuff mate");
		}
	}
		/*
		/////////////////////////////////////////////////////////////
		//PROBLEM4
		/////////////////////////////////////////////////////////////
		// What is the largest palindrome made of the product of 2-3 digit numbers
		int max1 = 999;
		int max2 = 999;
		ArrayList<ArrayList<String>> myIntegerArray = new ArrayList<ArrayList<String>>();
		
		for(int i = 0; i < 10; i++) {
			max1=999;
			myIntegerArray.add(new ArrayList<String>());
			myIntegerArray.get(i).add(Integer.valueOf(max1) + " x " + Integer.valueOf(max2));
			for (int j = 0; j < 10; j++) {
				myIntegerArray.get(i).add(Integer.valueOf(max1*max2).toString());
				max1--;
				
			}
			max2--;
		}
		for (int i = 0; i < myIntegerArray.size(); i++) {
			System.out.println(myIntegerArray.get(i).toString());
			
		}
	}
	
		
		
	/*	/////////////////////////////////////////////////////////////
		//PROBLEM3
		/////////////////////////////////////////////////////////////
		// WHAT IS THE LARGEST PRIME FACTOR OF 600851475143
		long longTest = 600851475143L;
		double newLong = Math.sqrt(longTest);
		//System.out.println(newLong);
		if (Math.floor(newLong) % 2 == 0)
			newLong = Math.floor(newLong)-1;
		System.out.println(newLong + " is the sqrt of 600851475143");
		ArrayList<Integer> myDivisorArray = new ArrayList<Integer>();
		ArrayList<Integer> myPrimeArray = new ArrayList<Integer>();
		
		for (int i = 3; i < newLong; i++) {
			if (longTest%i==0) {
				myDivisorArray.add(Integer.valueOf(i));
			}
		}
		System.out.println("My Divisor Array:" + myDivisorArray.toString());
		boolean isPrime;
		for(int k=0; k<myDivisorArray.size();k++) {
			int currnum = myDivisorArray.get(k);
			isPrime = true;
			for (int j=3; j < currnum; j+=2) {
				if (currnum%j==0) {
					isPrime = false;
					break;
				}
				else if (isPrime && (currnum-2)<=j && currnum%j!=0){
					myPrimeArray.add(currnum);
				}
				
			}
			
		}
		System.out.println("My Prime Array:" + myPrimeArray.toString());
	*/
		
	//	System.out.println(myPrimeList.toString());
		
		
		/////////////////////////////////////////////////////////////
		//PROBLEM2
		/////////////////////////////////////////////////////////////
		/*int fib1 = 1;
		int fib2 = 1;
		int holderfib = 0;
		int fibsum = 0;
		try {
			while (holderfib < 4_000_000) {
				holderfib = fib1 + fib2;
				fib1 = fib2;
				fib2 = holderfib;
				
				if (holderfib%2 == 0) {
					fibsum+=holderfib;
				}
			}
			System.out.println(fibsum);
		}catch (Exception e) {
			System.out.println("Uh-uh-uh");
		}*/
		/////////////////////////////////////////////////////////////
		//PROBLEM1
		/////////////////////////////////////////////////////////////
		/*Scanner s = new Scanner(System.in);
		int sum=0;
		try
		{
			int loopCount = s.nextInt();
			for (int i=0; i<loopCount; i++) 
			{
				if (i%3 == 0) 
				{
					sum +=i;
				}
				else if (i%5 == 0) 
				{
					sum +=i;
				}
			}
			System.out.println(sum);
		}
		catch(Exception e) {
			System.out.println("Are you sure about that?");
		}*/
	//}
}
