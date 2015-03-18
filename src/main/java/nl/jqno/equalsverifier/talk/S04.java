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
			return 53 * (53 + x) + y;
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
	 * But making your classes final is not always an option.
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * How do we fix this?
	 * 
	 * First, we need to know the equals contract.
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/* 
	 * - Reflexivity       Apple == Apple
	 * 
	 * - Symmetry          if Apple == Orange, then Orange == Apple
	 * 
	 * - Transitivity      if Apple == Banana and Banana == Orange, then Apple == Orange
	 * 
	 * - Consistency       if Apple == Orange now, then Apple == Orange always
	 * 
	 * - Non-nullity       Apple == null is never true
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * Our mutable Point broke consistency, BTW.
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}