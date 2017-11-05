package nl.jqno.equalsverifier.talk;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class S04 {





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
    public void whats_the_problem() {
        Point p = new Point(1, 1);
        Point sub = new Point(1, 1) {};

        assertEquals(p, sub);
    }














    @Test
    public void equalsverifier() {
        EqualsVerifier.forClass(Point.class)
//                .usingGetClass()
                .verify();
    }














    /**
     *   S
     *   O
     *   Liskov Substitution Principle
     *   I
     *   D
     */





}
