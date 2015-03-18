package nl.jqno.equalsverifier.talk;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import nl.jqno.equalsverifier.EqualsVerifier;

import org.junit.Test;

public class S01 {
	
	
	
	
	
	
	
	
	
	
	/*
	 * What's wrong with this implementation?
	 */
	public class Point {
		private int x;
		private int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public boolean equals(Point obj) {
			return x == obj.x && y == obj.y;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * Let's create some example data.
	 */
	private Point p1 = new Point(0, 1);
	private Point p2 = new Point(0, 1);
	private Point p3 = new Point(1, 2);
	
	
	/*
	 * It works, doesn't it?
	 */
	@Test
	public void equals_tests_equality_and_inequality() {
		assertTrue(p1.equals(p2));
		assertFalse(p1.equals(p3));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * Well... no. No it doesn't. :(
	 */
//	@Test
	public void equals_works_correctly_with_collections() {
		List<Point> list = new ArrayList<>();
		list.add(p1);
		
		assertTrue(list.contains(p2));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * Once more, with EqualsVerifier.
	 */
//	@Test
	public void equalsverifier() {
		EqualsVerifier.forClass(Point.class)
				.verify();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * Here's a better implementation.
	 */
	
	/*
		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Point)) {
				return false;
			}
			Point other = (Point)obj;
			return x == other.x && y == other.y;
		}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}