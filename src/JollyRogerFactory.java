

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

//Uploads FlyingDutchman image
public class JollyRogerFactory extends ShipBuilder {
	
	public JollyRogerFactory(Pane root) {
		super(root);
	}
	private static Image shipImage = null;
	@Override
	protected PirateShip BuildShip(UpdateStrategy strategy) {
		if (shipImage == null) {
			shipImage = new Image("pirateShip.png", OceanMap.scale, OceanMap.scale, true, true);
		}
		ImageView shipImageView = new ImageView(shipImage);
		PirateShip flyingDutchman = new JollyRoger(strategy); 
		flyingDutchman.shipImageView = shipImageView;
		return flyingDutchman;
	}

}
