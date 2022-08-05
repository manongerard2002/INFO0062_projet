package be.uliege.boigelot.oop.sokoban.main;

import be.uliege.boigelot.oop.sokoban.gui.SokobanError;
import be.uliege.boigelot.oop.sokoban.main.levels.GameLevel;
import be.uliege.boigelot.oop.sokoban.main.gui.ProjectSokobanGUI;

public class GameState {
    //Arbitrary choice of a 10x10 window
    public final static int WIDTH = 10;
    public final static int HEIGHT = 10;

    private static boolean gameNotCompleted;
    private static int gameLevelNumber;
	private GameLevel gameLevel;

    public GameState(int levelNumber){
		gameNotCompleted = true;
        gameLevelNumber = levelNumber;
	    initGameState();
    }

    private void initGameState(){
		gameLevel = new GameLevel(gameLevelNumber, WIDTH, HEIGHT);

    }
	
    public void draw(ProjectSokobanGUI gui) throws SokobanError {
        for (int i = 0; i < WIDTH; i++){
            for (int j = 0; j < HEIGHT; j++){
                gui.setCell(i, j, gameLevel.getCell(i,j));
            }
        }
    }
	
	public boolean getGameState(){
		if (gameLevel.getNumberOfTargets() == 0){
			gameNotCompleted = false;
            System.out.println("Congratulations, you finish this level in " + gameLevel.getMovesNumber() + " moves !");
            GameLevel.getPlayer().remove();
		}
		return gameNotCompleted;
	}

    public void setGameState(boolean newGameNotCompleted){
		gameNotCompleted = newGameNotCompleted;
	}
}