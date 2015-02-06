package phoenix.rem.proxies;

import cpw.mods.fml.common.FMLCommonHandler;
import elec332.repack.core.handler.UpdateHandler;

/**
 * Created by Elec332 on 6-2-2015.
 */
public class ClientProxy extends CommonProxy {
    public void registerHandlers(){
        FMLCommonHandler.instance().bus().register(new UpdateHandler());
    }
}
