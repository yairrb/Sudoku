package model;

public class Sudoku {
	private Box[][] boxes;

	public Sudoku() {
		this.boxes = new Box[9][9];

		fillBoxes();
	}

	private void fillBoxes() {
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				this.boxes[x][y] = new Box(x, y, true);
			}
		}
	}

	public void SetBox(Box box) {
		this.boxes[box.getPositionX()][box.getPositionY()] = box;
	}

	public Box getBox(int positionX, int positionY) {
		return this.boxes[positionX][positionY];
	}

	public void deleteBox(int positionX, int positionY) {
		this.boxes[positionX][positionY].setValue(0);
	}

	public Box[][] getBoxes() {
		return boxes;
	}

	public void setBoxes(Box[][] boxes) {
		this.boxes = boxes;
	}

}
