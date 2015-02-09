package phoenix.rem.blocks;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import phoenix.rem.api.wrench.IWrenchable;
import phoenix.rem.blocks.tile.TEDCEngine;

/**
 * Created by Elec332 on 8-2-2015.
 */
public class BlockDCEngine extends BlockBase implements ITileEntityProvider, IWrenchable{
    public BlockDCEngine(){
        super(Material.rock, "EngineTest");
        setNoOpaqueCube();
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TEDCEngine();
    }

    @Override
    public ItemStack ItemDropped() {
        return new ItemStack(ItemBlock.getItemFromBlock(this));
    }

    @Override
    public void onWrenched(World world, int x, int y, int z, ForgeDirection direction) {

    }
}
