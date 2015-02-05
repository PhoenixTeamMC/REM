package phoenix.rem.init;

import phoenix.rem.items.Wrench;

/**
 * Created by Elec332 on 5-2-2015.
 */
public class ItemRegist {

    public static final ItemRegist instance = new ItemRegist();

    public void init(){
        new Wrench("wrench");
    }
}
