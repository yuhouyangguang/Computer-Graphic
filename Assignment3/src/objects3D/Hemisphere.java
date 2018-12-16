package objects3D;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

import org.lwjgl.opengl.GL11;

import GraphicsObjects.Point4f;
import GraphicsObjects.Vector4f;

public class Hemisphere {
	public Hemisphere() {
		
	}
	
	public void DrawHemisphere(float radius,float nSlices,float nSegments) {
		// First I figure out the angles that need to be added to each cycle and start preparing to draw the quadrilateral.
			  float inctheta = (float)Math.PI * 2.0f / nSlices;
			  float incphi = (float)Math.PI/nSegments;
			  GL11.glBegin(GL11.GL_QUADS);
			  for(float theta=-(float)Math.PI; theta<(float)Math.PI; theta+=inctheta) {
				  for(float phi=0; phi<((float)Math.PI/2.0f); phi+=incphi) {
//						In each loop, you need to compute he sines and cosines of phi, theta, the next phi, and the next theta.
					  float sinphi = (float)sin((double)phi);
					  float cosphi = (float)cos((double)phi);
					  float sintheta = (float)sin((double)theta);
					  float costheta = (float)cos((double)theta);
					  float sinnextphi = (float)sin((double)(phi+incphi));
					  float cosnextphi = (float)cos((double)(phi+incphi));
					  float sinnexttheta = (float)sin((double)(theta+inctheta));
					  float cosnexttheta = (float)cos((double)(theta+inctheta));
//						Compute the coordinates of the points and place them in the vertices group.
					  Point4f vertices[] = {
						new Point4f(cosphi*costheta*radius, cosphi*sintheta*radius, sinphi*radius, 0.0f),
						new Point4f(cosnextphi*costheta*radius, cosnextphi*sintheta*radius, sinnextphi*radius, 0.0f),
						new Point4f(cosphi*cosnexttheta*radius, cosphi*sinnexttheta*radius, sinphi*radius, 0.0f),
						new Point4f(cosnextphi*cosnexttheta*radius, cosnextphi*sinnexttheta*radius, sinnextphi*radius, 0.0f)
					  };
//						Use glNormal3f and glVertex3f to draw the corresponding figure.
					  GL11.glNormal3f(vertices[0].x, vertices[0].y, vertices[0].z);
					  GL11.glVertex3f(vertices[0].x, vertices[0].y, vertices[0].z);
					  GL11.glNormal3f(vertices[1].x, vertices[1].y, vertices[1].z);
					  GL11.glVertex3f(vertices[1].x, vertices[1].y, vertices[1].z);
					  GL11.glNormal3f(vertices[3].x, vertices[3].y, vertices[3].z);
					  GL11.glVertex3f(vertices[3].x, vertices[3].y, vertices[3].z);
					  GL11.glNormal3f(vertices[2].x, vertices[2].y, vertices[2].z);
					  GL11.glVertex3f(vertices[2].x, vertices[2].y, vertices[2].z);
				  }
			  }
			  GL11.glEnd();
			  GL11.glBegin(GL11.GL_TRIANGLES);
			  Point4f point4f1 = new Point4f();
			  for(float i=0.0f; i < nSegments; i += 1.0f) {
					float angle = (float)Math.PI * i * 2.0f / nSegments;
					float nextAngle = (float)Math.PI * (i + 1.0f) * 2.0f / nSegments;
					float x1 = (float)Math.sin((double)angle)*radius, y1 = (float)Math.cos((double)angle)*radius;
					float x2 = (float)Math.sin((double)nextAngle)*radius, y2 = (float)Math.cos((double)nextAngle)*radius;
					Point4f point4f2 = new Point4f(x1, y1, 0, 0);
					Point4f point4f3 = new Point4f(x2, y2, 0, 0);
					Vector4f v = point4f2.MinusPoint(point4f1);
					Vector4f w = point4f3.MinusPoint(point4f1);
					Vector4f normal = v.cross(w).Normal();
					GL11.glNormal3f( normal.x, normal.y, normal.z);
					GL11.glVertex3f(0.0f, 0.0f, 0.0f);
			        GL11.glVertex3f(x2, y2, 0.0f);
			        GL11.glVertex3f(x1, y1, 0.0f);
			  }		
			  GL11.glEnd();
	}

}
