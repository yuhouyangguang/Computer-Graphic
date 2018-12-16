package objects3D;

import org.lwjgl.opengl.GL11;

import GraphicsObjects.Point4f;
import GraphicsObjects.Vector4f;

public class Roof {
	public Roof() {
		
	}
	public void DrawRoof(float c,float k, float g) {
		Point4f vertices[] = { 
				new Point4f(0.0f, 0.0f, 0.0f, 0.0f), 
				new Point4f(0.0f, 0.0f, g, 0.0f),
				new Point4f(0.0f, k, 0.0f, 0.0f), 
				new Point4f(c, 0.0f, 0.0f, 0.0f),
				new Point4f(c, k, 0.0f, 0.0f),
				new Point4f(0.0f, k, g, 0.0f),
		};	
		int faces1[][] = { 	
				{ 0, 1, 5, 2 }, 
				{ 1, 3, 4, 5 }, 
				{ 0, 3, 4, 2 }
	    };
		int faces2[][] = { 	
				{ 0, 1, 3 }, 
				{ 2, 4, 5 }, 
	    };
		GL11.glBegin(GL11.GL_QUADS);
		for (int face = 0; face < 3; face++) {
			Vector4f v = vertices[faces1[face][1]].MinusPoint(vertices[faces1[face][0]]);
			Vector4f w = vertices[faces1[face][3]].MinusPoint(vertices[faces1[face][0]]);
			Vector4f normal = v.cross(w).Normal();
			GL11.glNormal3f(normal.x, normal.y, normal.z);
			 
			GL11.glVertex3f(vertices[faces1[face][0]].x, vertices[faces1[face][0]].y, vertices[faces1[face][0]].z);
			 
			GL11.glVertex3f(vertices[faces1[face][1]].x, vertices[faces1[face][1]].y, vertices[faces1[face][1]].z);
		 
			GL11.glVertex3f(vertices[faces1[face][2]].x, vertices[faces1[face][2]].y, vertices[faces1[face][2]].z);
		 
			GL11.glVertex3f(vertices[faces1[face][3]].x, vertices[faces1[face][3]].y, vertices[faces1[face][3]].z);
		}
		GL11.glEnd();
		GL11.glBegin(GL11.GL_TRIANGLES);
		for (int face = 0; face < 2; face++) {
			Vector4f v = vertices[faces2[face][1]].MinusPoint(vertices[faces2[face][0]]);
			Vector4f w = vertices[faces2[face][2]].MinusPoint(vertices[faces2[face][0]]);
			Vector4f normal = v.cross(w).Normal();
			GL11.glNormal3f(normal.x, normal.y, normal.z);
			
			GL11.glVertex3f(vertices[faces2[face][0]].x, vertices[faces2[face][0]].y, vertices[faces2[face][0]].z);
			
			GL11.glVertex3f(vertices[faces2[face][1]].x, vertices[faces2[face][1]].y, vertices[faces2[face][1]].z);
			
			GL11.glVertex3f(vertices[faces2[face][2]].x, vertices[faces2[face][2]].y, vertices[faces2[face][2]].z);
		}
		GL11.glEnd();
	}
}
