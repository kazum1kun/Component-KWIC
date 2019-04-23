package component;

import java.util.LinkedList;

public abstract class SuperComponent extends Component {
    protected Component inputComponent;
    protected Component outputComponent;
    protected LinkedList<Component> components;

    public SuperComponent(Component next) {
        super(next);
    }

    public abstract void initSubComponents();

    public abstract void defineInputOutput();
}
