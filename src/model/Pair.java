package model;

public class Pair {

    private final Point p1;
    private final Point p2;

    private Pair(final Point p1, final Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public static Pair of(final Point p1, final Point p2) {
        return new Pair(p1, p2);
    }

    public double getDistance() {
        return Math.sqrt(this.getSquareDistance());
    }

    public double getSquareDistance() {
        double xDisplacement = p2.getX() - p1.getX();
        double yDisplacement = p2.getY() - p1.getY();
        return xDisplacement * xDisplacement + yDisplacement * yDisplacement;
    }

    @Override
    public String toString() {
        return String.format("{%s, %s}", p1 != null ? p1.toString() : "null", p2 != null ? p2.toString() : "null");
    }

}
