package tictactoe;

public class GameController {
    private TicTacToeGUI view;
    private GameLogic gameLogic;

    public GameController(TicTacToeGUI view, GameLogic gameLogic) {
        this.view = view;
        this.gameLogic = gameLogic;
    }

    public void onCellClicked(int row, int col) {
        try {
            if (gameLogic.makeMove(row, col)) {
                // Update the board view
                view.updateBoard(gameLogic.getBoard());

                // Check if the current player won
                if (gameLogic.checkWin()) {
                    view.showWinner(gameLogic.getCurrentPlayer());
                } else if (gameLogic.isDraw()) {
                    view.showDraw();
                } else {
                    // Switch player and update the turn message
                    gameLogic.switchPlayer();
                    String currentPlayerName = gameLogic.getCurrentPlayer().getName(); // Get current player name
                    view.showMessage(currentPlayerName + "'s Turn"); // Display message with player name
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid move");
        }
    }

    public void onResetClicked() {
        try {
            gameLogic.resetGame(); // Reset the game
            view.clearBoard(); // Clear the board
            
        } catch (Exception e) {
            System.out.println("Error resetting the game");
        }
    }

    public void setView(TicTacToeGUI view) {
        this.view = view;
    }
}
