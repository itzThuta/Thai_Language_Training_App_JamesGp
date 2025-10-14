package LabTuto03;

public class StopWatchCLI {
    public static void main(String[] args) throws Exception{
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();

        System.out.println("Stopwatch started. Press Enter to pause/resume. Ctrl+C to quit.");

        while (true) {
            if (System.in.available() > 0) {
                int c = System.in.read();
                if (c == '\n' || c == '\r') {
                    if (stopwatch.isRunning()) {
                        stopwatch.stop();
                    } else {
                        stopwatch.start();
                    }
                }
            }

            System.out.printf("\rElapsed time: %.2f s", stopwatch.elapsedTime());
            Thread.sleep(100);
        }
    }
}
