package chess;

import java.util.ArrayList;
import java.util.List;

public class Moves {
	private List<Location> moves = new ArrayList<>();

	//a list of possible moves starting from location
	
	public Moves(Location from, int [][]offset, int boardWidth, int boardHeight){
		for (int [] delta: offset) {
			Location newLoc = new Location(from.x() + delta[0], from.y() + delta[1]);
			if (isValid(newLoc, boardWidth,boardHeight)) {
				this.moves.add(newLoc);	
			}
		}
	}
	
	//board flexibility 
	public static boolean isValid(Location loc, int boardWidth, int boardHeight) {
		if(loc.x() < 1 || loc.x() > boardWidth || loc.y() < 1 || loc.y() > boardHeight) {
			return false;
		}
		return true;
	}
	
	public int getSize() {
		return this.moves.size();
	} 
	
	public Location getLoc(int i) {
		return this.moves.get(i);
	}
	
	public List<Location> get(){
		return this.moves;
	}
	
	//can i have a toString method that prints and doesn't return ?
	public String toString() {
		System.out.println("Possible moves:");
		for (int i = 0; i< moves.size(); i++) {
			System.out.println(String.format("[%d][%d]", moves.get(i).y(), moves.get(i).x()));
		}
		return "";
	}
}
