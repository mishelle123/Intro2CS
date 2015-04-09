
public class PrimesDensityVisualizer {

	private static Plotter plotter = new Plotter();

	public static void setPlotter(Plotter plotter) {
		PrimesDensityVisualizer.plotter = plotter;
	}
	/**
	 * Receives exactly one argument, a number n. 
	 * The function pi and its approximation will be plotted for all natural numbers 
	 * in the (inclusive) range [2,n].
	 * 
	 * @param args
	 * @param userNum
	 */
	public static void main(String[] args){
		int userNum= Integer.parseInt(args[0]);
		if(userNum<2){
			System.out.println("Usage: PrimesDensityVisualizer x, where x is a natural number greater than 1.");
            return;
		}
    
		drawPrimesCountingFunction(userNum);
	}
	/**
	 * Returns the number of primes which are smaller
	 *  than or equal to a given number.
	 *  
	 * @param number
	 * @return Returns the number of primes which are smaller
	 *  than or equal to a given number.
	 */
	public static int numberOfPrimesBelow(int number){
		PrimesEnumerator p = new PrimesEnumerator(number);
		int count =0; 
		while(p.hasNext()){
			count++;
			p.next();
		}

		return count;
	}
	/**
	 * Returns the approximate number of primes which are
	 *  smaller than or equal to a given number.
	 * 
	 * @param number
	 * @return
	 * Returns the approximate number of primes which are
	 *  smaller than or equal to a given number.
	 */
	public static double approximateNumOfPrimesBelow(int number){
		if(number<2){
			return 0;
		}
		else{
			return number/Math.log(number);
		}
	}

	/**
	 * Plots two curves: one is the counting function of prime numbers up to the given number (in red), 
	 * and the other is the approximation to the counting function of prime numbers up to the given parameter,
	 *  as given by approximateNumOfPrimesBelow().  
	 * 
	 * @param number
	 */
	public static void drawPrimesCountingFunction(int number){
		plotter.openWindow();

		plotter.startCurve(java.awt.Color.red);
		for(int i=2;i<=number; i++){
			Point point = new Point(i,numberOfPrimesBelow(i));
			plotter.addToCurve(point); 
		}
		plotter.endCurve();
		plotter.startCurve(java.awt.Color.green);
		for(int i=2;i<=number; i++){
			Point point = new Point(i,approximateNumOfPrimesBelow(i));
			plotter.addToCurve(point); 
		}
		plotter.endCurve();


	}

}

