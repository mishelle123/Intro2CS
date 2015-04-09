 /**
* FILE : Ex2a.java
* WRITER : Mishelle Fried + mishelle + 304844517
* EXERCISE : intro2cs ex0 2012-2013
* DESCRIPTION:
* A program that reads a person's age and prints the range of that person's
* target heart rate.
*/ 

import java.util.Scanner;

public class Ex2a {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
        System.out.println("This program calculates your target heart " +
                            "rate while exercising."); 							   					
		System.out.print("Enter your age: ");
		int age = scanner.nextInt(); // the user age
		double upperLimit = (220-age)*0.85;
		double lowerLimit = (220-age)*0.65;
		System.out.println("Your estimated target heart rate zone is "+
							Math.round(lowerLimit) + " - " + Math.round(upperLimit) + " beats per minute.");	
	}
}

