package kwic;

import java.util.*;
import java.util.concurrent.TimeUnit;

// CircularShifter reads in a set of lines and shift through each of them
class CircularShifter implements Runnable {
    // Repeatedly read time
    public void run () {
        ILineInput input = new Input();
        while (true) {
            try {
                List<String> original = input.lineInput();
                shiftLines(original);
            } catch (NoSuchElementException ex) {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    void shiftLines(List<String> original) {

        List<String> shifted = new ArrayList<>();

        // Iterate through the original lines
        for (String line : original) {
            // Separate the line into an array
            String[] words =  line.split(" ");
            List<String> currentShiftedLine = new LinkedList<>(Arrays.asList(words));

            // Shift the line from 0 to n-1 times
            for (int i = 0; i < currentShiftedLine.size(); i++) {
                shifted.add(String.join(" ", currentShiftedLine));
                // Remove a word from the beginning and append it to the end
                currentShiftedLine.add(currentShiftedLine.remove(0));
            }
        }

        // Attempt to add the shifted lines into the pipe
        while (!StorageBuffer.putShiftedLine(shifted)) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
