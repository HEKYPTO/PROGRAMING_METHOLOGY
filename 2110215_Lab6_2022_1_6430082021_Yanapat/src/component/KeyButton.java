package component;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import logic.GameLogic;

public class KeyButton extends Button{
	
	private String myKey;
	
	public static final String KEY_BKSPC = "BKSPC";
	public static final String KEY_ENTER = "ENTER";
	
	public KeyButton(String key) {
		super();
		String btnString;
		
		switch(key) {
		case "BKSPC":
			setMyKey("");
			btnString = "<-";
			break;
		case "ENTER":
			setMyKey("");
			btnString = "ENTER";
			break;
		default:
			setMyKey(key);
			btnString = key;
			break;
		}
		
		this.setText(btnString);
		this.setStatus(Status.NONE);
		
		this.setMinWidth(32);
		this.setPrefHeight(64);
	}

	public String getMyKey() {
		return myKey;
	}

	public void setMyKey(String myKey) {
		this.myKey = myKey;
	}
	
	//Happen when the player press the button
	public void handle() { 
		
	}
	
	//Set Color to each letter status
	public void setStatus(Status status) {
		switch(status) {
		case PARTIAL:
			this.setStyle("-fx-background-color: #c9b458; -fx-text-fill: #ffffff; -fx-font-family: Arial; -fx-font-weight: bold; -fx-font-size: 1.25em;");
			break;
		case CORRECT:
			this.setStyle("-fx-background-color: #6aaa64; -fx-text-fill: #ffffff; -fx-font-family: Arial; -fx-font-weight: bold; -fx-font-size: 1.25em;");
			break;
		case INCORRECT:
			this.setStyle("-fx-background-color: #787c7e; -fx-text-fill: #ffffff; -fx-font-family: Arial; -fx-font-weight: bold; -fx-font-size: 1.25em;");
			break;
		default:
			this.setStyle("-fx-background-color: #d3d6da; -fx-text-fill: #000000; -fx-font-family: Arial; -fx-font-weight: bold; -fx-font-size: 1.25em;");
			break;
		}
	}
}
