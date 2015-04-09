/**
* FILE : Ex2b.java
* WRITER : Mishelle Fried + mishelle + 304844517
* EXERCISE : intro2cs ex0 2012-2013
* DESCRIPTION:
* The program receives a sentence from the user, print a menu with options and respones
* according to the user’s choice.
*/ 

import java.util.Scanner;

public class Ex2c {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a sentence:");
		String sentence;
		sentence = sc.nextLine();
        //presents the menu to the user
		System.out.println("1) Number of characters");
		System.out.println("2) Remove vowels");
		System.out.println("3) Replace a string");
		System.out.println("4) First and last word");
		System.out.println("5) Remove following characters");
		System.out.println("6) Middle characters");
		System.out.println("7) Convert to upper/lower case");
		System.out.println("Choose option to execute:");
        //menu ends
		int choose = sc.nextInt();
		switch(choose) {
			case 1 :
            //length
			System.out.println("The result is: " +
                                sentence.length()); 
            break;
			case 2 :
            // print the sentence after removing all vowels
			sentence = sentence.replace("a","");
            sentence = sentence.replace("e","");
            sentence = sentence.replace("o","");
            sentence = sentence.replace("i","");
            sentence = sentence.replace("u","");
			System.out.println("The result is: " + sentence);
            break;

			case 3 :
            //replace a string
			System.out.println("String to replace:"); 
			String stringToReplace = sc.nextLine();
            stringToReplace = sc.nextLine();
			System.out.println("New string:");
			String newString = sc.next();
			System.out.println("The result is: " +
                          sentence.replaceAll(stringToReplace,newString));
			break;
            
            case 4 : 
            //replace first and last word
            if(sentence.indexOf(" ")==(-1)){ // cecks if the index is -1
                 System.out.println("The result is: ");   
            }
            else {
                if(sentence.indexOf(" ") != sentence.lastIndexOf(" ")) { // checks if there is only one space
                    String firstWord = sentence.substring(0,sentence.indexOf(" ")); 
                    String lastWord = sentence.substring(sentence.lastIndexOf(" ")+1); 
                    if(firstWord.equals(lastWord)){
                        String replace = sentence.replaceAll(firstWord,"");
                        System.out.println("The result is: " +
                                      replace.substring(1,(replace.length()-1)));                    
                    }
                    else {
                        System.out.println("The result is: " + sentence);
                    }
                }
                else{
                    String firstWord = sentence.substring(0,sentence.indexOf(" ")); 
                    String lastWord = sentence.substring(sentence.lastIndexOf(" ")+1); 
                    if(firstWord.equals(lastWord)){
                        String replace = sentence.replaceAll(firstWord,"");
                        System.out.println("The result is: ");                    
                    }
                    else {
                        System.out.println("The result is: " + sentence);
                    }
                }
            }
        
            break;

            case  5 : 
            // Remove following characters
			System.out.println("Enter a string:");
			String userStr = sc.nextLine();
            userStr = sc.nextLine();
            // findes the user string in the original sentence
            int userStrIndex = sentence.indexOf(userStr);
            if(userStrIndex!=-1){ 
            // the point that the program should start eraising
            int startErase = userStrIndex + userStr.length();
            String start = sentence.substring(0, startErase);
                        
            if(userStr.length()<(sentence.length()-(userStr.length()+userStrIndex))){
                String end = sentence.substring(startErase+userStr.length());
		        System.out.println("The result is: " + start+end);
            }
            else {
                System.out.println("The result is: " + start);
            } 
            }
            else {
                System.out.println("The result is: " + sentence);
            }
            break;   
			
            case 6 :
            // print 2/3 middle characters
            sentence = sentence.replaceAll(" " ,"");
            int lettersNum = sentence.length();
            if(lettersNum!=1){
                if(lettersNum%2==0) {
                System.out.println("The result is: " +
                        sentence.substring(lettersNum/2-1, lettersNum/2+1)); 
                }
                else{
                System.out.println("The result is: " + 
                      sentence.substring(sentence.length()/2-1, sentence.length()/2+2));
                }
            }
            else {
                 System.out.println("The result is: " + sentence);
            }
            break;
            
            case 7 : 
            // Convert to upper/lower case
            String toLowerCase = sentence.toLowerCase();
            if(sentence.equals(toLowerCase)){
                System.out.println("The result is: " + sentence.toUpperCase());
            }
            else {
                System.out.println("The result is: " + sentence.toLowerCase());
            }
            break;
            
            default :
                System.out.println("The result is: Error!");
		}		
	}
}
