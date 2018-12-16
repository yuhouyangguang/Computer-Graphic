package objects3D;

import org.lwjgl.opengl.GL11;

public class Slides {
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

	public Slides() {

	}

	public void drawSlides() {
		Cuoid cuoid = new Cuoid();
		Roof roof = new Roof();
		Cylinder cylinder = new Cylinder();
		Cone cone = new Cone();
		GL11.glPushMatrix();
		{
			 cuoid.DrawCuoid(2f, 2f, 1.5f);
				GL11.glPushMatrix();
				{
					GL11.glColor3f(brown[0], brown[1], brown[2]);
					GL11.glTranslatef(1f,-0.5f, -0.75f);
					roof.DrawRoof(2, 1, 1.5f);
				}
				GL11.glPopMatrix();
				GL11.glPushMatrix();
				{
					GL11.glColor3f(blue[0], blue[1], blue[2]);
					GL11.glTranslatef(-0.5f,-1f, -0.75f);
					GL11.glRotatef(-90, 0, 0, 1);
					roof.DrawRoof(2, 1, 1.5f);
				}
				GL11.glPopMatrix();
				GL11.glPushMatrix();
				{
					GL11.glColor3f(magenta[0], magenta[1], magenta[2]);
					GL11.glTranslatef(-0.75f,0.75f, 0.75f);
					GL11.glRotatef(-90, 0, 0, 1);
					cylinder.DrawCylinder(0.075f, 1.5f, 18);
				}
				GL11.glPopMatrix();
				GL11.glPushMatrix();
				{
					GL11.glColor3f(magenta[0], magenta[1], magenta[2]);
					GL11.glTranslatef(0.75f,0.75f, 0.75f);
					GL11.glRotatef(-90, 0, 0, 1);
					cylinder.DrawCylinder(0.075f, 1.5f, 18);
				}
				GL11.glPopMatrix();
				GL11.glPushMatrix();
				{
					GL11.glColor3f(magenta[0], magenta[1], magenta[2]);
					GL11.glTranslatef(0.75f,-0.75f, 0.75f);
					GL11.glRotatef(-90, 0, 0, 1);
					cylinder.DrawCylinder(0.075f, 1.5f, 18);
				}
				GL11.glPopMatrix();
				GL11.glPushMatrix();
				{
					GL11.glColor3f(magenta[0], magenta[1], magenta[2]);
					GL11.glTranslatef(-0.75f,-0.75f, 0.75f);
					GL11.glRotatef(-90, 0, 0, 1);
					cylinder.DrawCylinder(0.075f, 1.5f, 18);
				}
				GL11.glPopMatrix();
				GL11.glPushMatrix();
				{
					GL11.glColor3f(yellow[0],yellow[1], yellow[2]);
					GL11.glTranslatef(0, 0, 2.25f);
					cone.DrawCone(1.5f, 1, 18);
				}
				GL11.glPopMatrix();
		}
		GL11.glPopMatrix();
	}

}
