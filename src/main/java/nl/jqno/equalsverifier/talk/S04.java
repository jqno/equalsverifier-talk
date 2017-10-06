package nl.jqno.equalsverifier.talk;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class S04 {

    /**
     * Consistency
     */

    public class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

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


    @Test
    public void whats_the_problem() {
        Point point = new Point(1, 1);

        Set<Point> pts = new HashSet<>();
        pts.add(point);

        point.x = 2;
        assertTrue(pts.contains(point));
    }


    @Test
    public void equalsverifier() {
        EqualsVerifier.forClass(Point.class)
                .usingGetClass()
                .verify();
    }
}
