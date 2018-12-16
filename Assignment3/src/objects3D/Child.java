package objects3D;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;

import GraphicsObjects.Utils;

public class Child {
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

	public Child() {

	}

	// Implement using notes in Animation lecture
	public void DrawChild(float delta, boolean GoodAnimation, boolean slide) {
		float theta = (float) (delta * 2 * Math.PI);
		float LimbRotation;
		if (GoodAnimation) {
			LimbRotation = (float) Math.cos(theta) * 45;
		} else {
			LimbRotation = 0;
		}

		Sphere sphere = new Sphere();
		Cylinder cylinder = new Cylinder();
		Cuoid cuoid = new Cuoid();
		TexCuoid texCuoid = new TexCuoid();

		GL11.glPushMatrix();

		{
			GL11.glTranslatef(0.0f, 0.5f, 0.0f);
//				 sphere.DrawSphere(0.5f, 32, 32); 
			cuoid.DrawCuoid(1.1f, 1.4f, 0.7f);

			// chest

			// neck
			GL11.glColor3f(orange[0], orange[1], orange[2]);
			GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(orange));
			GL11.glPushMatrix();
			{
				GL11.glTranslatef(0.0f, 0.3f, 0.0f);
				GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
//			                GL11.glRotatef(45.0f,0.0f,1.0f,0.0f); 
				cylinder.DrawCylinder(0.15f, 0.7f, 32);

				// head
				GL11.glColor3f(cyan[0], cyan[1], cyan[2]);
				GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(cyan));
				GL11.glPushMatrix();
				{
					GL11.glTranslatef(0.0f, 0.0f, 1.0f);
//			                    cuoid.DrawCuoid(1.1f, 1.1f, 1.1f);
//			                    try {
//									Texture texture = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("res/"+string));
					GL11.glScalef(10, 10, 10);
					Color.orange.bind();
					sphere.DrawSphere(0.055f, 18, 18);
//									texCuoid.DrawTexCuoid(0.11f, 0.11f, 0.11f,texture);
//								} catch (IOException e) {
//									e.printStackTrace();
//								}
//			                    sphere.DrawSphere(0.5f, 32, 32); 
					GL11.glPopMatrix();
				}
				GL11.glPopMatrix();

				// left shoulder
				GL11.glColor3f(blue[0], blue[1], blue[2]);
				GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(blue));
				GL11.glPushMatrix();
				{
					GL11.glTranslatef(0.5f, 0.4f, 0.0f);
					GL11.glRotatef(30f, 0.0f, 0.0f, 1.0f);
					sphere.DrawSphere(0.25f, 32, 32);

					// left arm
					GL11.glColor3f(orange[0], orange[1], orange[2]);
					GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(orange));
					GL11.glPushMatrix();
					{
						GL11.glTranslatef(0.0f, 0.0f, 0.0f);
						GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
						GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);

						if (slide) {
							GL11.glRotatef(60, 1.0f, 0.0f, 0.0f);
						}else {							
							GL11.glRotatef(-LimbRotation, 0.0f, 1.0f, 0.0f);
						}

						// GL11.glRotatef(27.5f,0.0f,1.0f,0.0f);
						cylinder.DrawCylinder(0.15f, 0.7f, 32);

