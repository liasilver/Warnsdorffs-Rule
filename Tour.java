package chess;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.TreeMap;

public class Tour {
	private static Knight knight;
	private static LinkedHashSet<Location> visited;
	private int[][] offset;
	private int boardWidth;
	private int boardHeight;

	public Tour(int[][] offset, int boardWidth, int boardHeight) {
		this.offset = offset;
		this.boardWidth = boardWidth;
		this.boardHeight = boardHeight;
	}

	public void startTour(Location loc) {
		knight = new Knight(loc);
		visited = new LinkedHashSet<Location>();
	}

	public boolean hasNext() {
		Moves moves = new Moves(knight.getLoc(), offset, boardWidth, boardHeight);
		if (visited.isEmpty()) {
			return true;
		}
		for (int j = 0; j < moves.getSize(); j++) {
			if (!(visited.contains(moves.getLoc(j)))) {
				return true;
			}
		}
		return false;
	}

	public Location next() {
		Moves moves = new Moves(knight.getLoc(), offset, boardWidth, boardHeight);
		HashMap<Integer, Location> nextMoves = new HashMap<Integer, Location>();

		for (int i = 0; i < moves.getSize(); i++) {
			if (!Moves.isValid(moves.getLoc(i), boardWidth, boardHeight)) {
				moves.get().remove(i);
			}
		}

		if (moves.get().isEmpty()) {
			return null;
		}
		for (Location loc : moves.get()) {
			if (!visited.contains(loc)) {
				int moveCounter = 0;
				Moves secondaryMoves = new Moves(loc, offset, boardWidth, boardHeight);
				for (Location locs : secondaryMoves.get()) {
					if (!visited.contains(locs)) {
						moveCounter++;
					}
				}
				nextMoves.put(moveCounter, loc);
			}
		}
		TreeMap<Integer, Location> sorted = new TreeMap<>();
		sorted.putAll(nextMoves);
		knight.setLoc(sorted.firstEntry().getValue());
		visited.add(knight.getLoc());
		System.out.println(visited.toString());

		return sorted.firstEntry().getValue();
	}

}
