package challenge.patterns.creational.singleton;

public class MySingletonThreadSafeObject {
    private static MySingletonThreadSafeObject instance = null;

    private MySingletonThreadSafeObject() {

    }


    //Only one thread can access to this method
    public static synchronized MySingletonThreadSafeObject getInstance() {
        if(instance == null) {
            instance = new MySingletonThreadSafeObject();
        }
        return instance;
    }
}
