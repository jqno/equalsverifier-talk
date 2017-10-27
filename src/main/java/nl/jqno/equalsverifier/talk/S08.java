package nl.jqno.equalsverifier.talk;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class S08 {





    public class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // GENERATE HERE

        @Override
        public String toString() {
            return "Point: " + x + "," + y;
        }
    }

    @Test
    public void equalsverifier() {
        EqualsVerifier.forClass(Point.class)
                .verify();
    }














    /**
     * Correct! And simple.
     */





}
