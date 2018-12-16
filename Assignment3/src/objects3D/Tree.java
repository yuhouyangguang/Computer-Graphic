package objects3D;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;

public class Tree {
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
	
	public void DrawTree() throws IOException {
		Cone cone = new Cone();
		Cylinder cylinder = new Cylinder();
		GL11.glPushMatrix();
		{
			GL11.glColor3f(dkgreen[0], dkgreen[1], dkgreen[2]);
			cone.DrawCone(0.7f, 1f, 20);
			GL11.glPushMatrix();
			{
				GL11.glTranslatef(0, 0, 0.5f);
				GL11.glColor3f(dkgreen[0], dkgreen[1], dkgreen[2]);
				cone.DrawCone(0.5f, 1f, 20);
			}
			GL11.glPopMatrix();
			GL11.glPushMatrix();
			{
				GL11.glTranslatef(0, 0, -0.5f);
				GL11.glColor3f(brown[0], brown[1], brown[2]);
				cylinder.DrawCylinder(0.2f, 0.5f, 20);
			}
			GL11.glPopMatrix();
		}
		GL11.glPopMatrix();
	}

}
