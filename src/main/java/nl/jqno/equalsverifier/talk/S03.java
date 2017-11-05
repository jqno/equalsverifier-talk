package nl.jqno.equalsverifier.talk;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class S03 {





    public final class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Point)) {
                return false;
            }
            Point other = (Point)o;
            return x == other.x && y == other.y;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 53 * result + x;
            result = 53 * result + y;
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
                .verify();
    }














    /**
     * Consistency
     */





}
