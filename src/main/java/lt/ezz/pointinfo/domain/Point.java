package lt.ezz.pointinfo.domain;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Point {

	@NotNull
	Integer coordinateX;
	@NotNull
	Integer coordinateY;
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
