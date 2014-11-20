package nl.jqno.equalsverifier.talk;

public class S00 {
	
	
	
	
	
	
	
	
	
	
	/*
	 * Not all equals() methods are created equal
	 * 
	 * 
	 *                    -or-
	 * 
	 * How to write a good equals method in Java
	 * 
	 * 
	 * 
	 * 
	 *                           -by- Jan Ouwens
	 * 
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * In this talk:
	 * 
	 * - common pitfalls;
	 * 
	 * - how to avoid them;
	 * 
	 * - how to test them.
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * Our running example.
	 */
	public class Point {
		private int x;
		private int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int getX() {
			return x;
		}
		
		public int getY() {
			return y;
		}
	}
	
	
	
	public enum Color {
		RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}