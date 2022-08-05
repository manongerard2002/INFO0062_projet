package be.uliege.boigelot.oop.sokoban.main.gui;

public class MoveNotAllowedException extends Exception {
    public MoveNotAllowedException(){
        super();
    }

    public MoveNotAllowedException(String msg){
        super(msg);
    }
}