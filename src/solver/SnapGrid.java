package solver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.Graph;
import model.Point;

class SnapGrid {

    private final int size;
    private final Map<Integer, Map<Integer, Set<Point>>> pointMap;

    private SnapGrid(Map<Integer, Map<Integer, Set<Point>>> pointMap) {
        this.pointMap = pointMap;
        size = pointMap.size();
    }

    public static SnapGrid from(final Graph graph, final double degree) {
        final int size = (int) (1.0 / degree) + 3; // deliberately oversized to remove need for outofbounds checks
        final Map<Integer, Map<Integer, Set<Point>>> pointMap = new HashMap<>(size);
        for (int i = 0; i < size; i++) {
            Map<Integer, Set<Point>> map = new HashMap<>(size);
            for (int j = 0; j < size; j++) {
                map.put(j, new HashSet<>());
            }
            pointMap.put(i, map);
        }

        graph.getPoints().forEach(point -> {
            final Integer x = snapValueToDegree(point.getX(), degree);
            final Integer y = snapValueToDegree(point.getY(), degree);
            pointMap.get(x).get(y).add(point);
        });

        return new SnapGrid(pointMap);
    }

    public List<Point> getAllConsecutivePoints(final Integer x, final Integer y) {
        List<Point> points = new ArrayList<>();
        points.addAll(pointMap.get(x - 1).get(y - 1));
        points.addAll(pointMap.get(x).get(y - 1));
        points.addAll(pointMap.get(x + 1).get(y - 1));
        points.addAll(pointMap.get(x - 1).get(y));
        points.addAll(pointMap.get(x).get(y));
        points.addAll(pointMap.get(x + 1).get(y));
        points.addAll(pointMap.get(x - 1).get(y + 1));
        points.addAll(pointMap.get(x).get(y + 1));
        points.addAll(pointMap.get(x + 1).get(y + 1));
        return points;
    }

    @Override
    public String toString() {
        return String.format("{%s}", pointMap.toString());
    }

    private static int snapValueToDegree(final double val, final double degree) {
        return (int) (val / degree) + 1;
    }

    public int size() {
        return size;
    }

}
