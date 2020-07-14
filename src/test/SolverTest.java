package test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.Box;
import model.Sudoku;
import solver.SolverSudoku;

public class SolverTest {
	private Sudoku inputSudoku;
	private Sudoku expectedSudoku;
	private SolverSudoku solver;

	int[] sudokuCase1 = { 9, 6, 3, 1, 7, 4, 2, 5, 8, 1, 7, 8, 3, 2, 5, 6, 4, 9, 2, 5, 4, 6, 8, 9, 7, 3, 1, 8, 2, 1, 4,
			3, 7, 5, 9, 6, 4, 9, 6, 8, 5, 2, 3, 1, 7, 7, 3, 5, 9, 6, 1, 8, 2, 4, 5, 8, 9, 7, 1, 3, 4, 6, 2, 3, 1, 7, 2,
			4, 6, 9, 8, 5, 6, 4, 2, 5, 9, 8, 1, 7, 3 };

	int[] sudokuCase2 = { 5, 3, 4, 6, 7, 8, 9, 1, 2, 6, 7, 2, 1, 9, 5, 3, 4, 8, 1, 9, 8, 3, 4, 2, 5, 6, 7, 8, 5, 9, 7,
			6, 1, 4, 2, 3, 4, 2, 6, 8, 5, 3, 7, 9, 1, 7, 1, 3, 9, 2, 4, 8, 5, 6, 9, 6, 1, 5, 3, 7, 2, 8, 4, 2, 8, 7, 4,
			1, 9, 6, 3, 5, 3, 4, 5, 2, 8, 6, 1, 7, 9 };

	int[] sudokuCase3 = { 8, 1, 2, 7, 5, 3, 6, 4, 9, 9, 4, 3, 6, 8, 2, 1, 7, 5, 6, 7, 5, 4, 9, 1, 2, 8, 3, 1, 5, 4, 2,
			3, 7, 8, 9, 6, 3, 6, 9, 8, 4, 5, 7, 2, 1, 2, 8, 7, 1, 6, 9, 5, 3, 4, 5, 2, 1, 9, 7, 4, 3, 6, 8, 4, 3, 8, 5,
			2, 6, 9, 1, 7, 7, 9, 6, 3, 1, 8, 4, 5, 2 };

	@Before
	public void setUpBeforeTest() {

		this.inputSudoku = new Sudoku();
		this.expectedSudoku = new Sudoku();
		this.solver = new SolverSudoku(inputSudoku);
	}

	@Test
	public void happyTestSolve1() {
		loadCase1();
		solver.solve();

		LoadExpected(this.sudokuCase1);

		assertTrue(this.inputSudoku.equals(this.expectedSudoku));
	}

	@Test
	public void happyTestSolve2() {
		loadCase2();
		solver.solve();

		LoadExpected(this.sudokuCase2);

		assertTrue(this.inputSudoku.equals(this.expectedSudoku));
	}

	@Test
	public void happyTestSolve3() {
		loadCase3();

		solver.solve();

		LoadExpected(this.sudokuCase3);

		assertTrue(this.inputSudoku.equals(this.expectedSudoku));
	}

	@Test
	public void sadTestSolve1() {
		// same as Case 1 but it has numbers that will broke the sudoku
		loadCase4();

		solver.solve();

		System.out.println(this.inputSudoku);
		LoadExpected(this.sudokuCase3);

		assertTrue(!(this.inputSudoku.equals(this.expectedSudoku)));
		assertTrue(this.inputSudoku.equals(this.solver.getInputSudoku()));
	}

	private void LoadExpected(int[] listOfValues) {
		int index = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				Box aux = new Box(i, j, true);
				aux.setValue(listOfValues[index]);
				this.expectedSudoku.SetBox(aux);
				index++;
			}
		}
	}

	private void loadCase1() {
		int[] posX = { 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8 };
		int[] posY = { 1, 3, 5, 7, 2, 3, 5, 6, 0, 8, 0, 3, 5, 8, 2, 6, 0, 3, 5, 8, 0, 8, 2, 3, 5, 6, 1, 3, 5, 7 };
		int[] values = { 6, 1, 4, 5, 8, 3, 5, 6, 2, 1, 8, 4, 7, 6, 6, 3, 7, 9, 1, 4, 5, 2, 7, 2, 6, 9, 4, 5, 8, 7 };

		fillExpectedSudoku(posX, posY, values);
	}

	private void loadCase2() {
		int[] posX = { 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8 };
		int[] posY = { 0, 1, 4, 0, 3, 4, 5, 1, 2, 7, 0, 4, 8, 0, 3, 5, 8, 0, 4, 8, 1, 6, 7, 3, 4, 5, 8, 4, 7, 8 };
		int[] values = { 5, 3, 7, 6, 1, 9, 5, 9, 8, 6, 8, 6, 3, 4, 8, 3, 1, 7, 2, 6, 6, 2, 8, 4, 1, 9, 5, 8, 7, 9 };

		fillExpectedSudoku(posX, posY, values);
	}

	private void loadCase3() {

		/*
		 * I found this one in a web site, it's suppose to be one of the hardest
		 * sudoku's
		 */
		int[] posX = { 0, 1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8 };
		int[] posY = { 0, 2, 3, 1, 4, 6, 1, 5, 4, 5, 6, 3, 7, 2, 7, 8, 2, 3, 7, 1, 6 };
		int[] values = { 8, 3, 6, 7, 9, 2, 5, 7, 4, 5, 7, 1, 3, 1, 6, 8, 8, 5, 1, 9, 4 };

		fillExpectedSudoku(posX, posY, values);
	}

	private void loadCase4() {
		int[] posX = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8 };
		int[] posY = { 0, 1, 3, 5, 7, 2, 3, 5, 6, 0, 8, 0, 3, 5, 8, 2, 6, 0, 3, 5, 8, 0, 8, 2, 3, 5, 6, 1, 3, 5, 7 };
		int[] values = { 6, 6, 1, 4, 5, 8, 3, 5, 6, 2, 1, 8, 4, 7, 6, 6, 3, 7, 9, 1, 4, 5, 2, 7, 2, 6, 9, 4, 5, 8, 7 };

		fillExpectedSudoku(posX, posY, values);
	}

	private void fillExpectedSudoku(int[] posX, int[] posY, int[] values) {

		int valueIndex = 0;
		while (valueIndex < values.length) {
			int posx = posX[valueIndex];
			int posy = posY[valueIndex];
			Box box = new Box(posx, posy, false);
			box.setValue(values[valueIndex]);
			this.inputSudoku.SetBox(box);
			valueIndex++;

		}
	}

}
