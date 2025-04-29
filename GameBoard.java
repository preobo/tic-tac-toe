package tictactoe;

public class GameBoard {
	private char[][] board;
	private int movesCount;
	
	public GameBoard() {
		board = new char[3][3];
		resetBoard();
		
		
	}
	
	public boolean isCellEmpty(int row, int col) {
	    char cell = board[row][col];
	    return cell == ' ' || cell == '\u0000';
	}

	
	
	public boolean placeMove(int row, int col, char symbol) {
		if (isCellEmpty(row, col)) {
			board[row][col] = symbol;
			movesCount++;
			return true;
		}
		
		return false;
	}
	
	public boolean checkWin(char symbol) {
		for (int i = 0; i < 3; i++) {
			if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) ||
				(board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)) {
		        return true;	
		}
		
		}
		if ((board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
		    (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
				return true;
			}
		return false;
		}
	
	
	
		public boolean isDraw() {
			return movesCount == 9;
		}
		
		public void resetBoard() {
		    for (int i = 0; i < 3; i++) {
		        for (int j = 0; j < 3; j++) {
		            board[i][j] = ' ';
		        }
		    }
		    movesCount = 0;
		}

		
		public char [][] getBoard() {
			char[][] deepCopy = new char[3][3];
			for (int i = 0; i < 3; i++) {
				System.arraycopy(board[i], 0, deepCopy[i], 0, 3);
			}
			return deepCopy;
		}
		
}
	

