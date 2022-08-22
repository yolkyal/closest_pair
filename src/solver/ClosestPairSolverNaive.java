package solver;

import java.util.ArrayList;
import java.util.List;

import model.Graph;
import model.Pair;
import model.Point;

class ClosestPairSolverNaive implements ClosestPairSolver {

    @Override
    public Pair solve(final Graph graph) {
        List<Point> pointList = new ArrayList<>(graph.getPoints());

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

}
