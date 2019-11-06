

import java.util.Observer;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

//Implements the Player ship to move on the grid in different directions
public class PlayerShip extends Ship {
	
	ObservableShip observable = new ObservableShip();
	
	public PlayerShip() { 	
	}
	private static Image shipImage = null;
	//Loads CC ship to the pane
	public PlayerShip(float x, float y, Pane root) {
		if (shipImage == null) {
			shipImage = new Image("ship.png", OceanMap.scale, OceanMap.scale, true, true);	 
			}
		super.shipImageView = new ImageView(shipImage);
		super.setX(0);
		super.setY(0);
		root.getChildren().add(shipImageView);
		}
	
	//Each time the player moves it notifies the observers 
	public void goRight() {
		super.goRight();
		observable.setChanged();
		observable.notifyObservers(this);
		}
	public void goLeft() {
		super.goLeft();
		observable.setChanged();
		observable.notifyObservers(this);
		}
	public void goUp() {
		super.goUp();
		observable.setChanged();
		observable.notifyObservers(this);
		}
	public void goDown() {
		super.goDown();
		observable.setChanged();
		observable.notifyObservers(this);
		}
	public void addObserver(Observer ob) {
		observable.addObserver(ob);
		}
	}
