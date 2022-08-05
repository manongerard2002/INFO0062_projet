package be.uliege.boigelot.oop.sokoban.main;

import be.uliege.boigelot.oop.sokoban.main.levels.GameLevel;
import be.uliege.boigelot.oop.sokoban.main.cells.CellType;
import be.uliege.boigelot.oop.sokoban.main.gui.MoveNotAllowedException;

public class Counter{
	
	private static int counter;
	
	public Counter(){
		counter = 0;
	}

    public int getCounter(){
		return counter;
	}
	
    public boolean increaseMoveNumber(int x, int y) throws MoveNotAllowedException {
        if(x >= 0 && y >= 0) {
            switch(GameLevel.getCellType(x, y))
		    {
		    	case BLACK:
                    //needs to do the same thing as if it was NUMBER0
                case NUMBER0:
                    counter++;
		    		GameLevel.setCellType(x, y, CellType.NUMBER1);
                    break;
		    	case NUMBER1:
                    counter++;
		    		GameLevel.setCellType(x, y, CellType.NUMBER2);
                    break;
                case NUMBER2:
                    counter++;
		    		GameLevel.setCellType(x, y, CellType.NUMBER3);
                    break;
                case NUMBER3:
                    counter++;
		    		GameLevel.setCellType(x, y, CellType.NUMBER4);
                    break;
                case NUMBER4:
                    counter++;
		    		GameLevel.setCellType(x, y, CellType.NUMBER5);
                    break;
                case NUMBER5:
                    counter++;
		    		GameLevel.setCellType(x, y, CellType.NUMBER6);
                    break;
                case NUMBER6:
                    counter++;
		    		GameLevel.setCellType(x, y, CellType.NUMBER7);
                    break;
                case NUMBER7:
                    counter++;
		    		GameLevel.setCellType(x, y, CellType.NUMBER8);
                    break;
                case NUMBER8:
                    counter++;
		    		GameLevel.setCellType(x, y, CellType.NUMBER9);
                    break;
                case NUMBER9:
                    //Checking if we can still display a larger number
                    //If we can't, do nothing and leave the repetition of 9
                    boolean canIncrease = true;
                    for(int i = 1; i <= x && GameLevel.getCellType(x - i, y) == CellType.NUMBER9; i++)
                    {
                        if (x == i)
                            canIncrease = false;
                    }

                    if(canIncrease == true){
                        //No counter++ because it will be done while calling increaseMoveNumber(x - 1, y)
                        GameLevel.setCellType(x, y, CellType.NUMBER0);
                        increaseMoveNumber(x - 1, y);
                    }
                    break;
		    	default:
                    throw new MoveNotAllowedException("Error dans le compteur");
		    }
            return true;
        }

        else {
            return false;
        }
	}
}