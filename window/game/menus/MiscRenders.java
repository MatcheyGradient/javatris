package window.game.menus;

import window.Drawer;
import window.game.input.button.ButtonHighlight;

import java.awt.*;

public class MiscRenders {
    public void render(Graphics g){
        if(Drawer.mode == Drawer.Mode.MAINMENU){
            g.setColor(new Color(255, 255, 255, 70));
            if(ButtonHighlight.highlightType.equals("play")){
                g.fillRect(265, 200, 120, 50);
            } else if(ButtonHighlight.highlightType.equals("help")){
                g.fillRect(265, 265, 120, 50);
            }
        }
    }
}
