package map;

import scene.DirtNode;
import scene.EmptySceneNode;
import scene.SandNode;
import scene.Scene;
import scene.SceneNode;
import scene.StoneNode;
import util.ImprovedNoise;

public class Chunk extends EmptySceneNode {
	private static final int CHUNK_SIZE = 64;
	
	private Tile[][] tile = new Tile[CHUNK_SIZE][CHUNK_SIZE];
	
	public Chunk(Scene scene) {
		for(int row = CHUNK_SIZE - 1; row >= 0; row--) {
			System.out.println(row + " / " + CHUNK_SIZE);
			for(int column = CHUNK_SIZE - 1; column >= 0; column--) {
				double noiseValue = ImprovedNoise.noise((double)row / 100d, (double)column / 100d, 0);
				if (noiseValue <= 0) {
					tile[row][column] = new Tile(TileType.sand);
					SandNode sandNode = new SandNode(row, column);
					scene.addRootChild(sandNode);
				}
				if (noiseValue < 0.1) {
					tile[row][column] = new Tile(TileType.dirt);
					DirtNode dirtNode = new DirtNode(row, column);
					scene.addRootChild(dirtNode);
				}
				if (noiseValue > 0.1) {
					tile[row][column] = new Tile(TileType.stone);
					StoneNode stoneNode = new StoneNode(row, column);
					scene.addRootChild(stoneNode);
				}
			}
		}
	}
}