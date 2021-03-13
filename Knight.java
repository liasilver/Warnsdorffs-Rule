package chess;

public class Knight {
	private Location loc;

	/**
	 * Initializes this location to (x, y).
	 * 
	 * @param x the x-coordinate of this location
	 * @param y the y-coordinate of this location
	 */
	public Knight() {
		Location loc = new Location (0,0);
		this.loc = loc;
	}
	/**
	 * Initializes this location to (x, y).
	 * 
	 * @param x the x-coordinate of this location
	 * @param y the y-coordinate of this location
	 */
	public Knight(Location loc) {
		this.loc = loc;
	}

	
	/**
	 * Initializes this location by copying the coordinates of another location.
	 * 
	 * @param other the location to copy
	 */
	/*public Knight(Knight other) {
		this.loc = other.loc;
	}*/

	/**
	 * Return the x-coordinate of this location.
	 * 
	 * @return the x-coordinate of this location
	 */
	public int x() {
		return this.loc.x();
	}

	/**
	 * Return the y-coordinate of this location.
	 * 
	 * @return the y-coordinate of this location
	 */
	public int y() {
		return this.loc.y();
	}

	/**
	 * Set the x-coordinate of this location to the specified value.
	 * 
	 * @param x the x-coordinate to set
	 */
	public void x(int x) {
		this.loc.x(x);
	}

	/**
	 * Set the y-coordinate of this location to the specified value.
	 * 
	 * @param y the y-coordinate to set
	 */
	public void y(int y) {
		this.loc.y(y);
	}
	
	public Location getLoc() {
		return this.loc;
	}
	
	public void setLoc(Location loc) {
		this.loc = loc;
	}
	
	public String toString() {
		return String.format("[%d][%d]", this.loc.x(), this.loc.y());
	}
}
