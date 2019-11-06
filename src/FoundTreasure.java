

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

//Checks if player ship has found the treasure island
public class FoundTreasure {
	
	private Ship playerShip;
	int x;
	int y;
	
	
	public FoundTreasure (Ship columbus, int x, int y) {
		playerShip = columbus;
		this.x = x;
		this.y = y;
	}
	
	//Prints a message in case of player ship has found the treasure
	public void ifFoundTreasure() {
			if (playerShip.getX() == x && playerShip.getY() == y) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information");
				alert.setHeaderText("Woo-Hoo! Columbus has found the treasure island");
				alert.setContentText("You Won!");
				alert.showAndWait();
				Platform.exit();
				
			}

	}
	public void ifwhirlpoolHit() {
		if (playerShip.getX() == x && playerShip.getY() == y) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText("Woo-Hoo! Columbus has found the treasure island");
			alert.setContentText("GKIBFKJGDBSKJFNDS");
			alert.showAndWait();
			Platform.exit();
		}
	}
	
}