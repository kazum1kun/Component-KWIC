package kwic;

import component.Component;
import component.SuperComponent;

import java.util.List;

/**
 * This class represents a SuperComponent KWIC and defines the connectivity between its subcomponents
 * Input -> CircularShifter -> StorageBuffer -> Alphabetizer -> Output
 */
public class Kwic extends SuperComponent<List<String>> {
    public Kwic(Component next) {
        super(next);
        initSubComponents();
    }

    @Override
    public void initSubComponents() {
        // Add all components in a linked list
        // Since we are adding components backwards, and new components need to point to the one previously added,
        // It is ok to use get(1) since that is constantly changing
        components.add(new Output(null));
        components.addFirst(new Alphabetizer(components.get(1)));
        components.addFirst(new StorageBuffer(components.get(1)));
        components.addFirst(new CircularShifter(components.get(1)));
        components.addFirst(new Input(components.get(1)));
    }

    @Override
    public void defineInputOutput() {
        // Input port would be simply the Input (at the beginning), and output being Output (in the end)
        inputComponent = components.peekFirst();
        outputComponent = components.peekLast();
    }

    @Override
    public void input(Object message) {
        inputComponent.input(message);
    }
}
