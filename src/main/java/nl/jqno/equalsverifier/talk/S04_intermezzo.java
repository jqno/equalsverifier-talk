package nl.jqno.equalsverifier.talk;

public class S04_intermezzo {


	/*
	 * Why did EqualsVerifier say that "equals is not final"?
	 */

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
	 * (Our mutable Point breaks consistency.)
	 */
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * One more thing.
	 */
	public enum Color {
		RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}