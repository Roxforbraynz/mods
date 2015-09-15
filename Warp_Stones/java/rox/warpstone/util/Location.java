package rox.warpstone.util;

public class Location {
	
	private int dim;
	private int x;
	private int y;
	private int z;
	
	public Location(int dim, int x, int y, int z) {
		this.dim = dim;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public int getDim() {
		return dim;
	}
	public void setDim(int dim) {
		this.dim = dim;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	
}
