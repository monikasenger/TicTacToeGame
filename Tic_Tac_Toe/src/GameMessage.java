import javax.swing.*;
import java.awt.*;

/**
 * utility class to display messages to the user
  */

public class GameMessage {

    // display a message at the end of the game
    public static void showMessage(String message, boolean isWin) {
        JLabel label = new JLabel(message, JLabel.CENTER); // set the  message center-aligned
        label.setFont(new Font("Arial", Font.BOLD, 20)); // set font size and style
        label.setOpaque(true); // allow background color changes
        label.setBackground(isWin ? Color.BLUE : Color.PINK); // blue for win, pink for draw
        label.setForeground(isWin ? Color.CYAN : Color.RED); // cyan for win, red for draw

        // display a custom option pane with the message
        JOptionPane.showMessageDialog(null, label, "Game Over", JOptionPane.PLAIN_MESSAGE);
    }
}