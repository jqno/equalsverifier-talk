package nl.jqno.equalsverifier.talk;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.talk.S03_mutability.ImmutablePoint;

import org.junit.Test;

public class S04_intermezzo {
	
	
	
	
	
	
	
	
	
	
	/*
	 * Actually, I've been lying a little bit. Let's do that last thing again.
	 */
	@Test
	public void equalsverifier_on_immutable_point() {
		EqualsVerifier.forClass(ImmutablePoint.class)
//				.suppress(Warning.STRICT_INHERITANCE)
				.verify();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * First, we need to know the equals contract:
	 * 
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * One last thing.
	 */
	public enum Color {
		RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}