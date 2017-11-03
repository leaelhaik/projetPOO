package boids;

import java.util.Random;
import java.text.DecimalFormat;
public class BoidsNew {

	protected Predator[] PredatorsTab;
	protected Prey[] PreysTab;

	public BoidsNew(int nbPredators, int nbPreys) {//Boids est un Tableau de Boid
		this.PredatorsTab = new Predator[nbPredators];
	    for(int i = 0;i<nbPredators;i++) //On initialise aléatoirement les valeurs des attrbuts des Boid
	    {
	      Random r = new Random();
	      this.PredatorsTab[i] = new Predator(r.nextInt(1500),r.nextInt(1000), 750-r.nextInt(1500), 500-r.nextInt(1000), 750-r.nextInt(1000), 500-r.nextInt(1000));
	    }
	    this.PreysTab = new Prey[nbPreys];
	    for(int i = 0;i<nbPreys;i++) //On initialise aléatoirement les valeurs des attrbuts des Boid
	    {
	      Random r = new Random();
	      this.PreysTab[i] = new Prey(r.nextInt(1500),r.nextInt(1000), 750-r.nextInt(1500), 500-r.nextInt(1000), 750-r.nextInt(1000), 500-r.nextInt(1000));
	    }
	}

	@Override //Réécriture de la méthode toString
  public String toString()
  {
		DecimalFormat df = new DecimalFormat(); //Pour plus de lisibilité, on n'affiche que 2 chriffes apres la virgule
		df.setMaximumFractionDigits(2);
    String s = new String();
		s += "PREYS: \n";
    for( int i=0; i< this.PreysTab.length; i++)
    {
      s += "[" + i + " position:(" + df.format(this.PreysTab[i].x) + "," + df.format(this.PreysTab[i].y) + ") | vitesse:(" +
			df.format(this.PreysTab[i].getVelocityX()) + "," + df.format(this.PreysTab[i].getVelocityY()) + ") | acceleration:(" +
			df.format(this.PreysTab[i].getAccelerationX()) + "," + df.format(this.PreysTab[i].getAccelerationX()) + ") | orientation:(" + df.format(this.PreysTab[i].getOrientation()) + ") ] \n" ;
    }
		s += "PREDATORS: \n";
		for( int i=0; i< this.PredatorsTab.length; i++)
		{
			s += "[" + i + " position:(" + df.format(this.PredatorsTab[i].x) + "," + df.format(this.PredatorsTab[i].y) + ") | vitesse:(" +
			df.format(this.PredatorsTab[i].getVelocityX()) + "," + df.format(this.PredatorsTab[i].getVelocityY()) + ") | acceleration:(" +
			df.format(this.PredatorsTab[i].getAccelerationX()) + "," + df.format(this.PredatorsTab[i].getAccelerationX()) + ") | orientation:(" + df.format(this.PredatorsTab[i].getOrientation()) + ") ] \n" ;
		}
    return s;
  }




	public void movePredators()//methode qui fait bouger les predateurs seulement
	{
		for(int i =0; i< this.PredatorsTab.length ; i++)
		{
			this.PredatorsTab[i].move(this);
		}

	}
	public void movePreys()//methode qui fait bouger les proies seulement
	{
		for(int i=0;i<this.PreysTab.length;i++)
		{
			this.PreysTab[i].move(this);
		}
	}

	public void moveBoids()
	{
		for(int i =0; i< this.PredatorsTab.length ; i++)
		{
			this.PredatorsTab[i].move(this);
		}
		for(int i=0;i<this.PreysTab.length;i++)
		{
			this.PreysTab[i].move(this);
		}
	}


	public void reInitBoids() //Réinitialise les valeurs de attributs des Boid
	{
 		for(int i = 0;i< this.PredatorsTab.length;i++)
		{
			Random r = new Random();
			this.PredatorsTab[i].setLocation(r.nextInt(1500),r.nextInt(1000));
			this.PredatorsTab[i].setVelocityX( 750-r.nextInt(1500));
			this.PredatorsTab[i].setVelocityY( 500-r.nextInt(1000));
			this.PredatorsTab[i].setAccelerationX( 750-r.nextInt(1500));
			this.PredatorsTab[i].setAccelerationY( 500-r.nextInt(1000));

		}
		for(int i = 0;i< this.PreysTab.length;i++)
		{
			Random r = new Random();
			this.PreysTab[i].setLocation(r.nextInt(1500),r.nextInt(1000));
			this.PreysTab[i].setVelocityX( 750-r.nextInt(1500));
			this.PreysTab[i].setVelocityY( 500-r.nextInt(1000));
			this.PreysTab[i].setAccelerationX( 750-r.nextInt(1500));
			this.PreysTab[i].setAccelerationY( 500-r.nextInt(1000));

		}
	}

}
