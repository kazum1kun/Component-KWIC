package component;

public abstract class Component<T> {
    protected Component nextComponent;

    public Component(Component next) {
        nextComponent = next;
    }

    // Accept some input and send the output to next component
    public abstract void input(T message);
}
