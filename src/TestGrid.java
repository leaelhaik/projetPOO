import grid.Grid;

public class TestGrid {

	public static void main(String[] args) {
		Grid grid = new Grid(5,5);
		System.out.println(grid.toString());
		System.out.println(grid.getCell(2, 2).toString());
		System.out.println("Morts="+grid.countDeads(0,1));
		System.out.println("Morts="+grid.countAlives(0,1));
		/*for (int i=0; i<3; i++) { //trouver une condition d'arret
			Grid temp = new Grid(grid); 
			for (int k=0; k<temp.getLength(); k++) {
				for (int l=0; l< temp.getWidth(); l++) {
					
				}
			}
		} */
	} 

}
