package be.uliege.boigelot.oop.sokoban.main.levels;

import be.uliege.boigelot.oop.sokoban.main.cells.CellType;
import be.uliege.boigelot.oop.sokoban.main.cells.Coordinate;
import be.uliege.boigelot.oop.sokoban.main.Sokoban;
import be.uliege.boigelot.oop.sokoban.main.Counter;
import be.uliege.boigelot.oop.sokoban.main.GameState;
import be.uliege.boigelot.oop.sokoban.main.movable.crates.Crates;
import be.uliege.boigelot.oop.sokoban.main.movable.player.Player;


public class GameLevel{
	
	private Levels currentLevel;
	private static int numberOfTargets;
	private static CellType[][] grid;
    private static Crates[][] crates;
	private static Player player;
	private static Counter counter;
	private GameState gameState;

	public GameLevel(int gameCurrentLevel, int windowWidth, int windowHeight){
		
		initGameLevel(gameCurrentLevel, windowWidth, windowHeight);
	}
	
	private void initGameLevel(int gameCurrentLevel, int windowWidth, int windowHeight){
		
		currentLevel = new Levels(gameCurrentLevel);
		numberOfTargets = 0;
		grid = new CellType[windowWidth][windowHeight];
		crates = new Crates[windowWidth][windowHeight];
		counter = new Counter();
		gameState = Sokoban.getGameState();
	
		for (int i = 0; i < windowWidth; i++){
            for (int j = 0; j < windowHeight; j++){
				//j,i and not i,j
				CellType cell = currentLevel.getGridCell(j,i);
				switch(cell)
				{
					default:
						grid[i][j] = CellType.BLACK;
						break;
					case CRATE:
						grid[i][j] = CellType.CRATE;
						crates[i][j] = new Crates(gameState, new Coordinate(i, j));
						break;
					case CRATE2:
						grid[i][j] = CellType.CRATE2;
						crates[i][j] = new Crates(gameState, new Coordinate(i, j));
						break;
					case EMPTY:
						grid[i][j] = CellType.EMPTY;
						break;
					case PLAYERDOWN:
						grid[i][j] = CellType.PLAYERDOWN;
						player = new Player(gameState, new Coordinate(i, j), counter);
						break;
					case TARGET:
						grid[i][j] = CellType.TARGET;
						numberOfTargets++;
						break;
					case WALL: 
						grid[i][j] = CellType.WALL;
						break;
                    case PLAYERONTARGETDOWN:
						grid[i][j] = CellType.PLAYERONTARGETDOWN;
                        player = new Player(gameState, new Coordinate(i, j), counter);
						break;
					case MAGMA:
						grid[i][j] = CellType.MAGMA;
						break;
					case LAVA:
						grid[i][j] = CellType.LAVA;
						break;
					case PLAYERONLAVADOWN:
						grid[i][j] = CellType.PLAYERONLAVADOWN;
                        player = new Player(gameState, new Coordinate(i, j), counter);
						break;
                    case NUMBER0:
						grid[i][j] = CellType.NUMBER0;
						break;
				}
            }
        }
	}
	
	public CellType getCell(int i, int j){
		return grid[i][j];
	}
	
	public int getNumberOfTargets(){
		return numberOfTargets;
	}
	public static CellType getCellType(Coordinate coordinate) {
        return grid[coordinate.x][coordinate.y];
    }

    public static CellType getCellType(int x, int y) {
        return grid[x][y];
    }

    public static void setCellType(Coordinate coordinate, CellType type) {
        grid[coordinate.x][coordinate.y] = type;
    }

    public static void setCellType(int x, int y, CellType type) {
        grid[x][y] = type;
    }

    public static Player getPlayer() {
        return player;
    }

    public static Crates getCrates(Coordinate coordinate) {
        return crates[coordinate.x][coordinate.y];
    }

    public static void updateCrates(Coordinate coordinate, Coordinate newCoordinate) {
        crates[newCoordinate.x][newCoordinate.y] = crates[coordinate.x][coordinate.y];
        crates[coordinate.x][coordinate.y] = null;
    }
	
	public int getMovesNumber(){
		return counter.getCounter();
	}
	
	public static void updateNumberOfTargets(int target){
		numberOfTargets += target;
	}
}