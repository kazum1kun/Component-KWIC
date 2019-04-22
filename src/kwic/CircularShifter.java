package kwic;

import component.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

// CircularShifter reads in a set of lines and shift through each of them
class CircularShifter extends Component<List<String>> {
    public CircularShifter(Component next) {
        super(next);
    }

    @Override
    public void input(List<String> message) {
            shiftLines(message);
    }

    private void shiftLines(List<String> original) {
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

        nextComponent.input(shifted);
    }
}
