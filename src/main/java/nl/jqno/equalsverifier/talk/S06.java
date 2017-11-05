package nl.jqno.equalsverifier.talk;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.talk.helper.Color;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class S06 {





    public class Point {
        protected final int x;
        protected final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;

            Point point = (Point) o;

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














    public class ColorPoint extends Point {
        private final Color color;

        public ColorPoint(int x, int y, Color color) {
            super(x, y);
            this.color = color;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (o instanceof ColorPoint) {
                ColorPoint that = (ColorPoint) o;
                return super.equals(that) && color == that.color;
            }

            if (o instanceof Point) {
                return o.equals(this);
            }

            return false;
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
    public void solves_symmetry() {
        Point p = new Point(1, 1);
        Point q = new ColorPoint(1, 1, Color.INDIGO);

        assertEquals(p, q);
        assertEquals(q, p);
    }














    @Test
    public void whats_the_problem() {
        Point a = new ColorPoint(1, 1, Color.INDIGO);
        Point b = new Point(1, 1);
        Point c = new ColorPoint(1, 1, Color.RED);

        assertEquals(a, b);
        assertEquals(b, c);
//        assertEquals(a, c);
    }














    @Test
    public void equalsverifier() {
        EqualsVerifier.forClass(ColorPoint.class)
                .verify();
    }














    /**
     * Transitivity
     */




}
