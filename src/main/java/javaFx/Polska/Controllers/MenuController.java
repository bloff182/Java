package javaFx.Polska.Controllers;

import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class MenuController {
	
	MainController mainController;
	
	public void setMainController(MainController mainController)
	{
		this.mainController = mainController;
	}

	@FXML
	public void exitProgram() {

		Platform.exit();
	}
	
	@FXML
	void moveMouse(MouseEvent event) {

		Polygon e = (Polygon) event.getSource();
		e.setFill(Color.YELLOW);

	}

	@FXML
	void exitMouse(MouseEvent event) {

		Polygon e = (Polygon) event.getSource();
		e.setFill(Color.DODGERBLUE);
	}
	
	@FXML
	public void enterMouse() {

		openDolnyslask();
	}
	
	public void openDolnyslask()
	{
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/DolnyslaskWindow.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		DolnyslaskController dolnyslaskController = loader.getController();
		dolnyslaskController.setMainController(mainController);
		
		mainController.setWindow(anchorPane);
	}

    @FXML
    void openBrowse() {

    	FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/WebWindow.fxml"));
    	
    	AnchorPane anchorPane = null;
    	try {
			anchorPane = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	WebWindowController webWindowController = loader.getController();
    	webWindowController.setMainController(mainController);
    	
    	mainController.setWindow(anchorPane);
    }
}
