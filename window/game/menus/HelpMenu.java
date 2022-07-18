package window.game.menus;

import java.awt.*;

import static java.awt.Color.white;

public class HelpMenu {
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(white);
        g.setFont(new Font("no", Font.BOLD, 40));
        g.drawString("Controls", 15, 50);
        g.drawString("Changelog", 15, 340);
        g.drawLine(0, 70, 650, 70);
        g.drawLine(0, 360, 650, 360);
        g.drawLine(0, 290, 650, 290);

        g.setFont(new Font("no", Font.BOLD, 30));

        g.drawString("Left: Left Arrow", 15, 110);
        g.drawString("Right: Right Arrow", 15, 150);
        g.drawString("Hard Drop: Down Arrow", 15, 190);
        g.drawString("Clockwise Rotation: X", 15, 230);
        g.drawString("Back To Menu: Escape", 15, 270);

        g.drawString("Base game", 15, 400);
        g.drawString("Piece Packet System", 15, 440);
    }
}
