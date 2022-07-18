package window.game.input.mouse;

import window.Drawer;
import window.game.Board;
import window.game.piece.PieceManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Collections;

public class MouseHelper implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if(!Drawer.gameOn) {
            if(x > 265 && x < 385 && y > 200 && y < 250){
                System.out.println(Arrays.toString(PieceManager.packet));
                PieceManager.nextPiece();
                Board.clearBoard();
                Drawer.mode = Drawer.Mode.GAME;
                Drawer.gameOn = true;
            } else if(x > 265 && x < 385 && y > 265 && y < 315){
                Drawer.mode = Drawer.Mode.HELP;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
