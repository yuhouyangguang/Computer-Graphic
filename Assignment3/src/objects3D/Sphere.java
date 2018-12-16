package objects3D;

import org.lwjgl.opengl.GL11;
import static java.lang.Math.*;
import GraphicsObjects.Point4f;

public class Sphere {

	
	public Sphere() {

	}
   // First I figure out the angles that need to be added to each cycle and start preparing to draw the quadrilateral.
//	In each loop, you need to compute the values of phi, theta, the next phi, and the sines and cosines of the next theta.
//	Compute the coordinates of the points and place them in the vertices group.
//	Use glNormal3f and glVertex3f to draw the corresponding figure.
	public void DrawSphere(float radius,float nSlices,float nSegments) {
// First I figure out the angles that need to be added to each cycle and start preparing to draw the quadrilateral.
	  float inctheta = (float)Math.PI * 2.0f / nSlices;
	  float incphi = (float)Math.PI/nSegments;
	  GL11.glBegin(GL11.GL_QUADS);
	  for(float theta=-(float)Math.PI; theta<(float)Math.PI; theta+=inctheta) {
		  for(float phi=-((float)Math.PI/2.0f); phi<((float)Math.PI/2.0f); phi+=incphi) {
//				In each loop, you need to compute he sines and cosines of phi, theta, the next phi, and the next theta.
			  float sinphi = (float)sin((double)phi);
			  float cosphi = (float)cos((double)phi);
			  float sintheta = (float)sin((double)theta);
			  float costheta = (float)cos((double)theta);
			  float sinnextphi = (float)sin((double)(phi+incphi));
			  float cosnextphi = (float)cos((double)(phi+incphi));
			  float sinnexttheta = (float)sin((double)(theta+inctheta));
			  float cosnexttheta = (float)cos((double)(theta+inctheta));
//				Compute the coordinates of the points and place them in the vertices group.
			  Point4f vertices[] = {
				new Point4f(cosphi*costheta*radius, cosphi*sintheta*radius, sinphi*radius, 0.0f),
				new Point4f(cosnextphi*costheta*radius, cosnextphi*sintheta*radius, sinnextphi*radius, 0.0f),
				new Point4f(cosphi*cosnexttheta*radius, cosphi*sinnexttheta*radius, sinphi*radius, 0.0f),
				new Point4f(cosnextphi*cosnexttheta*radius, cosnextphi*sinnexttheta*radius, sinnextphi*radius, 0.0f)
			  };
//				Use glNormal3f and glVertex3f to draw the corresponding figure.
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
	}
}
 