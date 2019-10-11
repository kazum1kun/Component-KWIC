package kwic;

import component.Component;

import java.text.Collator;
import java.util.List;

/**
 * COMPONENT
 * Input: A List of Strings
 * Output: A List of Strings, sorted in ascending order alphabetically
 */
class Alphabetizer extends Component<List<String>> {
    Alphabetizer(Component<List<String>> next) {
        super(next);
    }

    @Override
    public void input(List<String> message) {
        if (message != null) {
            sortLines(message);
        }
    }

    // Use Java built-in function to sort the lines
    private void sortLines(List<String> lines) {
        lines.sort(Collator.getInstance());
        nextComponent.input(lines);
    }
}
