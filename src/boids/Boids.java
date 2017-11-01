package boids;
import java.util.Random;
import java.lang.Math;


public class Boids extends Boid{

  public Boid[] tab; //La classe Boids est un tableau de Boid

  public Boids(int nb)
  {
    this.tab = new Boid[nb];
    for(int i = 0;i<nb;i++) //On initialise aléatoirement les valeurs des attrbuts des Boid
    {
      Random r = new Random();
      this.tab[i] = new Boid(r.nextInt(500),r.nextInt(500));
      this.tab[i].setVelocityX(250-r.nextInt(500));
      this.tab[i].setVelocityY(250-r.nextInt(500));
      this.tab[i].setAccelerationX(250-r.nextInt(500));
      this.tab[i].setAccelerationY(250-r.nextInt(500));

    }
  }

  @Override //Réécriture de la méthode toString
  public String toString()
  {
    String s = new String();
    for( int i=0; i< this.tab.length; i++)
    {
      s += "[" + i + " position:(" + this.tab[i].x + "," + this.tab[i].y + ") | vitesse:(" + this.tab[i].getVelocityX() + "," + this.tab[i].getVelocityY() + ") | acceleration:(" + this.tab[i].getAccelerationX()
      + "," + this.tab[i].getAccelerationX() + ") ] \n" ;
    }
    return s;
  }

  public void reInit() //Réinitialise les valeurs de attributs des Boid
  {
    for(int i=0;i<this.tab.length;i++)
    {
      Random r = new Random();
      this.tab[i].setLocation(r.nextInt(500),r.nextInt(500));
      this.tab[i].setVelocityX(0);
      this.tab[i].setVelocityY(0);
      this.tab[i].setAccelerationX(0);
      this.tab[i].setAccelerationY(0);

    }
  }


  public void Rule1()//Calcule les centre de masse de chaque troupeau de Boid
  {
    for(int i =0; i< this.tab.length; i++)
      {
        int cX = 0; //Contient la somme des poisitions en X
        int cY = 0; //Contient la somme des poisitions en Y

      for(int j = 0; (j < this.tab.length) ; j++)
        {
          if (j !=i) //On inclut pas le boid i dans le calcul du centre de masse
          {
          cX += this.tab[j].x;
          cY += this.tab[j].y;
          }
        }
        this.tab[i].addAccelerationX(cX/(this.tab.length-1));//On ajoute le centre de masse à l'accéleration en X
        this.tab[i].addAccelerationY(cY/(this.tab.length-1));//On ajoute le centre de masse à l'accéleration en Y
      }
  }

  public void Rule2() //Garder une distance minimale séparant les Boid
  {
    for (int i =0; i<this.tab.length; i ++)
    {
      int cX = 0;
      int cY = 0;
      for( int j = 0; (j < this.tab.length) ; j++)
      {
        if (j !=i)
        {
          if (Math.abs(this.tab[i].x - this.tab[j].x) < 10 ) //Si la distance est trop petite
          {
            cX += -(this.tab[i].x - this.tab[j].x);//On décrémente cX de la distance trop courte
          }
          if (Math.abs(this.tab[i].y - this.tab[j].y) < 10 )
          {
            cY += -(this.tab[i].y - this.tab[j].y);//On décrémente cX de la distance trop courte
          }
        }
      }
      this.tab[i].addAccelerationX(cX); //On retranche cette distance à l'accelerationX
      this.tab[i].addAccelerationX(cY); //On retranche cette distance à l'accelerationX

    }
  }

  public void Rule3() //Les boids tendent à s'aligner en Vitesse
  {
    for (int i =0; i<this.tab.length; i ++)
    {
      int cX = 0;
      int cY = 0;
      for( int j = 0; (j < this.tab.length); j++)
      {
        if (j !=i)
        {
          cX += this.tab[j].getVelocityX(); // Contient la somme des vitesses en X
          cY += this.tab[j].getVelocityY(); // Contient la somme des vitesses en Y
        }
      }
      this.tab[i].addAccelerationX(cX/(this.tab.length-1)); //On ajoute à l'acceleration une portion de la somme des vitesses
      this.tab[i].addAccelerationX(cY/(this.tab.length-1));
    }
  }

  public void limitVelocity(int vLim) // Limite la vitesse des Boids à la vitesse vLim
  {
    for(int i= 0;i<this.tab.length;i++)
    {
      if(Math.abs(this.tab[i].getVelocityX()) > vLim)
      {
        this.tab[i].setVelocityX((this.tab[i].getVelocityX()/Math.abs(this.tab[i].getVelocityX()))*vLim);
      }
      if(Math.abs(this.tab[i].getVelocityY()) > vLim)
      {
        this.tab[i].setVelocityY((this.tab[i].getVelocityY()/Math.abs(this.tab[i].getVelocityY()))*vLim);
      }
    }
  }


  public void boundPosition(int Xmax,int Ymax,int Xmin,int Ymin)
  {

    for(int i=0; i<this.tab.length;i++)
    {
      if(this.tab[i].x < Xmin)
      {
        this.tab[i].addAccelerationX(1200);
        this.tab[i].addVelocityX(200);

      }
      if(this.tab[i].y < Ymin)
      {
        this.tab[i].addAccelerationY(700);
        this.tab[i].addVelocityY(140);

      }
      if(this.tab[i].x > Xmax )
      {
        this.tab[i].addAccelerationX(-1200);
        this.tab[i].addVelocityX(-200);
      }
      if(this.tab[i].y > Ymax )
      {
        this.tab[i].addAccelerationY(-700);
        this.tab[i].addVelocityY(-140);
      }
    }
  }

  public void resetAcceleration() //Remet l'acceleration des Boids à 0
  {
    for (int i=0;i<this.tab.length;i++)
    {
      this.tab[i].setAccelerationX(0);
      this.tab[i].setAccelerationY(0);
    }
  }

  public void moveBoids() //Bouge les Boids selon les règles définies
  {

    this.resetAcceleration();
    this.Rule1();
    this.Rule2();
    this.Rule3();

    for(int i = 0; i< this.tab.length; i++)
    {
      this.tab[i].setAccelerationX((this.tab[i].getAccelerationX()/(float)4.0));
      this.tab[i].setAccelerationY((this.tab[i].getAccelerationY()/(float)4.0));
      this.tab[i].addVelocityX(this.tab[i].getAccelerationX());
      this.tab[i].addVelocityY(this.tab[i].getAccelerationY());
      this.tab[i].x += this.tab[i].getVelocityX();
      this.tab[i].y += this.tab[i].getVelocityY();

    }
  }



  }
