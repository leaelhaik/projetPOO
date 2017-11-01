import grid.cells.CellConway;

public class TestCellConway {

	public static void main(String[] args) {
		CellConway cell = new CellConway(3,2);
		System.out.println(cell.toString());
		System.out.println(cell.getCellState().toString());
	}

}
