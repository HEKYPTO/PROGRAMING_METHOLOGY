package component;

import javafx.application.Platform;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import logic.GameLogic;

public class WordCanvas extends Canvas {
	
	LetterBox[] letterBox;
	private double[] letterScale;
	
	private GraphicsContext gc;
	
	private double scale;
	
	private int currentLetter;
	
	
	public WordCanvas(double scale) {
		super();
		
		this.scale = scale;
		currentLetter = 0;
		
		gc = this.getGraphicsContext2D();
		
		//====Set some global settings====
		gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.CENTER);
        gc.setFont(new Font("Arial Bold", 32));
        gc.scale(scale, scale);
		
		
		letterBox = new LetterBox[5];
		letterScale = new double[]{1, 1, 1, 1, 1};
		
		for(int i=0; i<5;i++) {
			letterBox[i] = new LetterBox((48 + 72*i), 48);
		}
		
		this.setWidth(384*scale);
		this.setHeight(96*scale);
		
		this.updateCanvas();
	}
	
	public void updateCanvas() {
		//Draw BG
		gc.setFill(Color.WHITE);
		
		gc.fillRect(0, 0, 384, 96);
		
		for(int i=0; i<5; i++) {
			letterBox[i].draw(gc, 1, letterScale[i]);
		}
	}
	
	public void setLetter(String word) {
		
		//Failsafe
		if(word.length()!=5) {
			for(LetterBox l : letterBox) {
				l.setCharacter("");
			}
			return;
		}
		
		for(int i=0;i<5;i++) {
			letterBox[i].setCharacter(""+word.charAt(i));
		}
	}
	
	public void setLetter(int index, String letter) {
		letterBox[index].setCharacter(letter);
	}
	
	public void setBoxStatus(Status[] status) {
		
		//Failsafe
		if(status.length!=5) {
			for(int i=0;i<5;i++) {
				letterBox[i].setStatus(Status.NONE);
			}
			return;
		}
		
		for(int i=0;i<5;i++) {
			letterBox[i].setStatus(status[i]);
		}
	}
	
	public void setBoxStatus(int index, Status status) {
		letterBox[index].setStatus(status);
	}
	
	public void resetBox() {
		for(LetterBox l : letterBox) {//Empty out the box
			l.setCharacter("");
		}
		for(int i=0;i<5;i++) { //Set all box status to NONE
			letterBox[i].setStatus(Status.NONE);
		}
		updateCanvas(); //draw the update
		
		currentLetter = 0;
	}
	
	public void flipLetter(int index, Status newStatus) {
		
		/*
		 * FIX CODE
		 * The following part of this code will freeze the program when run
		 * Please turn this into a separate thread instead
		 */
		
		LetterBox lb = letterBox[index];

		Thread thread = new Thread(() -> {
			try {
				for(double i=21; i>0;i--) {
					letterScale[index] = i/20;
					//CAUTION: This method contains UI update, which can cause an error if running in a different thread
					Platform.runLater(this::updateCanvas);
					Thread.sleep(16);
				}

				lb.setStatus(newStatus);

				for(double i=0;i<21;i++) {
					letterScale[index] = i/20;

					//CAUTION: This method contains UI update, which can cause an error if running in a different thread
					Platform.runLater(this::updateCanvas);

					Thread.sleep(16);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		thread.start();
	}
	
	public void flipWord(Status[] newStatus) {
		/*
		 * FIX CODE
		 * The following part of this code will freeze the program when run
		 * Please turn this into a separate thread instead
		 */

		Thread thread = new Thread(() -> {
			try {
				Thread.sleep(1000);
				Platform.runLater(() -> {
					Thread t = new Thread(() -> {
						for (int i = 0; i < 5; i++) {
							try {
								flipLetter(i, newStatus[i]);
								Thread.sleep(300);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					});
					GameLogic.endTurns();
					t.start();
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		thread.start();
	}
	
	public void addLetter(String letter) {
		if (currentLetter>=5) {
			return;
		}
		
		letterBox[currentLetter].setCharacter(letter);
		currentLetter += 1;
	}
	
	public void removeLetter() {
		if (currentLetter<=0) {
			return;
		}
		
		currentLetter -= 1;
		letterBox[currentLetter].setCharacter("");
		
	}

	public int getCurrentLetter() {
		return currentLetter;
	}

	public void setCurrentLetter(int currentLetter) {
		this.currentLetter = currentLetter;
	}
	
	public String getGuessWord() {
		String result = "";
		for(LetterBox l : letterBox) {
			result = result+l.getCharacter();
		}
		return result;
	}
	
}
