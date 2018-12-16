
import java.io.IOException;
import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import GraphicsObjects.Arcball;
import GraphicsObjects.Utils;
import objects3D.TexCube;
import objects3D.TexCuoid;
import objects3D.TexSphere;
import objects3D.Tree;
import objects3D.YouTube;
import objects3D.Android;
import objects3D.Child;
import objects3D.Cone;
import objects3D.Grid;
import objects3D.Hemisphere;
import objects3D.Human;
import objects3D.Plane;
import objects3D.Roof;
import objects3D.Slides;
import objects3D.Terrain;

//Main windows class controls and creates the 3D virtual world , please do not change this class but edit the other classes to complete the assignment. 
// Main window is built upon the standard Helloworld LWJGL class which I have heavily modified to use as your standard openGL environment. 
// 

// Do not touch this class, I will be making a version of it for your 3rd Assignment 
public class MainWindow {

	private boolean MouseOnepressed = true;
	private boolean dragMode = false;
	private boolean BadAnimation = true;
	private boolean BadAnimation1 = true;
	private boolean Earth = false;
	/** position of pointer */
	float x = 550, y = 240, z = -800;
	/** angle of rotation */
	float rotation = 0;
	/** time at last frame */
	long lastFrame;
	/** frames per second */
	int fps;
	/** last fps time */
	float x1 = x, y1 = y + 200, z1 = z + 400;
	float x2 = x, y2 = y, z2 = z;
	long lastFPS;

	long myDelta = 0; // to use for animation
	float Alpha = 0; // to use for animation
	long StartTime; // beginAnimiation

	Arcball MyArcball = new Arcball();

	boolean DRAWGRID = false;
	boolean waitForKeyrelease = true;
	/** Mouse movement */
	int LastMouseX = -1;
	int LastMouseY = -1;

	float pullX = 0.0f; // arc ball X cord.
	float pullY = 0.0f; // arc ball Y cord.

	int OrthoNumber = 2500; // using this for screen size, making a window of 1200 x 800 so aspect ratio 3:2
							// // do not change this for assignment 3 but you can change everything for your
							// project

	// basic colours
	static float black[] = { 0.0f, 0.0f, 0.0f, 1.0f };
	static float white[] = { 1.0f, 1.0f, 1.0f, 1.0f };

	static float grey[] = { 0.5f, 0.5f, 0.5f, 1.0f };
	static float spot[] = { 0.1f, 0.1f, 0.1f, 0.5f };

	// primary colours
	static float red[] = { 1.0f, 0.0f, 0.0f, 1.0f };
	static float green[] = { 0.0f, 1.0f, 0.0f, 1.0f };
	static float blue[] = { 0.0f, 0.0f, 1.0f, 1.0f };

	// secondary colours
	static float yellow[] = { 1.0f, 1.0f, 0.0f, 1.0f };
	static float magenta[] = { 1.0f, 0.0f, 1.0f, 1.0f };
	static float cyan[] = { 0.0f, 1.0f, 1.0f, 1.0f };

	// other colours
	static float orange[] = { 1.0f, 0.5f, 0.0f, 1.0f, 1.0f };
	static float brown[] = { 0.5f, 0.25f, 0.0f, 1.0f, 1.0f };
	static float dkgreen[] = { 0.0f, 0.5f, 0.0f, 1.0f, 1.0f };
	static float pink[] = { 1.0f, 0.6f, 0.6f, 1.0f, 1.0f };

	// static GLfloat light_position[] = {0.0, 100.0, 100.0, 0.0};

	// support method to aid in converting a java float array into a Floatbuffer
	// which is faster for the opengl layer to process

	public void start() throws IOException {

		StartTime = getTime();
		try {
			Display.setDisplayMode(new DisplayMode(1200, 800));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}

		initGL(); // init OpenGL
		getDelta(); // call once before loop to initialise lastFrame
		lastFPS = getTime(); // call before loop to initialise fps timer
		changeOrth();
		while (!Display.isCloseRequested()) {
			int delta = getDelta();
			update(delta);
			renderGL();
			Display.update();
			Display.sync(120); // cap fps to 120fps
		}

		Display.destroy();
	}

