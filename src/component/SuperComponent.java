package component;

import java.util.LinkedList;

/**
 * Represents a super component which can include many other component
 */
public abstract class SuperComponent<T> extends Component<T> {
    // Colloquially known as input port
    protected Component<T> inputComponent;
    // Colloquially known as output port
    protected Component<T> outputComponent;
    // Primary storage where each of the component is instantiated and stored during runtime
    protected LinkedList<Component<T>> components;

    public SuperComponent(Component next) {
        super(next);
    }

    // Components should initialized and linked in this step
    public abstract void initSubComponents();

    // Input and output field should be specified in this step
    public abstract void defineInputOutput();
}
