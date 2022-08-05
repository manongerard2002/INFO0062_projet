package be.uliege.boigelot.oop.sokoban.main.movable.player;

import be.uliege.boigelot.oop.sokoban.main.levels.GameLevel;
import be.uliege.boigelot.oop.sokoban.main.GameState;
import be.uliege.boigelot.oop.sokoban.main.Counter;
import be.uliege.boigelot.oop.sokoban.main.cells.CellType;
import be.uliege.boigelot.oop.sokoban.main.cells.Coordinate;
import be.uliege.boigelot.oop.sokoban.main.gui.MoveNotAllowedException;
import be.uliege.boigelot.oop.sokoban.main.gui.ProjectSokobanGUI;
import be.uliege.boigelot.oop.sokoban.main.movable.Movable;


public class Player extends Movable
{
	Counter counter;
	
    public Player(GameState gameState, Coordinate place, Counter counter) {
        super(gameState, place);
		this.counter = counter;
    }

    public void move(int action) throws MoveNotAllowedException 
    {
        counter.increaseMoveNumber(GameState.WIDTH - 1, GameState.HEIGHT - 1);

        int deltaX = 0;
        int deltaY = 0;

        switch (action)
        {
            case ProjectSokobanGUI.UP:
                deltaY--;
                break;
            case ProjectSokobanGUI.DOWN:
                deltaY++;
                break;
            case ProjectSokobanGUI.LEFT:
                deltaX--;
                break;
            case ProjectSokobanGUI.RIGHT:
                deltaX++;
                break;
            default:
                System.out.println("The input does not match any movement");
                return;
        }

        Coordinate newPlayerPlace = new Coordinate(place.x + deltaX, place.y + deltaY);
        CellType cellTypeNewPlayerPlace = GameLevel.getCellType(newPlayerPlace);
        switch (cellTypeNewPlayerPlace)
        {
            case CRATE:
                //no break because same thing as CRATE2 need to be done
            case CRATE2:
                if(GameLevel.getCrates(newPlayerPlace).moveCrate(newPlayerPlace.x - place.x, newPlayerPlace.y - place.y) == true)
                {
                    move(place, newPlayerPlace, GameLevel.getCellType(newPlayerPlace), deltaX, deltaY);
                }
                break;
            case TARGET:
                //no break because we also need to move
            case EMPTY:
                //no break because we also need to move
            case MAGMA:
                //no break because we also need to move
            case LAVA:
                move(place, newPlayerPlace, cellTypeNewPlayerPlace, deltaX, deltaY);
                break;
            default: //in case of de wall
                System.out.println("You cannot go through a wall");
                //just to change the direction du player
                move(place, place, GameLevel.getCellType(place), deltaX, deltaY);
                return;
        }
    }

    public void remove()
    {
        switch(GameLevel.getCellType(place))
        {
            default: //PLAYERDOWN:
                //no break because needs to the same thing as PLAYERUP
            case PLAYERUP:
                //no break because needs to the same thing as PLAYERLEFT
            case PLAYERLEFT:
                //no break because needs to the same thing as PLAYERRIGHT
            case PLAYERRIGHT:
                setMovable(place, CellType.EMPTY);
                break;
            case PLAYERONTARGETDOWN:
                //no break because needs to the same thing as PLAYERONTARGETUP
            case PLAYERONTARGETUP:
                //no break because needs to the same thing as PLAYERONTARGETLEFT
            case PLAYERONTARGETLEFT:
                //no break because needs to the same thing as PLAYERONTARGETRIGHT
            case PLAYERONTARGETRIGHT:
                setMovable(place, CellType.TARGET);
                break;
            case PLAYERONLAVADOWN:
                //no break because needs to the same thing as PLAYERONLAVAUP
            case PLAYERONLAVAUP:
                //no break because needs to the same thing as PLAYERONLAVALEFT
            case PLAYERONLAVALEFT:
                //no break because needs to the same thing as PLAYERONLAVARIGHT
            case PLAYERONLAVARIGHT:
                setMovable(place, CellType.LAVA);
                break;
        }
    }
}
