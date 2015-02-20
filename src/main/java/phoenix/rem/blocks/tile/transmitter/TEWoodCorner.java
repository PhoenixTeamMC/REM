package phoenix.rem.blocks.tile.transmitter;

import net.minecraftforge.common.util.ForgeDirection;
import phoenix.rem.api.power.BaseTileTransmitter;

/**
 * Created by Elec332 on 11-2-2015.
 */
public class TEWoodCorner extends BaseTileTransmitter{

    @Override
    public boolean canReceivePowerFromSide(ForgeDirection direction) {
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
    public boolean doesExplode() {
        return false;
    }

    @Override
    public int maxSpeed() {
        return 100;
    }

    @Override
    public int maxTorque() {
        return 50;
    }

    @Override
    public int minTorque() {
        return 1;
    }
}
