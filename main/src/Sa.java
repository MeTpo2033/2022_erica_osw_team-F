
public class Sa extends Piece{
	
	public Sa(String n, int c, int i, int j) {
		super(n, c, i, j);
	}
	
	@Override
	public boolean moveAble(int row, int col) {
		if(getCountry() == 1) {
			if(7 <= row && row <= 9 && 3 <= col && col <= 5 &&
			   (row == getRow()+1 && col == getCol()||row == getRow()-1 && col == getCol()||
			   col == getCol()+1 && row == getRow()||col == getCol()-1 && row == getRow()||
			   row == 8 && col == 4)) return true;
		} else {
			if(0 <= row && row <= 2 && 3 <= col && col <= 5 &&
			   (row == getRow()+1 && col == getCol()||row == getRow()-1 && col == getCol()||
			   col == getCol()+1 && row == getRow()||col == getCol()-1 && row == getRow()||
			   row == 1 && col == 4)) return true;
		}
		return false;
	}
}
