package grid.cells;
import java.awt.Point;
import java.util.Random;

public class Cell extends Point {

	private int cellState;
	private int nbr_State;


	public int getCellState() {
		return this.cellState;
	}
	public int getnbr_State() {
		return this.nbr_State;
	}

	public void setCellState(int cellState) {
		this.cellState = cellState;
	}



	//Constructeur qui crée une cellule aux coordonnées x et y
	public Cell(int x, int y,int nbr) {
		this.setLocation(x, y);
		 Random R = new Random();
		this.cellState = R.nextInt(nbr);
		this.nbr_State = nbr;

	}

	public Cell(int x, int y, int cellState,int nbr) {
		this.setLocation(x,y);
		this.cellState = cellState;
		this.nbr_State=nbr;
	}


	@Override
	public String toString() {
		String str = new String();
		str = "("+this.x+","+this.y+","+this.cellState+")";
		return str;
	}


}
