

import java.util.Observable;
import java.util.Random;

//Set Random chase strategy to sharks and notifies each time the player ship moves 
public class Shark extends PirateShip {
	
	Random rand = new Random();
	
	public Shark(UpdateStrategy strategy) {
		super(strategy);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		PlayerShip jews = (PlayerShip)arg;
		strategy.update(this, jews, null);
		moverandomly();
	}
	//Generates a number between 0-3 so it moves randomly around the grid
	public void moverandomly() {
		
		int number = rand.nextInt(4);
		if (number == 0) {
			super.goUp();
		}
		if (number == 1) {
			super.goDown();
		}
		if (number == 2) {
			super.goLeft();
		}
		if (number == 3) {
			super.goRight();
		}	
	}
}
