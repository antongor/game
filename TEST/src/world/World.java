package world;

import java.util.ArrayList;

import scene.Scene;
import map.Map;

public class World {
	private ArrayList<GameObject> entity;
	private Map map;
	
	public World(Scene scene) {
		entity = new ArrayList<GameObject>();
		map = new Map(scene);
	}
	
	public void update() {
		for(GameObject object : entity) {
			object.update();
		}
	}
}
