package phoenix.rem.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import phoenix.rem.REMMod;
import phoenix.rem.api.types.EngineType;
import phoenix.rem.api.types.TransmitterType;
import phoenix.rem.blocks.BlockBase;
import phoenix.rem.blocks.Engine;
import phoenix.rem.blocks.TransmitterCorner;
import phoenix.rem.blocks.TransmitterStraight;
import phoenix.rem.blocks.test.DirectionBlock;
import phoenix.rem.blocks.test.TestBlock;
import phoenix.rem.main.CTabs;

/**
 * Created by Elec332 on 5-2-2015.
 */
public class BlockRegist {

    public static final BlockRegist instance = new BlockRegist();
    static CreativeTabs tab = CTabs.TabMain;

    public static Block TestOre, RedstoneEngine;
    public static Block WoodenTransmitter, IronTransmitter;
    public static Block WoodenTransmitterCorner;

    public void init(){
        if (REMMod.developmentEnvironment) {
            new TestBlock("test").setCreativeTab(tab);
            TestOre = new BlockBase(Material.rock, "TestOre").setCreativeTab(tab);
            new DirectionBlock().setCreativeTab(tab);
        }
        RedstoneEngine = new Engine(EngineType.REDSTONE);
        WoodenTransmitter = new TransmitterStraight(TransmitterType.WOOD).setCreativeTab(tab);
        IronTransmitter = new TransmitterStraight(TransmitterType.IRON).setCreativeTab(tab);
        WoodenTransmitterCorner = new TransmitterCorner(TransmitterType.WOOD).setCreativeTab(tab);
    }
}
