package Domain;

import java.util.ArrayList;

public abstract class Pizza {
    private String name;
    private String dough;
    private String sauce;



    public abstract void prepare();

    public abstract void bake();

    public void box(){
        System.out.println("Put In A Box! And Ready To Go");
    }

}
