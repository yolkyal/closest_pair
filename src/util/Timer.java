package util;

public class Timer {

    private long started = 0;
    private long stopped = 0;

    public Timer() {
    }

    public void start() {
        started = System.nanoTime();
    }

    public void stop() {
        stopped = System.nanoTime();
    }

    public double getMillis() {
        return (double) (stopped - started) / 1000000;
    }

}
