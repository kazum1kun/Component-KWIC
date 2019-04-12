package kwic;

import java.util.List;
import java.util.Stack;

/*
    This is a Buffer/Pipe between CircularShifter and Alphabetizer
 */
class StorageBuffer {
    // Define maximum capacity of the pipe and store the data in a Stack
    private static final int capacity = 5;
    private static int currentSize = 0;
    private static final Stack<List<String>> buffer = new Stack<>();

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

    static List<String> getShiftedLine() {
        // Return empty string if the buffer is empty
        if (buffer.empty()) {
            return null;
        }
        else {
            currentSize--;
            return buffer.pop();
        }
    }

    public static int getAvailableCapacity() {
        return capacity - currentSize;
    }
}
