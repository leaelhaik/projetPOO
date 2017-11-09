package boids;

/**
* Classe des Proie, sous classe de BoidNew
* <p>Reprend le constructeur de BoidNew
*/

public class Prey extends Boid {
/** Prey a les mêmes parametres que BoidNew
*/
	public Prey(int x, int y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
	}



	/**
	* move() est une methode abstraite de BoidNew BoidNew
	* <p>On applique les troies règles à Prey
	* <p>On applique la méthode flee()
	*<p> On s'assure que Prey reste dans l'affichage à l'aide de boundPosition
	* <p>On actualise la position
	*  @param boidsHerds est le troupeau dans lequel se trouve Prey
	*/

	
	public void move(Boids boidsHerds) {
  //methode qui met en mouvement la proie
		this.ruleHerd(boidsHerds.PreysTab);
		this.ruleDistanceMin(boidsHerds.PreysTab,10);
		this.ruleVelocity(boidsHerds.PreysTab);
		this.flee(boidsHerds.MiddleTab, 200, 200);
		this.boundPosition(1400,900,0,0,300);
		this.update();
	}




}
