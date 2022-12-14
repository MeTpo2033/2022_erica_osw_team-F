
import javax.swing.JOptionPane;

public class PieceBoard {
	
	private Piece[][] board;

	public PieceBoard() {
		// Cha=1, Ma=2, Sang=3, King=4, Sa=5, Po=6, Jol=7 nothing=0
		int[][] arr = {{1,2,3,5,0,5,3,2,1},
					   {0,0,0,0,4,0,0,0,0},
					   {0,6,0,0,0,0,0,6,0},
					   {7,0,7,0,7,0,7,0,7},
					   {0,0,0,0,0,0,0,0,0},
					   {0,0,0,0,0,0,0,0,0},
					   {7,0,7,0,7,0,7,0,7},
					   {0,6,0,0,0,0,0,6,0},
					   {0,0,0,0,4,0,0,0,0},
					   {1,2,3,5,0,5,3,2,1}};
		
		board = new Piece[10][9];
		int country; // country=1 : 한나라(RED), country=0 : 초나라(BLUE)
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(i<5) country = 0; //초나라(BLUE)
				else country = 1; //한나라(RED)
				
				if(arr[i][j] == 1) board[i][j] = new Cha("車", country, i, j, board);
				else if(arr[i][j] == 2) board[i][j] = new Ma("馬", country, i, j);
				else if(arr[i][j] == 3) board[i][j] = new Sang("象", country, i, j);
				else if(arr[i][j] == 4) board[i][j] = new King("王", country, i, j);
				else if(arr[i][j] == 5) board[i][j] = new Sa("士", country, i, j);
				else if(arr[i][j] == 6) board[i][j] = new Po("包", country, i, j, board);
				else if(arr[i][j] == 7) board[i][j] = new Jol("卒", country, i, j);
				else board[i][j] = null;
			}
		}
	}
	
	public Piece getPiece(int row, int col) {
		Piece piece = board[row][col];
		return piece;
	}
	
	public boolean move(Piece p, int row, int col) {
		if(board[row][col] != null && p.getCountry() == board[row][col].getCountry())
			return false;
		if(p != null && p.moveAble(row, col)) {
			if(board[row][col] instanceof King) {
				JOptionPane.showMessageDialog(null, "You Got The King!");
			}
			board[row][col] = p;
			board[p.getRow()][p.getCol()] = null;
			board[row][col].setRow(row);
			board[row][col].setCol(col);
			consoleReturnBoard();
			return true;
		}
		return false;
	}
	
	public void consoleReturnBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] instanceof Cha) System.out.print("차");
                else if(board[i][j] instanceof Ma) System.out.print("마");
                else if(board[i][j] instanceof Sang) System.out.print("상");
                else if(board[i][j] instanceof King) System.out.print("왕");
                else if(board[i][j] instanceof Sa) System.out.print("사");
                else if(board[i][j] instanceof Po) System.out.print("포");
                else if(board[i][j] instanceof Jol) System.out.print("졸");
                else if(board[i][j] == null) System.out.print("0");
            }
            System.out.println();
        }
        System.out.println("----------------------");
    }

}