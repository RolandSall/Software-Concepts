public class SingletonObject {


    private static SingletonObject instance = new SingletonObject();

    // make constructor private
    private SingletonObject(){

    }

    public static SingletonObject getInstance(){
        return instance;
    }

    public void showMessage(){
        System.out.println("Message From A Singleton Object");
    }
}
