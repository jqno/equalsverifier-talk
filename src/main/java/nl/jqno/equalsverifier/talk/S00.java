package nl.jqno.equalsverifier.talk;

public class S00 {





    /**
     * Not all equals() methods are created equal
     *
     *
     *                    -or-
     *
     * How to write a good equals method in Java
     *
     *
     *
     *
     *                           -by- Jan Ouwens
     *                                @jqno
     */















	/**
	 * About me:
	 *
	 * - CODE.STΛR
	 *
	 * - EqualsVerifier
	 *
	 * - "Scala by day, Java by night"
	 */















    /**
     * In this talk:
     *
     * - equals()
     *
     * - pitfalls in equals()
     *
     * - EqualsVerifier
     */















    /**
     * Our running example.
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
            return "Point: " + x + "," + y;
        }
    }

    public enum Color {
        RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
    }




}
