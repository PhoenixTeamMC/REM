package phoenix.rem.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import phoenix.rem.api.types.TransmitterType;
import phoenix.rem.blocks.tile.transmitter.TEIronStraight;
import phoenix.rem.blocks.tile.transmitter.TEWoodStraight;

/**
 * Created by Elec332 on 10-2-2015.
 */
public class TransmitterStraight extends BlockMachineBase {

    public TransmitterStraight(TransmitterType type){
        super(Material.anvil, "transmitter.straight."+type.toString().toLowerCase());
        this.type = type;
    }

    TransmitterType type;

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        switch (type){
            case WOOD:
                return new TEWoodStraight();
            case IRON:
                return new TEIronStraight();
            default:
                return null;
        }
    }
}
