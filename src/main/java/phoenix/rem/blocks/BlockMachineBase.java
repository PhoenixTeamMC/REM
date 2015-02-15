package phoenix.rem.blocks;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import phoenix.rem.api.types.EngineType;
import phoenix.rem.api.wrench.BaseTileRotatable;
import phoenix.rem.api.wrench.IWrenchable;
import phoenix.rem.helper.DirectionHelper;

import java.util.Random;

/**
 * Created by Elec332 on 10-2-2015.
 */
public abstract class BlockMachineBase extends BlockBase implements ITileEntityProvider, IWrenchable {

    public BlockMachineBase(Material mat, String name){
        super(mat, name);
        setNoOpaqueCube();
    }

    EngineType type;

    @Override
    public int quantityDropped(Random random){
        return 0;
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity instanceof BaseTileRotatable) {
            ((BaseTileRotatable) tileEntity).setRotation(DirectionHelper.getFacingOnPlacement(entityLivingBase.rotationYaw));
        }
    }

    @Override
    public Item getItemDropped(int par1, Random rand, int par2){
        return null;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public int getRenderType()
    {
        return -1;
    }

    @Override
    public boolean hasTileEntity()
    {
        return true;
    }

    @Override
    public ItemStack ItemDropped() {
        return new ItemStack(ItemBlock.getItemFromBlock(this));
    }

    @Override
    public void onWrenched(World world, int x, int y, int z, ForgeDirection direction) {
        rotateBlock(world, x, y, z, direction);
    }
}
