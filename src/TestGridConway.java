import grid.GridConway;
import grid.cells.CellState;

public class TestGridConway {

	public static void main(String[] args) {
		GridConway grid = new GridConway(5,5);
	    System.out.println(grid.toString());
		for (int i=0; i<10; i++) { //trouver une condition d'arret
			GridConway temp = new GridConway(grid);

			for (int k=0; k<temp.getLength(); k++) {
				for (int l=0; l< temp.getWidth(); l++) {

					if (grid.getCell(k, l).getCellState() == CellState.DEAD) {
						if (temp.countAlives(k, l) == 3) {
							grid.setStateCell(k,l, CellState.ALIVE);
						}
					}
					if (grid.getCell(k, l).getCellState() == CellState.ALIVE) {
						if (temp.countAlives(k, l) != 3 && temp.countAlives(k,l) != 2) {
							grid.setStateCell(k,l, CellState.DEAD);
						}
					}


				}
			} 
		}

		System.out.println("Grid\n" + grid.toString());
	}


}
