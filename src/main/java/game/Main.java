package game;

import game.View.GameMenu;
import game.View.GameWindow;

import javax.swing.*;

/**
 * create a new instance of game menu that lets you choose between lvls and adjust setting and so on
 */
public class Main {
    public static void main(String[] args) {
//        new GameMenu();
        new GameWindow();

//            String[] options = new String[] {"Yes", "No", "Maybe", "Cancel"};
//            int response = JOptionPane.showOptionDialog(null, "Message", "Title",
//                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
//                    null, options, options[1]);
//
//        System.out.println(response);

        // Where response == 0 for Yes, 1 for No, 2 for Maybe and -1 or 3 for Escape/Cancel.


//        int response = JOptionPane.showConfirmDialog(null, "PJV is great ! Isn’t it?");
//        switch (response) {
//            case 0:
//                JOptionPane.showMessageDialog(null, "You are right!",
//                        "Confirm", JOptionPane.PLAIN_MESSAGE);
//                break;
//            case 1:
//                JOptionPane.showMessageDialog(null, "You are wrong!",
//                        "Error", JOptionPane.ERROR_MESSAGE);
//                break;
////            case 2:
////                JOptionPane.showMessageDialog(null, "You should know!",
////                        "Warn", JOptionPane.WARNING_MESSAGE);
////                break;
//            case 2:
//                JOptionPane.showMessageDialog(null, "cus info",
//                        "Info", JOptionPane.INFORMATION_MESSAGE);
//                break;
//        }

    }
}