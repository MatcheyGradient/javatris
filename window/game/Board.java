package window.game;


import window.Drawer;
import window.game.piece.PieceManager;

import java.awt.*;
import java.util.Arrays;

public class Board {

    public static int lines;

    public static int[][] board = new int[20][10];

    public static void updateCurrentPiece(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 1){
                    board[i][j] = 0;
                }
            }
        }
    }

    public static void clearBoard(){
        for (int[] ints : board) {
            Arrays.fill(ints, 0);
        }
    }

    public void render(Graphics g) {
        if(Drawer.mode == Drawer.Mode.GAME){
            g.setColor(Color.white);
            g.drawRect(214, 106, 222, 442);

            g.setFont(new Font("no", Font.BOLD, 30));
            g.drawString("Lines:", 214, 95);
            g.drawString(String.valueOf(lines), 310, 96);

            g.setColor(new Color(52, 52, 52, 150));
            for(int i = 0; i < 9; i++){
                g.drawLine((i * 22) + 237, 107, (i * 22) + 237, 545);
            }

            for(int i = 0; i < 19; i++){
                g.drawLine(215, (i * 22) + 129, 434, (i * 22) + 129);
            }

            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[i].length; j++){
                    if(board[i][j] == 1){
                        g.setColor(PieceManager.currentColor);
                        g.fillRect(216 + (j * 22), 108 + (i * 22), 21, 21);
                    } else if(board[i][j] == 2){
                        g.setColor(Color.yellow);
                        g.fillRect(216 + (j * 22), 108 + (i * 22), 21, 21);
                    } else if(board[i][j] == 3){
                        g.setColor(new Color(175, 41, 138));
                        g.fillRect(216 + (j * 22), 108 + (i * 22), 21, 21);
                    } else if(board[i][j] == 4) {
                        g.setColor(new Color(89, 177, 1));
                        g.fillRect(216 + (j * 22), 108 + (i * 22), 21, 21);
                    } else if(board[i][j] == 5) {
                        g.setColor(new Color(215, 15, 55));
                        g.fillRect(216 + (j * 22), 108 + (i * 22), 21, 21);
                    } else if(board[i][j] == 6) {
                        g.setColor(new Color(15, 155, 215));
                        g.fillRect(216 + (j * 22), 108 + (i * 22), 21, 21);
                    } else if(board[i][j] == 7) {
                        g.setColor(new Color(227, 91, 2));
                        g.fillRect(216 + (j * 22), 108 + (i * 22), 21, 21);
                    } else if(board[i][j] == 8) {
                        g.setColor(new Color(33, 65, 198));
                        g.fillRect(216 + (j * 22), 108 + (i * 22), 21, 21);
                    }
                }
            }
        }
    }

    public static void checkForLine() {
        for(int i = 0; i < board.length; i++){
            if(board[i][0] > 1 && board[i][1] > 1 && board[i][2] > 1 && board[i][3] > 1 && board[i][4] > 1 && board[i][5] > 1 && board[i][6] > 1 && board[i][7] > 1 && board[i][8] > 1 && board[i][9] > 1){ // BROO WTFF IS THIS
                lines++;
                Arrays.fill(board[i], 0);

                for(int j = i - 1; j > 0; j--){
                    System.arraycopy(board[j], 0, board[j + 1], 0, 10);
                }
            }
        }
    }
}
