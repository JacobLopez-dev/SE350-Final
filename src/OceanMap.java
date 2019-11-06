
import java.util.Random;

//Set all the objects on the grid
public class OceanMap {
	
	boolean[][] islands;
	boolean[][] whirlpool;
	boolean[][] treasure;
	boolean[][] jaws;
	int dimensions =25;
	int islandNumber;
	int whirlpoolNumber;
	Random random = new Random();
	Point shipLocation;
	Point treasureLocation;
	public static final int scale = 35;
	private int treasureNumber;
	private static OceanMap instance;
	private OceanMap(int dimensions, int islandNumber, int whirlpoolNumber, int treasureNumber) {
		
		islands = new boolean[dimensions][dimensions];
		whirlpool = new boolean[dimensions][dimensions];
		treasure = new boolean[dimensions][dimensions];
		this.dimensions = dimensions;
		this.islandNumber = islandNumber;
		this.whirlpoolNumber = whirlpoolNumber;
		this.treasureNumber = treasureNumber;
		setIslands();
		setWhirlpool();
		setTreasureIsland();
	}
	public static OceanMap getInstance() {
		if (instance == null) {
			instance = new OceanMap(20, 20, 3, 1);
		}
		return instance;
	}
	//Place the whirlpool randomly on the map
	private void setWhirlpool() {
		int whirlpoolToSet = whirlpoolNumber;
		while (whirlpoolToSet > 0) {
			int x = random.nextInt(dimensions);
			int y = random.nextInt(dimensions);
			if (whirlpool[x][y] == false && islands[x][y] == false) {
				whirlpool[x][y] = true;
				whirlpoolToSet--;
			}
		}
	}
	//Place the islands randomly on the map
	private void setIslands() {
		int islandsToSet = islandNumber;
		while (islandsToSet > 0) {
			int x = random.nextInt(dimensions);
			int y = random.nextInt(dimensions);
			if (islands[x][y] == false) {
				islands[x][y] = true;
				islandsToSet--;
			}
		}
	}
	//Place the treasue randomly on the map
	private void setTreasureIsland() {
		int treasureIslandToSet = treasureNumber;
		while (treasureIslandToSet > 0) {
			int x = random.nextInt(dimensions);
			int y = random.nextInt(dimensions);
			treasureLocation = new Point(x, y);
			if (treasure[x][y] == false && islands[x][y] == false && whirlpool[x][y] == false) {
				treasure[x][y] = true;
				treasureIslandToSet--;
			}
		}
	}
	//Return the generated ship
	public Point getShipLocation() {
		return shipLocation;
	}
	
	public Point getTreasure() {
		return treasureLocation;
	}
	//Return the generated map
	public boolean[][] getmap() {
		return islands;
	}
	//Return the grid dimensions
	public int getDimensions() {
		return dimensions;
	}
	//Checks to see that the ship is indeed on the ocean
	public boolean isOcean(int d, int e) {
		if (!islands[d][e])
			return true;
		else
			return false;
	}
}