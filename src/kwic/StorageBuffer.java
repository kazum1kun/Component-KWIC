package kwic;

import component.Component;

import java.util.List;
import java.util.Stack;

/*
    This is a Buffer/Pipe between CircularShifter and Alphabetizer
 */
class StorageBuffer extends Component<List<String>> {
    // Define maximum capacity of the pipe and store the data in a Stack
    private static final int capacity = 5;
    private static final Stack<List<String>> buffer = new Stack<>();
    private static int currentSize = 0;

    StorageBuffer(Component next) {
        super(next);
    }

    private static boolean putShiftedLine(List<String> input) {
        // Do not proceed if the current size exceeds the capacity.
        if (currentSize >= capacity) {
            return false;
        } else {
            buffer.push(input);
            currentSize++;
            return true;
        }
    }

    public static int getAvailableCapacity() {
        return capacity - currentSize;
    }

    @Override
    public void input(List<String> message) {
        putShiftedLine(message);
        pushContents();
    }

    private void pushContents() {
        // Return empty string if the buffer is empty
        if (!buffer.empty()) {
            currentSize--;
            nextComponent.input(buffer.pop());
        }
    }
}
