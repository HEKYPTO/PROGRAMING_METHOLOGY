import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

public class start extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		
		VBox root = new VBox(8);
		root.setPadding(new Insets(10, 5, 10, 5));
		root.setPrefWidth(270);
		root.setPrefHeight(300);
		stage.setTitle("MyNote");
		
		Label titleLabel = new Label("Topic : ");
		TextField titleField = new TextField();
		titleField.setPrefWidth(200);
		HBox box1 = new HBox();
		box1.getChildren().addAll(titleLabel, titleField);
		
		Label dateLabel = new Label("Date : ");
		DatePicker datePicker = new DatePicker();
		datePicker.setPrefWidth(150);
		HBox box2 = new HBox();
		box2.getChildren().addAll(dateLabel, datePicker);
		
		TextArea textArea = new TextArea();
		
		Button okButton = new Button("Ok");
		okButton.setPrefWidth(60);
		okButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				okButtonHandler();
			}
			private void okButtonHandler() {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setContentText("Topic : " + titleField.getText() + "\nDate : " + datePicker.getValue() + "\nDescription : " + textArea.getText());
				alert.setTitle("Message");
				alert.setHeaderText("Message");
				alert.show();
			}
		});

		Button clearButton = new Button("Clear");
		clearButton.setPrefWidth(60);
		clearButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				clearButtonHandler();
			}

			private void clearButtonHandler() {
				titleField.clear();
				datePicker.getEditor().clear();
				textArea.clear();

			}
		});

		HBox buttons = new HBox(3);
		buttons.getChildren().addAll(okButton, clearButton);
		buttons.setAlignment(Pos.BOTTOM_RIGHT);

		VBox box8 = new VBox(8);
		box8.getChildren().addAll(box2, textArea, buttons);

		VBox box3 = new VBox(3);
		box3.getChildren().addAll(box1, box8);

		
		root.getChildren().addAll(box3);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}



	public static void main(String[] args) {
		launch(args);
	}
	
}
