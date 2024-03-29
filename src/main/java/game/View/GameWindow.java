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
    ClockELement gameClock;
    TileManager tM = new TileManager(this);
    JToggleButton btTogglePause, loggingBt; JTextField HP_text; JToggleButton displayInventory;

    public final int cols = 20;
    public final int rows = 15;
    int originalTileSize = 16;
    int scale = 3;
    public final int finalTileSize = originalTileSize * scale;
    int screenWidth = cols * finalTileSize;
    int screenHeight = rows * finalTileSize;

    public GameWindow(){
//        gameWindow.setSize(new Dimension(1000, 600));
////        gameWindow.setLayout(new BorderLayout());
//        gameWindow.setLayout(new FlowLayout());
//        gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//
//        gameWindow.setLocationRelativeTo(null);
//        gameWindow.getContentPane().setBackground(Color.black);
//        gameWindow.setVisible(true);

        //set the window and panels
        JFrame gameWindow = new JFrame("Tetris");
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
//        gameWindow.setPreferredSize(new Dimension(screenWidth, screenHeight + (int)(1.5*finalTileSize)));
        gameWindow.setSize(new Dimension(1000, 600));

        gameWindow.setLayout(new BorderLayout());

        gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //panel with pause and quit buttons
        JPanel buttonPanel = new JPanel();

        JButton btQuit = new JButton("Quit");
        btQuit.setFocusable(false);
        btQuit.addActionListener(e -> System.exit(0));

        btTogglePause = new JToggleButton("Pause");
        btTogglePause.setFocusable(false);
        btTogglePause.createToolTip();

        loggingBt = new JToggleButton("logging");
        loggingBt.setFocusable(false);
        loggingBt.setSelected(true);

        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(btQuit);
        buttonPanel.add(btTogglePause);
        buttonPanel.add(loggingBt);

        // RPG JPanel / the game panel itself
        setSize(screenWidth, screenHeight);
//        setBackground(new Color(44, 9, 74));
        setBackground(Color.darkGray);
        setDoubleBuffered(true);
//        addKeyListener(keyHandler); // todo add key handler
        setFocusable(true);

        // add button panel, the canvas and pack
        gameWindow.add(buttonPanel, BorderLayout.PAGE_END);
        gameWindow.add(this, BorderLayout.CENTER);
//        gameWindow.pack();
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setVisible(true);

        startGame();
    }

    private void startGame(){
        running = true;

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        startTime = formatter.format(date);
        gameClock = new ClockELement();

        Thread gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
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

//        System.out.println("painting");

        if (gameClock != null) {
            tM.paintClockElement(g2, gameClock.currentTimeSec);
        }
        g.dispose();
        g2.dispose();
    }

    /**
     * checks if the game is paused, updates the logging argument, if game state i won or lost, stops updating snd calls displayGameState method
     * if not paused executes update method from controller, and updates the display of player HP
     */
    private void update(){ // update still runs even when paused, it just doesn't reach controller, just checks the pause button being toggled
//        System.out.println("updating");
    }
}
