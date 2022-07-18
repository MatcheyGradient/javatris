package window.game.input.button;

public class ButtonHighlight {
    public static String highlightType = "none";

    public static void highlightTrack(int x, int y){
        if(x > 265 && x < 385 && y > 200 && y < 250){
            highlightType = "play";
        } else if(x > 265 && x < 385 && y > 265 && y < 315){
            highlightType = "help";
        } else {
            highlightType = "none";
        }
    }
}
