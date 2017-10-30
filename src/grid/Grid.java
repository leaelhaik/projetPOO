package grid;

import java.awt.Color ;
import grid.cells.Cell;
import grid.cells.CellState;
import java.lang.Math;

public class Grid {

	private Cell[][] cellMat;
	private int length;
	private int width;

	private int n_State;

public Grid(int length, int width,int nbr) {
	this.length=length;
	this.width=width;
	this.cellMat= new Cell[length][width];
	this.n_State = nbr;
	for (int i=0; i < length; i++) {
		for (int j = 0; j < width; j++) {
			this.cellMat[i][j]=new Cell(i,j,nbr);

		}
	}


}
public int getn_State()
{
	return this.n_State;
}

public Grid(Grid grid) {
	this.length=grid.getLength();
	this.width=grid.getWidth();
	this.cellMat= new Cell[grid.getLength()][grid.getWidth()];
	this.n_State = grid.n_State;
	for (int i=0; i < grid.getLength(); i++) {
		for (int j = 0; j < grid.getWidth(); j++) {
			this.cellMat[i][j]=new Cell(i,j,grid.getCell(i, j).getCellState(),grid.n_State);
		}
	}
}

public Cell getCell(int i, int j) {
	return this.cellMat[i][j];
}

public void GridMoinsZero()
{
	for (int i=0; i < length; i++) {
		for (int j = 0; j < width; j++) {
			if (this.getCell(i,j).getCellState()==0)
			{
				if(i%this.n_State ==1){
					this.getCell(i,j).setCellState((i+j)%(this.n_State));
				}
			}
		}
	}
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

public int countStateK(int i, int j,int k) { //compte les morts
	int count = 0;
	for (int l=0; l< getNeighbors(i,j).length; l++) {
		if (getNeighbors(i,j)[l].getCellState() == k ) {
			count++;
		}
	}
	return count;
}

public void reInitgrid() {
	for (int i=0; i < length; i++) {
		for (int j = 0; j < width; j++) {
			this.cellMat[i][j]=new Cell(i,j,this.n_State);
		}
	}
}

public int countStateK_1(int i, int j,int k) { // compte les vivants
	int count = 0;
	for (int l=0; l< getNeighbors(i,j).length; l++) {
		if (getNeighbors(i,j)[l].getCellState() == (k +1) % this.n_State) {
			count++;
		}
	}
	return count;
}
//--------------------------------------------------------------
// Compte les voisins de même couleur et les logements vacants
public int countVoisinMemeCouleur(int i, int j, int k){
	int count = 0;
	for (int l=0; l< getNeighbors(i,j).length; l++) {
		if (getNeighbors(i,j)[l].getCellState() == k || getNeighbors(i,j)[l].getCellState()==0 ) {
			count++;
		}
	}
	return count;
}

public void setStateCell(int i, int j, int cellState) {
	this.getCell(i, j).setCellState(cellState);
}

public int getLength() {
	return this.length;
}

public int getWidth() {
	return this.width;
}

public String Couleur(int e)
{
	if (e==0) {return "#FEFEFE";}
	String c;
	if (e<6)
	{
		c = "#" + (String.valueOf(5-e)) + "0" +(String.valueOf(5-e)) + "0" +(String.valueOf(5-e)) + "0";
		return c;
	}
	if (e<10)
	{
		 c = "#" + (String.valueOf(e)) + "2" +(String.valueOf(e)) + "2" +(String.valueOf(e)) + "2";
		return c;
	}
	else
	{
		c = "#" + (String.valueOf(3*e)) +"DF"  +(String.valueOf(3*e)) ;
	    return c;
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
