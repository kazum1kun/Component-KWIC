package component;

public abstract class SuperComponent extends Component {
    private Component inputComponent;
    private Component outputComponent;

    public SuperComponent(Component next) {
        super(next);
    }

    public abstract void initSubComponents();

    public abstract void defineConnectivity();
}
