
public class Ma extends Piece{
	
	public Ma(String n, int c, int i, int j) {
		super(n, c, i, j);
	}
	
	@Override
	public boolean moveAble(int row, int col) {
		if(row == getRow()-2 && (col == getCol()-1 || col == getCol()+1) ||
		   row == getRow()+2 && (col == getCol()-1 || col == getCol()+1) ||
		   col == getCol()-2 && (row == getRow()-1 || row == getRow()+1) ||
		   col == getCol()+2 && (row == getRow()-1 || row == getRow()+1)) {
			return true;
		}
		return false;
	}
}
