package boids;
import java.awt.Point;
import java.util.Random;
/**
* Classe Boid, sous clase de Point
* <p>Possède une vitesse en X et Y ainsi qu'une accélération en X et Y */
public abstract class BoidNew extends Point{
/**
*velocityX: Vitesse en x,
*<p>velocityY: Vitesse en y,
*<p> accelerationX: Accélération en x,
*<p> accelerationY: Accélération en y,
*/

  private double velocityX;
  private double velocityY;
  private double accelerationX;
  private double accelerationY;
  private double orientation;
  /** Reprend le constructeur de Point()
    */
  public BoidNew(int x, int y)
  {
    super(x,y);
    this.velocityX = 0;
    this.velocityY = 0;
    this.accelerationX = 0;
    this.accelerationY = 0;
    this.orientation = 0;
  }
/** Reprend le constructeur de Point()*/
  public BoidNew()
  {
    super();
    this.velocityX = 0;
    this.velocityY = 0;
    this.accelerationX = 0;
    this.accelerationY = 0;
    this.orientation = 0;
  }
/** permet d'initialiser les attributs de BoidNew aux valeurs souhaitées */
  public BoidNew(int x, int y, double vx, double vy, double ax, double ay)
  {
	  super(x,y);
	  this.velocityX = vx;
	  this.velocityY = vy;
	  this.accelerationX = ax;
	  this.accelerationY = ay;
	  this.orientation=Math.acos(vx/Math.sqrt(vx*vx+vy*vy));
  }

/**Réinitialise les valeurs de attributs des Boid*/
  public void reInit()
  {

      Random r = new Random();
      this.setLocation(r.nextInt(500),r.nextInt(500));
      this.setVelocityX(0);
      this.setVelocityY(0);
      this.setAccelerationX(0);
      this.setAccelerationY(0);

  }
/** renvoie la distance entre Boid et un autre Boid */
  public double distanceFrom(BoidNew boid)
  {
    return Math.sqrt(Math.pow(this.x-boid.x,2)+Math.pow(this.y-boid.y,2));
  }


/** Met a jour la position d'un Boid */
  public void update() {
	  this.accelerationX=this.accelerationX/(float)4.0;
      this.accelerationY=this.accelerationY/(float)4.0;
      this.velocityX+=this.accelerationX;
      this.velocityY+=this.accelerationY;
      this.limitVelocity(60,60);
      this.x += (float)this.velocityX/(float)1;
      this.y += (float)this.velocityY/(float)1;
  }

  public void resetAcceleration() //Remet l'acceleration des Boids à 0
  {
      this.setAccelerationX(0);
      this.setAccelerationY(0);

  }

/** Permet de limiter la vitesse du boid
* @param vLimX vitesse en x
* @param vLimY vitesse en y
*/

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

/**
* Borne la position du BoidNew
* @param Xmax position en x max
* @param Ymax position en y max
* @param Xmin position en x min
* @param Ymin position en y min
*/

  public void boundPosition(int Xmax,int Ymax,int Xmin,int Ymin)
  {
      if(this.x < Xmin)
      {
        this.addAccelerationX(150);
      }
      if(this.y < Ymin)
      {
        this.addAccelerationY(150);
      }
      if(this.x > Xmax )
      {
        this.addAccelerationX(-150);
      }
      if(this.y > Ymax )
      {
        this.addAccelerationY(-150);
      }
  }







  public abstract void move(BoidsNew BoidsLists);
   /**
  * Methode abstraite implémentée dans les sous classes de BoidNew
  *<p> Permet le mouvement du boid */

  public abstract void flee(BoidsNew BoidsLists);
  /**
 * Methode abstraite implémentée dans les sous classes de BoidNew
 *<p> Permet au boid de s'echapper d'autres boids */

  public abstract void hunt(BoidsNew BoidsLists);
  /**
 * Methode abstraite implémentée dans les sous classes de BoidNew
 * <p>Permet au boid de chasser d'autres boids */







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


  public double getOrientation() {
	  return this.orientation;
  }

  public void setOrientation(double angle) {
	 double vx=this.velocityX;
	 double vy= this.velocityY;
	 this.velocityX=Math.sqrt(vx*vx+vy*vy)*Math.cos(angle);
	 this.velocityY=Math.sqrt(vx*vx+vy*vy)*Math.sin(angle);
	 this.orientation=angle;
  }

  }
