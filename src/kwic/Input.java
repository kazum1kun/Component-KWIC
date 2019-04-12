package kwic;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// Read a comma-delimited string and separate it into a List of strings
public class Input implements ILineInput {
    @Override
    public List<String> lineInput() {
        Scanner scanner = new Scanner(System.in);
        return Arrays.asList(scanner.nextLine().strip().split("\\s*,\\s*"));
    }
}
