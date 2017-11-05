package nl.jqno.equalsverifier.talk;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.talk.helper.Color;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class S05 {





    public class Point {
        protected final int x;
        protected final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // GENERATE HERE, accepting subclasses

        @Override
        public String toString() {
            return "Point: " + x + "," + y;
        }
    }














    @Test
    public void solves_liskov_substitution_principle() {
        Point p = new Point(1, 1);
        Point sub = new Point(1, 1) {};

        assertEquals(p, sub);
    }














    public class ColorPoint extends Point {
        private final Color color;

        public ColorPoint(int x, int y, Color color) {
            super(x, y);
            this.color = color;
        }

        // GENERATE HERE

        @Override
        public String toString() {
            return "ColorPoint: " + x + "," + y + "," + color;
        }
    }














    @Test
    public void whats_the_problem() {
        Point p = new Point(1, 1);
        Point q = new ColorPoint(1, 1, Color.INDIGO);

        assertEquals(p, q);
//        assertEquals(q, p);
    }














    @Test
    public void equalsverifier() {
        EqualsVerifier.forClass(ColorPoint.class)
                .verify();
    }














    /**
     * Symmetry
     */





}
