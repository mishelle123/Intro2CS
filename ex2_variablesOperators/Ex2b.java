/**
* FILE : Ex2b.java
* WRITER : Mishelle Fried + mishelle + 304844517
* EXERCISE : intro2cs ex0 2012-2013
* DESCRIPTION:
* A program that prints all real solutions to the quadratic equation:
* ax^2 + bx + c.
*/ 

import java.util.Scanner;

public class Ex2b {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("This program solves a quadratic equation.");
        System.out.print("Enter the coefficients a b c: ");
	     // these are the coefficients
        double a = scanner.nextDouble();
	    double b = scanner.nextDouble();
	    double c = scanner.nextDouble();
	    double delta = b*b-(4*a*c);
	    double solution1 = ((-b)+Math.sqrt(delta))/(2*a) + 0;
	    double solution2 = ((-b)-Math.sqrt(delta))/(2*a) + 0;
	    double solution3 = ((-c)/b) + 0;
	    System.out.format("Equation: %.2f*x^2 + %.2f*x + %.2f = 0\n", a, b, c);
        //tests all the the cases if a=0
	    if(a==0){ 
	        if(b==0){
		        if(c==0){
			        System.out.println("All real numbers are solutions.");
			    }
		        else if(c!=0){
			        System.out.println("There are no real solutions.");
			    }
		    }
		    else {
		        System.out.format("There is one real solution: %.2f.\n", solution3); 
		    }
	    }
        //tests all the the cases if a!=0
	    else {
            if(delta==0) {
			    System.out.format("There is one real solution: %.2f.\n", solution2);
		    }
		    if(delta>0) {
			    if(solution1>solution2){ 
                    System.out.format("There are two real solutions: %.2f, %.2f.\n", + 
                                        solution2, solution1);
     			}
			    else {
		            System.out.format("There are two real solutions: %.2f, %.2f.\n", +
          					            solution1, solution2);				
			    } 
		    }
		    else if(delta<0){
			    System.out.println("There are no real solutions.");
			
		    }
	    }	
    }
}
