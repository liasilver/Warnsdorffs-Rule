package chess;

import princeton.introcs.StdDraw;

public class TourViewer4 {
	
	//demonstrate rook moevement

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
					StdDraw.setPenColor(StdDraw.SKY_BLUE);
				} else {
					StdDraw.setPenColor(StdDraw.WHITE);
				}
				StdDraw.filledSquare(i + 1, j + 1, 0.5);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// edit the next line to draw a board of the size that you are testing
		drawBoard(8,8);

		StdDraw.setPenColor(StdDraw.DARK_GRAY);
		
		// create a Tour object on the next line
		int[][] offset = {
			{0,1},{0,-1},
			{1,0},{-1,0},
		};
		int bWidth = 8;
		int bHeight = 8;
		Tour t = new Tour(offset, bWidth, bHeight);
		
		
		// depending on the structure of your solution you may have to make
		// some more objects here...
		
		Location start = new Location(8, 8);
		
		//set board dimensions
		//set piece moves
		
		
		t.startTour(start);
		Location curr = start;
		int i = 0;
		while (t.hasNext()) {
			Location next = t.next();
			System.out.println(i + " : moving from " + curr + " to " + next);
			StdDraw.line(curr.x(), curr.y(), next.x(), next.y());
			StdDraw.setPenColor(StdDraw.DANK_BLUE);
			StdDraw.filledCircle(next.x(), next.y(), 0.1);
			StdDraw.setPenColor(StdDraw.DARK_GRAY);
			curr = new Location(next);
			//uncomment the next line to slow down the viewer; 500 is the pause time in milliseconds
			//Thread.sleep(500);
			i++;
		}
		
	}
}
