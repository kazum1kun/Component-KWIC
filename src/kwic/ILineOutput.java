package kwic;

import java.util.List;

public interface ILineOutput {
    /**
     * Return a set of lines that are shifted, and sorted.
     *
     * @return a set of lines delimited by \n
     */
    String lineOutput(List<String> line);
}
