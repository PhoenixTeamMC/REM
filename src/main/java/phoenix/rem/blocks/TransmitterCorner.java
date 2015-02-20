package phoenix.rem.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import phoenix.rem.api.types.TransmitterType;
import phoenix.rem.blocks.tile.transmitter.TEWoodCorner;

/**
 * Created by Elec332 on 10-2-2015.
 */
public class TransmitterCorner extends BlockMachineBase {
    TransmitterType type;

    public TransmitterCorner(TransmitterType type){
        super(Material.anvil, "transmitter.corner."+type.toString().toLowerCase());
        this.type = type;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        switch (type){
            case WOOD:
                return new TEWoodCorner();
            default:
                return null;
        }
    }
}
