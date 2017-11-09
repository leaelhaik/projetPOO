package boids;
/**
* Classe Predator, sous classe de BoidNew
*/
public class Predator extends Boid {


	public Predator(int x, int y, double vx, double vy, double ax, double ay) {
		/** Predator a le même constructeur que BoidNew */
		super(x, y, vx, vy, ax, ay);
	}



		/**
		* move() est une methode abstraite de BoidNew BoidNew
		* <p>On applique la regle ruleDistanceMin() a Predator
		* <p>On applique la méthode hunt()
		* <p>On s'assure que Predator reste dans l'affichage à l'aide de boundPosition
		* <p>On actualise la position
		*  @param boidsHerds est le troupeau dans lequel se trouve Prey
		*/
	
	public void move(Boids boidsHerds) {
			resetAcceleration();
		ruleDistanceMin(boidsHerds.PredatorsTab, 400);
		this.hunt(boidsHerds.MiddleTab);
		this.boundPosition(1400,900,0,0,400);
		update();
	}


}
