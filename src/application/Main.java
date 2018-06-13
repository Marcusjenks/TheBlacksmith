package application;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
	
	Stage stage = new Stage();
	ChoiceBox choiceBox = new ChoiceBox(FXCollections.observableArrayList("Crafting", "Town"));
	

	@Override
	public void start(Stage primaryStage) {
		crafting(stage);
		choiceBox.setValue("Crafting");

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void update(String stageSelect) {
		stage.close();
		switch (stageSelect) {
		case "Crafting":
			crafting(stage);
			break;
		case "Town":
			town(stage);
			break;
		default:
			break;

		}
	}

	public void crafting(Stage craftingScreen) {
		craftingScreen.setTitle("The Blacksmith");

		BorderPane border = new BorderPane();
		border.setTop(changeScene());
		border.setLeft(WeaponPane.addWeaponPane());
		border.setRight(GatherPane.addGatherPane());
		border.setBottom(ResourcePane.addResourcePane());
		ResourcePane.updateResources(Resources.getIron(), Inventory.getSword(), Inventory.getDagger());

		Scene scene = new Scene(border);
		craftingScreen.setScene(scene);

		craftingScreen.show();

	}

	public void town(Stage townScreen) {
		townScreen.setTitle("The Blacksmith");
		
		BorderPane border = new BorderPane();
		border.setTop(changeScene());
		border.setLeft(Town.addStorePane());
		border.setBottom(ResourcePane.addResourcePane());
		ResourcePane.updateResources(Resources.getIron(), Inventory.getSword(), Inventory.getDagger());

		
		Scene scene = new Scene(border);
		townScreen.setScene(scene);
		townScreen.show();
	}

	GridPane changeScene() {
		GridPane change = new GridPane();
		change.setAlignment(Pos.TOP_RIGHT);
		change.setHgap(10);
		change.setVgap(10);
		change.setPadding(new Insets(50, 50, 50, 50));
		change.setPickOnBounds(false);

		choiceBox.getSelectionModel().selectedItemProperty()
				.addListener((ChangeListener<String>) (ov, value, new_value) -> update(new_value));
		change.add(choiceBox, 0, 0);

		return change;

	}

}