package model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Graph {

    private final Set<Point> points;

    public Graph(int size) {
        this.points = new HashSet<>(size);
    }

    public static Graph randomised(int size) {
        final Graph graph = new Graph(size);
        for (int i = 0; i < size; i++) {
            graph.add(Point.of(Math.random(), Math.random()));
        }
        return graph;
    }

    public void add(Point point) {
        points.add(point);
    }

    public Collection<Point> getPoints() {
        return points;
    }

    public int size() {
        return points.size();
    }

    @Override
    public String toString() {
        return String.format("[\n\t%s\n]", points.stream().map(Point::toString).collect(Collectors.joining("\n\t")));
    }

}
