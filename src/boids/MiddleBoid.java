package boids;

/**
 * Classe des Proie, sous classe de BoidNew
 * <p>Reprend le constructeur de BoidNew
 */

public class MiddleBoid extends Boid {
	/** Prey a les mêmes parametres que Boid
	 */
	public MiddleBoid(int x, int y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
	}



	@Override
	public void move(Boids boidsHerds) { //methode qui met en mouvement la proie
		this.ruleHerd(boidsHerds.MiddleTab);
		this.ruleDistanceMin(boidsHerds.MiddleTab,200);
		this.ruleVelocity(boidsHerds.MiddleTab);
		this.flee(boidsHerds.PredatorsTab,400,600);
		this.hunt(boidsHerds.PreysTab);
		this.boundPosition(1400,900,0,0,300);
		this.update();
	}



}

