package application;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ResourcePane {
	static Text resources = new Text();
	static Text inventory = new Text();

	public static GridPane addResourcePane() {
		GridPane resourceGrid = new GridPane();
		resourceGrid.setAlignment(Pos.CENTER);
		resourceGrid.setHgap(10);
		resourceGrid.setVgap(10);
		resourceGrid.setPadding(new Insets(50, 50, 50, 50));
		resourceGrid.setPickOnBounds(false);
		
		resources.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 30));
		resourceGrid.add(resources, 0, 0, 2, 1);
		
		inventory.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 30));
		resourceGrid.add(inventory, 0, 1, 3, 2);
		
		return resourceGrid;
	}
	
	public static void updateResources(int materials, int sword, int dagger) {
		resources.textProperty().bind(Bindings.createStringBinding(() -> ("Resources: " + materials + " iron")));
		inventory.textProperty().bind(Bindings.createStringBinding(() -> ("Swords: " + sword + " | Daggers: " + dagger)));
	}
}
