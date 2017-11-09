package grid.cells;
import java.lang.Math;
import java.awt.Point;
import java.util.Random;


/**
 * Classe Cell spécifique au jeu de la vie (de Conway)
 * Classe étendue de Point
 * @see Point
 */
public class CellConway extends Point {

	/** 
	 * attribut cellState représentant l'état de la cellule
	 * c'est un enum
	 */
	private CellState cellState;

	/**
	 * méthode accessur getCellState
	 * @return cellState
	 */
	public CellState getCellState() {
		return this.cellState;
	}

	/**
	 * methode modifieur setCellstate
	 * @param cellState l'etat voulu à mettre dans la cellule
	 */
	public void setCellState(CellState cellState) {
		this.cellState = cellState;
	}

	/**
	 * Constructeur "par défaut" qui crée une cellule aux coordonnées x et y
	 * @param x la coordonnée en x
	 * @param y la coordonnée en y
	 */
	public CellConway(int x, int y) {
		this.setLocation(x, y);
		double i= Math.random();
			if (i<0.5) {
				this.cellState = CellState.DEAD;
			} else {
				this.cellState = CellState.ALIVE;
			}

	}

	/**
	 * Constructeur plus précis pour créer une cellule avec un état donné
	 * @param x coordonnée en x
	 * @param y coordonnée en y
	 * @param cellState l'état de la cellule voulu
	 */
	public CellConway(int x, int y, CellState cellState) {
		this.setLocation(x,y);
		this.cellState = cellState;
	}


	@Override
	public String toString() {
		String str = new String();
		str = "("+this.x+","+this.y+","+this.cellState+")";
		return str;
	}


}
