package game.View;

import java.awt.*;

public class TileManager {

    Graphics2D g2;
    GameWindow gW;
    public TileManager(GameWindow gW){
        this.gW = gW;
    }
    public void paintClockElement(Graphics g, int time){
        g.setColor(Color.white);
        g.drawString(String.valueOf(time), 200, 200);
    }
}
