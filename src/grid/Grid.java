package grid;

import java.awt.Color ;
import grid.cells.Cell;
import java.lang.Math;

public class Grid {

	private Cell[][] cellMat;
	private int length;
	private int width;

	private int n_State;

//----------------------------------------------------------------------------
// Créer une grille length*width

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
//------------------------------------------------------------------------
// Créer une grille identique à grid

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
	if (i> this.length || j> this.width)
	{
		throw new IllegalArgumentException("Impossible d'atteindre la cellule i,j -> Hors du grid");
	}
	return this.cellMat[i][j];
}

//------------------------------------------------------------------------------
// Enlever des zéros dans la grid pour la ségrégation
public void GridMoinsZero()
{
	if (this.n_State<7){

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
}

//Rajouter des 0 si on a beaucoup d'états

public void GridPlusZero()
{


		for (int i=0; i < length; i++) {
			for (int j = 0; j < width; j++) {
				if (this.getCell(i,j).getCellState()!=0)
				{
					if(i%this.n_State ==1 || i%this.n_State ==4 || i%this.n_State ==6){
						this.getCell(i,j).setCellState(0);
					}
				}
			}
		}


}

//------------------------------------------------------------------------------
// Retourne un tableau avec les voisins

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

//-----------------------------------------------------------------------------
// Compte le nombre de cellule dans l'état k dans le voisinage de this (les morts)

public int countStateK(int i, int j,int k) {
	int count = 0;
	for (int l=0; l< getNeighbors(i,j).length; l++) {
		if (getNeighbors(i,j)[l].getCellState() == k ) {
			count++;
		}
	}
	return count;
}
//------------------------------------------------------------------------------
// Reinitialise la grille
public void reInitgrid() {
	for (int i=0; i < length; i++) {
		for (int j = 0; j < width; j++) {
			this.cellMat[i][j]=new Cell(i,j,this.n_State);
		}
	}
}

//------------------------------------------------------------------------------
// Compte le nombre de cellule dans l'état k+1 dans le voisinage (les vivants)
public int countStateK_1(int i, int j,int k) {
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
	if (i> this.length || j> this.width)
	{
		throw new IllegalArgumentException("Impossible d'atteindre la cellule i,j -> Hors du grid (setStateCell)");
	}
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
	if (e>20) {throw new IllegalArgumentException("Le nombre de couleurs est supérieur à celui autorisé");}
	if (e==0) {return "#FEFEFE";}
	String c;
	if (e<6)
	{
		c = "#" + (String.valueOf(5-e)) + "0" +(String.valueOf(5-e)) + "0" +(String.valueOf(5-e)) + "0";
		return c;
	}
	switch (e){
		case 6:
			return ("#40FF00");
		case 7:
			return("#00BFFF");
		case 8:
			return("#7401DF");
		case 9:
			return("#DF0174");
		case 10:
			return ("#08088A");
		case 11:
			return ("#9C3823");
		case 12:
			return("#F04B17");
		case 13:
			return("#A7DC0E");
		case 14:
			return("#51680C");
		case 15:
			return ("#c55ef5");
		case 16:
			return ("#c6cb25");
		case 17:
			return("#481c5f");
		case 18:
			return("#102048");
		case 19:
			return("#2F8476");
		case 20:
			return ("#08088A");

	}
	return ("#FEFEFE");


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
