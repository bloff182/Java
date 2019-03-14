package javaFx.Polska.Units;

import javafx.scene.control.Alert;

public class Dialogs {
	
	public static void alertInformation(String header, String content) {
		Alert alertInform = new Alert(Alert.AlertType.INFORMATION);
		alertInform.setTitle("Okno informacyjne");
		alertInform.setHeaderText(header);
		alertInform.setContentText(content);
		alertInform.setResizable(true);
		alertInform.showAndWait();
	}
}
