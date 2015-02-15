package phoenix.rem.blocks.tile.transmitter;

import net.minecraftforge.common.util.ForgeDirection;
import phoenix.rem.api.power.BaseTileTransmitter;

/**
 * Created by Elec332 on 11-2-2015.
 */
public class TEWoodCorner extends BaseTileTransmitter{

    @Override
    public Boolean canReceivePowerFromSide(ForgeDirection direction) {
        switch (direction){
            /*case NORTH:
                return getFacing() == ForgeDirection.NORTH || getFacing() == ForgeDirection.WEST;*/
            case EAST:
                if (getFacing() == ForgeDirection.EAST)
                    this.output = ForgeDirection.NORTH.getOpposite();
                if (getFacing() == ForgeDirection.SOUTH)
                    this.output = ForgeDirection.EAST.getOpposite();
            case SOUTH:
                if (getFacing() == ForgeDirection.SOUTH) {
                    this.output = ForgeDirection.WEST.getOpposite();
                    return true;
                }
                if (getFacing() == ForgeDirection.EAST) {
                    this.output = ForgeDirection.EAST.getOpposite();
                    return true;
                }
            //case WEST:
                //return getFacing() == ForgeDirection.WEST || getFacing() == ForgeDirection.SOUTH;
            default:
                return false;
        }
    }

    @Override
    public Float maxSpeed() {
        return 100.0F;
    }

    @Override
    public Float maxTorque() {
        return 50.0F;
    }

    @Override
    public Float minTorque() {
        return 1.0F;
    }

    @Override
    public Boolean doesExplode() {
        return false;
    }
}
