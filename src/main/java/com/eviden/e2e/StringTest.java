package com.eviden.e2e;

public class StringTest {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		long endTime = 0L;
		int numberOfIncrements = 300000;
		
		System.out.println("Program started...");
		
		// first part
		String largeString = "";
		
		for (int i = 0; i < numberOfIncrements; i++) {
			largeString = largeString + i;
		}
		
		endTime = System.currentTimeMillis();
		
		System.out.println("Ellapsed time is: " + (endTime - startTime) + " ms");

		// second part
		startTime = System.currentTimeMillis();
		
		StringBuffer largeStringBuffer = new StringBuffer("");
		
		for (int i = 0; i < numberOfIncrements; i++) {
			largeStringBuffer.append(i);
		}
		
		endTime = System.currentTimeMillis();
		
		System.out.println("Ellapsed time is: " + (endTime - startTime) + " ms");
		
		// third part
		startTime = System.currentTimeMillis();
		
		StringBuilder largeStringBuilder = new StringBuilder("");
		
		for (int i = 0; i < numberOfIncrements; i++) {
			largeStringBuilder.append(i);
		}
		
		endTime = System.currentTimeMillis();
		
		System.out.println("Ellapsed time is: " + (endTime - startTime) + " ms");
	}

}
