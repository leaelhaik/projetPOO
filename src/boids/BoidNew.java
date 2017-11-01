package boids;
import java.awt.Point;
//CREER METHODE AJOUT POUR accelerationX ET velocityX
public abstract class BoidNew extends Point{

  private double velocityX;
  private double velocityY;
  private double accelerationX;
  private double accelerationY;
  //private double orientation;

  public BoidNew(int x, int y)
  {
    super(x,y);
    this.velocityX = 0;
    this.velocityY = 0;
    this.accelerationX = 0;
    this.accelerationY = 0;
  //  this.orientation = 0;
  }

  public BoidNew()
  {
    super();
    this.velocityX = 0;
    this.velocityY = 0;
    this.accelerationX = 0;
    this.accelerationY = 0;
  //  this.orientation = 0;
  }
  
  public BoidNew(int x, int y, double vx, double vy, double ax, double ay)
  {
	  super(x,y);
	  this.velocityX = vx;
	  this.velocityY = vy;
	  this.accelerationX = ax;
	  this.accelerationY = ay;
  }

  
  public void update() {
	  this.accelerationX=this.accelerationX/(float)4.0;
      this.accelerationY=this.accelerationY/(float)4.0;
      this.velocityX+=this.accelerationX;
      this.velocityY+=this.accelerationY;
      this.x += this.velocityX;
      this.y += this.velocityY;
  }
  
  public void resetAcceleration() //Remet l'acceleration des Boids à 0
  {
      this.setAccelerationX(0);
      this.setAccelerationY(0);
    
  }
  
  
  public abstract void move(BoidsNew BoidsLists);
  
  public abstract void flee(BoidsNew BoidsLists);
  
  public abstract void hunt(BoidsNew BoidsLists);

  
 
  
  public double getVelocityX()
  {
    return this.velocityX;
  }
  public void addVelocityX(double v)
  {
    this.velocityX += v;
  }
  public void setVelocityX(double i)
  {
    this.velocityX = i;
  }


  public double getVelocityY()
  {
    return this.velocityY;
  }
  public void addVelocityY(double v)
  {
    this.velocityY += v;
  }
  public void setVelocityY(double i)
  {
    this.velocityY = i;
  }


  public double getAccelerationX()
  {
    return this.accelerationX;
  }
  public void addAccelerationX(double a)
  {
    this.accelerationX += a;
  }
  public void setAccelerationX(double i)
  {
    this.accelerationX = i;
  }



  public double getAccelerationY()
  {
    return this.accelerationY;
  }
  public void addAccelerationY(double a)
  {
    this.accelerationY += a;
  }
  public void setAccelerationY(double i)
  {
    this.accelerationY = i;
  }
   

  }
