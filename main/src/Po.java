
public class Po extends Piece{
	Piece[][] board;
	public Po(String n, int c, int i, int j, Piece[][] b) {
		super(n, c, i, j);
		board = b;
	}
	
	@Override
	public boolean moveAble(int row, int col) {
		boolean check = false;
		if(getCol() == col){
			if(getRow() > row){ // 위로 가는 상황
				for(int i = getRow()-1; i >= row+1; i--){
					if(board[i][getCol()] != null){ // 가는 경로에 뭔가 있으면
						if(check){
							return false;
						}else{
							check = true;
						}
					}
				}
				if((board[row][getCol()] != null && board[row][getCol()].getCountry() == getCountry()) || !check){
					return false;
				}else{
					return true;
				}
			}

			if(getRow() < row){ // 아래로 가는 상황
				for(int i = getRow()+1; i <= row-1; i++){
					if(board[i][getCol()] != null){
						if(check){
							return false;
						}else{
							check = true;
						}
					}
				}
				if((board[row][getCol()] != null && board[row][getCol()].getCountry() == getCountry()) || !check){
					return false;
				}else{
					return true;
				}
			}
		}else if(getRow() == row){
			if(getCol() > col){ // 오른쪽으로 가는 상황
				for(int i = getCol()-1; i >= col + 1; i--){
					if(board[getRow()][i] != null){ // 가는 경로에 뭔가 있으면
						if(check){
							return false;
						}else{
							check = true;
						}
					}
				}
				if((board[getRow()][col] != null && board[getRow()][col].getCountry() == getCountry()) || !check){
					return false;
				}else{
					return true;
				}
			}

			if(getCol() < col){ // 왼쪽으로 가는 상황
				for(int i = getCol()+1; i <= col - 1; i++){
					if(board[getRow()][i] != null){ // 가는 경로에 뭔가 있으면
						if(check){
							return false;
						}else{
							check = true;
						}
					}
				}
				if((board[getRow()][col] != null && board[getRow()][col].getCountry() == getCountry()) || !check){
					return false;
				}else{
					return true;
				}
			}
		}
		return false;
	}

}
