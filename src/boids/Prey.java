package boids;

/**
* Classe des Proie, sous classe de BoidNew
* <p>Reprend le constructeur de BoidNew
*/

public class Prey extends BoidNew {
/** Prey a les mêmes parametres que BoidNew
*/
	public Prey(int x, int y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
	}

/**
* ruleHerd est une regle pour Prey
* <p>On calcule le centre de masse des Preys proches (on peut choisir la distance d'effet)
* <p>On ajoute ce centre de masse à l'accélération de Prey
*  @param boidsHerds est le troupeau dans lequel se trouve Prey
*/


	public void ruleHerd(BoidsNew boidsHerds)//Calcule les centre de masse de chaque troupeau de Boid
	  {

	        int cX = 0; //Contient la somme des poisitions en X
	        int cY = 0; //Contient la somme des poisitions en Y
					int counter=1;

	      for(int j = 0; (j < boidsHerds.PreysTab.length) ; j++)
	        {
	          if (this != boidsHerds.PreysTab[j]) //On inclut pas le boid i dans le calcul du centre de masse
	          {
							if (this.distanceFrom(boidsHerds.PreysTab[j]) < 500)//On peut modifier la distance d'effet de la regle
							{
			          cX += boidsHerds.PreysTab[j].x;
			          cY += boidsHerds.PreysTab[j].y;
								counter++;
							}
	          }
	        }
	      this.addAccelerationX((1/2)*cX/(counter));//On ajoute le centre de masse à l'accéleration en X
	      this.addAccelerationY((1/2)*cY/(counter));//On ajoute le centre de masse à l'accéleration en Y

	  }


		/**
		* ruleDistanceMin est une regle pour Prey
		* <p>Permet de garder une distance minimale entre les Preys du troupeau
		* <p>Si un membre du troupeau est trop proche de Prey, on calcule la distance du membre à Prey
		* <p>On retranche cette distance à l'acceleration de Prey
		*  @param boidsHerds est le troupeau dans lequel se trouve Prey
		*/

	public void ruleDistanceMin(BoidsNew boidsHerds) //Garder une distance minimale séparant les Boid
	{
		int cX = 0;
		int cY = 0;
		for( int j = 0; (j < boidsHerds.PreysTab.length) ; j++)
		{
			if (this != boidsHerds.PreysTab[j])
	        {
	          if (this.distanceFrom(boidsHerds.PreysTab[j]) < 50)//Si la distance est trop petite
	          {
	            cX += (1/1)*(this.x - boidsHerds.PreysTab[j].x);
							cY += (1/1)*(this.y - boidsHerds.PreysTab[j].y);//On décrémente cX de la distance trop courte
	          }
	        }
		}
		this.addAccelerationX(cX); //On retranche cette distance à l'accelerationX
		this.addAccelerationY(cY); //On retranche cette distance à l'accelerationX
	}


	/**
	* ruleVelocity est une regle pour Prey
	* <p>On calule la vitesse moyenne des Preys de boidsHerds
	* <p>On ajoute cette vitesse moyenne à l'acceleration de prey
	*  @param boidsHerds est le troupeau dans lequel se trouve Prey
	*/


	public void ruleVelocity(BoidsNew boidsHerds) //Les boids tendent à s'aligner en Vitesse
	{
		int cX = 0;
		int cY = 0;
		int counter=1;
		for( int j = 0; (j < boidsHerds.PreysTab.length); j++)
		{
			if (this != boidsHerds.PreysTab[j])
			{
				if (this.distanceFrom(boidsHerds.PreysTab[j]) < 500)//On peut modifier la distance d'effet de la regle
				{
					cX += boidsHerds.PreysTab[j].getVelocityX(); // Contient la somme des vitesses en X
					cY += boidsHerds.PreysTab[j].getVelocityY(); // Contient la somme des vitesses en Y
					counter++;
				}
			}
		}
		this.addAccelerationX(cX/( counter)); //On ajoute à l'acceleration une portion de la somme des vitesses
		this.addAccelerationY(cY/( counter));
	}




	/**
	* move() est une methode abstraite de BoidNew BoidNew
	* <p>On applique les troies règles à Prey
	* <p>On applique la méthode flee()
	*<p> On s'assure que Prey reste dans l'affichage à l'aide de boundPosition
	* <p>On actualise la position
	*  @param boidsHerds est le troupeau dans lequel se trouve Prey
	*/

	@Override
	public void move(BoidsNew boidsHerds) { //methode qui met en mouvement la proie
		this.ruleHerd(boidsHerds);
		this.ruleDistanceMin(boidsHerds);
		this.ruleVelocity(boidsHerds);
		this.flee(boidsHerds);
		this.boundPosition(1400,900,0,0);
		this.update();
	}

/**
* flee() est une methode abstraite de BoidNew
* <p>elle permet à Prey de s'eloigner des Predators
* <p>Si le predateur est trop proche, on modifie son acceleration suivant la vitesse de Predator
*  @param boidsHerds est le troupeau dans lequel se trouve Prey
*/
	@Override
	public void flee(BoidsNew boidsHerds) { //methode pour fuir les predateurs
		for( int j = 0; (j < boidsHerds.PredatorsTab.length); j++)
		{
			 if (this.distanceFrom(boidsHerds.PredatorsTab[j]) < 200)//Si la proie est trop proche d'un predateur
			 {
				if(boidsHerds.PredatorsTab[j].getVelocityX() >= 0){this.addAccelerationX(200);}//on modifie son acceleration pour eviter le predateur
				else {this.addAccelerationX(-200);}
				if(boidsHerds.PredatorsTab[j].getVelocityY() >= 0){this.addAccelerationY(200);}
				else {this.addAccelerationY(-200);}
			 }
		}

	}
/**
* hunt() est une methode abstraide de BoidNew
* <p>Elle n'est pas implementée dans cette classe car Prey ne chasse pas
*/
	@Override
	public void hunt(BoidsNew boidsHerds) { //les Proies de chassent pas
		// TODO Auto-generated method stub

	}

}
