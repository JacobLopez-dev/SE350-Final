

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

//Adds shark image to the instances
public class SharkFactory extends ShipBuilder {
	
	public SharkFactory(Pane root) {
		super(root);
	}
	private static Image shipImage = null;
	@Override
	protected Shark BuildShip(UpdateStrategy strategy) {
		if (shipImage == null) {
			shipImage = new Image("shark.jpg", OceanMap.scale, OceanMap.scale, true, true); //Change image
		}
		ImageView JawsImageView = new ImageView(shipImage);
		Shark shark = new Shark(strategy); 
		shark.shipImageView = JawsImageView;
		return shark;
	}
}