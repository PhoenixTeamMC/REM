package phoenix.rem.blocks;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import phoenix.rem.blocks.tile.TEDCEngine;

/**
 * Created by Elec332 on 8-2-2015.
 */
public class BlockDCEngine extends BlockBase implements ITileEntityProvider{
    public BlockDCEngine(){
        super(Material.rock, "EngineTest");
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TEDCEngine();
    }
}
