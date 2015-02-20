package phoenix.rem.blocks;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import phoenix.rem.api.types.EngineType;
import phoenix.rem.api.wrench.IWrenchable;
import phoenix.rem.blocks.tile.engine.TERedstoneEngine;

/**
 * Created by Elec332 on 8-2-2015.
 */
public class Engine extends BlockMachineBase implements ITileEntityProvider, IWrenchable{
    EngineType type;

    public Engine(EngineType type){
        super(Material.anvil, "engine."+type.toString().toLowerCase());
        this.type = type;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        switch (type) {
            case REDSTONE:
                return new TERedstoneEngine();
            default:
                return null;
        }
    }
}
