package game.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * loads settings from json file, after settings change, saves them into corresponding player's file
 */
public class GameMenu extends JPanel {
    public GameMenu(){

        JFrame menuWindow = new JFrame("Tetris menu");
//        try {
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
//        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException |
//                 IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }
        menuWindow.setSize(new Dimension(500, 600));
//        menuWindow.setLayout(new BorderLayout());
        menuWindow.setLayout(new FlowLayout());
        menuWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton startGame = new JButton("start a new game");
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameWindow();
                menuWindow.dispose();
            }
        });
        menuWindow.add(startGame);

        JButton settings = new JButton("settings");
        menuWindow.add(settings);

        menuWindow.setLocationRelativeTo(null);
        menuWindow.getContentPane().setBackground(Color.gray);
        menuWindow.setVisible(true);
    }
}
