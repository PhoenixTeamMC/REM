package phoenix.rem.blocks;

import elec332.repack.core.helper.RegisterHelper;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import phoenix.rem.blocks.BaseBlockRotatable;
import phoenix.rem.main.CTabs;
import phoenix.rem.main.REMMod;

import java.util.Random;

/**
 * Created by Elec332 on 5-2-2015.
 */
public class TestBlock extends BaseBlockRotatable{
    public TestBlock(String name) {
        super(Material.circuits, name);
        setBlockName(REMMod.modID + "." + name);
        setCreativeTab(CTabs.TabMain);
        RegisterHelper.registerBlock(this, name);
    }

    @Override
    public int quantityDropped(Random random){
        return 0;
    }

    @Override
    public Item getItemDropped(int par1, Random rand, int par2){
        return null;
    }

    @Override
    public ItemStack ItemDropped() {
        return new ItemStack(this);
    }

    @Override
    public void onWrenched() {
        //Insert code to turn block here
    }
}

