package challenge.patterns.creational.singleton;

public class MySingletonEagerObject {
    private static MySingletonEagerObject instance = new MySingletonEagerObject();

    private MySingletonEagerObject() {

    }

    // What happens if this class is never used:
    // (MySingletonEagerObject is going to be there occupying memory space)
    public static MySingletonEagerObject getInstance(){
        return instance;
    }
}
