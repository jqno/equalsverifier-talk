package nl.jqno.equalsverifier.talk;

import static org.junit.Assert.assertEquals;
import nl.jqno.equalsverifier.EqualsVerifier;

import org.junit.Test;

public class S08 {
	
	
	
	
	
	
	
	
	
	
	/*
	 * Liskov Substitution Principle:
	 * 
	 * - if Banana is a subtype of Fruit,
	 * - then objects of type Fruit may be replaced with objects of type Banana
	 * - and nothing will break.
	 */


	/*
	 * This is the basis for all of Object-Oriented Programming.
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * This is the same Point as in the previous slide.
	 */
	public class Point {
		private final int x;
		private final int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public final int hashCode() {
			return 53 * (53 + x) + y;
		}
		
		@Override
		public String toString() {
			return String.format("%s: %s,%s", getClass().getSimpleName(), x, y);
		}

		@Override
		public final boolean equals(Object obj) {
			if (obj == null || getClass() != obj.getClass()) {
				return false;
			}
			Point other = (Point)obj;
			return x == other.x && y == other.y;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * Now let's pretend that we're Hibernate.
	 */
	public class Point$$Proxy extends Point {
		public Point$$Proxy(int x, int y) {
			super(x, y);
		}
	}
	
	@Test
	public void equals_on_proxy() {
		Point p = new Point(1, 2);
		Point q = new Point$$Proxy(1, 2);
		assertEquals(p, q);
	}
	
	@Test
	public void equalsverifier_on_proxy() {
		EqualsVerifier.forClass(Point$$Proxy.class)
				.verify();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * This is a violation of the LSP.
	 * 
	 * 
	 * You should always use 'instanceof' instead of 'getClass'.
	 */
	
	
	/*
		@Override
		public final boolean equals(Object obj) {
			if (!(obj instanceof Point)) {
				return false;
			}
			Point other = (Point)obj;
			return x == other.x && y == other.y;
		}
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * "There is no way to extend an instantiable class and add a value component 
	 * while preserving the equals contract."
	 * -- Joshua Bloch, Effective Java
	 * 
	 * 
	 *    :(  :(  :(
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}