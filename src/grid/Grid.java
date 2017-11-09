package grid;


import grid.cells.Cell;
import java.lang.Math;

/**
 * Classe Grid correspondant à la grille de cellules
 */
public class Grid {

	/**
	 * matrice des cellules donc tableau Cell[][] 
	 */
	private Cell[][] cellMat;
	/**
	 * hauteur de la grille
	 */
	private int length;
	/**
	 * largeur de la grille
	 */
	private int width;
	/**
	 * 
	 */
	private int n_State;

/**
 * Constructeur Grid par défaut qui crée la grille de taille lengthxwidth
 * @param length hauteur de la grille souhaitée
 * @param width largeur de la grille
 * @param nbr nombre d'etat possible pour les cellules
 */
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

/**
 * Constructeur par copie
 * @param grid
 */
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

/**
 * Méthode accesseur getn_State
 * @return n_State
 */
public int getn_State()
{
	return this.n_State;
}


/**
 * Méthode accesseur pour une cellule
 * @param i la position en i sur la matrice (ligne)
 * @param j la position en j sur la matrice (colonne)
 * @return Cell la cellule en position (i,j)
 */
public Cell getCell(int i, int j) {
	if (i> this.length || j> this.width)
	{
		throw new IllegalArgumentException("Impossible d'atteindre la cellule i,j -> Hors du grid");
	}
	return this.cellMat[i][j];
}

/**
 * Méthode accesseur getLength
 * @return length la longueur
 */
public int getLength() {
	return this.length;
}

/**
 * Méthode accesseur getWidth
 * @return width la largeur
 */
public int getWidth() {
	return this.width;
}

/** Méthode setStateCell pour changer l'état d'une cellule
 * @param i la ligne de la cellule à changer
 * @param j la colonne de la cellule à changer
 * @param cellState l'etat voulu
 */
public void setStateCell(int i, int j, int cellState) {
	if (i> this.length || j> this.width)
	{
		throw new IllegalArgumentException("Impossible d'atteindre la cellule i,j -> Hors du grid (setStateCell)");
	}
	this.getCell(i, j).setCellState(cellState);
}


/**
 * Méthode pour enlever des zéros dans la grid pour la ségrégation
 */
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

/**
 * Méthode getNeighbors
 * @param i la ligne de la cellule
 * @param j la colonne de la cellule
 * @return Cell[] un tableau avec les voisins
 */
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


/**
 *  Compte le nombre de cellule dans l'état k dans le voisinage d'une cellule
 * @param i la position de la ligne de la cellule
 * @param j la position de la colonne de la cellule
 * @param k l'etat recherché
 * @return int le nombre de cellules correspondantes
 */

public int countStateK(int i, int j,int k) {
	int count = 0;
	for (int l=0; l< getNeighbors(i,j).length; l++) {
		if (getNeighbors(i,j)[l].getCellState() == k ) {
			count++;
		}
	}
	return count;
}


/**
 * Reinitialise la grille
 */
public void reInitgrid() {
	for (int i=0; i < length; i++) {
		for (int j = 0; j < width; j++) {
			this.cellMat[i][j]=new Cell(i,j,this.n_State);
		}
	}
}

/**
 * Compte le nombre de cellule dans l'état k+1 dans le voisinage (les vivants)
 * @param i la ligne de la cellule
 * @param j la colonne de la cellule
 * @param k l'etat précedent
 * @return int le nombre de cellules correspondantes
 */
public int countStateK_1(int i, int j,int k) {
	int count = 0;
	for (int l=0; l< getNeighbors(i,j).length; l++) {
		if (getNeighbors(i,j)[l].getCellState() == (k +1) % this.n_State) {
			count++;
		}
	}
	return count;
}


/**
 * Compte les voisins de même couleur et les logements vacants
 * @param i la ligne de la cellule
 * @param j la colonne de la cellule
 * @param k l'etat précedent
 * @return int le nombre de cellules correspondantes
 */
public int countVoisinMemeCouleur(int i, int j, int k){
	int count = 0;
	for (int l=0; l< getNeighbors(i,j).length; l++) {
		if (getNeighbors(i,j)[l].getCellState() == k || getNeighbors(i,j)[l].getCellState()==0 ) {
			count++;
		}
	}
	return count;
}

/**
 * Selection de la couleur en fonction du nombre d'etat possible
 * @param e le nombre de l'etat
 * @return String la couleur adapté
 */
public String Couleur(int e)
{
	if (e>10) {throw new IllegalArgumentException("Le nombre de couleurs est supérieur à celui autorisé");}
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
