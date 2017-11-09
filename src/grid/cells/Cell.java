package grid.cells;
import java.awt.Point;
import java.util.Random;

/**
 * Classe Cell représentant une cellule pour les différents jeux
 * Classe étendue de Point
 * @see Point
 */
public class Cell extends Point {

	/** 
	 * attribut cellState représentant l'état de la cellule
	 * int
	 */
	private int cellState;
	/**
	 * attribut nbr_State représentant le nombre d'états possibles
	 * int
	 */
	private int nbr_State;


	/**
	 * méthode accessur getCellState
	 * @return cellState
	 */
	public int getCellState() {
		return this.cellState;
	}
	
	/**
	 * méthode accesseur getnbr_State
	 * @return nb_State
	 */
	public int getnbr_State() {
		return this.nbr_State;
	}

	/**
	 * methode modifieur setCellstate
	 * @param cellState l'etat voulu à mettre dans la cellule
	 */
	public void setCellState(int cellState) {
		this.cellState = cellState;
	}



	/**
	 * Constructeur "par défaut" qui crée une cellule aux coordonnées x et y
	 * @param x la coordonnée en x
	 * @param y la coordonnée en y
	 * @param nbr le nombre d'états possibles
	 */
	public Cell(int x, int y,int nbr) {
		this.setLocation(x, y);
		 Random R = new Random();
		this.cellState = R.nextInt(nbr);
		this.nbr_State = nbr;

	}

	/**
	 * Constructeur plus précis pour créer une cellule avec un état donné
	 * @param x coordonnée en x
	 * @param y coordonnée en y
	 * @param cellState l'état de la cellule voulu
	 * @param nbr le nombre d'états possibles
	 */
	public Cell(int x, int y, int cellState,int nbr) {
		this.setLocation(x,y);
		this.cellState = cellState;
		this.nbr_State=nbr;
	}

	/**
	 * Methode toString réecrite
	 */
	@Override
	public String toString() {
		String str = new String();
		str = "("+this.x+","+this.y+","+this.cellState+")";
		return str;
	}


}
