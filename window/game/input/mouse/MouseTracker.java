package window.game.input.mouse;

import window.game.input.button.ButtonHighlight;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseTracker implements MouseMotionListener {
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        ButtonHighlight.highlightTrack(e.getX(), e.getY());
    }
}
