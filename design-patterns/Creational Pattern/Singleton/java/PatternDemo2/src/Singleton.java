public class Singleton {

    private static Singleton singleton = null;
    private Singleton(){

    }

    public static Singleton getInstance(){

        synchronized(Singleton.class){
            if(singleton == null) {
                singleton = new Singleton();
            }
        }

        return singleton;
    }
}
