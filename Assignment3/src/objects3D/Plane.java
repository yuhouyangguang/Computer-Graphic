package objects3D;

import org.lwjgl.opengl.GL11;

public class Plane {
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
	public Plane() {}
	public void DrawPlane(float delta,boolean GoodAnimation) {
		float theta = (float) (delta * 2 * Math.PI);
		float LimbRotation;
		if (GoodAnimation) {
			LimbRotation = (float) Math.cos(theta) * 45;
		} else {
			LimbRotation = 0;
		}
		Cylinder cylinder = new Cylinder();
		Cone cone = new Cone();
		Sphere sphere = new Sphere();
		Terrain terrain = new Terrain();
		GL11.glPushMatrix();
		{
			cylinder.DrawCylinder(0.7f, 6.5f, 32);
			GL11.glPushMatrix();
			{
				GL11.glColor3f(red[0], red[1], red[2]);
				GL11.glRotatef(180f, 0, 1, 0);
				cone.DrawCone(0.7f, 1.5f, 32);
			}
			GL11.glPopMatrix();
			GL11.glPushMatrix();
			{
				GL11.glTranslatef(0.0f, 0.4f, 0.5f);
				GL11.glColor3f(blue[0], blue[1], blue[2]);
				sphere.DrawSphere(0.6f, 32, 32);
			}
			GL11.glPopMatrix();
			GL11.glPushMatrix();
			{
				GL11.glTranslatef(2.3f, -0.3f, 3.25f);
				GL11.glRotatef(-10f, 0, 0, 1);
				GL11.glRotatef(90f, 1, 0, 0);
				terrain.DrawTerrain1(4f, 1f,"google.jpg");
			}
			GL11.glPopMatrix();
			GL11.glPushMatrix();
			{
				GL11.glTranslatef(-2.3f, 0.5f, 3.25f);
				GL11.glRotatef(-10f, 0, 0, 1);
				GL11.glRotatef(90f, 1, 0, 0);
				terrain.DrawTerrain1(4f, 1f,"google.jpg");
			}
			GL11.glPopMatrix();
			GL11.glPushMatrix();
			{
				GL11.glColor3f(red[0], red[1], red[2]);
				GL11.glTranslatef(0, 0, 6.8f);
				GL11.glRotatef(180f, 0, 1, 0);
				cone.DrawCone(0.9f, 1.5f, 32);
			}
			GL11.glPopMatrix();
			GL11.glPushMatrix();
			{
				GL11.glTranslatef(0f, 1f, 6.3f);
				GL11.glRotatef(90f, 0, 1, 0);
				GL11.glRotatef(10f, 1, 0, 0);
				GL11.glRotatef(90f, 0, 0, 1);
				terrain.DrawTerrain1(2f, 1f,"google.jpg");
			}
			GL11.glPopMatrix();
		}
		GL11.glPopMatrix();
	}
}
