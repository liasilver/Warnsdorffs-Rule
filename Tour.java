package chess;

import java.util.HashMap;
import java.util.TreeMap;

public class Tour {
	
	private static Knight knight;
	private static Visited visited;
	

	public void startTour(Location loc) {
		this.knight = new Knight(loc);
		this.visited = new Visited(loc);
	}
	
	public boolean hasNext() {
		Moves moves = new Moves(knight.getLoc());
		if (!(moves== null)) {
			if (visited.getVisited().isEmpty()) {
				return true;
			}
			for (int j = 0; j < moves.getSize(); j++) {
				if (!(visited.contains(moves.getLoc(j)))) {
					return true;
				}
			}
		}
		return false;
	}
	
	public Location next() {
		Moves moves = new Moves(knight.getLoc());
		HashMap <Integer, Location> nextMoves = new HashMap<Integer, Location>();
		
		for (int i = 0; i < moves.getSize(); i++) {
			if (!Moves.isValid(moves.getLoc(i))) {
				moves.get().remove(i);
			}
		}
		
		if(moves.get().isEmpty()) {
			return null;
		}
		for (Location loc: moves.get()) {
			if(!visited.contains(loc)) {
				int moveCounter = 0;
				Moves secondaryMoves = new Moves(loc);
				for (Location locs: secondaryMoves.get()) {
					if ( !visited.contains(loc)) {
						moveCounter++;
					}
				}	
				nextMoves.put(moveCounter, loc);
			}
		}
		TreeMap <Integer, Location> sorted = new TreeMap<>();
		sorted.putAll(nextMoves);
		knight.setLoc(sorted.firstEntry().getValue()); 
		this.visited.getVisited().add(knight.getLoc());
		return sorted.firstEntry().getValue();		
	}
	

	public static void main(String [] arg) {
		/*
		Location start = new Location(,4);
		Tour t = new Tour();
		t.knight = new Knight();
		t.startTour(start);
		System.out.println("knight location:" + knight.toString());
		Moves moves = new Moves(t.knight.getLoc());
		//check that these are all correct
		moves.toString();*/
		
		
	}
	
}
