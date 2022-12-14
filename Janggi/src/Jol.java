
public class Jol extends Piece{
	
	public Jol(String n, int c, int i, int j) {
		super(n, c, i, j);
	}
	
	@Override
	public boolean moveAble(int row, int col) {
		if(getCountry() == 1) {
			if(row == getRow()-1 && col == getCol()||
			   col == getCol()+1 && row == getRow()||
			   col == getCol()-1 && row == getRow()) {
				return true;
			}
		} else {
			if(row == getRow()+1 && col == getCol()||
			   col == getCol()-1 && row == getRow()||
			   col == getCol()+1 && row == getRow()) {
				return true;
			}
		}
		return false;
	}
}
