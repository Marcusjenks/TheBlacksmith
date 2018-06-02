package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class WeaponPane {

	final static Text actiontarget = new Text();

	public static GridPane addWeaponPane() {
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

		weaponGrid.add(actiontarget, 0, 6);

		craftWeapon(craftSword);
		craftWeapon(craftDagger);

		return weaponGrid;

	}

	public static void craftWeapon(Button weapon) {
			weapon.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent e) {
					actiontarget.setFill(Color.BLACK);
					if (Resources.iron > 0) {
						actiontarget.setText("You crafted a " + weapon.getText() + "!");
						Resources.useIron();
						ResourcePane.updateResources(Resources.getIron());
					} else if (Resources.iron <= 0) {
						actiontarget.setText("Not enough supplies!");
					}
				}
			});
			}

}
