package be.uliege.boigelot.oop.sokoban.main.gui;

import be.uliege.boigelot.oop.sokoban.gui.*;

import be.uliege.boigelot.oop.sokoban.main.cells.CellType;
//import be.uliege.boigelot.oop.sokoban.main.cells.Coordinate;

public class ProjectSokobanGUI extends SokobanGUI {

    private final int black = super.loadImage("tiles/black.png");
    private final int crate = super.loadImage("tiles/crate.png");
    private final int crate2 = super.loadImage("tiles/crate2.png");
    private final int empty = super.loadImage("tiles/empty.png");
    private final int playerDown = super.loadImage("tiles/playerDown.png");
    private final int playerUp = super.loadImage("tiles/playerUp.png");
    private final int playerLeft = super.loadImage("tiles/playerLeft.png");
    private final int playerRight = super.loadImage("tiles/playerRight.png");
	private final int target = super.loadImage("tiles/target.png");
	private final int wall = super.loadImage("tiles/wall.png");
    //lava
    private final int magma  = super.loadImage("tiles/magma.png");
    private final int lava = super.loadImage("tiles/lava.png");
    private final int playerOnLavaDown = super.loadImage("tiles/playerOnLavaDown.png");
    private final int playerOnLavaUp = super.loadImage("tiles/playerOnLavaUp.png");
    private final int playerOnLavaLeft = super.loadImage("tiles/playerOnLavaLeft.png");
    private final int playerOnLavaRight = super.loadImage("tiles/playerOnLavaRight.png");
    private final int playerInMagmaDown = super.loadImage("tiles/playerInMagmaDown.png");
    private final int playerInMagmaUp = super.loadImage("tiles/playerInMagmaUp.png");
    private final int playerInMagmaLeft = super.loadImage("tiles/playerInMagmaLeft.png");
    private final int playerInMagmaRight = super.loadImage("tiles/playerInMagmaRight.png");
    //counter of moves
    private final int number0 = super.loadImage("tiles/0.png");
    private final int number1 = super.loadImage("tiles/1.png");
    private final int number2 = super.loadImage("tiles/2.png");
    private final int number3 = super.loadImage("tiles/3.png");
    private final int number4 = super.loadImage("tiles/4.png");
    private final int number5 = super.loadImage("tiles/5.png");
    private final int number6 = super.loadImage("tiles/6.png");
    private final int number7 = super.loadImage("tiles/7.png");
    private final int number8 = super.loadImage("tiles/8.png");
    private final int number9 = super.loadImage("tiles/9.png");
        
    //public ProjectSokobanGUI(int width, int height, String path) throws SokobanError {
    public ProjectSokobanGUI(int width, int height) throws SokobanError {
        super(width, height);
        
        //faut trouver un moyen de les load que la premiere fois, faire un static initializaion ne marche pas
        //-> je les défini directement
        /*black = super.loadImage(path + "/black.png");
        crate = super.loadImage(path + "/crate.png");
		crate2 = super.loadImage(path + "/crate2.png");
        empty = super.loadImage(path + "/empty.png");
        playerDown = super.loadImage(path + "/playerDown.png");
        playerUp = super.loadImage(path + "/playerUp.png");
        playerLeft = super.loadImage(path + "/playerLeft.png");
        playerRight = super.loadImage(path + "/playerRight.png");
        target = super.loadImage(path + "/target.png");
		wall = super.loadImage(path + "/wall.png");

        //lava
        magma = super.loadImage(path + "/magma.png");
        lava = super.loadImage(path + "/lava.png");
        playerOnLavaDown = super.loadImage(path + "/playerOnLavaDown.png");
        playerOnLavaUp = super.loadImage(path + "/playerOnLavaUp.png");
        playerOnLavaLeft = super.loadImage(path + "/playerOnLavaLeft.png");
        playerOnLavaRight = super.loadImage(path + "/playerOnLavaRight.png");
        playerInMagmaDown = super.loadImage(path + "/playerInMagmaDown.png");
        playerInMagmaUp = super.loadImage(path + "/playerInMagmaUp.png");
        playerInMagmaLeft = super.loadImage(path + "/playerInMagmaLeft.png");
        playerInMagmaRight = super.loadImage(path + "/playerInMagmaRight.png");

        //counter of moves
        number0 = super.loadImage(path + "/0.png");
        number1 = super.loadImage(path + "/1.png");
        number2 = super.loadImage(path + "/2.png");
        number3 = super.loadImage(path + "/3.png");
        number4 = super.loadImage(path + "/4.png");
        number5 = super.loadImage(path + "/5.png");
        number6 = super.loadImage(path + "/6.png");
        number7 = super.loadImage(path + "/7.png");
        number8 = super.loadImage(path + "/8.png");
        number9 = super.loadImage(path + "/9.png");
        */
    }

    private int cellTypeId(CellType type) {
        switch (type){
            default:
                return black;
            case CRATE:
                return crate;
            case CRATE2:
                return crate2;
			case EMPTY :
				return empty;
            case PLAYERONTARGETDOWN:
                //no break because also needs to return playerdown
            case PLAYERDOWN:
                return playerDown;
            case PLAYERONTARGETUP:
                //no break because also needs to return playerup
            case PLAYERUP:
                return playerUp;
            case PLAYERONTARGETLEFT:
                //no break because also needs to return playerleft
            case PLAYERLEFT:
                return playerLeft;
            case PLAYERONTARGETRIGHT:
                //no break because also needs to return playerright
            case PLAYERRIGHT:
                return playerRight;
			case TARGET:
                return target;
			case WALL:
                return wall;
            
            //lava
            case MAGMA:
                return magma;
			case LAVA:
                return lava;
            case PLAYERONLAVADOWN:
                return playerOnLavaDown;
            case PLAYERONLAVAUP:
                return playerOnLavaUp;
            case PLAYERONLAVALEFT:
                return playerOnLavaLeft;
            case PLAYERONLAVARIGHT:
                return playerOnLavaRight;
            case PLAYERINMAGMADOWN:
                return playerInMagmaDown;
            case PLAYERINMAGMAUP:
                return playerInMagmaUp;
            case PLAYERINMAGMALEFT:
                return playerInMagmaLeft;
            case PLAYERINMAGMARIGHT:
                return playerInMagmaRight;

            //counter of moves
            case NUMBER0:
                return number0;
            case NUMBER1:
                return number1;
            case NUMBER2:
                return number2;
            case NUMBER3:
                return number3;
            case NUMBER4:
                return number4;
            case NUMBER5:
                return number5;
            case NUMBER6:
                return number6;
            case NUMBER7:
                return number7;
            case NUMBER8:
                return number8;
            case NUMBER9:
                return number9;
        }
    }

    public void setCell(int x, int y, CellType type) throws SokobanError {
        super.setCell(x, y, cellTypeId(type));
    }
}
