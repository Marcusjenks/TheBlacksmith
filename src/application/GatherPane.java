package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class GatherPane {
	
	final static Text actiontarget = new Text();
	
	public static GridPane addGatherPane() {
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

		gatherGrid.add(actiontarget, 0, 6);

		gatherMaterial(gatherIron);

		return gatherGrid;
	}
	
	public static void gatherMaterial(Button material) {
		material.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				actiontarget.setFill(Color.BLACK);
				actiontarget.setText("You gathered some iron!");
				Resources.gatherIron();
				ResourcePane.updateResources(Resources.getIron(), Inventory.getSword(), Inventory.getDagger());
			}
		});
		
	}

}
