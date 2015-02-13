package main;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluOrtho2D;

import java.util.ArrayList;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import scene.DirtNode;
import scene.Scene;
import world.World;

public class Main {
	
	private World world;
	private Scene scene;

	public Main() {
		createWindow();
		setupOpenGL();
		this.scene = new Scene();
		this.world = new World(scene);
	}
	
	
	
	private void run() {
		System.out.println("run()");
		while(!Display.isCloseRequested()) {
			newFrame();
			scene.draw();
		}
	}

	private static void newFrame() {
		Display.update();
		Display.sync(60);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glViewport(0, 0, Display.getWidth(), Display.getHeight());
		gluOrtho2D(0, Display.getWidth(), 0, Display.getHeight());
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
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}


}