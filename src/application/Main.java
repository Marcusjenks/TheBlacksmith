package application;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Main extends Application {

	Resources materials = new Resources(0);

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("The Blacksmith");

		BorderPane border = new BorderPane();
		border.setLeft(addWeaponPane());
		border.setRight(addGatherPane());

		StackPane root = new StackPane();

		GridPane resourceGrid = new GridPane();
		resourceGrid.setAlignment(Pos.BOTTOM_CENTER);
		resourceGrid.setHgap(10);
		resourceGrid.setVgap(10);
		resourceGrid.setPadding(new Insets(50, 50, 50, 50));
		resourceGrid.setPickOnBounds(false);

		Text scenetitle = new Text();
		scenetitle.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 30));
		resourceGrid.add(scenetitle, 0, 0, 2, 1);
		scenetitle.textProperty()
				.bind(Bindings.createStringBinding(() -> ("Resources : " + materials.getIron() + " iron")));

		final Text actiontarget = new Text();
		// weaponGrid.add(actiontarget, 1, 6);

		// craftSword.setOnAction(new EventHandler<ActionEvent>() {
		//
		// @Override
		// public void handle(ActionEvent e) {
		// actiontarget.setFill(Color.BLACK);
		// if(materials.getIron() > 0) {
		// actiontarget.setText("You crafted a sword!");
		// materials.useIron();;
		// scenetitle.textProperty().bind(Bindings.createStringBinding(() -> ("Resources
		// : " + materials.getIron() + " iron")));
		// } else if (materials.getIron() <= 0){
		// actiontarget.setText("Not enough supplies!");
		// }
		// }
		// });

		// gatherIron.setOnAction(new EventHandler<ActionEvent>() {
		//
		// @Override
		// public void handle(ActionEvent e) {
		// actiontarget.setFill(Color.BLACK);
		// actiontarget.setText("You gathered some iron!");
		// materials.gatherIron();
		// scenetitle.textProperty().bind(Bindings.createStringBinding(() -> ("Resources
		// : " + materials.getIron() + " iron")));
		// }
		// });
		root.getChildren().add(resourceGrid);

		Scene scene = new Scene(border);
		primaryStage.setScene(scene);

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	private GridPane addWeaponPane() {
		GridPane weaponGrid = new GridPane();
		weaponGrid.setAlignment(Pos.TOP_RIGHT);
		weaponGrid.setHgap(10);
		weaponGrid.setVgap(10);
		weaponGrid.setPadding(new Insets(50, 50, 50, 50));
		weaponGrid.setPickOnBounds(false);
		weaponGrid.getColumnConstraints().add(new ColumnConstraints(125));

		Text forge = new Text("Forge Weapon:");
		forge.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
		forge.setTextAlignment(TextAlignment.CENTER);
		weaponGrid.add(forge, 0, 1);
		GridPane.setHalignment(forge, HPos.RIGHT);

		Button craftSword = new Button("Sword");
		HBox cSword = new HBox(10);
		cSword.setAlignment(Pos.BASELINE_LEFT);
		cSword.getChildren().add(craftSword);
		weaponGrid.add(cSword, 1, 1);

		Button craftDagger = new Button("Dagger");
		HBox cDagger = new HBox(10);
		cDagger.setAlignment(Pos.BASELINE_LEFT);
		cDagger.getChildren().add(craftDagger);
		weaponGrid.add(cDagger, 1, 2);

		return weaponGrid;

	}

	private GridPane addGatherPane() {
		GridPane gatherGrid = new GridPane();
		gatherGrid.setAlignment(Pos.BASELINE_LEFT);
		gatherGrid.setHgap(10);
		gatherGrid.setVgap(10);
		gatherGrid.setPadding(new Insets(50, 50, 50, 50));
		gatherGrid.setPickOnBounds(false);

		Text gather = new Text("Gather Materials:");
		gather.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
		gather.setTextAlignment(TextAlignment.CENTER);
		gatherGrid.add(gather, 0, 0);
		GridPane.setHalignment(gather, HPos.RIGHT);

		Button gatherIron = new Button("Gather Iron");
		HBox gIron = new HBox(10);
		gIron.setAlignment(Pos.BASELINE_LEFT);
		gIron.getChildren().add(gatherIron);
		gatherGrid.add(gIron, 1, 0);

		return gatherGrid;
	}
}