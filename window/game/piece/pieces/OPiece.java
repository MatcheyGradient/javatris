package window.game.piece.pieces;

import window.game.Board;
import window.game.piece.PieceManager;

public class OPiece {

    static int block1x, block1y;
    static int block2x, block2y;
    static int block3x, block3y;
    static int block4x, block4y;

    public static void resetBlocks(){
        block1x = 5;
        block1y = 0;

        block2x = 4;
        block2y = 0;

        block3x = 5;
        block3y = 1;

        block4x = 4;
        block4y = 1;
    }

    public static void renderOPiece(){
        Board.board[block1y][block1x] = 1;
        Board.board[block2y][block2x] = 1;
        Board.board[block3y][block3x] = 1;
        Board.board[block4y][block4x] = 1;
    }

    public static void moveDown(){
        placeOBlock();

        if(block4y < 19){
            block1y += 1;
            block2y += 1;
            block3y += 1;
            block4y += 1;
        }
    }

    public static void moveLeft(){
        if(block1x > 1 && Board.board[block2y][block2x - 1] < 1 && Board.board[block4y][block4x - 1] < 1){
            block1x -= 1;
            block2x -= 1;
            block3x -= 1;
            block4x -= 1;
        }
    }

    public static void moveRight(){
        if(block4x < 8 && Board.board[block1y][block1x + 1] < 1 && Board.board[block3y][block3x + 1] < 1){
            block1x += 1;
            block2x += 1;
            block3x += 1;
            block4x += 1;
        }
    }

    public static void placeOBlock() {
        if(block4y == 19 || Board.board[block4y + 1][block4x] > 1 || Board.board[block3y + 1][block3x] > 1){
            Board.board[block1y][block1x] = 2;
            Board.board[block2y][block2x] = 2;
            Board.board[block3y][block3x] = 2;
            Board.board[block4y][block4x] = 2;

            resetBlocks();
            PieceManager.lineCheck();
            PieceManager.nextPiece();

        }
    }
}
