package nl.jqno.equalsverifier.talk;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.junit.Test;

public class S04 {
	
	
	
	
	
	
	
	
	
	
	/*
	 * Actually, I've been lying a little bit. Let's do that last thing again.
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
			return 31 * (31 + x) + y;
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
	 * In reality, I've been redirecting all EqualsVerifier calls to THIS.
	 */
	@Test
	public void equalsverifier_on_immutable_point() {
		EqualsVerifier.forClass(ImmutablePoint.class)
				.suppress(Warning.STRICT_INHERITANCE)
				.verify();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * I think this is a pretty nice solution!
	 * 
	 * But putting making your classes final is not always an option.
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * How do we fix this?
	 * 
	 * First, we need to know the equals contract.
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/* 
	 * - Reflexivity       x == x
	 * 
	 * - Symmetry          if x == y, then y == x
	 * 
	 * - Transitivity      if x == y and y == z, then x == z
	 * 
	 * - Consistency       if x == y now, then x == y always
	 * 
	 * - Non-nullity       x == null is never true
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * Our mutable Point broke consistency, BTW.
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}