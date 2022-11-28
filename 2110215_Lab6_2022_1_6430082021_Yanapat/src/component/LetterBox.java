package component;

import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class LetterBox {
	
	private String character;
	
	private double x;
	private double y;
	
	private Status status;
	
	private final double SIZE = 64;
	private final double HSIZE = SIZE*0.5;
	
	public LetterBox(double x, double y) {
		setCharacter("");
		
		this.x = x;
		this.y = y;
		
		setStatus(Status.NONE);
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public void draw(GraphicsContext gc, double scaleX, double scaleY) {
		
		switch(status) {
		
		case PARTIAL:
			gc.setFill(WDColor.PARTIAL_FILL);
			gc.fillRect(x-HSIZE*scaleX, y-HSIZE*scaleY, SIZE*scaleX, SIZE*scaleY);
			
			if(scaleY>=1) {
				gc.setFill(Color.WHITE);
				gc.fillText(character, x, y);
			}
			break;
		case CORRECT:
			gc.setFill(WDColor.CORRECT_FILL);
			gc.fillRect(x-HSIZE*scaleX, y-HSIZE*scaleY, SIZE*scaleX, SIZE*scaleY);
			
			if(scaleY>=1) {
				gc.setFill(Color.WHITE);
				gc.fillText(character, x, y);
			}
			break;
		case INCORRECT:
			gc.setFill(WDColor.INCORRECT_FILL);
			gc.fillRect(x-HSIZE*scaleX, y-HSIZE*scaleY, SIZE*scaleX, SIZE*scaleY);
			
			if(scaleY>=1) {
				gc.setFill(Color.WHITE);
				gc.fillText(character, x, y);
			}
			break;
		default:
			gc.setFill(Color.WHITE);
			gc.fillRect(x-HSIZE*scaleX, y-HSIZE*scaleY, SIZE*scaleX, SIZE*scaleY);
			
			if(scaleY>=1) {
				gc.setFill(Color.BLACK);
				gc.fillText(character, x, y);
			}
			
			gc.setLineWidth(2);
			gc.setStroke(WDColor.EMPTY_OUTLINE);
			gc.strokeRect(x-HSIZE*scaleX, y-HSIZE*scaleY, SIZE*scaleX, SIZE*scaleY);
		}
		
		
	}
}
