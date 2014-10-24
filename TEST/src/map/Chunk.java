package map;

public class Chunk {
	private static final int CHUNK_SIZE = 512;
	
	private Tile[][] tile = new Tile[CHUNK_SIZE][CHUNK_SIZE];
	
	public Chunk() {
		for(int row = 0; row < CHUNK_SIZE; row++) {
			for(int column = 0; column < CHUNK_SIZE; column++) {
				tile[row][column] = new Tile(TileType.dirt);
			}
		}
	}
}