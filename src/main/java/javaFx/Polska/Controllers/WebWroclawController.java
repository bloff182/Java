package javaFx.Polska.Controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class WebWroclawController {

	MainController mainController;
	DolnyslaskController dolnyslaskController = new DolnyslaskController();

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

	@FXML
	private ImageView viewPicture;

	@FXML
	private Label rynekLabel;

	@FXML
	private Label panoramaLabel;

	@FXML
	private Label ostrowLabel;

	@FXML
	private Label katedraLabel;

	@FXML
	private Label zooLabel;

	@FXML
	private Label cmanetarzZydowskiLabel;

	@FXML
	private Label halaLabel;

	@FXML
	private Label botanicznyLabel;

	@FXML
	private Label japonskiLabel;

	@FXML
	private Label skyTowerLabel;

	@FXML
	private Label dzielnicaLabel;

	@FXML
	private Label kosciolAntoniegoLabel;

	@FXML
	private Label soborLabel;

	@FXML
	private Label kosciolOpatrznosciLabel;

	@FXML
	private Label synagogaLabel;

	@FXML
	private Label sourceLabel;

	@FXML
	private Circle kosciolAnotoni;

	@FXML
	private Circle sobor;

	@FXML
	private Circle kosciolOpatrznosci;

	@FXML
	private Circle synagoga;

	List<Label> list = new ArrayList<Label>();

	@FXML
	void lightOn(MouseEvent event) {

		Circle circle = (Circle) event.getSource();

		if (circle.equals(kosciolAnotoni) || circle.equals(synagoga) || circle.equals(sobor)
				|| circle.equals(kosciolOpatrznosci)) {
			setLabelStyle(dzielnicaLabel, "yellow");
		}

		setStyleLabel(event, list);
		setCircleColor(Color.YELLOW, event);
		dolnyslaskController.setSourceLabel(sourceLabel, "èrÛd≥o: www.wikipedia.pl");
		showPicture(event);
	}

	@FXML
	void lightOff(MouseEvent event) {
		Circle circle = (Circle) event.getSource();

		if (circle.equals(kosciolAnotoni) || circle.equals(synagoga) || circle.equals(sobor)
				|| circle.equals(kosciolOpatrznosci)) {

			setLabelStyle(dzielnicaLabel, "null");
		}
		remarkStyleLabel(list);
		setCircleColor(Color.DODGERBLUE, event);
	}

	public void setCircleColor(Color color, MouseEvent event) {
		Circle circle = (Circle) event.getSource();
		circle.setFill(color);
	}

	public void setStyleLabel(MouseEvent event, List<Label> list) {

		Circle circle = (Circle) event.getSource();

		String id = circle.getAccessibleText();
		Integer intId = Integer.parseInt(id);
		setLabelStyle(list.get(intId), "yellow");

	}

	public void showPicture(MouseEvent event) {
		Circle circle = (Circle) event.getSource();
		String name = circle.getId();
		File file = new File("src/main/resources/pictures/".concat(name).concat(".jpg"));
		Image image = new Image(file.toURI().toString());
		viewPicture.setImage(image);

	}

	public void remarkStyleLabel(List<Label> list) {
		for (int i = 0; i < list.size(); i++) {
			setLabelStyle(list.get(i), "null");
		}
	}

	public void setLabelStyle(Label label, String color) {
		label.setStyle("-fx-background-color: ".concat(color).concat(";"));
	}

	@FXML
	public void goToDolnyOnAction() {

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
	public void backToMenuOnAction() {
		mainController.loaderMenu();
	}

	@FXML
	public void initialize() {

		list.add(rynekLabel);
		list.add(panoramaLabel);
		list.add(ostrowLabel);
		list.add(katedraLabel);
		list.add(zooLabel);
		list.add(cmanetarzZydowskiLabel);
		list.add(halaLabel);
		list.add(botanicznyLabel);
		list.add(japonskiLabel);
		list.add(skyTowerLabel);
		list.add(kosciolAntoniegoLabel);
		list.add(soborLabel);
		list.add(kosciolOpatrznosciLabel);
		list.add(synagogaLabel);
		list.add(dzielnicaLabel);

	}
}