						// left elbow
						GL11.glColor3f(blue[0], blue[1], blue[2]);
						GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(blue));
						GL11.glPushMatrix();
						{
							GL11.glTranslatef(0.0f, 0.0f, 0.75f);
							sphere.DrawSphere(0.2f, 32, 32);

							// left forearm
							GL11.glColor3f(orange[0], orange[1], orange[2]);
							GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(orange));
						}
						GL11.glPopMatrix();
					}
					GL11.glPopMatrix();
				}
				GL11.glPopMatrix();
				// to chest

				// right shoulder
				GL11.glColor3f(blue[0], blue[1], blue[2]);
				GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(blue));
				GL11.glPushMatrix();
				{
					GL11.glTranslatef(-0.5f, 0.4f, 0.0f);
					GL11.glRotatef(-30f, 0.0f, 0.0f, 1.0f);
					sphere.DrawSphere(0.25f, 32, 32);

					// right arm
					GL11.glColor3f(orange[0], orange[1], orange[2]);
					GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(orange));
					GL11.glPushMatrix();
					{
						GL11.glTranslatef(0.0f, 0.0f, 0.0f);
						GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
						GL11.glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
						if (slide) {
							GL11.glRotatef(60, 1.0f, 0.0f, 0.0f);
						}else {							
							GL11.glRotatef(-LimbRotation, 0.0f, 1.0f, 0.0f);
						}

//				                        GL11.glRotatef(LimbRotation,1.0f,0.0f,0.0f); 
						// GL11.glRotatef(27.5f,0.0f,1.0f,0.0f);
						cylinder.DrawCylinder(0.15f, 0.7f, 32);

						// right elbow
						GL11.glColor3f(blue[0], blue[1], blue[2]);
						GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(blue));
						GL11.glPushMatrix();
						{
							GL11.glTranslatef(0.0f, 0.0f, 0.75f);
							sphere.DrawSphere(0.2f, 32, 32);

						}
						GL11.glPopMatrix();
					}
					GL11.glPopMatrix();
				}
				GL11.glPopMatrix();

				// chest

			}
			GL11.glPopMatrix();

			// pelvis

			// left hip
			GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
			GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(yellow));
			GL11.glPushMatrix();
			{
				GL11.glTranslatef(-0.3f, -0.175f, 0.0f);

				sphere.DrawSphere(0.25f, 32, 32);

				// left high leg
				GL11.glColor3f(dkgreen[0], dkgreen[1], dkgreen[2]);
				GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(red));
				GL11.glPushMatrix();
				{
					GL11.glTranslatef(0.0f, 0.0f, 0.0f);
					GL11.glRotatef(0.0f, 0.0f, 0.0f, 0.0f);
//			                    GL11.glRotatef(90.0f,1.0f,0.0f,0.0f); 
					if (slide) {
						GL11.glRotatef(22.5f, 1.0f, 0.0f, 0.0f);
					}else {						
						GL11.glRotatef((LimbRotation / 2) + 90, 1.0f, 0.0f, 0.0f);
					}
					cylinder.DrawCylinder(0.15f, 0.7f, 32);

					// left knee
					GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
					GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(yellow));
					GL11.glPushMatrix();
					{
						GL11.glTranslatef(0.0f, 0.0f, 0.75f);
						GL11.glRotatef(0.0f, 0.0f, 0.0f, 0.0f);
						sphere.DrawSphere(0.25f, 32, 32);
					}
					GL11.glPopMatrix();
				}
				GL11.glPopMatrix();
			}
			GL11.glPopMatrix();

			// pelvis

			// right hip
			GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
			GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(blue));
			GL11.glPushMatrix();
			{
				GL11.glTranslatef(0.3f, -0.175f, 0.0f);
//	                        cuoid.DrawCuoid(0.8f, 0.8f, 0.8f);
				sphere.DrawSphere(0.25f, 32, 32);

				// right high leg
				GL11.glColor3f(dkgreen[0], dkgreen[1], dkgreen[2]);
				GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(orange));
				GL11.glPushMatrix();
				{
					GL11.glTranslatef(0.0f, 0.0f, 0.0f);
					GL11.glRotatef(0.0f, 0.0f, 0.0f, 0.0f);

//								GL11.glRotatef(90, 1.0f, 0.0f, 0.0f);
					if (slide) {
						GL11.glRotatef(22.5f, 1.0f, 0.0f, 0.0f);
					}else {						
						GL11.glRotatef((-LimbRotation / 2) + 90, 1.0f, 0.0f, 0.0f);
					}
					cylinder.DrawCylinder(0.15f, 0.7f, 32);

					// right knee
					GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
					GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(blue));
					GL11.glPushMatrix();
					{
						GL11.glTranslatef(0.0f, 0.0f, 0.75f);
						GL11.glRotatef(0.0f, 0.0f, 0.0f, 0.0f);
						sphere.DrawSphere(0.25f, 32, 32);
					}
					GL11.glPopMatrix();
				}
				GL11.glPopMatrix();
			}
			GL11.glPopMatrix();
		}

	}
}
