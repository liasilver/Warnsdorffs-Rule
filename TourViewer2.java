package chess;

import princeton.introcs.StdDraw;

public class TourViewer2 {

	/**
	 * Draws a regular rectangular chess board of the specified size.
	 * 
	 * <p>
	 * Students will need to modify this method to draw irregular boards
	 * if their solutions allows for irregular boards. 
	 * 
	 * @param width the number of squares in the width of the board
	 * @param height the number of squares in the height of the board
	 */
	private static void drawBoard(int width, int height) {
		if (width < 1 || height < 1) {
			throw new IllegalArgumentException();
		}
		int max = Math.max(width, height);
		StdDraw.setScale(0.5, max + 0.5);
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if ((i + j) % 2 == 0) {
					StdDraw.setPenColor(StdDraw.PINK);
				} else {
					StdDraw.setPenColor(StdDraw.WHITE);
				}
				StdDraw.filledSquare(i + 1, j + 1, 0.5);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// edit the next line to draw a board of the size that you are testing
		drawBoard(5, 10);
		
		StdDraw.setPenColor(StdDraw.DARK_GRAY);
		
		// depending on the structure of your solution you may have to make
		// some more objects here...
		int[][] offset = {
			{-2,1},{-2,-1},
			{1,2},{1,-2},
			{2,1},{2,-1},
			{-1,2},{-1,-2}
		};
		int bWidth = 5;
		int bHeight = 10;
		
		// create a Tour object on the next line
		Tour t = new Tour(offset, bWidth, bHeight);	
		Location start = new Location(5, 5);
		
		
		t.startTour(start);
		Location curr = start;
		int i = 0;
		while (t.hasNext()) {
			Location next = t.next();
			System.out.println(i + " : moving from " + curr + " to " + next);
			StdDraw.line(curr.x(), curr.y(), next.x(), next.y());
			StdDraw.setPenColor(StdDraw.DARK_PINK);
			StdDraw.filledCircle(next.x(), next.y(), 0.1);
			StdDraw.setPenColor(StdDraw.DARK_GRAY);
			
			curr = new Location(next);
			// uncomment the next line to slow down the viewer; 500 is the pause time in milliseconds
			//Thread.sleep(500);
			i++;
		}
		
	}
}
