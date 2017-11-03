package grid;

import grid.cells.CellConway;
import grid.cells.*;
import java.lang.Math;

public class GridConway {

	private CellConway[][] cellMat;
	private int length;
	private int width;

public GridConway(int length, int width) {
		this.length=length;
		this.width=width;
		this.cellMat= new CellConway[length][width];
		for (int i=0; i < length; i++) {
			for (int j = 0; j < width; j++) {
				this.cellMat[i][j]=new CellConway(i,j);
			}
		}
	}

public GridConway(int length, int width, CellState cellState) {
	this.length=length;
	this.width=width;
	this.cellMat= new CellConway[length][width];
	for (int i=0; i < length; i++) {
		for (int j = 0; j < width; j++) {
			this.cellMat[i][j]=new CellConway(i,j,cellState);
		}
	}
}




public GridConway(GridConway grid) {
	this.length=grid.getLength();
	this.width=grid.getWidth();
	this.cellMat= new CellConway[grid.getLength()][grid.getWidth()];
	for (int i=0; i < grid.getLength(); i++) {
		for (int j = 0; j < grid.getWidth(); j++) {
			this.cellMat[i][j]=new CellConway(i,j,grid.getCell(i, j).getCellState());
		}
	}
}


public CellConway getCell(int i, int j) {
	return this.cellMat[i][j];
}

public CellConway[] getNeighbors(int i, int j) {
	CellConway[] neighbors = {getCell(Math.floorMod(i-1,this.length),j),
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

public void reInit() {
	for (int i=0; i < length; i++) {
		for (int j = 0; j < width; j++) {
			this.cellMat[i][j]=new CellConway(i,j);
		}
	}
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
