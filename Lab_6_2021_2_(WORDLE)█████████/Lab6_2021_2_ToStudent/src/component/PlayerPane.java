package component;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PlayerPane extends GridPane{
	
	private int player;
	
	Text playerName;
	Text playerScore;
	Text prevWordLabel;
	
	WordCanvas prevWord;
	WordCanvas currentWord;
	
	public PlayerPane(int player) {
		super();
		
		this.player = player;
		
		this.setPrefWidth(512);
		this.setPrefHeight(256);
		
		this.setAlignment(Pos.CENTER);
		
		playerName = new Text("Player "+(player+1));
		playerName.setFont(new Font(20));
		
		playerScore = new Text("Score: 0");
		playerScore.setFont(new Font(20));
		
		prevWordLabel = new Text("Previous Guess: ");
		prevWordLabel.setFont(new Font(20));
		
		prevWord = new WordCanvas(0.5);
		currentWord = new WordCanvas(1);
		
		this.add(playerName, 0, 0);
		this.add(playerScore, 1, 0);
		this.add(prevWordLabel, 0, 1);
		this.add(prevWord, 1, 1);
		this.add(currentWord, 0, 2);
		
		GridPane.setHalignment(playerName, HPos.CENTER);
		GridPane.setHalignment(playerScore, HPos.CENTER);
		GridPane.setHalignment(prevWordLabel, HPos.RIGHT);
		GridPane.setHalignment(prevWord, HPos.RIGHT);
		GridPane.setHalignment(currentWord, HPos.CENTER);
		GridPane.setValignment(currentWord, VPos.CENTER);
		GridPane.setColumnSpan(currentWord, 2);
	}
	
	public void setPreviousWord(String word, Status[] status) {
		prevWord.setLetter(word);
		prevWord.setBoxStatus(status);
		prevWord.updateCanvas();
	}
	
	public void setScore(int score) {
		playerScore.setText("Score: "+score);
	}
	
	public WordCanvas getCurrentWordCanvas() {
		return currentWord;
	}
}
