package solver;

import java.util.Iterator;
import java.util.List;

import model.Graph;
import model.Pair;
import model.Point;

class ClosestPairSolverRandomisedLinear implements ClosestPairSolver {

    @Override
    public Pair solve(final Graph graph) {
        final double estimatedClosestPairDistance = calculateEstimatedClosestPairDistance(graph);

        final SnapGrid snapGrid = SnapGrid.from(graph, estimatedClosestPairDistance);

        Pair closestPair = null;
        double closestPairSquareDistance = 2;
        for (int x = 1; x < snapGrid.size() - 1; x++) {
            for (int y = 1; y < snapGrid.size() - 1; y++) {
                List<Point> points = snapGrid.getAllConsecutivePoints(x, y);
                if (points.size() > 1) {
                    Pair pair = bruteForce(points);
                    double pairSquareDistance = pair.getSquareDistance();
                    if (pairSquareDistance < closestPairSquareDistance) {
                        closestPair = pair;
                        closestPairSquareDistance = pairSquareDistance;
                    }
                }
            }
        }

        return closestPair;
    }

    private Pair bruteForce(List<Point> pointList) {
        Pair closestPair = Pair.of(pointList.get(0), pointList.get(1));
        double closestPairSquareDistance = closestPair.getSquareDistance();
        for (int i = 1; i < pointList.size() - 1; i++) {
            for (int j = i + 1; j < pointList.size(); j++) {
                Pair pair = Pair.of(pointList.get(i), pointList.get(j));
                double pairSquareDistance = pair.getSquareDistance();
                if (pairSquareDistance < closestPairSquareDistance) {
                    closestPair = pair;
                    closestPairSquareDistance = pairSquareDistance;
                }
            }
        }

        return closestPair;
    }

    private double calculateEstimatedClosestPairDistance(final Graph graph) {
        double minConsecutivePointDistance = Double.MAX_VALUE;
        final Iterator<Point> pointIt = graph.getPoints().iterator();
        Point previous = pointIt.next();
        while (pointIt.hasNext()) {
            Point current = pointIt.next();
            Pair pair = Pair.of(previous, current);
            minConsecutivePointDistance = Math.min(minConsecutivePointDistance, pair.getDistance());
            previous = current;
        }

        return minConsecutivePointDistance;
    }

}
