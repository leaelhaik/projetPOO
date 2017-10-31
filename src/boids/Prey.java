package boids;

public class Prey extends BoidNew {


	public Prey(int x, int y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
	}
	
	
	public void ruleHerd(BoidsNew BoidsHerds)//Calcule les centre de masse de chaque troupeau de Boid
	  {
	    for(int i =0; i< BoidsHerds.PreysTab.length; i++)
	      {
	        int cX = 0; //Contient la somme des poisitions en X
	        int cY = 0; //Contient la somme des poisitions en Y

	      for(int j = 0; (j < BoidsHerds.PreysTab.length) ; j++)
	        {
	          if (j !=i) //On inclut pas le boid i dans le calcul du centre de masse
	          {
	          cX += BoidsHerds.PreysTab[j].x;
	          cY += BoidsHerds.PreysTab[j].y;
	          }
	        }
	      BoidsHerds.PreysTab[i].addAccelerationX(cX/(BoidsHerds.PreysTab.length-1));//On ajoute le centre de masse à l'accéleration en X
	      BoidsHerds.PreysTab[i].addAccelerationY(cY/(BoidsHerds.PreysTab.length-1));//On ajoute le centre de masse à l'accéleration en Y
	      }
	  }

	@Override
	public void move(BoidsNew BoidsHerds) {
		resetAcceleration();
		ruleHerd(BoidsHerds);
		update();
	}

	@Override
	public void flee(BoidsNew BoidsHerds) {
		// TODO Auto-generated method stub

	}

	@Override
	public void hunt(BoidsNew BoidsHerds) {
		// TODO Auto-generated method stub

	}

}
