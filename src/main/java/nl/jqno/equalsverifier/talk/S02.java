package nl.jqno.equalsverifier.talk;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class S02 {





    public class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Point obj) {
            if (!(obj instanceof Point)) {
                return false;
            }
            return x == obj.x && y == obj.y;
        }
    }















    @Test
    public void whats_the_problem() {
        Point point = new Point(1, 1);
        Point clone = new Point(1, 1);

        List<Point> pts = List.of(point);

        assertTrue(pts.contains(clone));
    }















    @Test
    public void get_a_better_error_message() {
        EqualsVerifier.forClass(Point.class)
                .verify();
    }

    /**
     * Reflexivity
     */





}
