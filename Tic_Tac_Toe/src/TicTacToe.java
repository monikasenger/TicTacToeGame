import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Main TicTacToe class extending JFrame
  */

public class TicTacToe extends JFrame {
    static GameBoard gameBoard; // represents the game logic and board state
    static GameButton[][] buttons; // 2D array of buttons for the UI board

    // constructor for TicTacToe
    public TicTacToe() {
        setTitle("Tic-Tac-Toe"); // set the title of the game window
        setLayout(new GridLayout(3, 3)); // use a grid layout for the board
        gameBoard = new GameBoard(); // initialize the game board logic
        buttons = new GameButton[3][3]; // create a 3x3 button grid

        initializeBoard(); // initialize the game board UI

        setDefaultCloseOperation(EXIT_ON_CLOSE); // close app on exit
        setSize(400, 400); //set the window size
        setLocationRelativeTo(null); // center the window on the screen
        setVisible(true); // make the window visible
    }

    // method to initialize the game board buttons
    public void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new GameButton(row, col); // create a new button
                buttons[row][col].setFont(new Font("Arial", Font.PLAIN, 65)); // set font size
                buttons[row][col].setFocusPainted(false); // remove focus border
                buttons[row][col].setBackground(Color.LIGHT_GRAY); // set button background color
                buttons[row][col].addActionListener(new ButtonClickListener(row, col)); //add click listener
                add(buttons[row][col]); // add button to the frame
            }
        }
    }
    // Inner class method for handling button click events
    public static class ButtonClickListener implements ActionListener {
        int row, col; // button's position on the board

        // constructor to initialize row and column
        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        // methohd handles button click events
        @Override
        public void actionPerformed(ActionEvent e) {
            if (gameBoard.isValidMove(row, col)) { // check if the move is valid
                gameBoard.makeMove(row, col); // make the move on the game board
                buttons[row][col].setText(String.valueOf(gameBoard.getCurrentPlayer())); // update button text
                buttons[row][col].setForeground(gameBoard.getCurrentPlayer() == 'X' ? Color.BLUE : Color.RED); //set text color based on player

                // condition to check if the current move leads to a win
                if (gameBoard.checkForWinner()) {
                    GameMessage.showMessage("Player " + gameBoard.getCurrentPlayer() + " wins!", true); // Show winner message
                    gameBoard.resetBoard(); // reset the game board
                    resetButtons(); // reset the buttons
                } else if (gameBoard.isBoardFull()) { // condition to check if the board is full (draw)
                    GameMessage.showMessage("It's a draw!", false); // show draw message
                    gameBoard.resetBoard(); // reset the game board
                    resetButtons(); // reset the buttons
                } else {
                    gameBoard.switchPlayer(); // switch to the next player
                }
            }
        }

        //method to reset button states for a new game
        public static void resetButtons() {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    buttons[row][col].setText(""); // clear button text
                    buttons[row][col].setForeground(Color.BLACK); // reset text color
                }
            }
        }
    }
}
