package phoenix.rem.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import phoenix.rem.blocks.BlockBase;
import phoenix.rem.blocks.TestBlock;
import phoenix.rem.main.CTabs;
import phoenix.rem.main.REMMod;

/**
 * Created by Elec332 on 5-2-2015.
 */
public class BlockRegist {

    public static final BlockRegist instance = new BlockRegist();

    public static Block TestOre;

    public void init(){
        if (REMMod.developmentEnvironment) {
            new TestBlock("test").setCreativeTab(CTabs.TabMain);
            TestOre = new BlockBase(Material.rock, "TestOre").setCreativeTab(CTabs.TabMain);
        }
    }
}
