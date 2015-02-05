package phoenix.rem.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import elec332.core.helper.RegisterHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import phoenix.rem.api.wrench.IWrenchable;
import phoenix.rem.main.CTabs;
import phoenix.rem.main.REMMod;

import java.util.Random;

/**
 * Created by Elec332 on 5-2-2015.
 */
public class TestBlock extends Block implements IWrenchable{
    public TestBlock(String name) {
        super(Material.rock);
        setBlockName(REMMod.modID + "." + name);
        setCreativeTab(CTabs.TabMain);
        this.name = name;
        RegisterHelper.registerBlock(this, name);
    }

    String name;

    @Override
    @SideOnly(Side.CLIENT)
    protected String getTextureName(){
        return REMMod.modID + ":" + name;
    }


    @Override
    public int quantityDropped(Random random){
        return 0;
    }

    @Override
    public Item getItemDropped(int par1, Random rand, int par2){
        return Item.getItemFromBlock(this);
    }

    @Override
    public ItemStack ItemDropped() {
        //return new ItemStack(this);
        return new ItemStack(this);
    }

    @Override
    public void onWrenched() {
        //Insert code to turn block here
    }
}

