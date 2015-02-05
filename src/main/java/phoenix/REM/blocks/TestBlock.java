package phoenix.REM.blocks;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import elec332.core.helper.RegisterHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Elec332 on 5-2-2015.
 */
public class TestBlock extends Block {
    public baseblock(Material baseMaterial, String blockName, CreativeTabs CreativeTab, FMLPreInitializationEvent event, int setQuantitydropped) {
        super(baseMaterial);
        this.modID = event.getModMetadata().modId;
        this.Dropped = setQuantitydropped;
        setBlockName(modID + "." + blockName);
        setCreativeTab(CreativeTab);
        this.name = blockName;
        RegisterHelper.registerBlock(this, blockName);
    }

    @Override
    @SideOnly(Side.CLIENT)
    protected String getTextureName(){
        if (this.textureName != null)
            return textureName;
        return modID + ":" + name;
    }


    @Override
    public int quantityDropped(Random random){
        return 0;
    }

    @Override
    public Item getItemDropped(int par1, Random rand, int par2){
        return null;
    }
}

