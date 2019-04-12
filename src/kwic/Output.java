package kwic;

import java.util.List;

public class Output implements ILineOutput {

    @Override
    public String lineOutput(List<String> line) {
        String output = String.join("\n", line);
        System.out.println(output);
        return output;
    }
}
