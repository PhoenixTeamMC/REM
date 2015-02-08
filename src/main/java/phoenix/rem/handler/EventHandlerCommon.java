package phoenix.rem.handler;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import phoenix.rem.helper.ConfigHelper;
import phoenix.rem.main.REMMod;

/**
 * Created by Elec332 on 6-2-2015.
 */
public class EventHandlerCommon {

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent event){
        if(event.modID.equals(REMMod.modID)){
            REMMod.instance.loadConfiguration();
            ConfigHelper.INSTANCE.reload();
        }
    }
}