	public void update(int delta) {
		// rotate quad
		// rotation += 0.01f * delta;

		int MouseX = Mouse.getX();
		int MouseY = Mouse.getY();
		int WheelPostion = Mouse.getDWheel();

		boolean MouseButonPressed = Mouse.isButtonDown(0);

		if (MouseButonPressed && !MouseOnepressed) {
			MouseOnepressed = true;
			// System.out.println("Mouse drag mode");
			MyArcball.startBall(MouseX, MouseY, 1200, 800);
			dragMode = true;

		} else if (!MouseButonPressed) {
			// System.out.println("Mouse drag mode end ");
			MouseOnepressed = false;
			dragMode = false;
		}

		if (dragMode) {
			MyArcball.updateBall(MouseX, MouseY, 1200, 800);
		}

		if (WheelPostion > 0) {
			OrthoNumber += 10;

		}

		if (WheelPostion < 0) {
			OrthoNumber -= 10;
			if (OrthoNumber < 610) {
				OrthoNumber = 610;
			}

			// System.out.println("Orth nubmer = " + OrthoNumber);

		}

		/** rest key is R */
		if (Keyboard.isKeyDown(Keyboard.KEY_R))
			MyArcball.reset();

		/* bad animation can be turn on or off using A key) */

//		if (Keyboard.isKeyDown(Keyboard.KEY_A))
//			BadAnimation = !BadAnimation;
//		if (Keyboard.isKeyDown(Keyboard.KEY_D))
//			x += 0.35f * delta;
//
//		if (Keyboard.isKeyDown(Keyboard.KEY_W))
//			y += 0.35f * delta;
//		if (Keyboard.isKeyDown(Keyboard.KEY_S))
//			y -= 0.35f * delta;

//		if (Keyboard.isKeyDown(Keyboard.KEY_Q))
//			rotation += 0.35f * delta;
//		if (Keyboard.isKeyDown(Keyboard.KEY_E)) {
//			Earth = !Earth;
////			System.out.println(Earth);
//		}

		if (waitForKeyrelease) // check done to see if key is released
		{
			if (Keyboard.isKeyDown(Keyboard.KEY_G)) {

				DRAWGRID = !DRAWGRID;
				Keyboard.next();
				if (Keyboard.isKeyDown(Keyboard.KEY_G)) {
					waitForKeyrelease = true;
				} else {
					waitForKeyrelease = false;

				}
			}
		}

		/** to check if key is released */
		if (Keyboard.isKeyDown(Keyboard.KEY_G) == false) {
			waitForKeyrelease = true;
		} else {
			waitForKeyrelease = false;

		}

		// keep quad on the screen
		if (x < -800)
			x = -800;
		if (x > 2100)
			x = 2100;
		if (y < 240)
			y = 240;
		if (y > 800)
			y = 800;
		if (z < -7400)
			z = -7400;
		if (z > 600)
			z = 600;

		updateFPS(); // update FPS Counter

		LastMouseX = MouseX;
		LastMouseY = MouseY;
	}

	/**
	 * Calculate how many milliseconds have passed since last frame.
	 * 
	 * @return milliseconds passed since last frame
	 */
	public int getDelta() {
		long time = getTime();
		int delta = (int) (time - lastFrame);
		lastFrame = time;

		return delta;
	}

