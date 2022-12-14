
public class Sang extends Piece{
	
	public Sang(String n, int c, int i, int j) {
		super(n, c, i, j);
	}
	
	@Override
	public boolean moveAble(int row, int col) {
		return false;
	}
}
