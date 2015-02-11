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
            case WEST:
                return (output == ForgeDirection.SOUTH || output == ForgeDirection.NORTH);
            case NORTH:
                return (output == ForgeDirection.WEST || output == ForgeDirection.EAST);
            case EAST:
                return (output == ForgeDirection.NORTH || output == ForgeDirection.SOUTH);
            case SOUTH:
                return (output == ForgeDirection.EAST || output == ForgeDirection.WEST);
            default:
                return false;
        }
    }

    @Override
    public Integer maxSpeed() {
        return 100;
    }

    @Override
    public Integer maxTorque() {
        return 50;
    }

    @Override
    public Integer minTorque() {
        return 1;
    }

    @Override
    public Boolean doesExplode() {
        return false;
    }
}
