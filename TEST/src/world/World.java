package world;

import java.util.ArrayList;

public class World {
	private ArrayList<GameObject> entity;
	
	public World() {
		entity = new ArrayList<GameObject>();
	}
	
	public void update() {
		for(GameObject object : entity) {
			object.update();
		}
	}
}
