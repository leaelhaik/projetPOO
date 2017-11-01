package boids;

import java.util.Random;

public class BoidsNew {

	protected Predator[] PredatorsTab;
	protected Prey[] PreysTab;
	
	public BoidsNew(int nbPredators, int nbPreys) {
		this.PredatorsTab = new Predator[nbPredators];
	    for(int i = 0;i<nbPredators;i++) //On initialise aléatoirement les valeurs des attrbuts des Boid
	    {
	      Random r = new Random();
	      this.PredatorsTab[i] = new Predator(r.nextInt(500),r.nextInt(500), 250-r.nextInt(500), 250-r.nextInt(500), 250-r.nextInt(500), 250-r.nextInt(500));
	    }
	    this.PreysTab = new Prey[nbPreys];
	    for(int i = 0;i<nbPreys;i++) //On initialise aléatoirement les valeurs des attrbuts des Boid
	    {
	      Random r = new Random();
	      this.PreysTab[i] = new Prey(r.nextInt(500),r.nextInt(500), 250-r.nextInt(500), 250-r.nextInt(500), 250-r.nextInt(500), 250-r.nextInt(500));
	    }
	}
	
}
