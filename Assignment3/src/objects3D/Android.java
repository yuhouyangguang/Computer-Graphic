package objects3D;

import java.io.IOException;

import org.lwjgl.opengl.GL11;

public class Android {
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

	public Android() {
		// TODO Auto-generated constructor stub
	}

	public void DrawAndroid(float delta, boolean GoodAnimation) throws IOException {
		float theta = (float) (delta * 2 * Math.PI);
		float LimbRotation;
		if (GoodAnimation) {
			LimbRotation = (float) Math.cos(theta) * 45;
		} else {
			LimbRotation = 0;
		}
		Hemisphere hemisphere = new Hemisphere();
		Cylinder cylinder = new Cylinder();
		Sphere sphere = new Sphere();
		GL11.glPushMatrix();
		{
			GL11.glColor3f(dkgreen[0], dkgreen[1], dkgreen[2]);
			GL11.glTranslatef(0.0f, -0.5f, 0.0f);
			GL11.glRotatef(90, 1, 0, 0);
			cylinder.DrawCylinder(0.5f, 0.8f, 32);
			GL11.glPushMatrix();
			{
				GL11.glColor3f(green[0], green[1], green[2]);
//				GL11.glRotatef(90f, 0, 0, 1);
				GL11.glTranslatef(0.0f, 0.0f, -0.05f);
				GL11.glRotatef(180f, 0, 1, 0);
				hemisphere.DrawHemisphere(0.5f, 32, 32);
				GL11.glPushMatrix();
				{
					GL11.glColor3f(blue[0], brown[1], brown[2]);
					GL11.glTranslatef(0.20f, -0.45f, 0.25f);
					sphere.DrawSphere(0.0625f, 32, 32);
				}
				GL11.glPopMatrix();
				GL11.glPushMatrix();
				{
					GL11.glColor3f(blue[0], brown[1], brown[2]);
					GL11.glTranslatef(-0.20f, -0.45f, 0.25f);
					sphere.DrawSphere(0.0625f, 32, 32);
				}
				GL11.glPopMatrix();
				GL11.glPushMatrix();
				{
					GL11.glColor3f(green[0], green[1], green[2]);
					GL11.glTranslatef(-0.20f, 0.0625f, 0.375f);
					GL11.glRotatef(-37.5f, 0, 1, 0);
					cylinder.DrawCylinder(0.03125f, 0.25f, 32);
					GL11.glPushMatrix();
					{
						GL11.glColor3f(green[0], green[1], green[2]);
						GL11.glTranslatef(0, 0, 0.25f);
						hemisphere.DrawHemisphere(0.03125f, 32, 32);
					}
					GL11.glPopMatrix();
				}
				GL11.glPopMatrix();
				GL11.glPushMatrix();
				{
					GL11.glColor3f(green[0], green[1], green[2]);
					GL11.glTranslatef(0.20f, 0.0625f, 0.375f);
					GL11.glRotatef(37.5f, 0, 1, 0);
					cylinder.DrawCylinder(0.03125f, 0.25f, 32);
					GL11.glPushMatrix();
					{
						GL11.glColor3f(green[0], green[1], green[2]);
						GL11.glTranslatef(0, 0, 0.25f);
						hemisphere.DrawHemisphere(0.03125f, 32, 32);
					}
					GL11.glPopMatrix();
				}
				GL11.glPopMatrix();
				GL11.glPushMatrix();
				{
					GL11.glColor3f(green[0], green[1], green[2]);
					GL11.glTranslatef(-0.6f, 0, -0.075f);
					GL11.glRotatef(180f, 0, 1, 0);
					GL11.glRotatef(-LimbRotation, 1.0f, 0.0f, 0.0f);
					cylinder.DrawCylinder(0.0625f, 0.5f, 32);
					GL11.glPushMatrix();
					{
						GL11.glColor3f(green[0], green[1], green[2]);
						GL11.glTranslatef(0, 0, 0.5f);
						hemisphere.DrawHemisphere(0.0625f, 32, 32);
					}
					GL11.glPopMatrix();
					GL11.glPushMatrix();
					{
						GL11.glColor3f(green[0], green[1], green[2]);
						GL11.glRotatef(180f, 1, 0, 0);
						hemisphere.DrawHemisphere(0.0625f, 32, 32);
					}
					GL11.glPopMatrix();
				}
				GL11.glPopMatrix();
				GL11.glPushMatrix();
				{
					GL11.glColor3f(green[0], green[1], green[2]);
					GL11.glTranslatef(0.6f, 0, -0.075f);
					GL11.glRotatef(180f, 0, 1, 0);
					GL11.glRotatef(LimbRotation, 1.0f, 0.0f, 0.0f);
					cylinder.DrawCylinder(0.0625f, 0.5f, 32);
					GL11.glPushMatrix();
					{
						GL11.glColor3f(green[0], green[1], green[2]);
						GL11.glTranslatef(0, 0, 0.5f);
						hemisphere.DrawHemisphere(0.0625f, 32, 32);
					}
					GL11.glPopMatrix();
					GL11.glPushMatrix();
					{
						GL11.glColor3f(green[0], green[1], green[2]);
						GL11.glRotatef(180f, 1, 0, 0);
						hemisphere.DrawHemisphere(0.0625f, 32, 32);
					}
					GL11.glPopMatrix();
				}
				GL11.glPopMatrix();
				GL11.glPushMatrix();
				{
					GL11.glColor3f(green[0], green[1], green[2]);
					GL11.glTranslatef(-0.25f, 0, -0.75f);
					GL11.glRotatef(180f, 0, 1, 0);
					GL11.glRotatef(LimbRotation, 1.0f, 0.0f, 0.0f);
					cylinder.DrawCylinder(0.08f, 0.35f, 32);
					GL11.glPushMatrix();
					{
						GL11.glColor3f(green[0], green[1], green[2]);
						GL11.glTranslatef(0, 0, 0.35f);
						hemisphere.DrawHemisphere(0.08f, 32, 32);
					}
					GL11.glPopMatrix();
					GL11.glPushMatrix();
					{
						GL11.glColor3f(green[0], green[1], green[2]);
						GL11.glRotatef(180f, 1, 0, 0);
						hemisphere.DrawHemisphere(0.08f, 32, 32);
					}
					GL11.glPopMatrix();
				}
				GL11.glPopMatrix();
				GL11.glPushMatrix();
				{
					GL11.glTranslatef(0.25f, 0, -0.75f);
					GL11.glRotatef(180f, 0, 1, 0);
					GL11.glRotatef(-LimbRotation, 1.0f, 0.0f, 0.0f);
					cylinder.DrawCylinder(0.08f, 0.35f, 32);
					GL11.glPushMatrix();
					{
						GL11.glTranslatef(0, 0, 0.35f);
						hemisphere.DrawHemisphere(0.08f, 32, 32);
					}
					GL11.glPopMatrix();
					GL11.glPushMatrix();
					{
						GL11.glRotatef(180f, 1, 0, 0);
						hemisphere.DrawHemisphere(0.08f, 32, 32);
					}
					GL11.glPopMatrix();
				}
				GL11.glPopMatrix();
 			}
			GL11.glPopMatrix();		
		}
		GL11.glPopMatrix();
	}

}
