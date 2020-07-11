package model;

public class Box {

	private int positionX;
	private int positionY;
	private boolean editable;
	private int value;
	private int section;

	public Box(int posX, int posY, boolean editable) {
		this.positionX = posX;
		this.positionY = posY;
		this.editable = editable;
		this.value = 0;
		calculateSection();
	}

	public Box(int posX, int posY, boolean editable, int value) {
		this.positionX = posX;
		this.positionY = posY;
		this.editable = editable;
		this.value = value;
		calculateSection();
	}

	private void calculateSection() {

		if (positionX <= 2) {
			if (positionY <= 2) {
				this.section = 1;
			} else if (positionY > 2 && positionY <= 5) {
				this.section = 2;
			} else if (positionY > 5 && positionY <= 8) {
				this.section = 3;
			}
		} else if (positionX >= 3 && positionX <= 5) {
			if (positionY <= 2) {
				this.section = 4;
			} else if (positionY > 2 && positionY <= 5) {
				this.section = 5;
			} else if (positionY > 5 && positionY <= 8) {
				this.section = 6;
			}
		} else if (positionX >= 6 && positionX <= 8) {
			if (positionY <= 2) {
				this.section = 7;
			} else if (positionY > 2 && positionY <= 5) {
				this.section = 8;
			} else if (positionY > 5 && positionY <= 8) {
				this.section = 9;
			}
		}
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getSection() {
		return section;
	}

	public void setSection(int section) {
		this.section = section;
	}

}
