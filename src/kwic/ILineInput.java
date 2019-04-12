package kwic;

import java.util.List;

public interface ILineInput {
    /**
     * Accepts a comma-delimited line and forward it into components for further processing
     * @return a List of separated lines
     */
    List<String> lineInput();
}
