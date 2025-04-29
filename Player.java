package tictactoe;

public interface Player {

	public int[] makeMove(char[][]board);
	public char getSymbol();
	public String getName();
}
