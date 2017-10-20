package grid;

import grid.cells.Cell;
import grid.cells.CellState;
import java.lang.Math;

public class Grid {
  
	private Cell[][] cellMat;
	private int length;
	private int width;

public Grid(int length, int width) {
	this.length=length;
	this.width=width;
	this.cellMat= new Cell[length][width];
	for (int i=0; i < length; i++) {
		for (int j = 0; j < width; j++) {
			this.cellMat[i][j]=new Cell(i,j);
			//System.out.println("("+i+","+j+")");
		}
	}
}

public Grid(Grid grid) {
	this.length=grid.getLength();
	this.width=grid.getWidth();
	this.cellMat= new Cell[grid.getLength()][grid.getWidth()];
	for (int i=0; i < grid.getLength(); i++) {
		for (int j = 0; j < grid.getWidth(); j++) {
			this.cellMat[i][j]=new Cell(i,j,grid.getCell(i, j).getCellState());
		}
	}
}


public Cell getCell(int i, int j) {
	return this.cellMat[i][j];
}

public Cell[] getNeighbors(int i, int j) {
	Cell[] neighbors = {getCell(Math.floorMod(i-1,this.length),j), 
			getCell(Math.floorMod(i+1,this.length),j),
			getCell(Math.floorMod(i-1,this.length),Math.floorMod(j-1,this.width)),
			getCell(Math.floorMod(i+1,this.length),Math.floorMod(j-1,this.width)), 
			getCell(Math.floorMod(i-1,this.length),Math.floorMod(j+1,this.width)),
			getCell(Math.floorMod(i+1,this.length),Math.floorMod(j+1,this.width)),
			getCell(i,Math.floorMod(j-1,this.width)),
			getCell(i,Math.floorMod(j+1,this.width))}; 
	return neighbors;
	
}

public int countDeads(int i, int j) {
	int count = 0;
	for (int k=0; k< getNeighbors(i,j).length; k++) {
		if (getNeighbors(i,j)[k].getCellState() == CellState.DEAD ) {
			count++;
		}
	}
	return count;
}

public int countAlives(int i, int j) {
	int count = 0;
	for (int k=0; k< getNeighbors(i,j).length; k++) {
		if (getNeighbors(i,j)[k].getCellState() == CellState.ALIVE ) {
			count++;
		}
	}
	return count;
}


public void setStateCell(int i, int j, CellState cellState) {
	this.getCell(i, j).setCellState(cellState);
}

public int getLength() {
	return this.length;
}

public int getWidth() {
	return this.width;
}




@Override
public String toString() {
	String str = new String();
	for (int i = 0; i<this.length; i++) {
		str=  str + "[";
		for (int j=0; j<this.width; j++) {
			str = str + this.cellMat[i][j].toString();
		}
		str = str + "]\n";
	}
	return str;
}
	
	
	
}
