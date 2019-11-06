

import java.util.Random;

//Creates the random chase strategy, updates the pirate ship, player ship and shark ship when it is used
public class RandomChaseStrategy implements UpdateStrategy {
	
	Random rand = new Random();
	
	public void update(PirateShip pShip, PlayerShip ship, Shark shark) {
		
		int number = rand.nextInt(4);  //Generate a number between 0-3
		if (number == 0) {
			pShip.goUp();
		}
		if (number == 1) {
			pShip.goDown();
		}
		if (number == 2) {
			pShip.goLeft();
		}
		if (number == 3) {
			pShip.goRight();
		}
	}
}


