package window.game;

import window.Drawer;
import window.game.piece.PieceManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;

public class Update {

    static Drawer d = new Drawer();

    public static class MoveUpdate implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(Drawer.gameOn && Drawer.mode == Drawer.Mode.GAME){
                if(Board.board[2][4] > 1){ // checks if board is too full (not the best but will work)
                    Board.clearBoard();
                    PieceManager.resetPieceState();
                    Collections.shuffle(Arrays.asList(PieceManager.packet));
                    PieceManager.currentPacketPiece = 0;
                    PieceManager.nextPiece();
                    System.out.println(Arrays.toString(PieceManager.packet));
                }
                PieceManager.moveDown();
            }
        }
    }
}
