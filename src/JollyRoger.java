

import java.util.Observable;

//Set Random chase Strategy to Jolly Roger and notifies each time the player ship moves 
public class JollyRoger extends PirateShip {

	public JollyRoger(UpdateStrategy strategy) {
		super(strategy);
	}

	@Override
	public void update(Observable o, Object arg) {
		PlayerShip ship = (PlayerShip)arg;
		strategy.update(this, ship, null);
	}
}
