
public class Board {

	public static final int ROWS = 3;
	public static final int COLS = 3;
	
	Cell[][] cells;
	int currentRow, currentCol;
	
	public Board() {
		cells = new Cell[ROWS][COLS];
		
		for(int row = 0; row < ROWS; row++) {
			for(int col = 0; col < COLS; col++) {
				cells[row][col] = new Cell(row,col);
			}
		}
		
		
	}
	
	public void create() {
		for(int row = 0; row < ROWS; row++) {
			for(int col = 0; col < COLS; col++) {
				cells[row][col].clear();
			}
		}
	}
	
	public boolean drawGame() {
		for(int row = 0; row < ROWS; row++) {
			for(int col = 0; col < COLS; col++) {
				if(cells[row][col].piece == PieceType.EMPTY) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean wonGame(PieceType piece) {
		 return (cells[currentRow][0].piece == piece         // 3-row
                 && cells[currentRow][1].piece == piece
                 && cells[currentRow][2].piece == piece
            || cells[0][currentCol].piece == piece      // 3-column
                 && cells[1][currentCol].piece == piece
                 && cells[2][currentCol].piece == piece
            || currentRow == currentCol            // 3-diagonal
                 && cells[0][0].piece == piece
                 && cells[1][1].piece == piece
                 && cells[2][2].piece == piece
            || currentRow + currentCol == 2    // 3-diagonal(2)
                 && cells[0][2].piece == piece
                 && cells[1][1].piece == piece
                 && cells[2][0].piece == piece);
	}
	
	public void printBoard() {
		for(int row = 0 ; row < ROWS; row++) {
			for(int col = 0; col < COLS; col++) {
				cells[row][col].printCell();
				
				if(col < COLS - 1) System.out.print("|");
			}
			System.out.println();
			if(row < ROWS-1) {
				System.out.println("#############");
			}
			
			
		}
	}
}
