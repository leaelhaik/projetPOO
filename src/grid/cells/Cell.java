package grid.cells;
import java.lang.Math;
import java.awt.Point;

public class Cell extends Point {
	
	private CellState cellState;
	

	public CellState getCellState() {
		return cellState;
	}

	public void setCellState(CellState cellState) {
		this.cellState = cellState;
	}
	
	//Constructeur par défaut, qui crée une cellule à (0,0)
	public Cell() {
		double i= Math.random();
		if (i<0.5) {
			this.cellState = CellState.DEAD;
		} else {
			this.cellState = CellState.ALIVE;
		}
	}
	
	
	//Constructeur qui crée une cellule aux coordonnées x et y
	public Cell(int x, int y) {
		this.setLocation(x, y);
		double i= Math.random();
		if (i<0.5) {
			this.cellState = CellState.DEAD;
		} else {
			this.cellState = CellState.ALIVE;
		}
	}
	
	public Cell(int x, int y, CellState cellState) {
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
