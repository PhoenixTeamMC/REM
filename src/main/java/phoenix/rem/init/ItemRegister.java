package phoenix.rem.init;

import net.minecraft.item.Item;
import phoenix.rem.REMMod;
import phoenix.rem.items.Wrench;
import phoenix.rem.items.test.MultiMeter;
import phoenix.rem.main.CTabs;

/**
 * Created by Elec332 on 5-2-2015.
 */
public class ItemRegister {

    public static final ItemRegister instance = new ItemRegister();

    Item wrench;
    
    public void init(){
        if (REMMod.developmentEnvironment) {
            new MultiMeter("multimeter").setCreativeTab(CTabs.TabMain);
        }

        wrench = new Wrench("wrench");
    }
}
