package nl.jqno.equalsverifier.talk;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import nl.jqno.equalsverifier.EqualsVerifier;

import org.junit.Ignore;
import org.junit.Test;

public class S03_mutability {
	
	/*
	 * Let's start with Point again. This time, it has a hashCode.
	 * 
	 * Also, it has explicit getters and setters.
	 */
	public class Point {
		private int x;
		private int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int getX() { return x; }
		public int getY() { return y; }
		public void setX(int x) { this.x = x; }
		public void setY(int y) { this.y = y; }

		@Override
		public int hashCode() {
			int result = 1;
			result = (31 * result) + x;
			result = (31 * result) + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Point)) {
				return false;
			}
			Point other = (Point)obj;
			return x == other.x && y == other.y;
		}
	}
	
	
	
	
	
	
	/*
	 * Let's set up a test.
	 */
	private Point p = new Point(1, 2);
	private Set<Point> set = new HashSet<Point>();
	{
		set.add(p);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * Why do we care about mutability?
	 * 
	 * Well...
	 */
	@Test
	public void object_should_still_be_findable_in_a_collection_even_if_it_changed() {
		assertTrue(set.contains(p));
		
		// And now, we change p!
		p.setX(1337);
		
		assertTrue(set.contains(p));  //  <-- Fails... PROBABLY.
	}
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * So, the object can no longer be found using contains().
	 * 
	 * Does that mean it's gone?
	 */
	@Ignore
//	@Test
	public void no_its_not_gone() {
		p.setX(1337);
		
		boolean found = false;
		for (Point maybe : set) {
			if (maybe.equals(p)) {
				found = true;
			}
		}
		assertTrue(found);
	}
	
	
	
	
	
	
	
	/*
	 * So... how do we fix this?
	 * 
	 * Solution 1: use immutable id fields, like a database.
	 *  - you will lose semantic equality.
	 * 
	 * Solution 2: use immutable data classes.
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * Here's an immutable Point.
	 * 
	 * Note the use of the 'final' keyword.
	 */
	public class ImmutablePoint {
		private final int x;
		private final int y;
		
		public ImmutablePoint(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			int result = 1;
			result = (31 * result) + x;
			result = (31 * result) + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof ImmutablePoint)) {
				return false;
			}
			ImmutablePoint other = (ImmutablePoint)obj;
			return x == other.x && y == other.y;
		}
	}	
	
	/*
	 * And an EqualsVerifier test.
	 */
	@Ignore
//	@Test
	public void equalsverifier() {
		EqualsVerifier.forClass(ImmutablePoint.class)
				.verify();
	}
	
	
	
	
	
	
	
	
	
}