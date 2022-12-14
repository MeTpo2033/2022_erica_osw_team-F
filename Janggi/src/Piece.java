
public abstract class Piece {
	
	private String name;
	private int country;
	private int row;
	private int col;
	
	public Piece(String n, int c, int i, int j) {
		name = n;
		country = c;
		row = i;
		col = j;
	}
	
	public abstract boolean moveAble(int r, int c);
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public int getCountry() {
		return country;
	}
	
	public String getName() {
		return name;
	}
	
	public void setRow(int n) {
		row = n;
	}
	
	public void setCol(int n) {
		col = n;
	}
}
