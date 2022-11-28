package component;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TurnPane extends VBox{
	private Text header;
	private Text subtext;
	
	public TurnPane(){
		super();
		
		this.setPrefWidth(192);
		this.setPrefHeight(80);
		this.setAlignment(Pos.CENTER);
		
		
		header = new Text("Player 1");
		subtext = new Text("Ready");
		
		header.setFont(new Font(30));
		subtext.setFont(new Font(20));
		
		this.getChildren().add(header);
		this.getChildren().add(subtext);
	}
	
	public void setPlayer(int pl) {
		header.setText("Player "+pl);
	}
	
	public void setSubText(String s) {
		subtext.setText(s);
	}
}
