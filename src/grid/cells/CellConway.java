package grid.cells;
import java.lang.Math;
import java.awt.Point;
import java.util.Random;

public class CellConway extends Point {

	private CellState cellState;


	public CellState getCellState() {
		return this.cellState;
	}


	public void setCellState(CellState cellState) {
		this.cellState = cellState;
	}


	//Constructeur qui crée une cellule aux coordonnées x et y
	public CellConway(int x, int y) {
		this.setLocation(x, y);
		double i= Math.random();
			if (i<0.5) {
				this.cellState = CellState.DEAD;
			} else {
				this.cellState = CellState.ALIVE;
			}

	}

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
