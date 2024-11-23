/**
 * logic class for managing the game board state
  */

public class GameBoard {
    static char[][] board; // 2D array to represent the board state
    static char currentPlayer; // current player's variable for ('X' or 'O')

    // constructor for GameBoard
    public GameBoard() {
        board = new char[3][3]; // create a 3x3 board
        currentPlayer = 'X'; // X starts the game
        resetBoard(); // initialize the board
    }

    // method to reset the board to its initial state
    public void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' '; // set each cell to empty
            }
        }
    }

    // method to check if a move is valid or not
    public boolean isValidMove(int row, int col) {
        return board[row][col] == ' '; // valid if cell is empty
    }

    // method to make a move on the board
    public void makeMove(int row, int col) {
        board[row][col] = currentPlayer; // set the current player's symbol in the cell
    }

    // method to get the current player
    public char getCurrentPlayer() {
        return currentPlayer;
    }

    // method to switch to the other player
    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; // toggle between 'X' and 'O'
    }

    // method to check if the current player has won or not
    public boolean checkForWinner() {
        // check rows and columns for a win
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                    (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true; // Row or column win
            }
        }

        // check diagonals for a win
        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
            return true; // Diagonal win
        }

        return false; // no win detected
    }

    // method to check is the board is full or not or draw
    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false; // empty cell found, board is not full
                }
            }
        }
        return true; // no empty cells, board is full
    }
}

