package main;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import texture.Texture;
import texture.TextureLoader;
import static org.lwjgl.opengl.GL11.*;

public class OldStylePlayer {
	private int x;
	private int y;
	private int z;
	private int speed = 1;
	private final Texture texture;
	private boolean isJumping = false;
	private double zspeed = 0;
	private double gravity = 0.1;
	
	public OldStylePlayer() {
		this.texture = TextureLoader.loadTextureFromFile("res/man.png", false, 1);
	}
	
	public String Serialize() {
		return x + "; " + z + "; " + y;
	}
	
	public static OldStylePlayer deserialize(String position) {
		OldStylePlayer player = new OldStylePlayer();
		String[] parts = position.split("; ");
		int x = Integer.parseInt(parts[0]);
		int z = Integer.parseInt(parts[1]);
		int y = Integer.parseInt(parts[2]);
		player.x = x;
		player.z = z;
		player.y = y;
		return player;
	}

	public void move() {
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			speed = 2;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
			y += speed;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
			x -= speed;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
			y -= speed;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
			x += speed;
		}
		if(x < -Display.getWidth() / 2) {
			x = -Display.getWidth() / 2;
		}
		if(y < -Display.getHeight() / 2) {
			y = -Display.getHeight() / 2;
		}
		if(x > Display.getWidth() / 2) {
			x = Display.getWidth() / 2;
		}
		if(y > Display.getHeight() / 2) {
			y = Display.getHeight() / 2;
		}
		if(isJumping == false && Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			zspeed = 5;
			isJumping = true;
		}
		
		speed = 1;
		
		zspeed -= gravity;
		z += zspeed;
		
		if(z <= 0) {
			z = 0;
			zspeed = 0;
			isJumping = false;
		}
	
	}
	
	public void draw() {
		glEnable(GL_TEXTURE_2D);
		texture.bind();
		glPushMatrix();
		glTranslated(x, y, 0);
		drawPlayer(0, 0);
		glTranslated(0, z, 0);
		glColor4d(1, 1, 1, 1);
		if (isJumping == true) {
			drawPlayer(1, 1);
		}
		else {
			drawPlayer(0, 1);
		}
		glPopMatrix();
	}

	private void drawPlayer(double playerTexturex, double playerTexturey) {
		glBegin(GL_QUADS);
		glTexCoord2d(playerTexturex / 2d, playerTexturey / 2d);
		glVertex2d(-32, -32);
		glTexCoord2d((playerTexturex + 1) / 2d, playerTexturey / 2d);
		glVertex2d(32, -32);
		glTexCoord2d((playerTexturex + 1) / 2d, (playerTexturey + 1) / 2d);
		glVertex2d(32, 32);
		glTexCoord2d(playerTexturex / 2d, (playerTexturey + 1)/ 2d);
		glVertex2d(-32, 32);
		glEnd();
	}
}