package GraphicsObjects;



public class Vector4f {

	public float x=0;
	public float y=0;
	public float z=0;
	public float a=0;
	
	public Vector4f() 
	{  
		x = 0.0f;
		y = 0.0f;
		z = 0.0f;
		a = 0.0f;
	}
	 
	public Vector4f(float x, float y, float z,float a) 
	{ 
		this.x = x;
		this.y = y;
		this.z = z;
		this.a = a;
	}
	
	//Create a new vector, plus the four coordinate x, y, z, a with the vector Additional's four coordinate x,y,z,a
	//to get the new vector v1;
	public Vector4f PlusVector(Vector4f Additonal) 
	{ 
		Vector4f v1=new Vector4f();
		 v1.x=this.x+Additonal.x;
		 v1.y=this.y+Additonal.y;
		 v1.z=this.z+Additonal.z;
		 v1.a=this.a+Additonal.a;
		 return v1;
	} 	
	//Create a new vector, minus the four coordinate x, y, z, a with the vector Minus's four coordinate x,y,z,a
	//to get the new vector v1;
	public Vector4f MinusVector(Vector4f Minus) 
	{ 
		Vector4f v1=new Vector4f();
		  v1.x=this.x-Minus.x;
		  v1.y=this.y-Minus.y;
		  v1.z=this.z-Minus.z;
		  v1.a=this.a-Minus.a;
		  return v1;
	}
	
	//Create a new vector, minus the four coordinate x, y, z, a with the vector Minus's four coordinate x,y,z,a
	//to get the new vector v1;
	public Point4f PlusPoint(Point4f Additonal) 
	{ 
		Additonal.x=Additonal.x+this.x;
		Additonal.y=Additonal.y+this.y;
		Additonal.z=Additonal.z+this.z;
		Additonal.a=Additonal.a+this.a;
		return Additonal;
	} 
	//Create a new vector v1, multiple the four coordinate with the solid float scale to get a new vector.
	public Vector4f byScalar(float scale )
	{
		Vector4f v1=new Vector4f();
		v1.x=this.x*scale;
		v1.y=this.y*scale;
		v1.z=this.z*scale;
		v1.a=this.a*scale;
		return v1;
	}
	
	//Create a new vector v1, use 0 minus the four coordinate to get a new vector.
	public Vector4f  NegateVector()
	{
		Vector4f v1=new Vector4f();
		v1.x=0-this.x; 
		v1.y=0-this.y; 
		v1.z=0-this.z;
		v1.a=0-this.a;
		return v1;
	}
	
	//Add the square of the four coordinate x,y,z,a and compute the square root of the sum.
	public float length()
	{
		return (float)Math.sqrt(this.x*this.x+this.y*this.y+this.z*this.z+this.a*this.a);
	}
	
	//Create a new vector v1 and divide four coordinate x,y,z,a with the length f to get the normal vector. 
	public Vector4f Normal()
	{
		Vector4f v1=new Vector4f();
		   float f=length();
		   v1.x=this.x/f;
		   v1.y=this.y/f;
		   v1.z=this.z/f;
		   v1.a=this.a/f;
		   return v1;
	} 
	
	//v¡¤this=x*x1+y*y1+z*z1+a*a1¡£It only need to add the product of the coordinate.

	public float dot(Vector4f v)
	{ 
		return ( this.x*v.x + this.y*v.y + this.z*v.z+ this.a*v.a);
	}
	
	// Implemented this for you to avoid confusion 
	// as we will not normally  be using 4 float vector  
	//this method is used to cross multiply two vectors together, which will get a vector.
	public Vector4f cross(Vector4f v)  
	{ 
    float u0 = (this.y*v.z - z*v.y);
    float u1 = (z*v.x - x*v.z);
    float u2 = (x*v.y - y*v.x);
    float u3 = 0; //ignoring this for now  
    return new Vector4f(u0,u1,u2,u3);
	}
 
}
	 
	   

/*

										MMMM                                        
										MMMMMM                                      
 										MM MMMM                                    
 										MMI  MMMM                                  
 										MMM    MMMM                                
 										MMM      MMMM                              
  										MM        MMMMM                           
  										MMM         MMMMM                         
  										MMM           OMMMM                       
   										MM             .MMMM                     
MMMMMMMMMMMMMMM                        MMM              .MMMM                   
MM   IMMMMMMMMMMMMMMMMMMMMMMMM         MMM                 MMMM                 
MM                  ~MMMMMMMMMMMMMMMMMMMMM                   MMMM               
MM                                  OMMMMM                     MMMMM            
MM                                                               MMMMM          
MM                                                                 MMMMM        
MM                                                                   ~MMMM      
MM                                                                     =MMMM    
MM                                                                        MMMM  
MM                                                                       MMMMMM 
MM                                                                     MMMMMMMM 
MM                                                                  :MMMMMMMM   
MM                                                                MMMMMMMMM     
MM                                                              MMMMMMMMM       
MM                             ,MMMMMMMMMM                    MMMMMMMMM         
MM              IMMMMMMMMMMMMMMMMMMMMMMMMM                  MMMMMMMM            
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM               ZMMMMMMMM              
MMMMMMMMMMMMMMMMMMMMMMMMMMMMM          MM$             MMMMMMMMM                
MMMMMMMMMMMMMM                       MMM            MMMMMMMMM                  
  									MMM          MMMMMMMM                     
  									MM~       IMMMMMMMM                       
  									MM      DMMMMMMMM                         
 								MMM    MMMMMMMMM                           
 								MMD  MMMMMMMM                              
								MMM MMMMMMMM                                
								MMMMMMMMMM                                  
								MMMMMMMM                                    
  								MMMM                                      
  								MM                                        
                             GlassGiant.com */