import grid.cells.Cell;

public class TestCell {

	public static void main(String[] args) {
		Cell cell = new Cell(3,2);
		System.out.println(cell.toString());
		System.out.println(cell.getCellState().toString());
	}

}
