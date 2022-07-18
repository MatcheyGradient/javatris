import window.MainWindow;
import window.game.piece.PieceManager;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Collections.shuffle(Arrays.asList(PieceManager.packet));
        PieceManager.resetPieceState();


        new MainWindow();
    }
}
