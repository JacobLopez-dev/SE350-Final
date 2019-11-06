

//This is the primary chase strategy pirate ships and sharks are notified when the player ship moves
public class ChaseStrategy implements UpdateStrategy {
	
	public void update(PirateShip pShip, PlayerShip ship, Shark shark) {
		if(pShip.getX() > ship.getX()) {
			pShip.goLeft();
		}
		else if (pShip.getX() < ship.getX()) {
			pShip.goRight();
		}
		else if (pShip.getY() > ship.getY()) {
			pShip.goUp();
		}
		else if (pShip.getY() < ship.getY()) {
			pShip.goDown();
		}
	}
}
