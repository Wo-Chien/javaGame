package game.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * the actual game window
 * initiated via GameMenu instance
 */
public class GameWindow {
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
    }
}
