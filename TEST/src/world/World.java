package world;

import java.util.ArrayList;

import map.Map;

public class World {
	private ArrayList<GameObject> entity;
	private Map map = new Map();
	
	public World() {
		entity = new ArrayList<GameObject>();
	}
	
	public void update() {
		for(GameObject object : entity) {
			object.update();
		}
	}
}
