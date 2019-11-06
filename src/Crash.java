

import java.util.List;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

//Checks if player ship crashed into another ship, shark or whirlpool
public class Crash {
	
	private Ship playerShip;
	private List < Ship > ships;
	
	
	public Crash (Ship columbus, List < Ship > obstacles) {
		playerShip = columbus;
		ships = obstacles;
	}
	
	//Prints a message in case of player ship has crashed
	public void ifCrashed() {
		for (Ship obstacles : ships) {
			if (playerShip.getX() == obstacles.getX() && playerShip.getY() == obstacles.getY()) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information");
				alert.setHeaderText("Uh Oh! Columbus's ship has crashed");
				alert.setContentText("You Lost!");
				alert.showAndWait();
				Platform.exit();
			}
		}
	}
}
