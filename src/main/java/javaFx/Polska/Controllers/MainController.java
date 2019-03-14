package javaFx.Polska.Controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class MainController {

	@FXML
	public StackPane mainStackPane;

	public void loaderMenu() {
		FXMLLoader loader = new FXMLLoader(getClass()
				.getResource("/fxml/MenuWindow.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		MenuController menuController = loader.getController();
		menuController.setMainController(this);
		setWindow(anchorPane);
	}

	public void setWindow(Pane pane) {
		
		mainStackPane.getChildren().clear();
		mainStackPane.getChildren().add(pane);
	}
	
	@FXML
	public void initialize() {
		loaderMenu();
	}
}
