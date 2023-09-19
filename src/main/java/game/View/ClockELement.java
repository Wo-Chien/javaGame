package game.View;

import java.util.Timer;
import java.util.TimerTask;

public class ClockELement {
    public int currentTimeSec;
    public ClockELement() {
        final java.util.Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int i = 0;
            public void run() {
                System.out.println(i++);
                if (i > 20)
                    timer.cancel();
            }
        }, 0, 1000);
    }
}
