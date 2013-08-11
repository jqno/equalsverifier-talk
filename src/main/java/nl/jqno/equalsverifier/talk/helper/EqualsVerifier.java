package nl.jqno.equalsverifier.talk.helper;

import nl.jqno.equalsverifier.Warning;

/*
 * OK, OK, I'm cheating a bit here:
 * I don't want the inheritance-related warnings to show up just yet.
 * 
 * No need to show this to the audience. :P
 */
public class EqualsVerifier {
	public static <T> nl.jqno.equalsverifier.EqualsVerifier<T> forClass(Class<T> type) {
		return nl.jqno.equalsverifier.EqualsVerifier.forClass(type).suppress(Warning.STRICT_INHERITANCE, Warning.NULL_FIELDS);
	}
}