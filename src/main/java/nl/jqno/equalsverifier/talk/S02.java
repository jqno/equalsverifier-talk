package nl.jqno.equalsverifier.talk;

import static junit.framework.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import nl.jqno.equalsverifier.talk.helper.EqualsVerifier;

import org.junit.Test;

public class S02 {
	
	
	
	
	
	
	
	
	
	
	/*
	 * Let's start with Point again.
	 * This time, it has the correct equals signature.
	 */
	public class Point {
		private int x;
		private int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return String.format("Point: %s,%s", x, y);
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
	 * Two equal points.
	 */
	private Point p1 = new Point(0, 1);
	private Point p2 = new Point(0, 1);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * Why do we care about hashCode?
	 * 
	 * Well...
	 */
	@Test
	public void object_can_be_found_in_a_hash_based_collection() {
		Set<Point> set = new HashSet<>();
		set.add(p1);
		
		assertTrue(set.contains(p2));  //  <-- Fails... PROBABLY.
	}
	
	@Test
	public void equalsverifier() {
		EqualsVerifier.forClass(Point.class)
				.verify();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * The hashCode contract:
	 * 
	 * - Always returns the same value (per execution);
	 * - If two objects are equal, they must have the same hashCode.
	 */


	/*
		@Override
		public int hashCode() {
			return 42;  //  <-- Fulfills the contract! Oh yeah.
		}
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * Let's write a hashCode with a proper distribution.
	 */
	

	/*
		@Override
		public int hashCode() {
			int result = 17;
			result = (31 * result) + x;
			result = (31 * result) + y;
			return result;
		}
	 */



















	/*
	 * Actually, this one might even be slightly better!
	 */


	/*
		@Override
		public int hashCode() {
			int result = 17;
			result = (53 * result) + x;
			result = (53 * result) + y;
			return result;
		}
	 */  


	/*
	 * Why? Because 31...
	 *
	 * - is already used extensively by the Java API's, so there's more chance of overlap
	 *
	 * - 31's binary representation is 11111  :/
	 */




















}
