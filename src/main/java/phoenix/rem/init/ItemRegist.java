package phoenix.rem.init;

import phoenix.rem.REMMod;
import phoenix.rem.items.Wrench;
import phoenix.rem.items.test.MultiMeter;
import phoenix.rem.main.CTabs;

/**
 * Created by Elec332 on 5-2-2015.
 */
public class ItemRegist {

    public static final ItemRegist instance = new ItemRegist();

    public void init(){
        if (REMMod.developmentEnvironment) {
            new MultiMeter("multimeter").setCreativeTab(CTabs.TabMain);
        }

        new Wrench("wrench");
    }
}
