package LabTuto03;

public class StopWatch {
    private long start;
    private double accumulated = 0.0;
    private boolean running;

    public void start() {
        if (!running) {
            start = System.currentTimeMillis();
            running = true;
        }
    }

    public void stop() {
        if (running) {
            accumulated += (System.currentTimeMillis() - start) / 1000.0;
            running = false;
        }
    }

    public double elapsedTime() {
        if (running) {
            return accumulated + (System.currentTimeMillis() - start) / 1000.0;
        } else {
            return accumulated;
        }
    }

    public boolean isRunning() {
        return running;
    }
}