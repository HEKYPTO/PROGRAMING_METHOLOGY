package gui;

import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import logic.GameLogic;
import logic.SquareMark;
import logic.SquareState;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

public class MineSweeperSquare extends Pane {

	//Initialize Fields
	private boolean isDrawn;
	private Color baseColor;
	private int xPosition;
	private int yPosition;
	private final String oURL;
	private final String oneURL;
	private final String mineURL;
	private final String flagURL;

	public MineSweeperSquare(int x, int y) {
		oURL = "o.png";
		oneURL = "one.png";
		mineURL = "mine.png";
		flagURL = "flag.png";
		setxPosition(x);
		setyPosition(y);
		setPrefHeight(100);
		setPrefWidth(100);
		setMinHeight(100);
		setMinWidth(100);
		setBaseColor(Color.MOCCASIN);
		initializeCellColor();
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				onClickHandler();
			}
		});
	}

	public boolean isDrawn() {
		return isDrawn;
	}

	public void setDrawn(boolean drawn) {
		isDrawn = drawn;
	}

	public Color getBaseColor() {
		return baseColor;
	}

	public void setBaseColor(Color baseColor) {
		this.baseColor = baseColor;
	}

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public String getoURL() {
		return oURL;
	}

	public String getOneURL() {
		return oneURL;
	}

	public String getMineURL() {
		return mineURL;
	}

	public String getFlagURL() {
		return flagURL;
	}

	private void onClickHandler() {
		if (!GameLogic.getInstance().isGameEnd()) {
			if (!GameLogic.getInstance().isSecureMode() && GameLogic.getInstance().getBoardState()[xPosition][yPosition] != SquareState.REVEALED) {
				if (GameLogic.getInstance().getBoardMark()[xPosition][yPosition] == SquareMark.ONE) {
					draw(new Image(ClassLoader.getSystemResource(oneURL).toString()), Color.ORANGE);
				} else if (GameLogic.getInstance().getBoardMark()[xPosition][yPosition] == SquareMark.NOTHING) {
					draw(new Image(ClassLoader.getSystemResource(oURL).toString()), Color.YELLOW);
				} else if (GameLogic.getInstance().getBoardMark()[xPosition][yPosition] == SquareMark.MINE) {
					draw(new Image(ClassLoader.getSystemResource(mineURL).toString()), Color.RED);
				}
				GameLogic.getInstance().updateState(xPosition, yPosition, SquareState.REVEALED);

			}

			else if (GameLogic.getInstance().isSecureMode() && GameLogic.getInstance().getBoardState()[xPosition][yPosition] != SquareState.REVEALED) {
				draw(new Image(ClassLoader.getSystemResource(flagURL).toString()), Color.GREEN);
				GameLogic.getInstance().updateState(xPosition, yPosition, SquareState.SECURED);
			}
		}
	}
	
	private void draw(Image image, Color backgroundColor) {
		BackgroundFill bgFill = new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY);
		BackgroundFill[] bgFillA = {bgFill};
		BackgroundSize bgSize = new BackgroundSize(100,100,false,false,false,false);
		BackgroundImage bgImg = new BackgroundImage(image, null, null, null, bgSize);
		BackgroundImage[] bgImgA = {bgImg};
		this.setBackground(new Background(bgFillA,bgImgA));
		setDrawn(true);
	}

	public void initializeCellColor() {
		BackgroundFill bgFill = new BackgroundFill(this.getBaseColor(), CornerRadii.EMPTY, Insets.EMPTY);
		BackgroundFill[] bgFillArrays = {bgFill};
		this.setBackground(new Background(bgFillArrays));
		setDrawn(false);
	}
	
}
