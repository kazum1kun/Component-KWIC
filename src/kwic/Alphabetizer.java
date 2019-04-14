package kwic;

import component.Component;

import java.text.Collator;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
        Output output = new Output();
        lines.sort(Collator.getInstance());
        output.lineOutput(lines);
    }
}
