package objects3D;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import GraphicsObjects.Utils;

public class YouTube {

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
	
	
	public YouTube() {

	}
	
	// Implement using notes  in Animation lecture  
	public void DrawYouTube(float delta,boolean GoodAnimation, String string) 
 { 
		 float theta = (float) (delta * 2 * Math.PI);
		  float LimbRotation;
		 if (GoodAnimation)
		 {
			 LimbRotation = (float) Math.cos(theta)*45;
		 }else
		 {
			 LimbRotation =0;
		 } 
		  
		Sphere sphere= new Sphere();
		Cylinder cylinder= new Cylinder();
		Cuoid cuoid = new Cuoid();
		TexCuoid texCuoid = new TexCuoid();
 
 
		 GL11.glPushMatrix(); 
		 
		 {
			  GL11.glTranslatef(0.0f,0.5f,0.0f);
//			 sphere.DrawSphere(0.5f, 32, 32); 
			  cuoid.DrawCuoid(1.1f, 1.4f, 0.7f);

		        //  chest


		            // neck
		       	 GL11.glColor3f(orange[0], orange[1], orange[2]);
		           GL11.glMaterial( GL11.GL_FRONT,  GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
		            GL11.glPushMatrix(); {
		                GL11.glTranslatef(0.0f,0.3f, 0.0f);
		                GL11.glRotatef(-90.0f,1.0f,0.0f,0.0f);
//		                GL11.glRotatef(45.0f,0.0f,1.0f,0.0f); 
		                cylinder.DrawCylinder(0.15f,0.7f,32);


		                // head
		           	 GL11.glColor3f(red[0], red[1], red[2]);
		               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(red));
		                GL11.glPushMatrix(); {
		                    GL11.glTranslatef(0.0f,0.0f,1.0f);
//		                    cuoid.DrawCuoid(1.1f, 1.1f, 1.1f);
//		                    try {
//								Texture texture = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("res/"+string));
								GL11.glScalef(10, 10, 10);
								Color.red.bind();
								cuoid.DrawCuoid(0.08f, 0.08f, 0.08f);
//								texCuoid.DrawTexCuoid(0.11f, 0.11f, 0.11f,texture);
//							} catch (IOException e) {
//								e.printStackTrace();
//							}
//		                    sphere.DrawSphere(0.5f, 32, 32); 
		                    GL11.glPopMatrix();
		                } GL11.glPopMatrix();


		                // left shoulder
		           	 GL11.glColor3f(blue[0],blue[1], blue[2]);
		               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
		                GL11.glPushMatrix(); {
		                    GL11.glTranslatef(0.5f,0.4f,0.0f);
		                    GL11.glRotatef(30f,0.0f,0.0f,1.0f); 
		                    sphere.DrawSphere(0.25f, 32, 32); 
		                    

		                    // left arm
		               	 GL11.glColor3f(orange[0], orange[1], orange[2]);
		                   GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
		                    GL11.glPushMatrix(); {
		                        GL11.glTranslatef(0.0f,0.0f,0.0f);
		                        GL11.glRotatef(90.0f,1.0f,0.0f,0.0f);
		                        GL11.glRotatef(90.0f,0.0f,0.0f,1.0f);
		                        
		                        GL11.glRotatef(-LimbRotation,0.0f,1.0f,0.0f); 
		                     //   GL11.glRotatef(27.5f,0.0f,1.0f,0.0f);  
		                        cylinder.DrawCylinder(0.15f,0.7f,32);


		                        // left elbow
		                   	 GL11.glColor3f(blue[0], blue[1], blue[2]);
		                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
		                        GL11.glPushMatrix(); {
		                            GL11.glTranslatef(0.0f,0.0f,0.75f);
		                            sphere.DrawSphere(0.2f, 32, 32); 
		                            
		                            //left forearm
		                       	 GL11.glColor3f(orange[0], orange[1], orange[2]);
		                           GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
		                            GL11.glPushMatrix(); {
		                                GL11.glTranslatef(0.0f,0.0f,0.0f);
		                                GL11.glRotatef(-90.0f,0.0f,1.0f,0.0f);
//		                                GL11.glRotatef(LimbRotation/2,1.0f,0.0f,0.0f); 
		                             //   GL11.glRotatef(90.0f,0.0f,1.0f,0.0f); 
		                                cylinder.DrawCylinder(0.1f,0.5f,32);

		                                // left hand
		                           	 GL11.glColor3f(blue[0], blue[1], blue[2]);
		                               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
		                                GL11.glPushMatrix(); {
		                                    GL11.glTranslatef(0.0f,0.0f,0.55f);
		                                    sphere.DrawSphere(0.2f, 32, 32); 
		                                    


		                                } GL11.glPopMatrix();
		                            } GL11.glPopMatrix();
		                        } GL11.glPopMatrix();
		                    } GL11.glPopMatrix ();
		                } GL11.glPopMatrix ();
		                // to chest

		                // right shoulder
		                GL11.glColor3f(blue[0],blue[1], blue[2]);
			               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
			                GL11.glPushMatrix(); {
			                    GL11.glTranslatef(-0.5f,0.4f,0.0f);
			                    GL11.glRotatef(-30f,0.0f,0.0f,1.0f); 
			                    sphere.DrawSphere(0.25f, 32, 32); 
			                    

			                    // right arm
			               	 GL11.glColor3f(orange[0], orange[1], orange[2]);
			                   GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
			                    GL11.glPushMatrix(); {
			                        GL11.glTranslatef(0.0f,0.0f,0.0f);
			                        GL11.glRotatef(90.0f,1.0f,0.0f,0.0f);
			                        GL11.glRotatef(-90.0f,0.0f,0.0f,1.0f);
			                        
			                        GL11.glRotatef(-LimbRotation,0.0f,1.0f,0.0f); 
			                        
//			                        GL11.glRotatef(LimbRotation,1.0f,0.0f,0.0f); 
			                     //   GL11.glRotatef(27.5f,0.0f,1.0f,0.0f);  
			                        cylinder.DrawCylinder(0.15f,0.7f,32);


			                        // right elbow
			                   	 GL11.glColor3f(blue[0], blue[1], blue[2]);
			                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
			                        GL11.glPushMatrix(); {
			                            GL11.glTranslatef(0.0f,0.0f,0.75f);
			                            sphere.DrawSphere(0.2f, 32, 32); 
			                            
			                            //right forearm
			                       	 GL11.glColor3f(orange[0], orange[1], orange[2]);
			                           GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
			                            GL11.glPushMatrix(); {
			                                GL11.glTranslatef(0.0f,0.0f,0.0f);
			                                               GL11.glRotatef(90.0f,0.0f,1.0f,0.0f);
			                             //   GL11.glRotatef(90.0f,0.0f,1.0f,0.0f); 
//			                                               GL11.glRotatef(LimbRotation,1.0f,0.0f,0.0f); 
			                                cylinder.DrawCylinder(0.1f,0.5f,32);

			                                // right hand
			                           	 GL11.glColor3f(blue[0], blue[1], blue[2]);
			                               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
			                                GL11.glPushMatrix(); {
			                                    GL11.glTranslatef(0.0f,0.0f,0.55f);
			                                    sphere.DrawSphere(0.2f, 32, 32); 
			                                    


			                                } GL11.glPopMatrix();
			                            } GL11.glPopMatrix();
			                        } GL11.glPopMatrix();
			                    } GL11.glPopMatrix ();
			                } GL11.glPopMatrix ();
		                                    
		                                   
		                         

		                //chest


		            } GL11.glPopMatrix();


		            // pelvis

		            // left hip
		       	 GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
		           GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(yellow));
		            GL11.glPushMatrix(); {
		                GL11.glTranslatef(-0.3f,-0.175f,0.0f);
		               
		                sphere.DrawSphere(0.25f, 32, 32); 


		                // left high leg
		           	 GL11.glColor3f(red[0], red[1], red[2]);
		               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(red));
		                GL11.glPushMatrix(); {
		                    GL11.glTranslatef(0.0f,0.0f,0.0f);
		                    GL11.glRotatef(0.0f,0.0f,0.0f,0.0f);
//		                    GL11.glRotatef(90.0f,1.0f,0.0f,0.0f); 
		                    GL11.glRotatef((LimbRotation/2)+90,1.0f,0.0f,0.0f); 
		                    cylinder.DrawCylinder(0.15f,0.7f,16);


		                    // left knee
		               	 GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
		                   GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(yellow));
		                    GL11.glPushMatrix(); {
		                        GL11.glTranslatef(0.0f,0.0f,0.75f);
		                        GL11.glRotatef(0.0f,0.0f,0.0f,0.0f); 
		                        sphere.DrawSphere(0.25f, 32, 32);
		                        GL11.glColor3f(red[0], red[1], red[2]);
		                        GL11.glPushMatrix(); {
		                        	 GL11.glTranslatef(0.0f,0.0f,0.05f);
		                        	 GL11.glRotatef(LimbRotation*3/4-45, 1.0f, 0.0f, 0.0f);
		                        	 cylinder.DrawCylinder(0.15f,0.5f,16);
		                        	 GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
		                        	 GL11.glPushMatrix(); {
		                        		 GL11.glTranslatef(0.0f,0.0f,0.5f);
		                        		 sphere.DrawSphere(0.25f, 20, 20);
		                        	 }
		                        	 GL11.glPopMatrix();
		                        }GL11.glPopMatrix();
		                    } GL11.glPopMatrix();
		                } GL11.glPopMatrix();
		            } GL11.glPopMatrix();

		            // pelvis


		         // right hip
					GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
					GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(blue));
					GL11.glPushMatrix();
					{
						GL11.glTranslatef(0.3f, -0.175f, 0.0f);
//                        cuoid.DrawCuoid(0.8f, 0.8f, 0.8f);
						sphere.DrawSphere(0.25f, 32, 32);

						// right high leg
						GL11.glColor3f(red[0], red[1], red[2]);
						GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(orange));
						GL11.glPushMatrix();
						{
							GL11.glTranslatef(0.0f, 0.0f, 0.0f);
							GL11.glRotatef(0.0f, 0.0f, 0.0f, 0.0f);

//							GL11.glRotatef(90, 1.0f, 0.0f, 0.0f);
							GL11.glRotatef(-(LimbRotation/2)+90,1.0f,0.0f,0.0f); 
							cylinder.DrawCylinder(0.15f, 0.7f, 32);

							// right knee
							GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
							GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(blue));
							GL11.glPushMatrix();
							{
								GL11.glTranslatef(0.0f, 0.0f, 0.75f);
								GL11.glRotatef(0.0f, 0.0f, 0.0f, 0.0f);
								sphere.DrawSphere(0.25f, 32, 32);
								 GL11.glColor3f(red[0], red[1], red[2]);
			                        GL11.glPushMatrix(); {
			                        	 GL11.glTranslatef(0.0f,0.0f,0.05f);
			                        	 GL11.glRotatef(-LimbRotation*3/4+315, 1.0f, 0.0f, 0.0f);
			                        	 cylinder.DrawCylinder(0.15f,0.5f,16);
			                        	 GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
			                        	 GL11.glPushMatrix(); {
			                        		 GL11.glTranslatef(0.0f,0.0f,0.5f);
			                        		 sphere.DrawSphere(0.25f, 20, 20);
			                        	 }
			                        	 GL11.glPopMatrix();
			                        }GL11.glPopMatrix();
							}
							GL11.glPopMatrix();
						}
						GL11.glPopMatrix();
					}
					GL11.glPopMatrix();
		    }
	}	
}
