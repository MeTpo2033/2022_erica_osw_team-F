
public class Sang extends Piece{
	
	public Sang(String n, int c, int i, int j) {
		super(n, c, i, j);
	}
	
	@Override
	public boolean moveAble(int row, int col) {
		if(row == getRow()-3 && (col == getCol()-2 || col == getCol()+2) ||
		   row == getRow()+3 && (col == getCol()-2 || col == getCol()+2) ||
		   col == getCol()-3 && (row == getRow()-2 || row == getRow()+2) ||
		   col == getCol()+3 && (row == getRow()-2 || row == getRow()+2)) {
			return true;
		}
		return false;
	}
}
