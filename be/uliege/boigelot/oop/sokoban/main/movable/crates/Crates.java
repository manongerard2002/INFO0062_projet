package be.uliege.boigelot.oop.sokoban.main.movable.crates;

import be.uliege.boigelot.oop.sokoban.main.levels.GameLevel;
import be.uliege.boigelot.oop.sokoban.main.GameState;
import be.uliege.boigelot.oop.sokoban.main.cells.CellType;
import be.uliege.boigelot.oop.sokoban.main.cells.Coordinate;
import be.uliege.boigelot.oop.sokoban.main.gui.MoveNotAllowedException;
import be.uliege.boigelot.oop.sokoban.main.movable.Movable;

public class Crates extends Movable
{
    public Crates(GameState gameState, Coordinate place) {
        super(gameState, place);
    }

    public boolean moveCrate(int deltaX, int deltaY) throws MoveNotAllowedException 
    {
        if (deltaX != 0 && deltaY != 0) {
            throw new MoveNotAllowedException("Error : this move is not allowed by the code");
        }

        Coordinate newCratePlace = new Coordinate(place.x + deltaX, place.y + deltaY);

        CellType cellTypeNewCratePlace = GameLevel.getCellType(newCratePlace);
        if (cellTypeNewCratePlace == CellType.TARGET || cellTypeNewCratePlace == CellType.EMPTY || cellTypeNewCratePlace == CellType.MAGMA || cellTypeNewCratePlace == CellType.LAVA)
        {
            GameLevel.updateCrates(place, newCratePlace);
            move(place, newCratePlace, cellTypeNewCratePlace, deltaX, deltaY);
            return true;
        }
        else //in case of wall, crate, crate2
        {
            System.out.println("Move not allowed in this game.");
            return false;
        }
    }
}
