package scene;

import java.util.ArrayList;

import world.GameObject;

public class EmptySceneNode implements SceneNode {

	private ArrayList<SceneNode> children;
	
	public EmptySceneNode() {
		children = new ArrayList<SceneNode>();
	}
	
	@Override
	public ArrayList<SceneNode> getChildren() {
		return children;
	}

	@Override
	public void addChild(SceneNode node) {
		children.add(node);
	}

	@Override
	public void removeChild(SceneNode node) {
		children.remove(node);
	}

	@Override
	public void draw() {
	}
	
}
