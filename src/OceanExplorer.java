
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class OceanExplorer extends Application {
	
	boolean[][]islandMap;
	boolean[][]whirlpoolMap;
	boolean[][]treasureMap;
	ArrayList<PirateShip> jaws = new ArrayList<PirateShip>();
	Pane root;
	Scene scene;
	AddShipAbility ship;
	Random Rand = new Random();
	Crash crash;
	FoundTreasure treasure;

	//Creating stage
	@Override
	public void start(Stage mapStage) throws Exception {
		islandMap = OceanMap.getInstance().islands;
		whirlpoolMap = OceanMap.getInstance().whirlpool;
		treasureMap = OceanMap.getInstance().treasure;
		root = new AnchorPane();
		drawMap();
		
		ship = new AddShipAbility(new PlayerShip(0, 0, root));
		
		ShipBuilder flyingDutchmanFactory = new JollyRogerFactory(root);
		PirateShip flyingDutchman = flyingDutchmanFactory.buildShip(7, 7, new RandomChaseStrategy());
		ShipBuilder blackPearlFactory = new QueenAnnFactory(root);
		PirateShip blackPearl = blackPearlFactory.buildShip(11, 11, new ChaseStrategy());
		
		ShipBuilder jaw = new SharkFactory(root);
		for (int i = 0; i < 4; i++) {
			int x = Rand.nextInt(OceanMap.getInstance().getDimensions());
			int y = Rand.nextInt(OceanMap.getInstance().getDimensions());
			while (treasureMap[x][y] == false && islandMap[x][y] == false && whirlpoolMap[x][y] == false) {
				x = Rand.nextInt(OceanMap.getInstance().getDimensions());
				y = Rand.nextInt(OceanMap.getInstance().getDimensions());
			}
			jaws.add(jaw.buildShip(x, y, new RandomChaseStrategy()));
		}
		ArrayList < Ship > obstecals = new ArrayList < Ship > ();
		ship.addObserver(flyingDutchman);
		ship.addObserver(blackPearl);
		
		for (PirateShip j : jaws) {
			ship.addObserver(j);
			obstecals.add(j);
		}
				
		obstecals.add(flyingDutchman);
		obstecals.add(blackPearl);
		
		crash = new Crash(ship.ship, obstecals);
		treasure = new FoundTreasure(ship.ship, OceanMap.getInstance().getTreasure().x , OceanMap.getInstance().getTreasure().y); 
		scene = new Scene(root,500,500);
		
		//Set the Scene, height and width
		mapStage.setTitle("Christopher Columbus sails the Ocean looking for treasure island");
		mapStage.setScene(scene);
		mapStage.show();
		mapStage.setHeight(800);
		mapStage.setWidth(800);
		sailAway();
		
		TextInputDialog dialog = new TextInputDialog("");
		dialog.setTitle("Info");
		dialog.setHeaderText("Welcome!");
		dialog.setContentText("Please enter your name:");

		//Get the users response to inital dialog box
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
		    System.out.println("Player name: " + result.get());
		}
	}
	
	//Key event handler for player ship movement
	private void sailAway() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			
			@Override
			public void handle(KeyEvent key) {
				switch(key.getCode()) {
				case RIGHT:
					ship.goRight();
					break;
				case LEFT:
					ship.goLeft();
					break;
				case UP:
					ship.goUp();
					break;
				case DOWN:
					ship.goDown();
					break;
				default:
					break;
				}
				crash.ifCrashed();
				treasure.ifFoundTreasure();
			}
		} );
	}	
	//Create ocean grid, and places islands, whirlpools and treasure on the grid
	public void drawMap() { 
	for(int x = 0; x < OceanMap.getInstance().getDimensions(); x++) {
			for(int y = 0; y < OceanMap.getInstance().getDimensions(); y++) {
				Rectangle rectan = new Rectangle(x*OceanMap.scale, y*OceanMap.scale, OceanMap.scale, OceanMap.scale);
				rectan.setStroke(Color.BLACK);
				if(islandMap[x][y]) {
					Image image = new Image("island.jpg", OceanMap.scale, OceanMap.scale, true, true);
					ImagePattern imagepattern = new ImagePattern(image);
					rectan.setFill(imagepattern);
				}
				else if (whirlpoolMap[x][y]) {
					Image image = new Image("whirlpool.jpg", OceanMap.scale, OceanMap.scale, true, true);
					ImagePattern imagepattern1 = new ImagePattern(image);
					rectan.setFill(imagepattern1);
				}
				else if (treasureMap[x][y]) {
					Image image = new Image("treasure.jpeg", OceanMap.scale, OceanMap.scale, true, true);
					ImagePattern imagepattern2 = new ImagePattern(image);
					rectan.setFill(imagepattern2);
				}
				else
					rectan.setFill(Color.PALETURQUOISE);
				root.getChildren().add(rectan);
			}
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}