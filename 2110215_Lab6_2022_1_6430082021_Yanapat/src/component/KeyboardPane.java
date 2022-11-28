package component;

import java.util.Enumeration;
import java.util.Hashtable;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.GameLogic;

public class KeyboardPane extends VBox{
	
	private Hashtable<String, KeyButton> btnDict;
	
	private String[][] keyArray;
	
	public KeyboardPane() {
		super(5);
		
		//=======Initialized Fields========
		keyArray = new String[][]{ {"Q","W", "E", "R", "T", "Y", "U", "I", "O", "P"}, {"A","S","D", "F", "G", "H", "J","K", "L"}, {"ENTER","Z","X","C","V","B","N","M","BKSPC"}};
		
		btnDict = new Hashtable<String, KeyButton>();

		//=======Set up the main pane========
		this.setPrefWidth(512);
		this.setPrefHeight(128);
		this.setAlignment(Pos.CENTER);
		
		
		//=======Set up each keyboard row========
		for(int i = 0; i < 3; i++) {
			HBox hbox = new HBox(5);
			
			hbox.setPrefWidth(512);
			hbox.setAlignment(Pos.CENTER);
			
			for(String s: keyArray[i]) {
				KeyButton kB = new KeyButton(s);
				btnDict.put(s, kB);

				kB.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent mouseEvent) {
						GameLogic.addLetterToCurrentPlayer(s);
					}
				});
				
				hbox.getChildren().add(kB);
			}
			
			this.getChildren().add(hbox);
		}
		
		//==================================
		disableKeyboard();
	}
	
	public void setKeyStatus(String key, Status status) {
		btnDict.get(key).setStatus(status);
	}
	
	public void setKeyStatus(Hashtable<String, Status> keySet) {
		//btnDict.get(key).setStatus(status);
		Enumeration<String> enu = keySet.keys();
		while (enu.hasMoreElements()) {
			String key = enu.nextElement();
			btnDict.get(key).setStatus(keySet.get(key));
        }
	}
	
	public void disableKeyboard() {
		for(int i = 0; i < 3; i++) {
			for(String s: keyArray[i]) {
				btnDict.get(s).setStatus(Status.INCORRECT);
				btnDict.get(s).setDisable(true);
			}
		}
	}
	
	public void enableKeyboard() {
		for(int i = 0; i < 3; i++) {
			for(String s: keyArray[i]) {
				btnDict.get(s).setStatus(Status.NONE);
				btnDict.get(s).setDisable(false);
			}
		}
	}

}
