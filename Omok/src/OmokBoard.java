
public class OmokBoard{
	
	private int[][] board;
	
	public OmokBoard() {
		board = new int[19][19];
	}
	
	public void add(int row, int col, int stone) {
		board[row][col] = stone;
	}

	public boolean isBlank(int row, int col) {
		return board[row][col] == 0;
	}
	
	public boolean check(){
		// 조건 추가
		return false;
	}
}
