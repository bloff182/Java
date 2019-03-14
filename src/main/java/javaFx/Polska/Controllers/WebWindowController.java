package javaFx.Polska.Controllers;

import javafx.fxml.FXML;

public class WebWindowController {

	MainController mainController;
	
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

	@FXML
	public void backToMenuOnAction() {

		mainController.loaderMenu();
	}
}
