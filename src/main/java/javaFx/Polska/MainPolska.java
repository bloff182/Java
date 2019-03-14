package javaFx.Polska;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainPolska extends Application{

	public static void main(String[] args) {
		Application.launch(args);

	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MainWindow.fxml"));
		StackPane pane = loader.load();
		
		Scene scene = new Scene(pane, 1366, 700);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Mapa interaktywna Polski");
		primaryStage.show();
		
	}

}
