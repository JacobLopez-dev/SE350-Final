

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

//Add QueenAnn image to map
public class QueenAnnFactory extends ShipBuilder {
	
	public QueenAnnFactory(Pane root) {
		super(root);
	}
	private static Image shipImage = null;
	@Override
	protected PirateShip BuildShip(UpdateStrategy strategy) {
		if (shipImage == null) {
			shipImage = new Image("pirateShip2.png", OceanMap.scale, OceanMap.scale, true, true); //Change image
		}
		ImageView shipImageView = new ImageView(shipImage);
		PirateShip BlackPearl = new QueenAnn(strategy); 
		BlackPearl.shipImageView = shipImageView;
		return BlackPearl;
	}
}