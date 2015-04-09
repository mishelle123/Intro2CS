/**
 * Displays sequences in a window.
 */
import il.ac.huji.cs.intro.ex8.Sequence;
import il.ac.huji.cs.intro.ex8.SequencePlotter;
import il.ac.huji.cs.intro.ex8.SequencePlotter.CURVE_DISPLAY_STYLE;

import il.ac.huji.cs.intro.IntroUtil;
import java.util.Scanner; 

public class SequenceViewer {

	private final static String BLACK = "black";
	private final static String BLUE = "blue";
	private final static String RED = "red";
	private final static String GREEN = "green";
	private final static String SEQUENCE = "SEQUENCE";
	private final static String LIMIT_POINT= "LIMIT_POINT";
	private final static String CURVE_DISPLAY = "CURVE_DISPLAY_STYLE.DOT_PLOT";
	private final static String CONTINUOUS_LINEAR = "CONTINUOUS_LINEAR_INTERPOLATION";
	private final static String ERROR_MESSAGE = "Usage: SequenceViewer filePath, where" +
												" filePath is a path to an input file.";
	/**
	 *   
	 *  Runs the main program.

	 * An input file path is given as a single argument to this function. Each line in the 
	 * file is either a whitespace line (and is ignored), or a line of the format:
	 * SEQUENCE, [color], [style], [numberOfPoints], [sequence expression]
	 * or a line of the format: LIMIT_POINT, [double] For example: 
	 * SEQUENCE, black, CONTINUOUS_LINEAR_INTERPOLATION, 100, n^2 Or: 
	 * LIMIT_POINT, 3.14159265359 
	 * In each of the line's components, whitespace is ignored. 
	 * A sequence line is defined as follows: 
	 * Colors may be one of: black, blue, red, green. 
	 * Style may be one of: CONTINUOUS_LINEAR_INTERPOLATION, DOT_PLOT. 
	 * Number of points determines how many points are plotted. 
	 * The sequence expression is used to display a sequence. 
	 * A limit point line is defined as follows: A single number (double-precision) is given, 
	 * and this number should be added to the plotter window using its limit point functionality.
	 * The program will open a plotting window and display all the specified graphs in it, with their
	 *  specified parameters. Limit points are added as specified. 
	 *  In case the number of arguments is different than 1, display an error message: 
	 *  "Usage: SequenceViewer filePath, where filePath is a path to an input file.". Otherwise, we assume 
	 *  the argument is a legal accessible path to an input file.  
	 *  
	 *  
	 * @param args
	 */
	public static void main(java.lang.String[] args){
		
		
		if(args.length!=1){
			System.out.println(ERROR_MESSAGE);
			return;
		}
		Scanner sc = IntroUtil.newScannerFromFile(args[0]);
		SequencePlotter plotter = SequencePlotter.getPlotter();
		plotter.openWindow();
		SequencePlotter.CURVE_DISPLAY_STYLE style = CURVE_DISPLAY_STYLE.DOT_PLOT;
		java.awt.Color clr = java.awt.Color.black;
		String params[];
		String line;
		while(sc.hasNext()){
			line = sc.nextLine();
			line = line.replaceAll("\\s", "");
			params = line.split(",");
			
			//plot sequence
			if (params[0].equals(SEQUENCE)){
				
				//checks the colors
				if(params[1].equals(BLACK)){
					clr = java.awt.Color.black;
				}
				if(params[1].equals(BLUE)){
					clr = java.awt.Color.blue;
				}
				if(params[1].equals(RED)){
					clr = java.awt.Color.red;
				}
				if(params[1].equals(GREEN)){
					clr = java.awt.Color.green;
				}
				//checks the line style
				switch(params[2]){
				case CURVE_DISPLAY:
				style = CURVE_DISPLAY_STYLE.DOT_PLOT;
				case CONTINUOUS_LINEAR:
				style = CURVE_DISPLAY_STYLE.CONTINUOUS_LINEAR_INTERPOLATION;
				}
				int numberOfPoints = Integer.parseInt(params[3]);
				Sequence seq = SequenceFactory.sequenceFromString(params[4]);
				
			
				plotter.plotSequence(seq, clr, style, numberOfPoints);
			}
			//plot limit_point
			if(params[0].equals(LIMIT_POINT)){
				plotter.addLimitPoint(Double.parseDouble(params[1]));

			}
			
		}
		
	
		

	}
}
