package scene;

import java.util.ArrayList;

public interface SceneNode {
	public ArrayList<SceneNode> getChildren();
	public void addChild(SceneNode node);
	public void removeChild(SceneNode node);
	public void draw();
}