package game.View;

//import rpg.Controller.PlaneController;
//import rpg.Models.Grid;
//import rpg.Models.Plane;
import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.logging.Logger;


public class RPG extends JPanel implements Runnable {
    //window settings
    public final int cols = 20;
    public final int rows = 15;
    int originalTileSize = 16;
    int scale = 3;
    public final int finalTileSize = originalTileSize * scale;
    int screenWidth = cols * finalTileSize;
    int screenHeight = rows * finalTileSize;
    int FPS = 60;
    // other variables
    long time_begin;
    boolean running, paused;
    public boolean logging = true;
    int paused_checker = 0;

    // swing elements
    JToggleButton btTogglePause, loggingBt; JTextField HP_text; JToggleButton displayInventory;

    // other classes
//    KeyHandler keyHandler = new KeyHandler();
//    Plane plane = new Plane(this);
//    PlaneController controller = new PlaneController(keyHandler, plane);
//    TileManager tileManager = new TileManager(this);
    private static final Logger rpg_logger = Logger.getLogger(RPG.class.getName());

    public RPG(){
        // time
        if (logging) {
            rpg_logger.info("game start at " + new Date());
        }
        //set the window and panels
        JFrame gameWindow = new JFrame("Game");
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        gameWindow.setPreferredSize(new Dimension(screenWidth, screenHeight + (int)(1.5*finalTileSize)));
        gameWindow.setLayout(new BorderLayout());
        gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //panel with pause and quit buttons
        JPanel buttonPanel = new JPanel();
        JButton bt = new JButton("Quit");
        bt.setFocusable(false);
        bt.addActionListener(e -> System.exit(0));
        btTogglePause = new JToggleButton("Pause");
        btTogglePause.setFocusable(false);
        btTogglePause.createToolTip();

//        HP_text = new JTextField(String.valueOf(plane.getPlayer().getHP()));
//        HP_text.setPreferredSize(new Dimension(35, 30));
//        HP_text.setEditable(false);

        JLabel hp_label = new JLabel("Health points");
        hp_label.setLabelFor(HP_text);

        displayInventory = new JToggleButton("display inventory");
        displayInventory.setFocusable(false);
        displayInventory.setSelected(true);

        loggingBt = new JToggleButton("logging");
        loggingBt.setFocusable(false);
        loggingBt.setSelected(true);

        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(bt);
        buttonPanel.add(btTogglePause);
//        buttonPanel.add(HP_text);
        buttonPanel.add(hp_label);
        buttonPanel.add(displayInventory);
        buttonPanel.add(loggingBt);

        // RPG JPanel / the game panel itself
        setSize(screenWidth, screenHeight);
        setBackground(Color.black);
        setDoubleBuffered(true);
//        addKeyListener(keyHandler);
        setFocusable(true);

        // add button panel, the canvas and pack
        gameWindow.add(buttonPanel, BorderLayout.PAGE_END);
        gameWindow.add(this, BorderLayout.CENTER);
        gameWindow.pack();
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setVisible(true);

        start_the_game();
    }

    /**
     * notes the current time, retrieves laoded grid from plane starts a new thread, that runs the main update clock (updates everything except enemies)
     */
    public void start_the_game(){
        running = true;
        time_begin = System.currentTimeMillis();

        Thread t = new Thread(this);
        t.start();

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

    /**
     * override of a JComponent method, is called with repaint()
     * calls draw methods from TileManager
     * @param g the <code>Graphics</code> object to protect
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        System.out.println("painting");

        g.dispose();
        g2.dispose();
    }

    /**
     * checks if the game is paused, updates the logging argument, if game state i won or lost, stops updating snd calls displayGameState method
     * if not paused executes update method from controller, and updates the display of player HP
     */
    private void update(){ // update still runs even when paused, it just doesn't reach controller, just checks the pause button being toggled
        System.out.println("updating");
    }
}
