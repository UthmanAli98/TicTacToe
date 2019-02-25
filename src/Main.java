import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	private Board board;
	private GameCondition state;
	private PieceType playerPiece;
	
	private static Scanner scan = new Scanner(System.in);
	
	public Main() {
		board = new Board();
		createGame();
		
		do {
			 playerMove(playerPiece); 
	         board.printBoard();          
	         updateGame(playerPiece);
	         if (state == GameCondition.CROSS_WON) {
	            
	        	System.out.println();
	        	System.out.println("'X' won!");
	            System.out.println("Game: Win");
	            
	         } else if (state == GameCondition.CIRCLE_WON) {
	        	 
	        	System.out.println();
	            System.out.println("'O' won!");
	            System.out.println("Game: Win");
	            
	         } else if (state == GameCondition.DRAW) {
	        	 
	            System.out.println("It's Draw!");
	            System.out.println("Game: Draw");
	            
	         }else {
	        	 
	        	 System.out.println();
	        	 System.out.println("Game: In Progress");
	         }
	         playerPiece = (playerPiece == PieceType.CROSS) ? PieceType.CIRCLE : PieceType.CROSS;
			
		}while(state == GameCondition.PLAYING);
	}
	
	public void playerMove(PieceType currentPiece) {
		boolean validInput = false;
		do {
			
			if(playerPiece == PieceType.CROSS) {
				System.out.print("X your turn, enter your co-ordinates(row[1-3],column[1-3])");
			}else {
				System.out.print("O your turn, enter your co-ordrinates(row[1-3],column[1-3])" );
			}
			
			
			try {
			String coordinates = scan.next().trim();
			String[] coords = coordinates.split(",");
			
			int row = Integer.parseInt(coords[0]) - 1;
			int col = Integer.parseInt(coords[1]) -1;
			
			 if (row >= 0 && row < Board.ROWS && col >= 0 && col < Board.COLS
			            && board.cells[row][col].piece == PieceType.EMPTY) {
			            board.cells[row][col].piece = currentPiece;
			            board.currentRow = row;
			            board.currentCol = col;
			            validInput = true;
			         } else {
			            System.out.println("This move at (" + (row + 1) + "," + (col + 1)
			                  + ") is not valid. Try again...");
			         }
			
			}catch(InputMismatchException | ArrayIndexOutOfBoundsException | NumberFormatException ex) {
				System.out.println("You have inputed the coordinates incorrectly please restart the game and do it correctly this time!");
				System.exit(0);
			}
			
			
			
		}while(!validInput);
	}
	private void createGame() {
		// TODO Auto-generated method stub
		board.create();
		playerPiece = PieceType.CROSS;
		state = GameCondition.PLAYING;
	}
	
	public void updateGame(PieceType piece) {
		if(board.wonGame(piece)) {
			state = (piece == PieceType.CROSS)?GameCondition.CROSS_WON : GameCondition.CIRCLE_WON;
		}else if(board.drawGame()) {
			state = GameCondition.DRAW;
		}
	}
	public static void main(String[] args) {
		
		System.out.println("LETS PLAY TIC TAC TOE");
		System.out.println("**********************************");
		new Main();
		
	}
	
}
