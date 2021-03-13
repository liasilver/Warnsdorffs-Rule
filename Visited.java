package chess;

import java.util.LinkedHashSet;

public class Visited {
	private static LinkedHashSet<Location> visited;

	/**
	 * Initializes this location to (x, y).
	 * 
	 * @param x the x-coordinate of this location
	 * @param y the y-coordinate of this location
	 */
	public Visited(Location loc) {
		this.visited = new LinkedHashSet<Location>();
		this.visited.add(loc);
	}

	/**
	 * Return the x-coordinate of this location.
	 * 
	 * @return the x-coordinate of this location
	 */
	public LinkedHashSet<Location> getVisited() {
		return this.visited;
	}


	/**
	 * Set the x-coordinate of this location to the specified value.
	 * 
	 * @param x the x-coordinate to set
	 */
	public void addMove(Location loc) {
			this.visited.add(loc);
		
	}

	/**
	 * Determine if location has been visited.
	 * 
	 * @param 
	 */
	public boolean isNew(Location loc) {
		if (this.visited.contains(loc)) {
			return false;
		}
		return true;
	}
	
	public boolean contains(Location loc) {
		if (this.visited.contains(loc)) {
			return true;
		}
		return false;
	}
	

}
