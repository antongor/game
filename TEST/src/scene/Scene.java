package scene;

import java.util.ArrayList;

public class Scene {
	private SceneNode rootNode = new EmptySceneNode();
	
	public void draw() {
		drawNode(rootNode);
	}

	private void drawNode(SceneNode node) {
		node.draw();
		ArrayList<SceneNode> children = node.getChildren();
		for(SceneNode child : children) {
			drawNode(child);
		}
	}
	
	public void addRootChild(SceneNode node) {
		rootNode.addChild(node);
	}
}
