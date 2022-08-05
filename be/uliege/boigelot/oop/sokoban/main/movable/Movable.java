package be.uliege.boigelot.oop.sokoban.main.movable;

import be.uliege.boigelot.oop.sokoban.main.GameState;
import be.uliege.boigelot.oop.sokoban.main.levels.GameLevel;
import be.uliege.boigelot.oop.sokoban.main.cells.CellType;
import be.uliege.boigelot.oop.sokoban.main.cells.Coordinate;
import be.uliege.boigelot.oop.sokoban.main.gui.MoveNotAllowedException;


public abstract class Movable 
{
    protected GameState gameState;
    protected Coordinate place;

    public Movable(GameState gameState, Coordinate place)
    {
        this.gameState = gameState;
        this.place = place;
    }

    protected void setMovable(Coordinate place, CellType cellType) {
        GameLevel.setCellType(place, cellType);
    }

    protected void move(Coordinate place, Coordinate newPlace, CellType cellTypeNewPlace, int deltaX, int deltaY) throws MoveNotAllowedException 
    {
        this.place = newPlace;
        CellType placeCellType = GameLevel.getCellType(place);
        
        if(placeCellType == CellType.PLAYERONTARGETDOWN || placeCellType == CellType.PLAYERONTARGETUP || placeCellType == CellType.PLAYERONTARGETLEFT || placeCellType == CellType.PLAYERONTARGETRIGHT
        || placeCellType == CellType.PLAYERDOWN || placeCellType == CellType.PLAYERUP || placeCellType == CellType.PLAYERLEFT || placeCellType == CellType.PLAYERRIGHT
        || placeCellType == CellType.PLAYERONLAVADOWN || placeCellType == CellType.PLAYERONLAVAUP || placeCellType == CellType.PLAYERONLAVALEFT || placeCellType == CellType.PLAYERONLAVARIGHT) {
            //does not enter the if when it just needs to change the player's direction
            if (cellTypeNewPlace != CellType.PLAYERONTARGETDOWN && cellTypeNewPlace != CellType.PLAYERONTARGETUP && cellTypeNewPlace != CellType.PLAYERONTARGETLEFT && cellTypeNewPlace != CellType.PLAYERONTARGETRIGHT
            && cellTypeNewPlace != CellType.PLAYERDOWN && cellTypeNewPlace != CellType.PLAYERUP && cellTypeNewPlace != CellType.PLAYERLEFT && cellTypeNewPlace != CellType.PLAYERRIGHT) {
                if(placeCellType == CellType.PLAYERONTARGETDOWN || placeCellType == CellType.PLAYERONTARGETUP || placeCellType == CellType.PLAYERONTARGETLEFT || placeCellType == CellType.PLAYERONTARGETRIGHT) {
                    setMovable(place, CellType.TARGET);
                }
                else if(placeCellType == CellType.PLAYERDOWN || placeCellType == CellType.PLAYERUP || placeCellType == CellType.PLAYERLEFT || placeCellType == CellType.PLAYERRIGHT) {
                    setMovable(place, CellType.EMPTY);
                }
                else if(placeCellType == CellType.PLAYERONLAVADOWN || placeCellType == CellType.PLAYERONLAVAUP || placeCellType == CellType.PLAYERONLAVALEFT || placeCellType == CellType.PLAYERONLAVARIGHT) {
                    setMovable(place, CellType.MAGMA);
                }
                else {
                    throw new Error("Error : this move is not allowed by the code");
                }
            }

            if(cellTypeNewPlace == CellType.MAGMA || cellTypeNewPlace == CellType.PLAYERONLAVADOWN || cellTypeNewPlace == CellType.PLAYERONLAVAUP || cellTypeNewPlace == CellType.PLAYERONLAVALEFT || cellTypeNewPlace == CellType.PLAYERONLAVARIGHT) {
                change(newPlace, deltaX, deltaY, CellType.PLAYERINMAGMADOWN, CellType.PLAYERINMAGMAUP, CellType.PLAYERINMAGMALEFT, CellType.PLAYERINMAGMARIGHT);
                throw new MoveNotAllowedException("You fell in magma !");
            }
            else if(cellTypeNewPlace == CellType.TARGET || cellTypeNewPlace == CellType.PLAYERONTARGETDOWN || cellTypeNewPlace == CellType.PLAYERONTARGETUP || cellTypeNewPlace == CellType.PLAYERONTARGETLEFT || cellTypeNewPlace == CellType.PLAYERONTARGETRIGHT) {
                change(newPlace, deltaX, deltaY, CellType.PLAYERONTARGETDOWN, CellType.PLAYERONTARGETUP, CellType.PLAYERONTARGETLEFT, CellType.PLAYERONTARGETRIGHT);
            }
            else if(cellTypeNewPlace == CellType.EMPTY || cellTypeNewPlace == CellType.PLAYERDOWN || cellTypeNewPlace == CellType.PLAYERUP || cellTypeNewPlace == CellType.PLAYERLEFT || cellTypeNewPlace == CellType.PLAYERRIGHT){
                change(newPlace, deltaX, deltaY, CellType.PLAYERDOWN, CellType.PLAYERUP, CellType.PLAYERLEFT, CellType.PLAYERRIGHT);
            }
            else if(cellTypeNewPlace == CellType.LAVA){
                change(newPlace, deltaX, deltaY, CellType.PLAYERONLAVADOWN, CellType.PLAYERONLAVAUP, CellType.PLAYERONLAVALEFT, CellType.PLAYERONLAVARIGHT);
            }
            else {
                throw new MoveNotAllowedException("Error : this move is not allowed by the code");
            }
        }
        else if(placeCellType == CellType.CRATE || placeCellType == CellType.CRATE2) {
            if(placeCellType == CellType.CRATE2) {
                setMovable(place, CellType.TARGET);
                GameLevel.updateNumberOfTargets(1);
            }
            else {
                setMovable(place, CellType.EMPTY);
            }

            if(cellTypeNewPlace == CellType.MAGMA) {
                throw new MoveNotAllowedException("A crate fell in magma !");
            }
            else if(cellTypeNewPlace == CellType.LAVA) {
                setMovable(newPlace, CellType.MAGMA);
                throw new MoveNotAllowedException("The lava broke and the crate fell in the magma !");
            }
            else if(cellTypeNewPlace == CellType.TARGET) {
                setMovable(newPlace, CellType.CRATE2);
                GameLevel.updateNumberOfTargets(-1);
            }
            else {
                setMovable(newPlace, CellType.CRATE);
            }
        }
        else {
            throw new MoveNotAllowedException("Error : this move is not allowed by the code");
        }
    }

    private void change(Coordinate newPlace, int deltaX, int deltaY, CellType typeDOWN, CellType typeUP, CellType typeLEFT, CellType typeRIGHT) throws MoveNotAllowedException {
        if (deltaY > 0 && deltaX == 0) {
            setMovable(newPlace, typeDOWN);
        }
        else if (deltaY < 0 && deltaX == 0) {
            setMovable(newPlace, typeUP);
        }
        else if (deltaX < 0 && deltaY == 0) {
            setMovable(newPlace, typeLEFT);
        }
        else if (deltaX > 0 && deltaY == 0) {
            setMovable(newPlace,typeRIGHT);
        }
        else {
            throw new MoveNotAllowedException("Error : this move is not allowed by the code");
        }
    }
}
