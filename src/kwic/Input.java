package kwic;

import java.util.Arrays;
import java.util.List;
import component.Component;

// Read a comma-delimited string and separate it into a List of strings
public class Input extends Component<List<String>> implements ILineInput {
    Input (Component next) {
        super(next);
    }

    @Override
    public void lineInput(List<String> message) {
        nextComponent.input(message);
    }

    @Override
    public void input(List<String> message) {
        nextComponent.input(message);
    }
}
