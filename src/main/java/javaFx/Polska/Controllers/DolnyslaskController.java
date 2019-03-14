package javaFx.Polska.Controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javaFx.Polska.Units.Dialogs;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class DolnyslaskController {

	MainController mainController;
	Dialogs dialogs;

	List<ImageView> listCastle = new ArrayList<ImageView>();
	List<ImageView> listCave = new ArrayList<ImageView>();
	List<ImageView> listView = new ArrayList<ImageView>();
	List<ImageView> listWaterfall = new ArrayList<ImageView>();
	List<ImageView> listUnesco = new ArrayList<ImageView>();
	List<ImageView> listAtractions = new ArrayList<ImageView>();

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

	@FXML
	private ImageView Czocha;

	@FXML
	private ImageView Chojnik;

	@FXML
	private ImageView Ksiaz;

	@FXML
	private CheckBox castleCheckBox;

	@FXML
	private CheckBox waterfallCheckBox;

	@FXML
	private CheckBox caveCheckBox;

	@FXML
	private CheckBox unescoCheckBox;

	@FXML
	private CheckBox atractionCheckBox;

	@FXML
	private CheckBox viewCheckBox;

	@FXML
	private ImageView Grodno;

	@FXML
	private ImageView bolkow;

	@FXML
	private ImageView sleza;

	@FXML
	private ImageView szrenica;

	@FXML
	private ImageView sniezka;

	@FXML
	private ImageView szczeliniec;

	@FXML
	private ImageView snieznik;

	@FXML
	private ImageView caveBear;

	@FXML
	private ImageView caveRiese;

	@FXML
	private ImageView caveKowary;

	@FXML
	private ImageView caveZlotyStok;

	@FXML
	private ImageView hala;

	@FXML
	private ImageView swidnica;

	@FXML
	private ImageView jawor;

	@FXML
	private ImageView kamienczyk;

	@FXML
	private ImageView szklarka;

	@FXML
	private ImageView podgornej;

	@FXML
	private ImageView western;

	@FXML
	private ImageView minipark;

	@FXML
	private ImageView bledneSkaly;

	@FXML
	private ImageView twierdzaKlodzko;

	@FXML
	private ImageView twierdzaSrebrnaGora;

	@FXML
	private ImageView krzywaWieza;

	@FXML
	private ImageView wang;

	@FXML
	private ImageView viewPicture;

	@FXML
	private Label nameItem;

	@FXML
	private CheckBox allCheckBox;

	@FXML
	private Label sourceLabel;

	void addToList(List<ImageView> list, ImageView image) {
		list.add(image);
	}

	@FXML
	void selectAllCheckBox(ActionEvent event) {

		CheckBox checkBox = (CheckBox) event.getSource();

		if (allCheckBox.isSelected()) {
			castleCheckBox.setSelected(true);
			showIcon(listCastle, checkBox);
			caveCheckBox.setSelected(true);
			showIcon(listCave, checkBox);
			viewCheckBox.setSelected(true);
			showIcon(listView, checkBox);
			unescoCheckBox.setSelected(true);
			showIcon(listUnesco, checkBox);
			atractionCheckBox.setSelected(true);
			showIcon(listAtractions, checkBox);
			waterfallCheckBox.setSelected(true);
			showIcon(listWaterfall, checkBox);
		} else {
			castleCheckBox.setSelected(false);
			caveCheckBox.setSelected(false);
			viewCheckBox.setSelected(false);
			unescoCheckBox.setSelected(false);
			atractionCheckBox.setSelected(false);
			waterfallCheckBox.setSelected(false);
			noShowIcon(castleCheckBox, listCastle);
			noShowIcon(caveCheckBox, listCave);
			noShowIcon(viewCheckBox, listView);
			noShowIcon(unescoCheckBox, listUnesco);
			noShowIcon(waterfallCheckBox, listWaterfall);
			noShowIcon(atractionCheckBox, listAtractions);
		}
	}

	// pokazuja ikony

	@FXML
	void show(ActionEvent event) {

		CheckBox checkBox = (CheckBox) event.getSource();

		if (checkBox.equals(castleCheckBox))
			showIcon(listCastle, checkBox);
		if (checkBox.equals(caveCheckBox))
			showIcon(listCave, checkBox);
		if (checkBox.equals(waterfallCheckBox))
			showIcon(listWaterfall, checkBox);
		if (checkBox.equals(viewCheckBox))
			showIcon(listView, checkBox);
		if (checkBox.equals(unescoCheckBox))
			showIcon(listUnesco, checkBox);
		if (checkBox.equals(atractionCheckBox))
			showIcon(listAtractions, checkBox);
	}

	void showIcon(List<ImageView> list, CheckBox checkBox) {
		if (checkBox.isSelected()) {
			for (int i = 0; i < list.size(); i++)
				list.get(i).setVisible(true);
		} else {
			for (int i = 0; i < list.size(); i++)
				list.get(i).setVisible(false);
		}
	}

	// nie sa wyswietlony ikony
	void noShowIcon(CheckBox checkBox, List<ImageView> list) {

		if (!checkBox.isSelected()) {
			for (int i = 0; i < list.size(); i++)
				list.get(i).setVisible(false);
		}
	}
	
	// wyswietla inforamcje o atrakcji po kliknieciu na ikone
	@FXML
	void clickCastle(MouseEvent event) {

		String description = ((ImageView) event.getSource()).getAccessibleRoleDescription();
		String accText = ((ImageView) event.getSource()).getAccessibleText();

		Dialogs.alertInformation(accText, description);

		showPicture(event);
		setSourceLabel(sourceLabel, "ród³o: www.wikipedia.pl");
		showNameAtraction(event);
	}

	// zadania gdy myszka nie jest skupiona na obiekcie
	@FXML
	void lightOff(MouseEvent event) {

		Object object = ((Object) event.getSource());

		if (object instanceof Circle) {
			((Circle) object).setFill(Color.DODGERBLUE);
		} else if (object instanceof ImageView) {
			SetSizeImage(0.6, (ImageView) object);
			nameItem.setText("");
			viewPicture.setImage(null);
			setSourceLabel(sourceLabel, "");
		}
	}

	// najechanie myszka na obiekt
	@FXML
	void lightOn(MouseEvent event) {

		Object object = ((Object) event.getSource());
		DropShadow dropShadow = new DropShadow();

		if (object instanceof Circle) {
			((Circle) object).setFill(Color.YELLOW);
		} else if (object instanceof ImageView) {
			SetSizeImage(0.9, (ImageView) object);
			showNameAtraction(event);
			nameItem.setEffect(dropShadow);
			showPicture(event);
			setSourceLabel(sourceLabel, "ród³o: www.wikipedia.pl");
		}
	}
	
	public void SetSizeImage(double size, ImageView image) {
		image.setScaleX(size);
		image.setScaleY(size);
	}

	// wyswietlanie nazwy atrakcji, obrazka
	public void showNameAtraction(MouseEvent event) {
		Object object = ((Object) event.getSource());
		String name = ((ImageView) object).getAccessibleText();
		nameItem.setText(name);
	}

	// pokazuje zdjecie atrakcji
	public void showPicture(MouseEvent event) {
		ImageView object = (ImageView) event.getSource();
		String fileName = object.getId();
		File file = new File("src/main/resources/pictures/".concat(fileName).concat(".jpg"));
		Image image = new Image(file.toURI().toString());
		viewPicture.setImage(image);
	}

	public void setSourceLabel(Label label, String text) {
		label.setText(text);
	}

	@FXML
	void backToMenuOnAction() {

		mainController.loaderMenu();
	}

	@FXML
	public void exitProgram() {

		Platform.exit();
	}

	// ladowanie strony miasta Wroclaw

	@FXML
	public void openBrowseWroclaw() {

		loaderBrowseWroclaw();
	}

	public void loaderBrowseWroclaw() {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/WebWroclawWindow.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		WebWroclawController wroclaw = loader.getController();
		wroclaw.setMainController(mainController);
		mainController.setWindow(anchorPane);
	}

	@FXML
	void openBrowse() {

		browse();
	}

	public void browse() {
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

	@FXML
	public void initialize() {

		addToList(listCastle, Czocha);
		addToList(listCastle, Chojnik);
		addToList(listCastle, Ksiaz);
		addToList(listCastle, Grodno);
		addToList(listCastle, bolkow);

		addToList(listCave, caveBear);
		addToList(listCave, caveKowary);
		addToList(listCave, caveRiese);
		addToList(listCave, caveZlotyStok);

		addToList(listView, sleza);
		addToList(listView, szrenica);
		addToList(listView, sniezka);
		addToList(listView, snieznik);
		addToList(listView, szczeliniec);

		addToList(listUnesco, hala);
		addToList(listUnesco, jawor);
		addToList(listUnesco, swidnica);

		addToList(listWaterfall, kamienczyk);
		addToList(listWaterfall, szklarka);
		addToList(listWaterfall, podgornej);

		addToList(listAtractions, wang);
		addToList(listAtractions, western);
		addToList(listAtractions, minipark);
		addToList(listAtractions, bledneSkaly);
		addToList(listAtractions, twierdzaKlodzko);
		addToList(listAtractions, twierdzaSrebrnaGora);
		addToList(listAtractions, krzywaWieza);

	}

}
