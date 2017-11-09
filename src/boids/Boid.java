package boids;
import java.awt.Point;
import java.util.Random;
/**
* Classe Boid, sous clase de Point
* <p>Possède une vitesse en X et Y ainsi qu'une accélération en X et Y */
public abstract class Boid extends Point{
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
  public Boid(int x, int y)
  {
    super(x,y);
    this.velocityX = 0;
    this.velocityY = 0;
    this.accelerationX = 0;
    this.accelerationY = 0;
    this.orientation = 0;
  }
/** Reprend le constructeur de Point()*/
  public Boid()
  {
    super();
    this.velocityX = 0;
    this.velocityY = 0;
    this.accelerationX = 0;
    this.accelerationY = 0;
    this.orientation = 0;
  }
/** permet d'initialiser les attributs de Boid aux valeurs souhaitées */
  public Boid(int x, int y, double vx, double vy, double ax, double ay)
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
  public double distanceFrom(Boid boid)
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



  /**
  * ruleHerd est une regle pour Prey
  * <p>On calcule le centre de masse des Preys proches (on peut choisir la distance d'effet)
  * <p>On ajoute ce centre de masse à l'accélération du boid
  *  @param boidsHerds est le troupeau dans lequel se trouve le boid
  */


  	public void ruleHerd(Boid[] boidTab)//Calcule les centre de masse de chaque troupeau de Boid
  	  {

  	        int cX = 0; //Contient la somme des poisitions en X
  	        int cY = 0; //Contient la somme des poisitions en Y
  					int counter=1;

  	      for(int j = 0; (j < boidTab.length) ; j++)
  	        {
  	          if (this != boidTab[j]) //On inclut pas le boid i dans le calcul du centre de masse
  	          {
  							if (this.distanceFrom(boidTab[j]) < 500)//On peut modifier la distance d'effet de la regle
  							{
  			          cX += boidTab[j].x;
  			          cY += boidTab[j].y;
  								counter++;
  							}
  	          }
  	        }
  	      this.addAccelerationX((1/2)*cX/(counter));//On ajoute le centre de masse à l'accéleration en X
  	      this.addAccelerationY((1/2)*cY/(counter));//On ajoute le centre de masse à l'accéleration en Y
          // le facteur 1/2 permet de diminuer l'influence de cette règle
  	  }




  /**
  * ruleDistanceMin est une regle pour les boids
  * <p>Permet de garder une distance minimale entre les boids d'un troupeau
  * <p>Si un membre du troupeau est trop proche de ce boid, on calcule la distance du membre au boid
  * <p>On retranche cette distance à l'acceleration du boid
  *  @param boidsHerds est le troupeau dans lequel se trouve le boid
  *  @param distMin est la distance minimale que l'on veut garder entre les boids
  */


  public void ruleDistanceMin(Boid[] boidTab, int distMin) //Garder une distance minimale séparant les Boid
	{
		int cX = 0;
		int cY = 0;
		for( int j = 0; (j < boidTab.length) ; j++)
		{
			if (this != boidTab[j])
	        {
	          if (this.distanceFrom(boidTab[j]) < distMin)//Si la distance est trop petite
	          {
	            cX += (1/1)*(this.x - boidTab[j].x);
							cY += (1/1)*(this.y - boidTab[j].y);//On décrémente cX de la distance trop courte
	          }
	        }
		}
		this.addAccelerationX(cX); //On retranche cette distance à l'accelerationX
		this.addAccelerationY(cY); //On retranche cette distance à l'accelerationX
	}

  /**
  * ruleVelocity est une regle pour les boids
  * <p>On calule la vitesse moyenne des Preys de boidsHerds
  * <p>On ajoute cette vitesse moyenne à l'acceleration du boid
  *  @param boidsHerds est le troupeau dans lequel se trouve le boid
  */


