package application;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Town {
	
	public static GridPane addStorePane() {
		GridPane storeGrid = new GridPane();
		storeGrid.setAlignment(Pos.TOP_RIGHT);
		storeGrid.setHgap(10);
		storeGrid.setVgap(10);
		storeGrid.setPadding(new Insets(50, 50, 50, 50));
		storeGrid.setPickOnBounds(false);
		storeGrid.getColumnConstraints().add(new ColumnConstraints(125));
		
		
		Text sell = new Text("Sell Weapons:");
		sell.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
		sell.setTextAlignment(TextAlignment.CENTER);
		storeGrid.add(sell, 0, 1);
		GridPane.setHalignment(sell, HPos.RIGHT);
		return storeGrid;
	}

}
