package window;

import window.game.Board;
import window.game.Update;
import window.game.input.KeyListener;
import window.game.input.mouse.MouseHelper;
import window.game.input.mouse.MouseTracker;
import window.game.menus.HelpMenu;
import window.game.menus.MainMenu;
import window.game.menus.MiscRenders;
import window.game.piece.PieceManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.black;
import static window.Drawer.Mode.*;

public class Drawer extends JPanel implements ActionListener {


    public static int downDelay = 200;
    int delay = 1;

    public static boolean fastDown = false;

    public final static int width = 650;
    public final static int height = 620;
    public static boolean gameOn = false;
    public static Timer timer, timer2;

    public static Mode mode = Mode.MAINMENU;

    MainMenu mainmenu;
    HelpMenu helpmenu;
    MiscRenders misc;
    Board board;

    public Drawer(){
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(black);
        this.setFocusable(true);
        this.addKeyListener(new KeyListener());
        this.addMouseListener(new MouseHelper());
        this.addMouseMotionListener(new MouseTracker());
        mainmenu = new MainMenu();
        helpmenu = new HelpMenu();
        timer = new Timer(delay, this);
        timer2 = new Timer(downDelay, new Update.MoveUpdate());
        startGame();
        board = new Board();
        misc = new MiscRenders();
    }

    public void startGame() {
        gameOn = false;
        timer.start();
        timer2.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        draw(g);
    }

    public void draw(Graphics g){
        misc.render(g);
        board.render(g);
        if(mode == MAINMENU){
            mainmenu.render(g);
        } else if(mode == HELP){
            helpmenu.render(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(gameOn){
            if(mode == GAME){
                if(fastDown){
                    PieceManager.moveDown();
                }

                Board.updateCurrentPiece();
                PieceManager.updateCurrentColor();
                PieceManager.renderPiece();
            }
        }
        repaint();
    }

    public enum Mode{
        GAME,
        MAINMENU,
        HELP
    }
}