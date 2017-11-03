package boids;
/**
* Classe Predator, sous classe de BoidNew
*/
public class Predator extends BoidNew {


	public Predator(int x, int y, double vx, double vy, double ax, double ay) {
		/** Predator a le même constructeur que BoidNew */
		super(x, y, vx, vy, ax, ay);
	}

	/**
	* ruleDistanceMin est une regle pour Predator
	* <p>Permet de garder une distance minimale entre les différents Predator
	*  @param boidsHerds est le troupeau dans lequel se trouve Predator
	*/

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
		/**
		* move() est une methode abstraite de BoidNew BoidNew
		* <p>On applique la regle ruleDistanceMin() a Predator
		* <p>On applique la méthode hunt()
		* <p>On s'assure que Predator reste dans l'affichage à l'aide de boundPosition
		* <p>On actualise la position
		*  @param boidsHerds est le troupeau dans lequel se trouve Prey
		*/
	@Override
	public void move(BoidsNew boidsHerds) {
		resetAcceleration();
		ruleDistanceMin(boidsHerds);
		this.hunt(boidsHerds);
		this.boundPosition(1000,600,50,50);
		update();
	}
	/**
	* flee() est une methode abstraide de BoidNew
	* <p>Elle n'est pas implementée dans cette classe car Predator n'est pas chassé
	*/
	@Override
	public void flee(BoidsNew BbidsHerds) {

		// TODO Auto-generated method stub

	}

	@Override
	/**
	* hunt() est une methode abstraite de BoidNew
	* <p>elle permet à Predator de se rapprocher des Preys
	* <p> Le predateur cherche la proie la plus proche,
	* <p>On ajoute a l'acceleration sa distance par rapport a la proie,
	* <p>On fait concorder la vitesse du predateur a la vitesse de la proie,
	*  @param boidsHerds est le troupeau dans lequel se trouve Prey
	*/
	public void hunt(BoidsNew boidsHerds) {
		double distMin= this.distanceFrom(boidsHerds.PreysTab[0]);
		Prey nearestBoid = boidsHerds.PreysTab[0];
		for( int i =1; (i < boidsHerds.PreysTab.length); i++)// Le predateur cherche la proie la plus proche
		{
			if(this.distanceFrom(boidsHerds.PreysTab[i]) < distMin) nearestBoid = boidsHerds.PreysTab[i];
		}
		this.addAccelerationX((nearestBoid.x-this.x));//on ajoute a l'acceleration sa distance par rapport a la proie
		this.addAccelerationY((nearestBoid.y-this.y));
		this.addAccelerationX(nearestBoid.getVelocityX());//on fait concorder la vitesse du predateur a la vitesse de la proie
		this.addAccelerationY(nearestBoid.getVelocityY());
	}


}
