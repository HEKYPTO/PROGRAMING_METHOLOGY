package gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class ControlGridPane extends GridPane {
    private final String miningImageURL;
    private ControlPane controlPane;

    public ControlGridPane (ControlPane controlPane) {
        setControlPane(controlPane);
        this.miningImageURL = "bitcoin.png";
        String miningImageURL_Path = ClassLoader.getSystemResource(this.miningImageURL).toString();
        Image image = new Image(miningImageURL_Path);
        ImageView imv = new ImageView();
        imv.setImage(image);
        imv.setFitHeight(150);
        imv.setFitWidth(150);
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefHeight(200);
        borderPane.setPrefWidth(150);
        borderPane.setCenter(imv);
        add(borderPane, 0, 0);
        add(this.controlPane, 0, 1);
    }

    public ControlPane getControlPane() {
        return controlPane;
    }

    public void setControlPane(ControlPane controlPane) {
        this.controlPane = controlPane;
    }
}
