package lt.ezz.pointinfo.domain;

public class Point {

	int coordinateX;
	int coordinateY;
	String name;
	String color;
	
	public int getCoordinateX() {
		return coordinateX;
	}
	public void setCoordinateX(int coordinateX) {
		this.coordinateX = coordinateX;
	}
	public int getCoordinateY() {
		return coordinateY;
	}
	public void setCoordinateY(int coordinateY) {
		this.coordinateY = coordinateY;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "Point [coordinateX=" + coordinateX + ", coordinateY=" + coordinateY + ", name=" + name + ", color="
				+ color + "]";
	}
	
	
}
