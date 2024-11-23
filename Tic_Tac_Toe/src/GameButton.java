import javax.swing.*;

/**
 * custom JButton class to represent game board cells
  */

public class GameButton extends JButton {
    private int row, col; // row and column of the button on the board

    // constructor for GameButton
    public GameButton(int row, int col) {
        this.row = row;
        this.col = col;
    }

    // getter for row
    public int getRow() {
        return row;
    }

    // getter for column
    public int getCol() {
        return col;
    }
}