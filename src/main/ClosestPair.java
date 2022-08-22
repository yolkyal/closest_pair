package main;

import model.Graph;
import model.Pair;
import solver.ClosestPairSolver;
import solver.ClosestPairSolverFactory;
import solver.SolverStrategy;
import util.Timer;

public class ClosestPair {

    public static void main(String[] args) {
        final int size = Integer.parseInt(args[0]);
        final Graph graph = Graph.randomised(size);

        final SolverStrategy strategy = SolverStrategy.valueOf(args[1]);
        final ClosestPairSolver solver = ClosestPairSolverFactory.createClosestPairSolver(strategy);

        solve(graph, solver);
    }

    private static void solve(Graph graph, ClosestPairSolver solver) {
        final Timer timer = new Timer();
        timer.start();
        final Pair closestPair = solver.solve(graph);
        timer.stop();

        System.out.println("n=" + graph.size());
        System.out.println("pair=" + closestPair);
        System.out.println("d=" + closestPair.getDistance());
        System.out.println("t=" + timer.getMillis() + "ms");
    }

}
