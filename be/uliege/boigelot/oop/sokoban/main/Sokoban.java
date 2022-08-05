package be.uliege.boigelot.oop.sokoban.main;

import be.uliege.boigelot.oop.sokoban.gui.*;
import be.uliege.boigelot.oop.sokoban.main.gui.MoveNotAllowedException;
import be.uliege.boigelot.oop.sokoban.main.gui.ProjectSokobanGUI;
import be.uliege.boigelot.oop.sokoban.main.levels.GameLevel;

public class Sokoban {
    private static int NUMBEROFLEVEL = 4;

    private ProjectSokobanGUI gui;
    private static GameState gameState;
    private boolean isRunning;

    public Sokoban(int levelNumber) throws SokobanError {
        //gui = new ProjectSokobanGUI(GameState.WIDTH, GameState.HEIGHT, "tiles");
        gui = new ProjectSokobanGUI(GameState.WIDTH, GameState.HEIGHT);
        gameState = new GameState(levelNumber);

        show();
    }

    private void show() throws SokobanError {
        gameState.draw(gui);
        gui.show();
    }

    private void update(int event){
        if (event == ProjectSokobanGUI.QUIT){
            System.out.println("Leaving game...");
            gameState.setGameState(false);
            isRunning = gameState.getGameState();
        }else{
            try {
                GameLevel.getPlayer().move(event);
            } catch (MoveNotAllowedException e) {
                System.out.println(e);
                System.out.println("Game Over!");
                gameState.setGameState(false);
                isRunning = gameState.getGameState();
            }
        }
    }

    public static void main(String args[]){
        try {
            for(int i = 0; i < NUMBEROFLEVEL; i++)
            {
                Sokoban game = new Sokoban(i);
                game.run();
            }
        } catch (SokobanError e) {
            System.out.println(e);
        }
    }

    private void close() throws SokobanError {
        int event = gui.getEvent();
        while (event != ProjectSokobanGUI.QUIT)
        {
            event = gui.getEvent();
        }
    }

    private void run() throws SokobanError {
        isRunning = gameState.getGameState();
        while (isRunning){
            update(gui.getEvent());
            isRunning = gameState.getGameState();
            show();
        }
        close();
    }
	
	public static GameState getGameState(){
		return gameState;
	}
}