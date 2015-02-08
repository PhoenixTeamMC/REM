package phoenix.rem.proxies;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.MinecraftForge;
import phoenix.rem.blocks.test.TestBlockTE;
import phoenix.rem.handler.EventHandlerCommon;

/**
 * Created by Elec332 on 6-2-2015.
 */
public class CommonProxy {
    public void registerHandlers(){
        FMLCommonHandler.instance().bus().register(new EventHandlerCommon());
        MinecraftForge.EVENT_BUS.register(new EventHandlerCommon());
    }

    public void registerTileEntities(){
        GameRegistry.registerTileEntity(TestBlockTE.class, "Test");
    }
    public void registerRenderer(){}
}
