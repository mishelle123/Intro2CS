/**
* FILE: HelloTurtle2.java
* WRITER: Mishelle Fried
* EXERCISE: intro2cs 2012-2013
* DESCRIPTION: 
* the program consist a turtle holding imaginary pen and drwas   
* different shapes.
*/
import il.ac.huji.cs.intro.ex1.*;
public class HelloTurtle{
    public static void main(String args[]){
        IntroTurtle turtle = new IntroTurtle();
        turtle.penUp();
        turtle.counterclockwise(180);
        turtle.forward(80);
        turtle.penDown();
        turtle.back(80);
        turtle.counterclockwise(90);
        turtle.forward(100);
        turtle.clockwise(135); // Starting to draw the triangle
        turtle.forward(20);
        turtle.counterclockwise(120);
        turtle.forward(40);
        turtle.counterclockwise(120);
        turtle.forward(40);
        turtle.counterclockwise(120);
        turtle.forward(20);
        turtle.clockwise(135);  // Triangle is finished
        turtle.forward(50);
        turtle.clockwise(90); // drwas the picture "legs"
        turtle.forward(80);
        turtle.penUp();
        turtle.back(80);
        turtle.penDown();
        turtle.counterclockwise(90);
        turtle.forward(50);
        turtle.counterclockwise(90);
        turtle.forward(100);
        turtle.clockwise(90); // drwas the picture "legs"
        turtle.forward(80);
        turtle.penUp();
        turtle.back(80);
        turtle.penDown();
        turtle.counterclockwise(90);
        turtle.forward(100);
        turtle.clockwise(45); // draws the colored lines
        turtle.setPenSize(5);
        turtle.setPenColor(IntroTurtle.Color.RED);
        turtle.forward(120);
        turtle.penUp(); 
        turtle.back(120);
        turtle.penDown();
        turtle.clockwise(2);
        turtle.setPenColor(IntroTurtle.Color.ORANGE);
        turtle.forward(120);
        turtle.penUp(); 
        turtle.back(120);
        turtle.penDown();
        turtle.clockwise(2);
        turtle.setPenColor(IntroTurtle.Color.YELLOW);
        turtle.forward(120);
        turtle.penUp(); 
        turtle.back(120);
        turtle.penDown();
        turtle.clockwise(2);
        turtle.setPenColor(IntroTurtle.Color.GREEN);
        turtle.forward(120);
        turtle.penUp(); 
        turtle.back(120);
        turtle.penDown();
        turtle.clockwise(2);
        turtle.setPenColor(IntroTurtle.Color.BLUE);
        turtle.forward(120);
        turtle.penUp(); 
        turtle.back(120);
        turtle.penDown();
        turtle.clockwise(2);
        turtle.setPenColor(IntroTurtle.Color.VIOLET);
        turtle.forward(120);
        turtle.penUp(); 
        turtle.back(120);
        turtle.penDown();
        turtle.setPenColor(IntroTurtle.Color.WHITE);
        turtle.setPenSize(2);
        turtle.counterclockwise(145); //finish drawing lines
        turtle.forward(50); 
        turtle.clockwise(90); // drwas the picture "legs"
        turtle.forward(80);
        turtle.penUp();
        turtle.back(80);
        turtle.penDown();
        turtle.counterclockwise(90);
        turtle.forward(50);
        turtle.counterclockwise(90);
        turtle.forward(100);
        turtle.hideTurtle();
    }
}
