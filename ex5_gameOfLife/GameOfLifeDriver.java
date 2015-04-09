
import java.util.Scanner; 
import il.ac.huji.cs.intro.IntroUtil;
import il.ac.huji.cs.intro.GridWindow;

public class GameOfLifeDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int height = Integer.parseInt(args[0]);
		int width = Integer.parseInt(args[1]);
		Scanner sc = IntroUtil.newScannerFromFile(args[2]);
		boolean isCyclic = false;
		if(args[3].equals("cyclic")){
			isCyclic = true;
		}	

		String stringWorld= "";
		for(int i=0; i<height; i++){
			if(sc.hasNext()){
				stringWorld+= sc.nextLine() + "\n";
			}
		}
		GameOfLife game = new GameOfLife(height, width, stringWorld, isCyclic);
		GridWindow grid = new GridWindow(height, width, stringWorld);

		while(true){
			game.nextGeneration();
			grid.update(game.getWorld());
			IntroUtil.sleep(1);
		}


	}


}
