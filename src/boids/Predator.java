package boids;

public class Predator extends BoidNew {


	public Predator(int x, int y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
	}



		public void ruleDistanceMin(BoidsNew boidsHerds) //Garder une distance minimale séparant les Boid
		{
			int cX = 0;
			int cY = 0;
			for( int j = 0; (j < boidsHerds.PredatorsTab.length) ; j++)
			{
				if (this != boidsHerds.PredatorsTab[j])
		        {
		          if (this.distanceFrom(boidsHerds.PredatorsTab[j]) < 400)//Si la distance est trop petite
		          {
		            cX += (2/1)*(this.x - boidsHerds.PredatorsTab[j].x);
								cY += (2/1)*(this.y - boidsHerds.PredatorsTab[j].y);//On décrémente cX de la distance trop courte
		          }
		        }
			}
			this.addAccelerationX(cX); //On retranche cette distance à l'accelerationX
			this.addAccelerationY(cY); //On retranche cette distance à l'accelerationX
		}

	@Override
	public void move(BoidsNew boidsHerds) {
		resetAcceleration();
		ruleDistanceMin(boidsHerds);
		this.hunt(boidsHerds);
		this.boundPosition(1000,600,50,50);
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
		for( int i =1; (i < boidsHerds.PreysTab.length); i++)// Le predateur cherche la proie la plus proche
		{
			if(this.distanceFrom(boidsHerds.PreysTab[i]) < distMin) nearestBoid = boidsHerds.PreysTab[i];
		}
		this.addAccelerationX((nearestBoid.x-this.x));//on ajoute a l'acceleration sa distance par rapport a la proie
		this.addAccelerationY((nearestBoid.y-this.y));
		this.addAccelerationX(nearestBoid.getVelocityX());//on fais concorder la vitesse du predateur a la vitesse de la proie
		this.addAccelerationY(nearestBoid.getVelocityY());
	}


}
