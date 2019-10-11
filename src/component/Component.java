package component;

/**
 * Represents a component in a component diagram
 * @param <T> the type of massage being used between components
 */
public abstract class Component<T> {
    // Next component where the result from this component will be delivered
    protected Component<T> nextComponent;

    public Component(Component<T> next) {
        nextComponent = next;
    }

    // Accept some input and send the output to next component
    public abstract void input(T message);
}
