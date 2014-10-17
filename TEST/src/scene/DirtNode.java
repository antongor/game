package scene;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor4d;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTexCoord2d;
import static org.lwjgl.opengl.GL11.glTranslated;
import static org.lwjgl.opengl.GL11.glVertex2d;
import texture.Texture;
import texture.TextureLoader;

public class DirtNode extends EmptySceneNode {
	private static final double DIRT_SIZE = 16;
	private Texture texture;

	@Override
	public void draw() {
		glEnable(GL_TEXTURE_2D);
		texture.bind();
		drawDirt(0, 0);
		glColor4d(1, 1, 1, 1);
	}
	
	private void drawDirt(int i, int j) {
		glBegin(GL_QUADS);
		glTexCoord2d(0,0);
		glVertex2d(-DIRT_SIZE, -DIRT_SIZE);
		glTexCoord2d(1,0);
		glVertex2d(DIRT_SIZE, -DIRT_SIZE);
		glTexCoord2d(1,1);
		glVertex2d(DIRT_SIZE, DIRT_SIZE);
		glTexCoord2d(0,1);
		glVertex2d(-DIRT_SIZE, DIRT_SIZE);
		glEnd();
		
	}

	public DirtNode() {
		this.texture = TextureLoader.loadTextureFromFile("res/dirt.png", false, 1);
	}
}
