package model;

import java.util.Arrays;

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
	
	public void resetBox (Box boxToDelete) {
		this.boxes[boxToDelete.getPositionX()][boxToDelete.getPositionY()].setValue(0);
	}

	public Box[][] getBoxes() {
		return boxes;
	}

	public void setBoxes(Box[][] boxes) {
		this.boxes = boxes;
	}
	
	@Override
	public String toString() {
		String ret = "\n";
		for (int x = 0 ; x < 9 ; x++ ){
			for( int y = 0 ; y < 9 ; y++ ){
				ret+=this.boxes[x][y].toString();
				if ( y == 8 ){
					ret+="\n";
				}
			}
		}
		return ret;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(boxes);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sudoku other = (Sudoku) obj;
		if (!Arrays.deepEquals(boxes, other.boxes))
			return false;
		return true;
	}
	
	
	

}
