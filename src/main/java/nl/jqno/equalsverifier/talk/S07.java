package nl.jqno.equalsverifier.talk;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.talk.helper.Color;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class S07 {





    public class Point {
        protected final int x;
        protected final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean canEqual(Object o) {
            return o instanceof Point;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;

            Point point = (Point) o;

            if (!point.canEqual(this)) return false;
            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        @Override
        public String toString() {
            return "Point: " + x + "," + y;
        }
    }














    public final class ColorPoint extends Point {
        private final Color color;

        public ColorPoint(int x, int y, Color color) {
            super(x, y);
            this.color = color;
        }

        @Override
        public boolean canEqual(Object o) {
            return o instanceof ColorPoint;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ColorPoint)) return false;
            if (!super.equals(o)) return false;

            ColorPoint that = (ColorPoint) o;
            if (!that.canEqual(this)) return false;
            return color == that.color;
        }

        @Override
        public int hashCode() {
            int result = super.hashCode();
            result = 31 * result + color.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return "ColorPoint: " + x + "," + y + "," + color;
        }
    }














    @Test
    public void solves_symmetry() { // by not allowing added state
        Point p = new Point(1, 1);
        Point q = new ColorPoint(1, 1, Color.INDIGO);

        assertNotEquals(p, q);
        assertNotEquals(q, p);
    }

    @Test
    public void solves_transitivity() { // by not allowing added state
        Point a = new ColorPoint(1, 1, Color.INDIGO);
        Point b = new Point(1, 1);
        Point c = new ColorPoint(1, 1, Color.RED);

        assertNotEquals(a, b);
        assertNotEquals(b, c);
        assertNotEquals(a, c);
    }

    @Test
    public void solves_liskov_substitution_principle() {
        Point p = new Point(1, 1);
        Point sub = new Point(1, 1) {};

        assertEquals(p, sub);
    }














    @Test
    public void equalsverifier() {
        EqualsVerifier.forClass(Point.class)
                .withRedefinedSubclass(ColorPoint.class)
                .verify();

        EqualsVerifier.forClass(ColorPoint.class)
                .withRedefinedSuperclass()
                .verify();
    }














    /**
     * Correct! But awkward...
     */




}
