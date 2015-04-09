import il.ac.huji.cs.intro.mastermind.*;

public class Mastermind {
	public static void main(String args[]){

		int length=0, valuesNumber=0, maxTurns=0, bulls=0, userCows=0, codeCows=0 ,cows=0, bullsCounter=0; 
		int cowsCounter=0, countGamesNumber=0, countWins=0, turnsTilWin=0;
		int gameTurns=1;
		double winRate=0;
		double averageWinLength= Double.NaN;
		boolean gameEnds=false;
		boolean anotherGame= true;
		boolean changeGameOptions = true;


		MastermindUI ui = MastermindUIFactory.newMastermindUI();
		//keep runing until gameEnds
        do { 
			if(length==0 && maxTurns==0 && valuesNumber==0){
				//length- checks if the number is positive and prints error message if not
				do {
					length = ui.askNumber("Enter code length: ");
					if(length<=0){
						ui.displayErrorMessage("Value must be positive:");
					} 
				}
				while (length<=0); 
				// valuesNumber- checks if the number is positive and prints error message if not
				do {
					valuesNumber = ui.askNumber("Enter numbers of values: ");
					if(valuesNumber<=0) {
						ui.displayErrorMessage("Value must be positive:");
					}                              
				}
				while (valuesNumber<=0);
				//maxTurns- checks if the number is positive and prints error message if not
				do {
					maxTurns = ui.askNumber("Enter Max number of guesses: ");
					if(maxTurns<=0) {
						ui.displayErrorMessage("Value must be positive:");
					}
				}
				while (maxTurns<=0);

				// prints the values on the screen
				ui.reset(length, valuesNumber, maxTurns);
			}

			//import the coputer code
			Code code = CodeGenerator.newCode(length, valuesNumber); 

            //keep playing until user wins/failes
			while(gameTurns<=maxTurns && gameEnds==false) {
				Code userCode = ui.askGuess("Enter guess: " ,length);
				//checks the numbers of bulls and cows
				for(int i=0;i<valuesNumber;i++){ 
					for(int j=1;j<=length;j++){ 
                            // compare the value to the usercode
							if(i==userCode.getValue(j)){ 
							userCows++;
						}
                        // compare the value to code
						if(i==code.getValue(j)){ 
							codeCows++;   
						}
                        // check if there are bulls
						if(i==userCode.getValue(j) && i==code.getValue(j)){ 
							bulls++;
						}
					}
                    // substruct the bulls
					userCows-=bulls; 
					codeCows-=bulls;
					cows = (userCows<codeCows) ? userCows : codeCows;
                    // count the total numbers of bulls					
                    bullsCounter+=bulls; 
                    // count the total number of cows
					cowsCounter+=cows; 
					bulls=0;
					codeCows=userCows=0;
				} 
				//shows the guess result
				ui.showGuessResult(userCode,bullsCounter,cowsCounter);
				//use wins
				if(code.equals(userCode)){
					ui.displayMessage("You won in "+gameTurns+" turns!");
					gameEnds = true;
					countWins++;
					turnsTilWin+=gameTurns;
					
				}
				//game ends
				else if(gameTurns==maxTurns){
					ui.displayMessage("You lost! You failed to find the code!");
					gameEnds=true;
				}
				//game ends/user wins
				if(code.equals(userCode) || gameTurns==maxTurns){
					countGamesNumber++;
                    //evoid dividing by 0
					if(countGamesNumber!=0){
						winRate = (double)countWins/countGamesNumber;
					}
					else{
						winRate= Double.NaN;
					}
                    //evoid dividing by 0
					if(countWins!=0){		
						averageWinLength = turnsTilWin/(double)countWins; 
					}
					else{
						averageWinLength= Double.NaN;
					}
					ui.showStats(countGamesNumber,countWins,winRate,averageWinLength);
					anotherGame = ui.askYesNo("Another game? ");
					if(anotherGame==true){
						//play another game
						gameEnds=false;
						anotherGame=true;
						changeGameOptions = ui.askYesNo("Do you want to change the game options? ");
						if(changeGameOptions==true){
							//changes the game options
							length=0;
							valuesNumber=0;
							maxTurns=0;
							gameEnds= false; 
							gameTurns=0;
							countGamesNumber=0;
							countWins=0;
							turnsTilWin=0;
						

						}
						else{
                            //keeps the game optinos
							ui.clear();							
							gameEnds= false; 
							gameTurns=0;
							code = CodeGenerator.newCode(length, valuesNumber);
						}
					}
					else{
                        //ends the game
						ui.close();
					}
				}

				bullsCounter=0;
				cowsCounter=0;
				gameTurns++;
				
			}
		}
		while(anotherGame==true);

	}
}

