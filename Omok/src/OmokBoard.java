public class OmokBoard{
	
	private int[][] board;
	
	public OmokBoard() {
		// ArrayIndexOutOfBoundsException이 발생하지 않기 위해 기존 19x19칸에서 4칸씩 늘려 check() 메소드가 원활히 작동하도록 함
		board = new int[23][23];
	}
	
	/** add() - 오목보드 좌표에 돌을 저장
	 *  @param row - 돌을 저장할 보드의 가로위치
	 *  @param col - 돌을 저장할 보드의 세로위치
	 *  @param stone - 저장할 돌 (검은돌 = 1, 흰돌 = -1 로 받도록 함)
	 */
	public void add(int row, int col, int stone) {
		board[row+2][col+2] = stone;
	}
	
	/** isBlank() - 해당 좌표가 비어있는지 확인
	 *  @param row - 확인할 보드의 가로위치
	 *  @param col - 확인할 보드의 세로위치
	 *  @return boolean 값으로 출력 (빈칸 = 1, 채워진 칸 = 0)
	 */
	public boolean isBlank(int row, int col) {
		return board[row+2][col+2] == 0;
	}
	
	/** check() - 배열 요소의 합을 계산하며 오목체크
	 *  @return integer 값으로 출력 (검은돌 오목 = 1, 흰돌 오목 = -1, 오목완성X = 0)
	 */
	public int check(){
		for (int i = 2; i < 21; i++) {
			for (int j = 2; j < 21; j++) {
				if(board[i][j-2]+board[i][j-1]+board[i][j]+board[i][j+1]+board[i][j+2] == 5 ||
				   board[i-2][j]+board[i-1][j]+board[i][j]+board[i+1][j]+board[i+2][j] == 5 ||
				   board[i-2][j-2]+board[i-1][j-1]+board[i][j]+board[i+1][j+1]+board[i+2][j+2] == 5 ||
				   board[i+2][j-2]+board[i+1][j-1]+board[i][j]+board[i-1][j+1]+board[i-2][j+2] == 5) {
					return 1;
				}
				else if(board[i][j-2]+board[i][j-1]+board[i][j]+board[i][j+1]+board[i][j+2] == -5 ||
				        board[i-2][j]+board[i-1][j]+board[i][j]+board[i+1][j]+board[i+2][j] == -5 ||
				        board[i-2][j-2]+board[i-1][j-1]+board[i][j]+board[i+1][j+1]+board[i+2][j+2] == -5 ||
				        board[i+2][j-2]+board[i+1][j-1]+board[i][j]+board[i-1][j+1]+board[i-2][j+2] == -5) {
					return -1;
				}
			}
		}
		return 0;
	}
	
	/** consoleReturnBoard() - console에 보드 배열을 프린트
	 */
	public void consoleReturnBoard() {
        for (int i = 2; i < 21; i++) {
            for (int j = 2; j < 21; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println("----------------------");
    }
	
	
}