package phoenix.rem.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import elec332.repack.core.helper.RegisterHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import phoenix.rem.api.wrench.IWrenchable;
import phoenix.rem.main.CTabs;
import phoenix.rem.main.REMMod;

import java.util.Random;

/**
 * Created by Elec332 on 5-2-2015.
 */
public class TestBlock extends Block implements IWrenchable{
    public TestBlock(String name) {
        super(Material.circuits);
        setBlockName(REMMod.modID + "." + name);
        setCreativeTab(CTabs.TabMain);
        this.name = name;
        RegisterHelper.registerBlock(this, name);
    }

    public IIcon[] icons = new IIcon[6];
    String name;

    @Override
    @SideOnly(Side.CLIENT)
    protected String getTextureName(){
        return REMMod.modID + ":" + name;
    }

    @Override
    public void registerBlockIcons(IIconRegister register) {
        for (int i = 0; i < 6; i ++) {
            this.icons[i] = register.registerIcon(this.getTextureName() + "_" + i);
        }
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