  public void ruleVelocity(Boid[] boidTab) //Les boids tendent à s'aligner en Vitesse
  {
    int cX = 0;
    int cY = 0;
    int counter=1;
    for( int j = 0; (j < boidTab.length); j++)
    {
      if (this != boidTab[j])
      {
          cX += boidTab[j].getVelocityX(); // Contient la somme des vitesses en X
          cY += boidTab[j].getVelocityY(); // Contient la somme des vitesses en Y
          counter++;
      }
    }
    this.addAccelerationX(cX/( counter)); //On ajoute à l'acceleration une portion de la somme des vitesses
    this.addAccelerationY(cY/( counter));
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
* Borne la position du Boid
* @param Xmax position en x max
* @param Ymax position en y max
* @param Xmin position en x min
* @param Ymin position en y min
*/

  public void boundPosition(int Xmax,int Ymax,int Xmin,int Ymin, int setAcc)
  {
      if(this.x < Xmin)
      {
        this.addAccelerationX(setAcc);
      }
      if(this.y < Ymin)
      {
        this.addAccelerationY(setAcc);
      }
      if(this.x > Xmax )
      {
        this.addAccelerationX(-setAcc);
      }
      if(this.y > Ymax )
      {
        this.addAccelerationY(-setAcc);
      }
  }

  /**
  * Est une methode pour les boids
  * <p>elle permet aux proies de s'eloigner des prédateurs
  * La proie regarde l'ensembre des prédateurs pour s'eloigner
  * de ceux qui sont plus proches que distMin
  * La proie prend la vitesse en x et y du prédateur trop proche
  * et modifie son accélération pour s'en éloigner
  *  @param boidsHerds est le troupeau dans lequel se trouve la proie
  */
  public void flee(Boid[] boidTab, int distMin, int setAcc) { //methode pour fuir les predateurs
		for( int j = 0; (j < boidTab.length); j++)
		{
			 if (this.distanceFrom(boidTab[j]) < distMin)//Si la proie est trop proche d'un predateur
			 {
				if(boidTab[j].getVelocityX() >= 0){this.addAccelerationX(setAcc);}//on modifie son acceleration pour eviter le predateur
				else {this.addAccelerationX(-setAcc);}
				if(boidTab[j].getVelocityY() >= 0){this.addAccelerationY(setAcc);}
				else {this.addAccelerationY(-setAcc);}
			}
		}
	}


	/**
	* Est une methode pour les boids
	* <p>elle permet au prédateur de se rapprocher des proies
	* <p> Le predateur cherche la proie la plus proche,
	* <p>On ajoute a l'acceleration sa distance par rapport a la proie,
	* <p>On fait concorder la vitesse du predateur a la vitesse de la proie,
	*  @param boidsHerds est le troupeau dans lequel se trouve la proie
	*/
	public void hunt(Boid[] boidTab) {
    if(boidTab.length > 0)
    {
      double distMin= this.distanceFrom(boidTab[0]);
  		Boid nearestBoid = boidTab[0];
  		for( int i =1; (i < boidTab.length); i++)// Le predateur cherche la proie la plus proche
  		{
  			if(this.distanceFrom(boidTab[i]) < distMin)
  			nearestBoid = boidTab[i];
  		}
  		this.addAccelerationX((nearestBoid.x-this.x));//on ajoute a l'acceleration sa distance par rapport a la proie
  		this.addAccelerationY((nearestBoid.y-this.y));
  		this.addAccelerationX(nearestBoid.getVelocityX());//on fait concorder la vitesse du predateur a la vitesse de la proie
  		this.addAccelerationY(nearestBoid.getVelocityY());
    }
	}

  /**
 * Methode abstraite implémentée dans les sous classes de Boid
 *<p> Permet le mouvement du boid */
  public abstract void move(Boids boids);



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
	 this.accelerationX +=Math.sqrt(vx*vx+vy*vy)*Math.cos(angle);
	 this.accelerationY +=Math.sqrt(vx*vx+vy*vy)*Math.sin(angle);
	 this.orientation=angle;
  }

  }
