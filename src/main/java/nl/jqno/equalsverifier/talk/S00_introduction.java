package nl.jqno.equalsverifier.talk;

public class S00_introduction {
	
	
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
	 *                                Jan Ouwens
	 * 
	 */
	
	
	
	
	
	
	
	
	
	
	/*
	 * In this talk:
	 * - common pitfalls
	 * - how to avoid them
	 * - how to test them
	 */
	

	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * Java-centric
	 * 
	 * Though most of this applies to C#, as well
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/* 
	 * Resources:
	 * 
	 * - "How to Write an Equality Method in Java" by Odersky, Spoon & Venners
	 *   http://www.artima.com/lejava/articles/equality.html
	 * 
	 * - Effective Java, by Joshua Bloch
	 * 
	 * - Effective C#, by Bill Wagner
	 * 
	 * - EqualsVerifier, by me :)
	 */
	
	
	
	
	
	

	
	
	
	
	
	
	/*
	 * Our running example
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
	
	
	
	
	
}