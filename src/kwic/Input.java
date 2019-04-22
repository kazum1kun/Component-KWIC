package kwic;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import component.Component;

// Read a comma-delimited string and separate it into a List of strings
public class Input extends Component<List<String>> implements ILineInput {
    Input (Component next) {
        super(next);
    }

    // Todo need to work on this
    @Override
    public List<String> lineInput() {
        Scanner scanner = new Scanner(System.in);
        return Arrays.asList(scanner.nextLine().strip().split("\\s*,\\s*"));
    }

    @Override
    public void input(List<String> message) {

    }
}
