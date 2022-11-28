package gui;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class NumberSquare extends HBox {
	
	private int number;
	private boolean isDrawn;
	private Text numberText;

	public NumberSquare() {
		BingoUtil.initializeNumberSquare(this);		
	}

	public void setupNumber(int number) {
        this.number = number;
        this.isDrawn = false;
        numberText.setText(Integer.toString(number));
        this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    }
	
	public void highlight() {
		this.setBackground(new Background(new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
		this.isDrawn = true;
	}
	
	public int getNumber() {
		return number;
	}	

	public boolean isDrawn() {
		return isDrawn;
	}

	public void setNumberText(Text numberText) {
		this.numberText = numberText;
	}
}
