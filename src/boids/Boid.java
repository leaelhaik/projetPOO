package boids;
import java.awt.Point;
//CREER METHODE AJOUT POUR accelerationX ET velocityX
public class Boid extends Point{

  private double velocityX;
  private double velocityY;
  private double accelerationX;
  private double accelerationY;
  //private double orientation;

  public Boid(int x, int y)
  {
    super(x,y);
    this.velocityX = 0;
    this.velocityY = 0;
    this.accelerationX = 0;
    this.accelerationY = 0;
  }

  public Boid()
  {
    super();
    this.velocityX = 0;
    this.velocityY = 0;
    this.accelerationX = 0;
    this.accelerationY = 0;
  }

  public Boid(int x, int y, double vx, double vy, double ax, double ay)
  {
	  super(x,y);
	  this.velocityX = vx;
	  this.velocityY = vy;
	  this.accelerationX = ax;
	  this.accelerationY = ay;
  }


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
