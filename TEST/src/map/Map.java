package map;

import scene.Scene;

public class Map {
	public Map(Scene scene) {
		chunk = new Chunk(scene);
	}

	private Chunk chunk;
}