package objects3D;

import org.lwjgl.opengl.GL11;

import GraphicsObjects.Point4f;
import GraphicsObjects.Vector4f;

public class Cone {
	
	public Cone() { 
	}
	
	//First, the origin is located at the center of the circle below. First, draw the triangle above the side.
	//Draw the triangle on top of the lid according to the triangle on top of the side.
	//Draw the triangle below the sides.
	 //Draw the triangle on the lower lid according to the triangle below the side.
	public void DrawCone(float radius, float height, int nSegments ) 
	{
		GL11.glBegin(GL11.GL_TRIANGLES);
		Point4f point4f7 = new Point4f();
		Point4f point4f8 = new Point4f(0.0f, 0.0f, height, 0.0f);
		for(float i=0.0f; i < nSegments; i += 1.0f) {
			//First, the origin is located at the center of the circle below. First, draw the triangle above the side.
			float angle = (float)Math.PI * i * 2.0f / nSegments;
			float nextAngle = (float)Math.PI * (i + 1.0f) * 2.0f / nSegments;
			float x1 = (float)Math.sin((double)angle)*radius, y1 = (float)Math.cos((double)angle)*radius;
			float x2 = (float)Math.sin((double)nextAngle)*radius, y2 = (float)Math.cos((double)nextAngle)*radius;
            
            Point4f point4f4 = new Point4f(x1, y1, 0.0f, 0.0f);
			Point4f point4f5 = new Point4f(x2, y2, 0.0f, 0.0f);
			Vector4f v1 = point4f4.MinusPoint(point4f8);
			Vector4f w1 = point4f5.MinusPoint(point4f8);
			Vector4f normal1 = v1.cross(w1).Normal();
			GL11.glNormal3f( normal1.x, normal1.y, normal1.z);
			GL11.glNormal3f( x1, y1, 0.0f);
			GL11.glVertex3f(x1, y1, 0.0f);
			GL11.glNormal3f( x2, y2, 0.0f);
            GL11.glVertex3f(x2, y2, 0.0f);
            GL11.glNormal3f(0, 0, height);
            GL11.glVertex3f(0, 0, height);
            
            Vector4f v3 = point4f4.MinusPoint(point4f7);
            Vector4f w3 = point4f5.MinusPoint(point4f7);
            Vector4f normal3 = v3.cross(w3).Normal();
            GL11.glNormal3f( normal3.x, normal3.y, normal3.z);
            GL11.glVertex3f(0.0f, 0.0f, 0.0f);
            GL11.glVertex3f(x2, y2, 0.0f);
            GL11.glVertex3f(x1, y1, 0.0f);
		}
		GL11.glEnd();
	}

}
