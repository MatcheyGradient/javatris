package window.game.menus;

import java.awt.*;

public class MainMenu {
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g.setFont(new Font("no", Font.BOLD, 60));

        g.setColor(new Color(15, 155, 215));
        g.drawString("j", 237, 130);
        g.setColor(new Color(175, 41, 138));
        g.drawString("a", 253, 130);
        g.setColor(new Color(89, 177, 1));
        g.drawString("v", 286, 130);
        g.setColor(new Color(215, 15, 55));
        g.drawString("t", 319, 130);
        g.setColor(Color.yellow);
        g.drawString("r", 339, 130);
        g.setColor(new Color(227, 91, 2));
        g.drawString("i", 362, 130);
        g.setColor(new Color(33, 65, 198));
        g.drawString("s", 379, 130);

        g.setColor(Color.WHITE);
        g.setFont(new Font("no", Font.BOLD, 30));
        g.drawRect(265, 200, 120, 50);
        g.drawString("Play", 293, 235);

        g.drawRect(265, 265, 120, 50);
        g.drawString("Help", 293, 300);

        g.setColor(Color.darkGray);
        g.setFont(new Font("maybe", Font.PLAIN, 20));
        g.drawString("Version 1", 10, 607);
    }
}
