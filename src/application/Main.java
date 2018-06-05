package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Main extends Application {

	WeaponPane weaponpane = new WeaponPane();

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("The Blacksmith");

		BorderPane border = new BorderPane();
		border.setLeft(WeaponPane.addWeaponPane());
		border.setRight(GatherPane.addGatherPane());
		border.setBottom(ResourcePane.addResourcePane());
		ResourcePane.updateResources(Resources.getIron(), Inventory.getSword(), Inventory.getDagger());


		Scene scene = new Scene(border, 640, 480);
		primaryStage.setScene(scene);

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	
}