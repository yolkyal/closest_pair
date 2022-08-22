package model;

import java.util.Objects;

public class Point {

    private final double x;
    private final double y;

    private Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public static Point of(final double x, final double y) {
        return new Point(x, y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("{X=%f, Y=%f}", x, y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Point) {
            Point otherPt = (Point) other;
            return x == otherPt.getX() && y == otherPt.getY();
        }
        return false;
    }

}
