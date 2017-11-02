package boids;

public class Prey extends BoidNew {


	public Prey(int x, int y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
	}


	public void ruleHerd(BoidsNew boidsHerds)//Calcule les centre de masse de chaque troupeau de Boid
	  {

	        int cX = 0; //Contient la somme des poisitions en X
	        int cY = 0; //Contient la somme des poisitions en Y

	      for(int j = 0; (j < boidsHerds.PreysTab.length) ; j++)
	        {
	          if (this != boidsHerds.PreysTab[j]) //On inclut pas le boid i dans le calcul du centre de masse
	          {
	          cX += boidsHerds.PreysTab[j].x;
	          cY += boidsHerds.PreysTab[j].y;
	          }
	        }
	      this.addAccelerationX(cX/(boidsHerds.PreysTab.length-1));//On ajoute le centre de masse à l'accéleration en X
	      this.addAccelerationY(cY/(boidsHerds.PreysTab.length-1));//On ajoute le centre de masse à l'accéleration en Y

	  }

		public void Rule2(BoidsNew boidsHerds) //Garder une distance minimale séparant les Boid
	  {

	      int cX = 0;
	      int cY = 0;
	      for( int j = 0; (j < boidsHerds.PreysTab.length) ; j++)
	      {
	        if (this != boidsHerds.PreysTab[j])
	        {
	          if (Math.abs(this.x - boidsHerds.PreysTab[j].x) < 10 ) //Si la distance est trop petite
	          {
	            cX += -(this.x - boidsHerds.PreysTab[j].x);//On décrémente cX de la distance trop courte
	          }
	          if (Math.abs(this.y - boidsHerds.PreysTab[j].y) < 10 )
	          {
	            cY += -(this.y - boidsHerds.PreysTab[j].y);//On décrémente cX de la distance trop courte
	          }
	        }
	      }
	      this.addAccelerationX(cX); //On retranche cette distance à l'accelerationX
	      this.addAccelerationX(cY); //On retranche cette distance à l'accelerationX

	   }



		   public void Rule3(BoidsNew boidsHerds) //Les boids tendent à s'aligner en Vitesse
		   {
		       int cX = 0;
		       int cY = 0;
		       for( int j = 0; (j < boidsHerds.PreysTab.length); j++)
		       {
		         if (this != boidsHerds.PreysTab[j])
		         {
		           cX += boidsHerds.PreysTab[j].getVelocityX(); // Contient la somme des vitesses en X
		           cY += boidsHerds.PreysTab[j].getVelocityY(); // Contient la somme des vitesses en Y
		         }
		       }
		       this.addAccelerationX(cX/(boidsHerds.PreysTab.length-1)); //On ajoute à l'acceleration une portion de la somme des vitesses
		       this.addAccelerationX(cY/(boidsHerds.PreysTab.length-1));
		   }





	@Override
	public void move(BoidsNew boidsHerds) {
		System.out.println(this.getAccelerationX());
		this.ruleHerd(boidsHerds);
		this.Rule2(boidsHerds);
		this.Rule3(boidsHerds);
		this.flee(boidsHerds);
		this.boundPosition(1500,1200,0,0);
		this.update();
	}

	@Override
	public void flee(BoidsNew boidsHerds) {
		int cX=0;
		int cY=0;
		for( int j = 0; (j < boidsHerds.PredatorsTab.length); j++)
		{
			 if (this.distanceFrom(boidsHerds.PredatorsTab[j]) < 200)
			 {
				 this.setVelocityX(-this.getVelocityX());
				 this.setVelocityY(-this.getVelocityY());
				 this.setAccelerationX(-this.getAccelerationX());
				 this.setAccelerationY(-this.getAccelerationY());
			 }
		}

	}

	@Override
	public void hunt(BoidsNew boidsHerds) {
		// TODO Auto-generated method stub

	}

}
