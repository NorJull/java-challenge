package challenge.patterns.creational.singleton;

public class MySingletonLazyObject {
    private static MySingletonLazyObject instance = null;

    private MySingletonLazyObject() {

    }

    //What happens if two thread access to this method at the same time:
    // (instance == null true and two instances are going to be created)
    public static MySingletonLazyObject getInstance() {
        if(instance == null) {
            instance = new MySingletonLazyObject();
        }
        return instance;
    }
}
