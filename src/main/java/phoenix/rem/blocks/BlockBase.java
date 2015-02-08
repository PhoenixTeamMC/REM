package phoenix.rem.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import elec332.repack.core.helper.RegisterHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import phoenix.rem.main.CTabs;
import phoenix.rem.main.REMMod;

import java.util.Random;

/**
 * Created by Elec332 on 8-2-2015.
 */
//This code is 99,9% copied from ElecCore, you can the code here:
// https://github.com/Elecs-Mods/ElecCore/blob/05324a5ccd78443535af672886f8093778d24793/src/main/java/elec332/core/util/blocks/baseblock.java
public class BlockBase extends Block {
    public BlockBase(Material baseMaterial, String blockName) {
        super(baseMaterial);
        setBlockName(modID + "." + blockName);
        setCreativeTab(CTabs.TabMain);
        this.name = blockName;
        RegisterHelper.registerBlock(this, blockName);
    }

    public BlockBase(Material baseMaterial, String blockName,  CreativeTabs CreativeTab) {
        this(baseMaterial, blockName);
        setCreativeTab(CreativeTab);
    }

    @Deprecated
    public BlockBase(Material baseMaterial, String blockName, CreativeTabs CreativeTab,  int setQuantityDropped) {
        this(baseMaterial, blockName, CreativeTab);
        this.Dropped = setQuantityDropped;
    }

    public BlockBase setGhost(){
        this.ghost = true;
        this.setNoOpaqueCube();
        return this;
    }

    public BlockBase setItemDropped(Item itemDropped){
        this.dropped = itemDropped;
        return this;
    }

    //I know vanilla has this, but that's a void, this isn't ;)
    public BlockBase setToolLevel(String toolClass, int level){
        this.setHarvestLevel(toolClass, level);
        return this;
    }

    public BlockBase setNoOpaqueCube(){
        this.opaqueCube = false;
        return this;
    }

    public BlockBase setQuantityDropped(int setQuantityDropped){
        this.Dropped = setQuantityDropped;
        return this;
    }

    Boolean opaqueCube;
    Item dropped;
    boolean ghost;
    String name;
    String modID = REMMod.modID;
    int Dropped;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister){
        blockIcon = iconRegister.registerIcon(this.getTextureName());
    }

    @Override
    @SideOnly(Side.CLIENT)
    protected String getTextureName(){
        if (this.textureName != null)
            return textureName;
        return modID + ":" + name;
    }

    @Override
    public boolean isOpaqueCube(){
        return opaqueCube != null ? opaqueCube : true;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z){
        if (ghost)
            return null;
        return AxisAlignedBB.getBoundingBox((double)x + this.minX, (double)y + this.minY, (double)z + this.minZ, (double)x + this.maxX, (double)y + this.maxY, (double)z + this.maxZ);
    }

    @Override
    public int quantityDropped(Random random){
        return Dropped;
    }

    @Override
    public Item getItemDropped(int par1, Random rand, int par2){
        return dropped != null ? dropped : super.getItemDropped(par1, rand, par2);
    }
}
