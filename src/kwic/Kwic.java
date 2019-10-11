package kwic;

import component.Component;
import component.SuperComponent;

import java.util.LinkedList;
import java.util.List;

/**
 * This class represents a SuperComponent KWIC and defines the connectivity between its subcomponents
 * Input -> CircularShifter -> StorageBuffer -> Alphabetizer -> Output
 */
public class Kwic extends SuperComponent<List<String>> {
    public Kwic(Component next) {
        super(next);
        components = new LinkedList<>();
        initSubComponents();
        defineInputOutput();
    }

    @Override
    public void initSubComponents() {
        // Add all components in a linked list
        // Since we are adding components backwards, and new components need to point to the one previously added,
        // It is ok to use get(1) since that is constantly changing
        components.add(new Output(null));
        components.addFirst(new Alphabetizer(components.peek()));
        components.addFirst(new StorageBuffer(components.peek()));
        components.addFirst(new CircularShifter(components.peek()));
        components.addFirst(new Input(components.peek()));
    }

    @Override
    public void defineInputOutput() {
        // Input port would be simply the Input (at the beginning), and output being Output (in the end)
        inputComponent = components.peek();
        outputComponent = components.peekLast();
    }

    @Override
    public void input(List<String> message) {
        inputComponent.input(message);
    }
}
