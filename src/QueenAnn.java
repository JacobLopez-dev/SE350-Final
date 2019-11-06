

import java.util.Observable;

//Set ChaseShip Strategy to Queen Ann's revenge and notifies each time the player ship moves 
public class QueenAnn extends PirateShip {

	public QueenAnn(UpdateStrategy strategy) {
		super(strategy);
	}
	
	//Updates Queen Ann of the player ship location
	@Override
	public void update(Observable o, Object arg) {
		PlayerShip ship = (PlayerShip)arg;
		strategy.update(this, ship, null);
	}
}