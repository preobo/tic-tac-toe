package tictactoe;

public class GameLogic {
	private Player currentPlayer;
	private Player player1;
	private Player player2;
	private GameBoard board;
	
	public GameLogic(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		this.board = new GameBoard();
		
}
	
	public void startGame() {
		board.resetBoard();
		currentPlayer = player1;
	}
	
	public boolean makeMove(int row, int col) {
		if (board.isCellEmpty(row,  col) ) {
			board.placeMove(row,  col,  currentPlayer.getSymbol());
			return true;
		}
		return false;
	}
	
	public boolean checkWin() {
		return board.checkWin(currentPlayer.getSymbol());
	}
	
	public boolean isDraw() {
		return board.isDraw();
	}
	
	public void switchPlayer() {
		if (currentPlayer == player1) {
			currentPlayer = player2;
		} else {
			currentPlayer = player1;
		}
		
	}
	
	public void resetGame() {
		board.resetBoard();
		currentPlayer = player1;
	}
	
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	public char[][] getBoard() {
		return board.getBoard();
	}

}