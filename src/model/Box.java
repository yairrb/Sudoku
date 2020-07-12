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
	
	@Override
	public String toString() {
		return "["+this.value+"]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (editable ? 1231 : 1237);
		result = prime * result + positionX;
		result = prime * result + positionY;
		result = prime * result + section;
		result = prime * result + value;
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
		Box other = (Box) obj;
		if (editable != other.editable)
			return false;
		if (positionX != other.positionX)
			return false;
		if (positionY != other.positionY)
			return false;
		if (section != other.section)
			return false;
		if (value != other.value)
			return false;
		return true;
	}

}
