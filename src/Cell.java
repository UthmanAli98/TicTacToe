
public class Cell {

	PieceType piece;
	int row, col;
	
	public Cell(int row, int col) {
		this.row = row;
		this.col = col;
		clear();
	}
	
	
	public void clear() {
		piece = PieceType.EMPTY;
	}
	
	public void printCell() {
		switch(piece) {
		case CROSS: System.out.print(" X ");break;
		case EMPTY: System.out.print("   ");break;
		case CIRCLE:System.out.print(" O ");break;
		}
	}
}
