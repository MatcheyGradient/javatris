package window.game.piece;

import window.Drawer;
import window.game.Board;
import window.game.piece.pieces.*;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;

import static window.game.piece.PieceManager.Piece.*;

public class PieceManager {

    public static Piece currentPiece = J_PIECE; // j :)
    public static Color currentColor;
    public static int currentPacketPiece = 0;

    public static Piece[] packet = {O_PIECE, T_PIECE, S_PIECE, Z_PIECE, I_PIECE, L_PIECE, J_PIECE}; // will be scrambled

    public static void moveDown(){
        if(currentPiece.equals(O_PIECE)){
            OPiece.moveDown();
        } else if(currentPiece.equals(T_PIECE)){
            TPiece.moveDown();
        } else if(currentPiece.equals(S_PIECE)){
            SPiece.moveDown();
        } else if(currentPiece.equals(Z_PIECE)){
            ZPiece.moveDown();
        } else if(currentPiece.equals(I_PIECE)){
            IPiece.moveDown();
        } else if(currentPiece.equals(L_PIECE)){
            LPiece.moveDown();
        } else if(currentPiece.equals(J_PIECE)) {
            JPiece.moveDown();
        }
    }

    public static void moveLeft(){
        if(currentPiece.equals(O_PIECE)){
            OPiece.moveLeft();
        } else if(currentPiece.equals(T_PIECE)){
            TPiece.moveLeft();
        } else if(currentPiece.equals(S_PIECE)){
            SPiece.moveLeft();
        } else if(currentPiece.equals(Z_PIECE)){
            ZPiece.moveLeft();
        } else if(currentPiece.equals(I_PIECE)){
            IPiece.moveLeft();
        } else if(currentPiece.equals(L_PIECE)){
            LPiece.moveLeft();
        } else if(currentPiece.equals(J_PIECE)) {
            JPiece.moveLeft();
        }
    }

    public static void moveRight(){
        if(currentPiece.equals(O_PIECE)){
            OPiece.moveRight();
        } else if(currentPiece.equals(T_PIECE)){
            TPiece.moveRight();
        } else if(currentPiece.equals(S_PIECE)){
            SPiece.moveRight();
        } else if(currentPiece.equals(Z_PIECE)){
            ZPiece.moveRight();
        } else if(currentPiece.equals(I_PIECE)){
            IPiece.moveRight();
        } else if(currentPiece.equals(L_PIECE)){
            LPiece.moveRight();
        } else if(currentPiece.equals(J_PIECE)) {
            JPiece.moveRight();
        }
    }

    public static void renderPiece() {
        if(currentPiece.equals(O_PIECE)){
            OPiece.renderOPiece();
        } else if (currentPiece.equals(T_PIECE)){
            TPiece.renderTPiece();
        } else if (currentPiece.equals(S_PIECE)){
            SPiece.renderSPiece();
        } else if(currentPiece.equals(Z_PIECE)){
            ZPiece.renderZPiece();
        } else if(currentPiece.equals(I_PIECE)){
            IPiece.renderIPiece();
        } else if(currentPiece.equals(L_PIECE)){
            LPiece.renderLPiece();
        } else if(currentPiece.equals(J_PIECE)) {
            JPiece.renderJPiece();
        }
    }

    public static void rotateClockwise() {
        if (currentPiece.equals(T_PIECE)){
            TPiece.rotateClockwise();
        } else if (currentPiece.equals(S_PIECE)){
            SPiece.rotateClockwise();
        } else if(currentPiece.equals(Z_PIECE)){
            ZPiece.rotateClockwise();
        } else if(currentPiece.equals(I_PIECE)){
            IPiece.rotateClockwise();
        } else if(currentPiece.equals(L_PIECE)){
            LPiece.rotateClockwise();
        } else if(currentPiece.equals(J_PIECE)) {
            JPiece.rotateClockwise();
        }
    }

    public static void lineCheck() {
        Board.checkForLine();
    }

    public static void resetPieceState() {
        OPiece.resetBlocks();
        TPiece.resetBlocks();
        SPiece.resetBlocks();
        ZPiece.resetBlocks();
        IPiece.resetBlocks();
        JPiece.resetBlocks();
        LPiece.resetBlocks();
    }


    public static void updateCurrentColor() { // for moving piece
        if(currentPiece.equals(O_PIECE)){
            currentColor = Color.yellow;
        } else if (currentPiece.equals(T_PIECE)){
            currentColor = new Color(175, 41, 138);
        } else if(currentPiece.equals(S_PIECE)){
            currentColor = new Color(89, 177, 1);
        } else if(currentPiece.equals(Z_PIECE)){
            currentColor = new Color(215, 15, 55);
        } else if(currentPiece.equals(I_PIECE)){
            currentColor = new Color(15, 155, 215);
        } else if(currentPiece.equals(L_PIECE)){
            currentColor = new Color(227, 91, 2);
        } else if(currentPiece.equals(J_PIECE)){
            currentColor = new Color(33, 65, 198);
        }
    }

    public static void nextPiece() {

        Drawer.fastDown = false; // stops my budget "hard-drop" system

        if(currentPacketPiece == 0){
            currentPiece = packet[0];
            currentPacketPiece += 1;
        } else if(currentPacketPiece == 1){
            currentPiece = packet[1];
            currentPacketPiece += 1;
        } else if(currentPacketPiece == 2){
            currentPiece = packet[2];
            currentPacketPiece += 1;
        } else if(currentPacketPiece == 3){
            currentPiece = packet[3];
            currentPacketPiece += 1;
        } else if(currentPacketPiece == 4){
            currentPiece = packet[4];
            currentPacketPiece += 1;
        } else if(currentPacketPiece == 5){
            currentPiece = packet[5];
            currentPacketPiece += 1;
        } else if(currentPacketPiece == 6){ // resets and shuffles the packet
            currentPiece = packet[6];
            currentPacketPiece += 1;
            Collections.shuffle(Arrays.asList(packet));
            currentPacketPiece = 0;
        }
    }

    public enum Piece {
        O_PIECE,
        T_PIECE,
        S_PIECE,
        Z_PIECE,
        I_PIECE,
        L_PIECE,
        J_PIECE
    }
}
