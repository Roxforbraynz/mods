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
	
	public int accurateDistanceTo(Location loc) {
		//Slow due to square root and powering, but it's accurate.
		return (int)Math.sqrt(Math.pow(this.x-loc.x, 2) + Math.pow(this.y-loc.y, 2) + Math.pow(this.z-loc.z, 2));
	}
	
	/**
	 * Quick and dirty calculation. DOES NOT RETURN AN ACCURATE DISTANCE.
	 * This is for finding the shortest distance only.
	 * @param loc
	 * @return
	 */
	public int quickDistanceTo(Location loc) {
		//Not accurate at all, but should hopefully work for quick and dirty comparisons to other distances calculated this way.
		return (int) (Math.pow(this.x - loc.x,2) + Math.pow(this.y - loc.y,2) + Math.pow(this.z - loc.z,2));
	}
	
}
