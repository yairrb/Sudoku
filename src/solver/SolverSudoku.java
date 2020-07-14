package solver;

import java.util.ArrayList;
import java.util.List;

import model.Box;
import model.Sudoku;

public class SolverSudoku {

	private Sudoku inputSudoku;

	public SolverSudoku(Sudoku inputSudoku) {
		this.inputSudoku = inputSudoku;
	}

	public Sudoku solve() {
		// we will use backtracking
		return solveSudokuUsingBackTracking();
	}

	private Sudoku solveSudokuUsingBackTracking() {

		// we are going to work with the Boxes that are empty. If we can solve
		// this sudoku we will return the same input sudoku that we got
		List<Box> editableBoxes = getEditableBoxes();

		// after get the boxes that we can write and rewrite, we can proceed

		int actualIndex = 0;

		while (actualIndex < editableBoxes.size()) {

			Box actualBox = editableBoxes.get(actualIndex);

			/*
			 * if the current box has value higher than 9 that means that we
			 * have increase the value of that box enough times to reach the
			 * limit, so we should look back to other boxes
			 */

			if (actualBox.getValue() > 9) {
				// reset value XXX:chek this
				this.inputSudoku.resetBox(actualBox);
				actualIndex--;

				if (actualIndex < 0) { // this should tell us that our sudoku is
										// not valid
					return null; // null for now
				}

				actualBox = editableBoxes.get(actualIndex);
				increaseBoxValueByOne(actualBox);
			} else {
				if (actualBox.getValue() == 0) {
					increaseBoxValueByOne(actualBox);
				}

				if (isSudokuValid()) {
					actualIndex++;
				} else {
					increaseBoxValueByOne(actualBox);
					if (actualBox.getValue() > 9) {
						this.inputSudoku.resetBox(actualBox);
						if (actualIndex > 0) {
							actualIndex--;
							actualBox = editableBoxes.get(actualIndex);
							increaseBoxValueByOne(actualBox);
						} else {
							return null; // invalid sudoku
						}
					}
				}
			}
		}

		return this.inputSudoku;
	}

	private List<Box> getEditableBoxes() {
		List<Box> boxesEditable = new ArrayList<>();

		for (int posX = 0; posX < 9; posX++) {
			for (int posY = 0; posY < 9; posY++) {
				Box box = this.inputSudoku.getBox(posX, posY);
				if (box.isEditable()) {
					boxesEditable.add(box);
				}
			}
		}

		return boxesEditable;
	}

	private void increaseBoxValueByOne(Box box) {
		box.setValue(box.getValue() + 1);
	}

	// this would chek if the actual state of the sudoku is valid acording the
	// rules
	private boolean isSudokuValid() {
		boolean isValid = true;

		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				Box box = this.inputSudoku.getBox(x, y);
				if (box.getValue() != 0) {
					isValid = isValid && isPlacedRigth(box);
				}
			}
		}
		return isValid;
	}

	private boolean isPlacedRigth(Box box) {
		return isRepeated(box, getRow(box.getPositionX())) && isRepeated(box, getColumn(box.getPositionY()))
				&& isRepeated(box, getSection(box.getSection()));
	}

	private boolean isRepeated(Box box, List<Box> Boxes) {
		boolean isRepeated = true;

		for (Box boxInTheList : Boxes) {
			if (!(boxInTheList.getPositionX() == box.getPositionX()
					&& boxInTheList.getPositionY() == box.getPositionY())) {
				isRepeated = isRepeated && (boxInTheList.getValue() != box.getValue());
			}
		}

		return isRepeated;
	}

	private List<Box> getRow(int requestedRow) {
		List<Box> row = new ArrayList<>();

		for (int column = 0; column < 9; column++) {
			row.add(this.inputSudoku.getBox(requestedRow, column));
		}
		return row;
	}

	private List<Box> getColumn(int requestedColumn) {
		List<Box> column = new ArrayList<>();

		for (int row = 0; row < 9; row++) {
			column.add(this.inputSudoku.getBox(row, requestedColumn));
		}
		return column;
	}

	private List<Box> getSection(int requestedSection) {
		List<Box> section = new ArrayList<>();
		for (int row = 0; row < 9; row++) {
			for (int columm = 0; columm < 9; columm++) {
				Box box = this.inputSudoku.getBox(row, columm);
				if (box.getSection() == requestedSection) {
					section.add(box);
				}
			}
		}

		return section;
	}

	public Sudoku getInputSudoku() {
		return inputSudoku;
	}

	public void setInputSudoku(Sudoku inputSudoku) {
		this.inputSudoku = inputSudoku;
	}

}
