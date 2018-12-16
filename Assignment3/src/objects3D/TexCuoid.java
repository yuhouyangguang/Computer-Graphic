package objects3D;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

import GraphicsObjects.Point4f;
import GraphicsObjects.Vector4f;

public class TexCuoid {
	public TexCuoid() {
		
	}
	public void DrawTexCuoid(float l, float k, float h,Texture myTexture) {
		Point4f vertices[] = { new Point4f(-l/2, -k/2, -h/2, 0.0f), new Point4f(-l/2, -k/2, h/2, 0.0f),
				new Point4f(-l/2, k/2, -h/2, 0.0f), new Point4f(-l/2, k/2, h/2, 0.0f),
				new Point4f(l/2, -k/2, -h/2, 0.0f), new Point4f(l/2, -k/2, h/2, 0.0f),
				new Point4f(l/2, k/2, -h/2, 0.0f), new Point4f(l/2, k/2, h/2, 0.0f) };

		int faces[][] = { { 0, 4, 5, 1 }, { 0, 2, 6, 4 }, { 0, 1, 3, 2 }, { 4, 6, 7, 5 }, { 1, 5, 7, 3 },
				{ 2, 3, 7, 6 } };

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_CLAMP);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
		myTexture.bind();
		GL11.glBegin(GL11.GL_QUADS);
        
		for (int i = 0; i < 6; i++) { // per face
			Vector4f v = vertices[faces[i][1]].MinusPoint(vertices[faces[i][0]]);
			Vector4f w = vertices[faces[i][3]].MinusPoint(vertices[faces[i][0]]);
			Vector4f normal = v.cross(w).Normal();
			GL11.glNormal3f(normal.x, normal.y, normal.z);
			GL11.glVertex3f(vertices[faces[i][0]].x, vertices[faces[i][0]].y, vertices[faces[i][0]].z);
			GL11.glTexCoord2f(0,0);
			GL11.glVertex3f(vertices[faces[i][1]].x, vertices[faces[i][1]].y, vertices[faces[i][1]].z);
			GL11.glTexCoord2f(1,0);
			GL11.glVertex3f(vertices[faces[i][2]].x, vertices[faces[i][2]].y, vertices[faces[i][2]].z);
			GL11.glTexCoord2f(1,1);
			GL11.glVertex3f(vertices[faces[i][3]].x, vertices[faces[i][3]].y, vertices[faces[i][3]].z);
			GL11.glTexCoord2f(0,1);
		} // per face

		GL11.glEnd();
		GL11.glDisable(GL11.GL_TEXTURE_2D);
	}

}
