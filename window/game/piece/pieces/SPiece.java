package window.game.piece.pieces;

import window.game.Board;
import window.game.piece.PieceManager;

public class SPiece {

    static int block1x, block1y;
    static int block2x, block2y;
    static int block3x, block3y;
    static int block4x, block4y;

    static int rotationState = 0;

    public static void resetAndCheck(){
        Board.board[block1y][block1x] = 4;
        Board.board[block2y][block2x] = 4;
        Board.board[block3y][block3x] = 4;
        Board.board[block4y][block4x] = 4;

        resetBlocks();
        PieceManager.lineCheck();
        rotationState = 0;

        PieceManager.nextPiece();
    }

    public static void shiftDown(){
        block1y += 1;
        block2y += 1;
        block3y += 1;
        block4y += 1;
    }

    public static void shiftLeft(){
        block1x -= 1;
        block2x -= 1;
        block3x -= 1;
        block4x -= 1;
    }

    public static void shiftRight(){
        block1x += 1;
        block2x += 1;
        block3x += 1;
        block4x += 1;
    }

    public static void resetBlocks(){
        block1x = 5;
        block1y = 0;
        block2x = 4;
        block2y = 1;
        block3x = 5;
        block3y = 1;
        block4x = 6;
        block4y = 0;
    }

    public static void rotateClockwise(){
        if(rotationState == 0){
            rotateState1();
        } else if(rotationState == 1) {
            rotateState0();
        }
    }

    public static void rotateState0(){
        if(block1x > 0 && Board.board[block1y + 1][block1x - 1] < 1 && Board.board[block1y + 1][block1x] < 1){
            block2x -= 1;
            block2y += 2;
            block3x -= 1;

            rotationState = 0;
        }
    }

    public static void rotateState1(){
        if(Board.board[block1y - 1][block1x] < 1 && Board.board[block1y + 1][block1x + 1] < 1){
            block2x += 1;
            block2y -= 2;
            block3x += 1;

            rotationState = 1;
        }
    }

    public static void renderSPiece(){
        Board.board[block1y][block1x] = 1;
        Board.board[block2y][block2x] = 1;
        Board.board[block3y][block3x] = 1;
        Board.board[block4y][block4x] = 1;
    }

    public static void moveDown(){
        placeSBlock();

        if(rotationState == 0){
            if(block3y < 19 && Board.board[block2y + 1][block2x] < 1 && Board.board[block3y + 1][block3x] < 1 && Board.board[block4y + 1][block4x] < 1){
                shiftDown();
            }
        } else if(rotationState == 1){
            if(block3y < 19 && Board.board[block3y + 1][block3x] < 1 && Board.board[block1y + 1][block1x] < 1){
                shiftDown();
            }
        }
    }

    public static void moveLeft(){
        if(rotationState == 0){
            if(block2x > 0 && Board.board[block2y][block2x - 1] < 1 && Board.board[block1y][block1x - 1] < 1){
                shiftLeft();
            }
        } else if (rotationState == 1){
            if(block1x > 0 && Board.board[block1y][block1x - 1] < 1 && Board.board[block3y][block3x - 1] < 1 && Board.board[block2y][block2x - 1] < 1){
                shiftLeft();
            }
        }
    }

    public static void moveRight(){
        if(rotationState == 0){
            if(block4x < 9 && Board.board[block3y][block3x + 1] < 1 && Board.board[block4y][block4x + 1] < 1){
                shiftRight();
            }
        } else if(rotationState == 1){
            if(block4x < 9 && Board.board[block4y][block4x + 1] < 1 && Board.board[block2y][block2x + 1] < 1 && Board.board[block3y][block3x + 1] < 1){
                shiftRight();
            }
        }
    }

    public static void placeSBlock() {
        if(rotationState == 0){
            if (block2y == 19 || Board.board[block2y + 1][block2x] > 1 || Board.board[block3y + 1][block3x] > 1 || Board.board[block4y + 1][block4x] > 1) {
                resetAndCheck();
            }
        } else if (rotationState == 1){
            if (block3y == 19 || Board.board[block1y + 1][block1x] > 1 || Board.board[block3y + 1][block3x] > 1) {
                resetAndCheck();
            }
        }
    }
}
