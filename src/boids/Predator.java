package boids;

public class Predator extends BoidNew {


	public Predator(int x, int y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
	}


	public void ruleDistance(BoidsNew BoidsHerds) //Garder une distance minimale séparant les Boid
	  {
	    for (int i =0; i<BoidsHerds.PredatorsTab.length; i ++)
	    {
	      int cX = 0;
	      int cY = 0;
	      for( int j = 0; (j < BoidsHerds.PredatorsTab.length) ; j++)
	      {
	        if (j !=i)
	        {
	          if (Math.abs(BoidsHerds.PredatorsTab[i].x - BoidsHerds.PredatorsTab[j].x) < 50 ) //Si la distance est trop petite
	          {
	            cX += -(BoidsHerds.PredatorsTab[i].x - BoidsHerds.PredatorsTab[j].x);//On décrémente cX de la distance trop courte
	          }
	          if (Math.abs(BoidsHerds.PredatorsTab[i].y - BoidsHerds.PredatorsTab[j].y) < 50 )
	          {
	            cY += -(BoidsHerds.PredatorsTab[i].y - BoidsHerds.PredatorsTab[j].y);//On décrémente cX de la distance trop courte
	          }
	        }
	      }
	      BoidsHerds.PredatorsTab[i].addAccelerationX(cX); //On retranche cette distance à l'accelerationX
	      BoidsHerds.PredatorsTab[i].addAccelerationX(cY); //On retranche cette distance à l'accelerationX

	    }
	  }

	@Override
	public void move(BoidsNew boidsHerds) {
		resetAcceleration();
		ruleDistance(boidsHerds);
		this.hunt(boidsHerds);
		this.boundPosition(1200,800,0,0);
		update();
	}

	@Override
	public void flee(BoidsNew BbidsHerds) {
		// TODO Auto-generated method stub

	}

	@Override
	public void hunt(BoidsNew boidsHerds) {
		double distMin= this.distanceFrom(boidsHerds.PreysTab[0]);
		Prey nearestBoid = boidsHerds.PreysTab[0];
		for( int i =1; (i < boidsHerds.PreysTab.length); i++)
		{
			if(this.distanceFrom(boidsHerds.PreysTab[i]) < distMin) nearestBoid = boidsHerds.PreysTab[i];
		}
		this.addAccelerationX((nearestBoid.x-this.x));
		this.addAccelerationY((nearestBoid.y-this.y));
		this.addAccelerationX(nearestBoid.getVelocityX());
		this.addAccelerationY(nearestBoid.getVelocityY());
	}


}
