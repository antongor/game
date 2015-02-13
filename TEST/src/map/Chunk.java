package map;

import scene.DirtNode;
import scene.EmptySceneNode;
import scene.Scene;

public class Chunk extends EmptySceneNode {
	private static final int CHUNK_SIZE = 64;
	
	private Tile[][] tile = new Tile[CHUNK_SIZE][CHUNK_SIZE];
	
	public Chunk(Scene scene) {
		for(int row = CHUNK_SIZE - 1; row >= 0; row--) {
			System.out.println(row + " / " + CHUNK_SIZE);
			for(int column = CHUNK_SIZE - 1; column >= 0; column--) {
				tile[row][column] = new Tile(TileType.dirt);
				DirtNode dirtNode = new DirtNode(row, column);
				scene.addRootChild(dirtNode);
			}
		}
	}
}