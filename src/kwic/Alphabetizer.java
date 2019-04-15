package kwic;

import component.Component;

import java.text.Collator;
import java.util.List;

class Alphabetizer extends Component<List<String>> {
    public Alphabetizer(Component next) {
        super(next);
    }

    @Override
    public void input(List<String> message) {
        if (message != null) {
            sortLines(message);
        }
    }

    private void sortLines(List<String> lines) {
        lines.sort(Collator.getInstance());
        nextComponent.input(lines);
    }
}
