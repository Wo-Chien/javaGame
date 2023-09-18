package game.View;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * the actual game window
 * initiated via GameMenu instance
 */
public class GameWindow extends JPanel implements Runnable {
    String startTime;
    int FPS = 60;
    boolean running;
    public GameWindow(){
        JFrame gameWindow = new JFrame("Tetris");
//        try {
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
//        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException |
//                 IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }
        gameWindow.setSize(new Dimension(1000, 600));
//        gameWindow.setLayout(new BorderLayout());
        gameWindow.setLayout(new FlowLayout());
        gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        gameWindow.setLocationRelativeTo(null);
        gameWindow.getContentPane().setBackground(Color.black);
        gameWindow.setVisible(true);

        running = true;
        startGame();
    }

    private void startGame(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        startTime = formatter.format(date);
        Thread gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        System.out.println("hello, started the game at: " + startTime);

        final java.util.Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int i = 5;
            public void run() {
                System.out.println(i--);
                if (i< 0)
                    timer.cancel();
            }
        }, 0, 1000);

        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        // main loop
        while (running){

            update();
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if (remainingTime < 0){
                    remainingTime = 0;
                }

                Thread.sleep((long)remainingTime);

                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        //todo

        /*
        idea je asi nakreslit postupne alespon 3 layers
         */

        g.dispose();
        g2.dispose();
    }

    private void update(){
        // todo
    }
}
