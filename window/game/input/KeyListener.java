package window.game.input;

import window.Drawer;
import window.game.Board;
import window.game.piece.PieceManager;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Collections;

public class KeyListener extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent event) {
        switch(event.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                if(Drawer.gameOn){
                    PieceManager.moveLeft();
                }
                break;

            case KeyEvent.VK_RIGHT:
                if(Drawer.gameOn){
                    PieceManager.moveRight();
                }
                break;

            case KeyEvent.VK_X:
                if(Drawer.gameOn){
                    PieceManager.rotateClockwise();
                }
                break;

            case KeyEvent.VK_ESCAPE:
                Drawer.gameOn = false;
                Drawer.mode = Drawer.Mode.MAINMENU;
                Board.lines = 0;
                PieceManager.resetPieceState();
                Collections.shuffle(Arrays.asList(PieceManager.packet));
                break;

            case KeyEvent.VK_M:
                Board.clearBoard();
                Board.lines = 0;
                PieceManager.resetPieceState();
                Collections.shuffle(Arrays.asList(PieceManager.packet));
                PieceManager.currentPacketPiece = 0;
                PieceManager.nextPiece();
                break;

            case KeyEvent.VK_DOWN:
                Drawer.fastDown = true;
                break;

        }
    }
}
