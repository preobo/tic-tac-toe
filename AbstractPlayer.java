package tictactoe;

public abstract class AbstractPlayer implements Player{

	protected String name;
	protected char symbol;
	
	public AbstractPlayer(String name, char symbol) {
		this.name = name;
		this.symbol = symbol;
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public char getSymbol() {
		return symbol;
	}
	public abstract int[] makeMove(char[][] board);
}

