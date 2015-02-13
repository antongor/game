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

public class StoneNode extends EmptySceneNode {
	private static final Texture stoneTexture = TextureLoader.loadTextureFromFile("res/stone.png", false, 1);
	private static final double STONE_SIZE = 32;
	private Texture texture;
	private int row;
	private int column;

	@Override
	public void draw() {
		glEnable(GL_TEXTURE_2D);
		texture.bind();
		drawStone(row, column);
		glColor4d(1, 1, 1, 1);
	}
	
	private void drawStone(int i, int j) {
		double tileYDistance = (25d / 32d);
		double yFactor = (double) j * tileYDistance;
		glBegin(GL_QUADS);
			glTexCoord2d(0,0);
			glVertex2d(i * STONE_SIZE, yFactor * STONE_SIZE);
			glTexCoord2d(1,0);
			glVertex2d((i + 1) * STONE_SIZE, yFactor * STONE_SIZE);
			glTexCoord2d(1,1);
			glVertex2d((i + 1) * STONE_SIZE, (yFactor + 1) * STONE_SIZE);
			glTexCoord2d(0,1);
			glVertex2d(i * STONE_SIZE, (yFactor + 1) * STONE_SIZE);
		glEnd();
		
	}

	public StoneNode(int row, int column) {
		this.row = row;
		this.column = column;
		this.texture = stoneTexture;
	}
}
