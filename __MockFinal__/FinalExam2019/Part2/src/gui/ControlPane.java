package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

//You might need to do something to the following line
public class ControlPane extends VBox{
	
	private Text drawnNumberText;
	private Text drawCountText;
	private Text bingoText;
	private Button drawButton;
	private Button newRoundButton;
	private NumberGrid numberGrid;

	
	public ControlPane(NumberGrid numberGrid) {
		this.numberGrid = numberGrid;
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(300);
		this.setSpacing(20);
		this.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.drawnNumberText = new Text("");
		this.drawCountText = new Text("");
		this.drawnNumberText.setFont(new Font(20));
		initializeBingoText();
		initializeDrawButton();
		initializeNewRoundButton();
		getChildren().addAll(drawnNumberText, drawButton, newRoundButton, bingoText);
		BingoUtil.setTextsBeginning(drawnNumberText, drawCountText);
	}
	
	private void initializeBingoText() {
		this.bingoText = new Text("Bingo!!");
		this.bingoText.setFont(new Font(40));
		this.bingoText.setVisible(false);
	}

	private void initializeDrawButton() {
		this.drawButton = new Button("Draw a number");
		this.drawButton.setPrefWidth(100);
		this.drawButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	drawButtonHandler();
            }
		});
	}

	private void initializeNewRoundButton() {
		this.newRoundButton = new Button("New Round");
		this.newRoundButton.setPrefWidth(100);
		this.newRoundButton.setDisable(true);
		this.newRoundButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				newRoundButtonHandler();
			}
		});
	}
	
	private void drawButtonHandler() {
		int number = BingoUtil.drawNumber();
        if(numberGrid.highlightNumber(number)) {
            bingoText.setVisible(true);
            drawButton.setDisable(true);
            newRoundButton.setDisable(false);
        }
        BingoUtil.updateTextsAfterDrawn(number, drawnNumberText, drawCountText);
		
	}
	
	private void newRoundButtonHandler() {
		BingoUtil.assignRandomNumbers(numberGrid.getNumberSquares());
		this.bingoText.setVisible(false);
		this.drawButton.setDisable(false);
		this.newRoundButton.setDisable(true);
		BingoUtil.setTextsBeginning(drawnNumberText, drawCountText);
		
	}

	public Text getDrawnNumberText() {
		return drawnNumberText;
	}

	public void setDrawnNumberText(Text drawnNumberText) {
		this.drawnNumberText = drawnNumberText;
	}

	public Text getDrawCountText() {
		return drawCountText;
	}

	public void setDrawCountText(Text drawCountText) {
		this.drawCountText = drawCountText;
	}

	public Text getBingoText() {
		return bingoText;
	}

	public void setBingoText(Text bingoText) {
		this.bingoText = bingoText;
	}

	public Button getDrawButton() {
		return drawButton;
	}

	public void setDrawButton(Button drawButton) {
		this.drawButton = drawButton;
	}

	public Button getNewRoundButton() {
		return newRoundButton;
	}

	public void setNewRoundButton(Button newRoundButton) {
		this.newRoundButton = newRoundButton;
	}

	public NumberGrid getNumberGrid() {
		return numberGrid;
	}

	public void setNumberGrid(NumberGrid numberGrid) {
		this.numberGrid = numberGrid;
	}

}
