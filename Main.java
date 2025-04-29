package tictactoe;


public class Main {
    public static void main(String[] args) {
        // Create two human players
        HumanPlayer player1 = new HumanPlayer("Player 1", 'X');
        HumanPlayer player2 = new HumanPlayer("Player 2", 'O');

        // Create the game logic with both players
        GameLogic gameLogic = new GameLogic(player1, player2);

        // Create the GUI (View), but initially pass null for controller
        TicTacToeGUI view = new TicTacToeGUI(null);

        // Create the controller and connect everything
        GameController controller = new GameController(view, gameLogic);

        // Now that controller is ready, link the GUI to the controller
        view.setController(controller);

        // (Optional) Start the game if needed (reset, update screen, etc.)
        gameLogic.startGame();
        
        view.updateBoard(gameLogic.getBoard());

    }
}
