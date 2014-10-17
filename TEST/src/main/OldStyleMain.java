package main;
import java.io.IOException;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Cursor;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluOrtho2D;

public class OldStyleMain {
	public static void main(String[] args) {
		createWindow();
		setupOpenGL();
		OldStylePlayer var = OldStylePlayer.deserialize(Save.load());
		double angle = 0;
		while(!Display.isCloseRequested()) {
			var.move();
			newFrame();
			var.draw();
//			angle -= 0.1;
//			glLineWidth(25);
//			glRotated(angle, 0, 0, 1);
			glBegin(GL_LINES);
			glColor4d(0, 0, 0, 1);
//			glVertex2d(0, 0);
//			glVertex2d(0, 1000);
			
			glEnd();
			if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
				Save.save(var.Serialize());
				System.exit(0);
			}
		}
	}

	private static void newFrame() {
		Display.update();
		Display.sync(60);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glViewport(0, 0, Display.getWidth(), Display.getHeight());
		gluOrtho2D(-Display.getWidth() / 2, Display.getWidth() / 2, -Display.getHeight() / 2, Display.getHeight() / 2);
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT | GL_STENCIL_BUFFER_BIT);
	}

	private static void setupOpenGL() {
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glViewport(0, 0, Display.getWidth(), Display.getHeight());
		gluOrtho2D(0, Display.getWidth(), 0, Display.getHeight());
		glClearColor(1, 1, 1, 1);
		glShadeModel(GL_SMOOTH);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glDisable(GL_TEXTURE_2D);
	}

	private static void createWindow() {
		// TODO Auto-generated method stub
		System.out.print("TEST_launched");
		Display.setResizable(true);
		Display.setTitle("TEST");
		Display.setLocation(0, 0);
		try {
			Display.setDisplayMode(new DisplayMode(640, 480));
			Display.setFullscreen(false);
			Display.create();
			Mouse.create();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}