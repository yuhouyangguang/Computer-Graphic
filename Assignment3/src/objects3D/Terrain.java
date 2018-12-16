package objects3D;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import GraphicsObjects.Point4f;
import GraphicsObjects.Vector4f;

public class Terrain {
	public void DrawPlate(float l, float k) {
		Point4f vertices[] = { new Point4f(-l/2, -k/2, 0.0f, 0.0f), new Point4f(-l/2, k/2, 0.0f, 0.0f),
				new Point4f(l/2, -k/2, 0.0f, 0.0f), new Point4f(l/2, k/2, 0.0f, 0.0f),
		};
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_CLAMP);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
		Color.white.bind();
		GL11.glBegin(GL11.GL_QUADS);
		Vector4f v = vertices[1].MinusPoint(vertices[0]);
		Vector4f w = vertices[3].MinusPoint(vertices[0]);
		Vector4f normal = v.cross(w).Normal();
		GL11.glNormal3f(normal.x, normal.y, normal.z);
		GL11.glVertex3f(vertices[0].x, vertices[0].y, vertices[0].z);
		GL11.glTexCoord2f(0,0);
		GL11.glVertex3f(vertices[1].x, vertices[1].y, vertices[1].z);
		GL11.glTexCoord2f(1,0);
		GL11.glVertex3f(vertices[3].x, vertices[3].y, vertices[3].z);
		GL11.glTexCoord2f(1,1);
		GL11.glVertex3f(vertices[2].x, vertices[2].y, vertices[2].z);
		GL11.glTexCoord2f(0,1);
		GL11.glEnd();
		GL11.glDisable(GL11.GL_TEXTURE_2D);
	}
	public void DrawTerrain1(float l, float k,String name) {
		try {
			TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("res/"+name)).bind();
			DrawPlate(l, k);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
