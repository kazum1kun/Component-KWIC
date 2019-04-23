package component;

import java.util.LinkedList;

/**
 * Represents a super component which can include many other component
 */
public abstract class SuperComponent extends Component {
    // Colloquially known as input port
    protected Component inputComponent;
    // Colloquially known as output port
    protected Component outputComponent;
    // Primary storage where each of the component is instantiated and stored during runtime
    protected LinkedList<Component> components;

    public SuperComponent(Component next) {
        super(next);
    }

    // Components should initialized and linked in this step
    public abstract void initSubComponents();

    // Input and output field should be specified in this step
    public abstract void defineInputOutput();
}
