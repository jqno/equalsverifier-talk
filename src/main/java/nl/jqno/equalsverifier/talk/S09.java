package nl.jqno.equalsverifier.talk;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.talk.helper.Color;
import nl.jqno.equalsverifier.talk.helper.NonNull;

import org.junit.Test;

public class S09 {
	
	
	
	
	
	
	
	
	
	
	/*
	 * But... that's kind of sad.
	 * 
	 * Isn't there another way? 
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * COULD JOSH BLOCH BE WRONG!?
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * As it turns out, he could!
	 * 
	 * Martin Odersky, Lex Spoon and Bill Venners describe it in their Scala book.
	 */
	
	
	
	/*
	 * But it's not trivial.
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public class Point {
		private final int x;
		private final int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			return 53 * (53 + x) + y;
		}
		
		
		
		
		
		
		
		/*
		 * Add a canEqual method:
		 */
		public boolean canEqual(Object obj) {
			return obj instanceof Point;
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Point)) {
				return false;
			}
			Point other = (Point)obj;
			/*
			 * And then check if other is compatible with us:
			 */
			return other.canEqual(this) && x == other.x && y == other.y;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * Leaf nodes should be final.
	 * 
	 * (Or at least, have final equals and hashCode methods.)
	 */
	public final class ColorPoint extends Point {
		@NonNull private final Color color;
		
		public ColorPoint(int x, int y, Color color) {
			super(x, y);
			this.color = color;
		}

		@Override
		public int hashCode() {
			return 53 * (53 + super.hashCode()) + color.hashCode();
		}
		
		
		
		
		
		
		
		/*
		 * Note that now, obj must instanceof ColorPoint!
		 */
		@Override
		public boolean canEqual(Object obj) {
			return obj instanceof ColorPoint;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof ColorPoint)) {
				return false;
			}
			ColorPoint other = (ColorPoint)obj;
			return other.canEqual(this) && color.equals(other.color) && super.equals(obj);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * EqualsVerifier gets a bit more involved:
	 */
	
	@Test
	public void equalsverifier_on_point() {
		EqualsVerifier.forClass(Point.class)
				.withRedefinedSubclass(ColorPoint.class)
				.verify();
	}
	
	@Test
	public void equalsverifier_on_color_point() {
		EqualsVerifier.forClass(ColorPoint.class)
				.withRedefinedSuperclass()
				.verify();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * That's because EqualsVerifier wants to:
	 * 
	 * - make the common stuff easy, and
	 * 
	 * - make the uncommon stuff possible.
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * But it also works on our Proxy!
	 */
	public final class Point$$Proxy extends Point {
		public Point$$Proxy(int x, int y) {
			super(x, y);
		}
	}
	
//	@Test
	public void equalsverifier_on_proxy() {
		EqualsVerifier.forClass(Point$$Proxy.class)
				.verify();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}