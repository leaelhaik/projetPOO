package boids;
import java.awt.Point;
import java.util.Random;
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
  }

  public BoidNew(int x, int y, double vx, double vy, double ax, double ay)
  {
	  super(x,y);
	  this.velocityX = vx;
	  this.velocityY = vy;
	  this.accelerationX = ax;
	  this.accelerationY = ay;
  }


  public void reInit() //Réinitialise les valeurs de attributs des Boid
  {

      Random r = new Random();
      this.setLocation(r.nextInt(500),r.nextInt(500));
      this.setVelocityX(0);
      this.setVelocityY(0);
      this.setAccelerationX(0);
      this.setAccelerationY(0);

  }

  public double distanceFrom(BoidNew boid)
  {
    return Math.sqrt(Math.pow(this.x-boid.x,2)+Math.pow(this.y-boid.y,2));
  }


  public void update() {
	  this.accelerationX=this.accelerationX/(float)4.0;
      this.accelerationY=this.accelerationY/(float)4.0;
      this.velocityX+=this.accelerationX;
      this.velocityY+=this.accelerationY;
      this.limitVelocity(1500,1500);
      this.x += this.velocityX/30;
      this.y += this.velocityY/30;
  }

  public void resetAcceleration() //Remet l'acceleration des Boids à 0
  {
      this.setAccelerationX(0);
      this.setAccelerationY(0);

  }


  public void limitVelocity(int vLimX, int vLimY) // Limite la vitesse des Boids à la vitesse vLim
  {

      if(Math.abs(this.getVelocityX()) > vLimX)
      {
        this.setVelocityX((this.getVelocityX()/Math.abs(this.getVelocityX()))*vLimX);
      }
      if(Math.abs(this.getVelocityY()) > vLimY)
      {
        this.setVelocityY((this.getVelocityY()/Math.abs(this.getVelocityY()))*vLimY);
      }
  }

  public void boundPosition(int Xmax,int Ymax,int Xmin,int Ymin)
  {


      if(this.x < Xmin)
      {
        this.addAccelerationX(4000);
        this.addVelocityX(200);

      }
      if(this.y < Ymin)
      {
        this.addAccelerationY(4000);
        this.addVelocityY(200);

      }
      if(this.x > Xmax )
      {
        this.addAccelerationX(-4000);
        this.addVelocityX(-200);
      }
      if(this.y > Ymax )
      {
        this.addAccelerationY(-4000);
        this.addVelocityY(-200);
      }
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
