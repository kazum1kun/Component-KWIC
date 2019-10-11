package kwic;

import component.Component;

import java.util.List;

public class Output extends Component<List<String>> implements ILineOutput {
    Output(Component<List<String>> next) {
        super(next);
    }

    @Override
    public String lineOutput(List<String> line) {
        String output = String.join("\n", line);
        System.out.println(output);
        return output;
    }

    @Override
    public void input(List<String> message) {
        lineOutput(message);
    }
}
