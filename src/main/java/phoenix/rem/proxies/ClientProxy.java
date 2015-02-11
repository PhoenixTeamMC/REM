package phoenix.rem.proxies;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import elec332.repack.core.handler.UpdateHandler;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import phoenix.rem.blocks.tile.engine.TERedstoneEngine;
import phoenix.rem.blocks.tile.transmitter.TEWoodCorner;
import phoenix.rem.blocks.tile.transmitter.TEWoodStraight;
import phoenix.rem.client.renderers.block.BasicTESR;
import phoenix.rem.client.renderers.block.TileRedstoneEngineRenderer;
import phoenix.rem.client.renderers.block.TileWoodenTransmitterSRenderer;
import phoenix.rem.client.renderers.block.item.ItemRedstoneEngineRenderer;
import phoenix.rem.handler.EventHandlerClient;
import phoenix.rem.init.BlockRegist;

/**
 * Created by Elec332 on 6-2-2015.
 */
@SuppressWarnings("UnusedDeclaration")
public class ClientProxy extends CommonProxy {

    public void registerHandlers(){
        FMLCommonHandler.instance().bus().register(new UpdateHandler());
        FMLCommonHandler.instance().bus().register(new EventHandlerClient());
        MinecraftForge.EVENT_BUS.register(new EventHandlerClient());
    }

    public void registerRenderer(){
        ClientRegistry.bindTileEntitySpecialRenderer(TERedstoneEngine.class, new TileRedstoneEngineRenderer());
        MinecraftForgeClient.registerItemRenderer(ItemBlock.getItemFromBlock(BlockRegist.RedstoneEngine), new ItemRedstoneEngineRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TEWoodStraight.class, new TileWoodenTransmitterSRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TEWoodCorner.class, new BasicTESR("p90", "test_0.png"));
    }
}
