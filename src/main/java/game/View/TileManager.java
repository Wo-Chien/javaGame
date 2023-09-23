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
        g.setFont(new Font("Microsoft YaHei", Font.BOLD, 30));
        g.drawString(String.valueOf(time), 480, 60);
//        g.drawRect(20, 20, 100, 100);
    }
}
