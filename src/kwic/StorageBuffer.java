package kwic;

import java.util.List;
import java.util.Stack;
import component.Component;

/*
    This is a Buffer/Pipe between CircularShifter and Alphabetizer
 */
class StorageBuffer extends Component<List<String>> {
    // Define maximum capacity of the pipe and store the data in a Stack
    private static final int capacity = 5;
    private static int currentSize = 0;
    private static final Stack<List<String>> buffer = new Stack<>();

    public StorageBuffer(Component next) {
        super(next);
    }

    @Override
    public void input(List<String> message) {
        putShiftedLine(message);
        pushContents();
    }

    static boolean putShiftedLine(List<String> input) {
        // Do not proceed if the current size exceeds the capacity.
        if (currentSize >= capacity) {
            return false;
        }
        else {
            buffer.push(input);
            currentSize++;
            return true;
        }
    }

    void pushContents() {
        // Return empty string if the buffer is empty
        if (!buffer.empty()) {
            currentSize--;
            nextComponent.input(buffer.pop());
        }
    }

    public static int getAvailableCapacity() {
        return capacity - currentSize;
    }
}
