package logic;

import gui.ControlPane;

public class GameLogic {
	
	private static GameLogic instance = null;
	private boolean isGameEnd;
	private boolean isGameWin;
	private int mineX = 1;
	private int mineY = 2;
	private int tileCount;
	private ControlPane controlPane;
	private boolean secureMode;
	private SquareMark[][] boardMark = new SquareMark[5][5];
	private SquareState[][] boardState = new SquareState[5][5];
	
	private GameLogic() {
		this.newGame();
	}
	
	public void updateState(int x, int y,SquareState state) {
		
		
		boardState[x][y] = state;
		
		checkGameEnd();
		if(isGameEnd) {
			if(isGameWin) {
				controlPane.updateGameText("You win!");
				return;	
			}
			else {
				controlPane.updateGameText("You lose!");
				return;	

			}
		}
		else if(!isSecureMode()){
			tileCount = tileCount - 1;
			controlPane.updateGameText("Tiles left : " + getTileCount());
		}
		
		
	}
	
	private void checkGameEnd() {
		if(boardState[mineX][mineY]==SquareState.REVEALED) {
			this.setGameEnd(true);
			this.setGameWin(false);
		}
		
		else {
			boolean allRevealed = true;
			for(int i = 0;i<5;i++) {
				for(int j = 0;j<5;j++) {
					if(!(i == mineX && j == mineY)) {
						if(boardState[i][j] != SquareState.REVEALED) {
							allRevealed = false;
							break;
						}
					}
					else {
						if(boardState[i][j] != SquareState.SECURED) {
							allRevealed = false;
							break;
						}
					}
				}
			}
			if(allRevealed) {
				this.setGameEnd(true);
				this.setGameWin(true);
			}
		}
	}
	
	public void newGame() {
		this.setGameEnd(false);
		this.tileCount = 25;
		this.secureMode = false;
		for(int i = 0;i<5;i++) {
			for(int j = 0;j<5;j++) {
				boardState[i][j] = SquareState.CONCEALED;
				boardMark[i][j] = SquareMark.NOTHING;
			}
		}
		
		for(int i = mineX-1;i < mineX+2;i++) {
			for(int j = mineY-1;j < mineY+2;j++) {
				boardMark[i][j] = SquareMark.ONE;
			}
		}
		
		boardMark[mineX][mineY] = SquareMark.MINE;
	}
	
	public void toggleSecureMode() {
		this.secureMode = !this.secureMode;
	}
	
	public boolean isSecureMode() {
		return secureMode;
	}

	public void setSecureMode(boolean secureMode) {
		this.secureMode = secureMode;
	}

	public int getTileCount() {
		return tileCount;
	}

	public SquareMark[][] getBoardMark() {
		return boardMark;
	}

	public SquareState[][] getBoardState() {
		return boardState;
	}

	public boolean isGameEnd() {
		return isGameEnd;
	}
	public void setGameEnd(boolean gameEnd) {
		isGameEnd = gameEnd;
	}


	public boolean isGameWin() {
		return isGameWin;
	}

	public void setGameWin(boolean isGameWin) {
		this.isGameWin = isGameWin;
	}

	public static GameLogic getInstance() {
		if(instance == null) {
			instance = new GameLogic();
		}
		return instance;
	}

	public void setControlPane(ControlPane controlPane) {
		this.controlPane = controlPane;
	}
	
	
	
}
