package component;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.GameLogic;
import logic.Timer;

public class TimerPane extends VBox{
	
	private Text header;
	private Text timer;
	
	private int pl;
	
	private Button button;
	
	public TimerPane(int pl) {
		super();
		
		this.setPrefWidth(192);
		this.setPrefHeight(80);
		this.setAlignment(Pos.CENTER);
		
		
		header = new Text("P"+(pl+1)+" Timer");
		timer = new Text("00:00:00");
		
		header.setFont(new Font(25));
		timer.setFont(new Font(20));
		
		button = new Button("Start");
		
		this.getChildren().add(header);
		this.getChildren().add(timer);
		this.getChildren().add(button);
		
		setTimer(GameLogic.getPlayerTimer(pl));
		button.setDisable(true);
		
		/*
		 * FILL CODE - Clicking button should calls the static method beginTurns(int pl) from GameLogic.
		 */

		button.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				GameLogic.beginTurns(pl);
			}
		});
		
	}
	
	public void setTimer(Timer t) {
		timer.setText(t.toString());
	}
	
	public void setButtonDisable(boolean b) {
		button.setDisable(b);
	}
}