	/**
	 * Get the accurate system time
	 * 
	 * @return The system time in milliseconds
	 */
	public long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}

	/**
	 * Calculate the FPS and set it in the title bar
	 */
	public void updateFPS() {
		if (getTime() - lastFPS > 1000) {
			Display.setTitle("FPS: " + fps);
			fps = 0;
			lastFPS += 1000;
		}
		fps++;
	}

	public void initGL() {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		changeOrth();
		MyArcball.startBall(0, 0, 1200, 800);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		FloatBuffer lightPos = BufferUtils.createFloatBuffer(4);
		lightPos.put(10000f).put(1000f).put(1000).put(0).flip();

		FloatBuffer lightPos2 = BufferUtils.createFloatBuffer(4);
		lightPos2.put(0f).put(1000f).put(0).put(0f).flip();

		FloatBuffer lightPos3 = BufferUtils.createFloatBuffer(4);
		lightPos3.put(-10000f).put(1000f).put(1000).put(0).flip();

		FloatBuffer lightPos4 = BufferUtils.createFloatBuffer(4);
		lightPos4.put(0f).put(1000f).put(0f).put(-1000).flip();

		GL11.glLight(GL11.GL_LIGHT0, GL11.GL_POSITION, lightPos);// specify the
																	// position
																	// of the
																	// light
		GL11.glEnable(GL11.GL_LIGHT0); // switch light #0 on // I've setup specific
		// materials so in real light it will look abit strange
		GL11.glLight(GL11.GL_LIGHT0, GL11.GL_DIFFUSE, Utils.ConvertForGL(white));

		GL11.glLight(GL11.GL_LIGHT1, GL11.GL_POSITION, lightPos2); // specify the
																	// position
																	// of the
																	// light
		GL11.glEnable(GL11.GL_LIGHT1); // switch light #0 on
		GL11.glLight(GL11.GL_LIGHT1, GL11.GL_DIFFUSE, Utils.ConvertForGL(white));

		GL11.glLight(GL11.GL_LIGHT2, GL11.GL_POSITION, lightPos3); // specify
																	// the
																	// position
																	// of the
																	// light
		GL11.glEnable(GL11.GL_LIGHT2); // switch light #0 on
		GL11.glLight(GL11.GL_LIGHT2, GL11.GL_DIFFUSE, Utils.ConvertForGL(white));

		GL11.glLight(GL11.GL_LIGHT3, GL11.GL_POSITION, lightPos4); // specify
																	// the
																	// position
																	// of the
																	// light
		GL11.glEnable(GL11.GL_LIGHT3); // switch light #0 on
		GL11.glLight(GL11.GL_LIGHT3, GL11.GL_DIFFUSE, Utils.ConvertForGL(white));

		GL11.glEnable(GL11.GL_LIGHTING); // switch lighting on
		GL11.glEnable(GL11.GL_DEPTH_TEST); // make sure depth buffer is switched
											// on
		GL11.glEnable(GL11.GL_NORMALIZE); // normalize normal vectors for safety
		GL11.glEnable(GL11.GL_COLOR_MATERIAL);

		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		FloatBuffer lightPos5 = BufferUtils.createFloatBuffer(4);
		lightPos5.put(1f).put(1f).put(1f).put(1f).flip();
//		GL11.glEnable(GL11.GL_FOG);
//		   {		      
//		      GL11.glFogi (GL11.GL_FOG_MODE, GL11.GL_EXP2);
//		      GL11.glFog(GL11.GL_FOG_COLOR, lightPos5);
//		      GL11.glFogf (GL11.GL_FOG_DENSITY, 0.5f);
//		      GL11.glFogf (GL11.GL_FOG_START, 5);
//		      GL11.glFogf (GL11.GL_FOG_END, 300);
//		      GL11.glHint (GL11.GL_FOG_HINT, GL11.GL_NICEST);
//		      GL11.glClearColor(1, 1, 1, 1);
//		   }
		try {
			init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // load in texture

	}

	public void changeOrth() {

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
//		GL11.glOrtho(1200 - OrthoNumber, OrthoNumber, (800 - (OrthoNumber * 0.66f)), (OrthoNumber * 0.66f), 100000,
//				-100000);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		FloatBuffer CurrentMatrix = BufferUtils.createFloatBuffer(16);
		GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, CurrentMatrix);
		// if(MouseOnepressed)
		// {
		MyArcball.getMatrix(CurrentMatrix);
		// }
		GL11.glLoadMatrix(CurrentMatrix);
	}
	float youtux=1900,youtuy=220,youtuz=50,youtuRotation=0;
	float childx=130,childy=165.5f,childz=-3650,childRotation=180;
	boolean slide=false;
	/*
	 * You can edit this method to add in your own objects / remember to load in
	 * textures in the INIT method as they take time to load
	 * 
	 */
	public void renderGL() throws IOException {
		changeOrth();
		GLU.gluPerspective(90f, -1.0f, 0.1f, 100000);
		GLU.gluLookAt(x1, y1, z1, x, y, z, 0, 1, 0);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glClearColor(0.49f, 0.89f, 0.98f, 1.0f);

		myDelta = getTime() - StartTime;
		float delta = ((float) myDelta) / 10000;
        System.out.println(delta);
		// code to aid in animation
		float theta = (float) (delta * 2 * Math.PI);
		float thetaDeg = delta * 360;
		float posn_x = 0.5f * (float) Math.cos(theta); // same as your circle code in your notes
		float posn_y = 0.5f * (float) Math.sin(theta);
		/*
		 * This code draws a grid to help you view the human models movement You may
		 * change this code to move the grid around and change its starting angle as you
		 * please
		 */
		if (DRAWGRID) {
			GL11.glPushMatrix();
			GL11.glColor3f(green[0], green[1], green[2]);
			Grid MyGrid = new Grid();
			GL11.glTranslatef(600, 400, 0);
			GL11.glScalef(200f, 200f, 200f);
			MyGrid.DrawGrid();
			GL11.glPopMatrix();
		}
		Android android = new Android();
		YouTube youTube = new YouTube();
		Terrain terrain = new Terrain();
		Plane plane = new Plane();
		TexSphere texSphere = new TexSphere();
		Tree tree = new Tree();
		GL11.glPushMatrix();
		{
			GL11.glColor3f(green[0], green[1], green[2]);
			GL11.glTranslatef(x, y, z);
			GL11.glRotatef(rotation, 0, 1, 0);
			GL11.glScalef(90, 90, 90);

			float rad = (float) (Math.PI * rotation / 180.0f);
			if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
				rotation -= 10;
				x1 = (float) (x + 400 * Math.sin(rad));
				z1 = (float) (z + 400 * Math.cos(rad));
				y1 = y + 200;
				BadAnimation = false;
			} else if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
				rotation += 10;
				x1 = (float) (x + 400 * Math.sin(rad));
				z1 = (float) (z + 400 * Math.cos(rad));
				y1 = y + 200;
				BadAnimation = false;
			} else if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
				z -= 25 * Math.cos(rad);
				x -= 25 * Math.sin(rad);
				if (x != x2 || y != y2 || z != z2) {
					x1 = (float) (x + 400 * Math.sin(rad));
					z1 = (float) (z + 400 * Math.cos(rad));
					y1 = y + 200;
				}
				BadAnimation = false;
			} else if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
				z += 25 * Math.cos(rad);
				x += 25 * Math.sin(rad);
				if (x != x2 || y != y2 || z != z2) {
					x1 = (float) (x + 400 * Math.sin(rad));
					z1 = (float) (z + 400 * Math.cos(rad));
					y1 = y + 200;
				}
				BadAnimation = false;
			} else if (Keyboard.isKeyDown(Keyboard.KEY_R)) {
				x = 550;
				y = 235;
				z = -800;
				rotation = 0;
				x1 = x;
				y1 = y + 200;
				z1 = z + 400;
			} else if (Keyboard.isKeyDown(Keyboard.KEY_Q)) {
				y += 10;
				if (x != x2 || y != y2 || z != z2) {
					x1 = (float) (x + 400 * Math.sin(rad));
					z1 = (float) (z + 400 * Math.cos(rad));
					y1 = y + 200;
				}
				BadAnimation = false;
			} else if (Keyboard.isKeyDown(Keyboard.KEY_E)) {
				y -= 10;
				if (x != x2 || y != y2 || z != z2) {
					x1 = (float) (x + 400 * Math.sin(rad));
					z1 = (float) (z + 400 * Math.cos(rad));
					y1 = y + 200;
				}
				BadAnimation = false;
			} else {
				BadAnimation = true;
			}
			x2 = x;
			y2 = y;
			z2 = z;
			android.DrawAndroid(7 * delta, !BadAnimation);
		}
		GL11.glPopMatrix();
		GL11.glPushMatrix();
		{
			GL11.glColor3f(orange[0], orange[1], spot[2]);
			GL11.glTranslatef(500, 1355, -700);
			GL11.glScalef(50, 50, 50);
			GL11.glTranslatef(40 * -posn_x, -10, 150 * -posn_y-100);
			GL11.glRotatef(-thetaDeg, 0.0f, 1.0f, 0.0f);
			plane.DrawPlane(delta, !BadAnimation);
		}
		GL11.glPopMatrix();
		GL11.glPushMatrix();
		{
			GL11.glColor3f(brown[0], brown[1], brown[2]);
			GL11.glTranslatef(youtux, youtuy, youtuz);
			GL11.glScalef(70, 70, 70);
			if(delta%6>=0&&delta%6<2.5) {
				youtuz-=20;
			}
			else if(delta%6>=2.5&&delta%6<3) {
				GL11.glRotatef(90, 0, 1, 0);
				youtux-=15;
			}
			else if(delta%6>=3&&delta%6<5.5) {
				GL11.glRotatef(180, 0, 1, 0);
				youtuz+=20;
			}
			else if(delta%6>=5.5&&delta%6<6) {
				GL11.glRotatef(270, 0, 1, 0);
				youtux+=15;
			}
			youTube.DrawYouTube(10 * delta, BadAnimation1, "youtube.jpg");
		}
		GL11.glPopMatrix();
		GL11.glPushMatrix();
		{
			Color.white.bind();
			GL11.glTranslatef(630, 90, -1380);
			GL11.glRotatef(90f, 1, 0, 0);
			GL11.glScalef(1000, 1000, 1000);
			terrain.DrawTerrain1(3f, 4f, "grassy3.png");
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			Color.white.bind();
			GL11.glTranslatef(630, 90, -5380);
			GL11.glRotatef(90f, 1, 0, 0);
			GL11.glScalef(1000, 1000, 1000);
			terrain.DrawTerrain1(3f, 4f, "grassy3.png");
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			Color.white.bind();
			GL11.glTranslatef(630, 540, 620);
			GL11.glScalef(600, 300, 400);
			terrain.DrawTerrain1(3f, 3f, "google.jpg");
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			Color.white.bind();
			GL11.glTranslatef(-530, -120, -4450);
			GL11.glRotatef(90f, 1, 0, 0);
			GL11.glRotatef(-90f, 0, 0, 1);
			GL11.glScalef(350, 350, 350);
			texSphere.DrawTexsphere(0.5f, 25, 25, "2018.png");
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			GL11.glTranslatef(-130, 165, 0);
			GL11.glRotatef(-90f, 1, 0, 0);
			GL11.glScalef(150, 150, 150);
			tree.DrawTree();
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			GL11.glTranslatef(-370, 165, -700);
			GL11.glRotatef(-90f, 1, 0, 0);
			GL11.glScalef(150, 150, 150);
			tree.DrawTree();
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			GL11.glTranslatef(-250, 165, -2000);
			GL11.glRotatef(-90f, 1, 0, 0);
			GL11.glScalef(150, 150, 150);
			tree.DrawTree();
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			GL11.glTranslatef(930, 165, 0);
			GL11.glRotatef(-90f, 1, 0, 0);
			GL11.glScalef(150, 150, 150);
			tree.DrawTree();
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			GL11.glTranslatef(1030, 165, -700);
			GL11.glRotatef(-90f, 1, 0, 0);
			GL11.glScalef(150, 150, 150);
			tree.DrawTree();
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			GL11.glTranslatef(1500, 165, -2000);
			GL11.glRotatef(-90f, 1, 0, 0);
			GL11.glScalef(150, 150, 150);
			tree.DrawTree();
			GL11.glPopMatrix();
		}

		GL11.glPushMatrix();
		{
			GL11.glTranslatef(130, 165, -1000);
			GL11.glRotatef(-90f, 1, 0, 0);
			GL11.glScalef(150, 150, 150);
			tree.DrawTree();
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			GL11.glTranslatef(-170, 165, -1700);
			GL11.glRotatef(-90f, 1, 0, 0);
			GL11.glScalef(150, 150, 150);
			tree.DrawTree();
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			GL11.glTranslatef(-50, 165, -3000);
			GL11.glRotatef(-90f, 1, 0, 0);
			GL11.glScalef(150, 150, 150);
			tree.DrawTree();
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			GL11.glTranslatef(1130, 165, -1000);
			GL11.glRotatef(-90f, 1, 0, 0);
			GL11.glScalef(150, 150, 150);
			tree.DrawTree();
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			GL11.glTranslatef(1230, 165, -1700);
			GL11.glRotatef(-90f, 1, 0, 0);
			GL11.glScalef(150, 150, 150);
			tree.DrawTree();
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			GL11.glTranslatef(1700, 165, -3000);
			GL11.glRotatef(-90f, 1, 0, 0);
			GL11.glScalef(150, 150, 150);
			tree.DrawTree();
			GL11.glPopMatrix();
		}

		GL11.glPushMatrix();
		{
			GL11.glTranslatef(30, 165, -4000);
			GL11.glRotatef(-90f, 1, 0, 0);
			GL11.glScalef(150, 150, 150);
			tree.DrawTree();
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			GL11.glTranslatef(-170, 165, -4700);
			GL11.glRotatef(-90f, 1, 0, 0);
			GL11.glScalef(150, 150, 150);
			tree.DrawTree();
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			GL11.glTranslatef(-50, 165, -6000);
			GL11.glRotatef(-90f, 1, 0, 0);
			GL11.glScalef(150, 150, 150);
			tree.DrawTree();
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			GL11.glTranslatef(1130, 165, -4000);
			GL11.glRotatef(-90f, 1, 0, 0);
			GL11.glScalef(150, 150, 150);
			tree.DrawTree();
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			GL11.glTranslatef(1230, 165, -4700);
			GL11.glRotatef(-90f, 1, 0, 0);
			GL11.glScalef(150, 150, 150);
			tree.DrawTree();
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			GL11.glTranslatef(1700, 165, -6000);
			GL11.glRotatef(-90f, 1, 0, 0);
			GL11.glScalef(150, 150, 150);
			tree.DrawTree();
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			GL11.glTranslatef(330, 165, -5000);
			GL11.glRotatef(-90f, 1, 0, 0);
			GL11.glScalef(150, 150, 150);
			tree.DrawTree();
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			GL11.glTranslatef(170, 165, -5700);
			GL11.glRotatef(-90f, 1, 0, 0);
			GL11.glScalef(150, 150, 150);
			tree.DrawTree();
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			GL11.glTranslatef(150, 165, -7000);
			GL11.glRotatef(-90f, 1, 0, 0);
			GL11.glScalef(150, 150, 150);
			tree.DrawTree();
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			GL11.glTranslatef(1230, 165, -5000);
			GL11.glRotatef(-90f, 1, 0, 0);
			GL11.glScalef(150, 150, 150);
			tree.DrawTree();
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			GL11.glTranslatef(1330, 165, -5700);
			GL11.glRotatef(-90f, 1, 0, 0);
			GL11.glScalef(150, 150, 150);
			tree.DrawTree();
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			GL11.glTranslatef(1800, 165, -7000);
			GL11.glRotatef(-90f, 1, 0, 0);
			GL11.glScalef(150, 150, 150);
			tree.DrawTree();
			GL11.glPopMatrix();
		}
		Slides slides = new Slides();
		GL11.glPushMatrix();
		{
			GL11.glColor3f(red[0], red[1], red[2]);
			GL11.glTranslatef(-350, 202.5f, -3650);
			GL11.glRotatef(-90f, 1, 0, 0);
			GL11.glScalef(150, 150, 150);
			slides.drawSlides();
		}
		GL11.glPopMatrix();
		Child child = new Child();
		GL11.glPushMatrix();
		{
			GL11.glColor3f(cyan[0], cyan[1], cyan[2]);
			GL11.glTranslatef(childx, childy, childz);
			GL11.glRotatef(-90f, 0, 1, 0);
			GL11.glScalef(50, 50, 50);
			if(delta%2.65>=0&&delta%2.65<0.5) {
				slide = false;
				childx-=5;
				childy+=3.75;
			}
			else if(delta%2.65>=0.5&&delta%2.65<0.75) {
				slide = false;
				childx-=5;
			}
			else if(delta%2.65>=0.75&&delta%2.65<1) {
				slide = false;
				GL11.glRotatef(90, 0, 1, 0);
				childz+=5;
			}
			else if(delta%2.65>=1&&delta%2.65<1.15) {
				GL11.glRotatef(90, 0, 1, 0);
				slide = true;
				childz+=50/3;
				childy-=12.5;
			}else if(delta%2.65>=1.15&&delta%2.65<1.9) {
				slide = false;
				GL11.glRotatef(180, 0, 1, 0);
				childx+=5;
			}
			else if(delta%2.65>=1.9&&delta%2.65<2.65) {
				slide = false;
				GL11.glRotatef(270, 0, 1, 0);
				childz-=5;				
			}
			child.DrawChild(13*delta, BadAnimation1, slide);
		}
		GL11.glPopMatrix();
	}

	public static void main(String[] argv) throws IOException {
		MainWindow hello = new MainWindow();
		hello.start();
	}

	Texture texture;

	/*
	 * Any additional textures for your assignment should be written in here. Make a
	 * new texture variable for each one so they can be loaded in at the beginning
	 */
	public void init() throws IOException {

//		texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/earthspace.png"));
		System.out.println("Texture loaded okay ");
	}
}
