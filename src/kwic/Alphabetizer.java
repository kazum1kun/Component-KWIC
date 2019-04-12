package kwic;

import java.text.Collator;
import java.util.List;
import java.util.concurrent.TimeUnit;

class Alphabetizer implements Runnable {
    public void run() {
        while (true) {
            List<String> lines = StorageBuffer.getShiftedLine();
            if (lines != null) {
                sortLines(lines);
            } else {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void sortLines(List<String> lines) {
        Output output = new Output();
        lines.sort(Collator.getInstance());
        output.lineOutput(lines);
    }
}
