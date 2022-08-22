package solver;

public final class ClosestPairSolverFactory {

    private ClosestPairSolverFactory() {
    }

    public static ClosestPairSolver createClosestPairSolver(SolverStrategy strategy) {
        switch (strategy) {
            case NAIVE:
                return createNaiveClosestPairSolver();
            case RANDOMISED_LINEAR:
                return createRandomisedLinearClosestPairSolver();
            default:
                throw new RuntimeException("SolverStrategy does not match any registered ClosestPairSolver: " + strategy.name());
        }
    }

    private static ClosestPairSolver createNaiveClosestPairSolver() {
        return new ClosestPairSolverNaive();
    }

    private static ClosestPairSolver createRandomisedLinearClosestPairSolver() {
        return new ClosestPairSolverRandomisedLinear();
    }

}
