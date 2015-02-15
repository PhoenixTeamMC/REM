package phoenix.rem.blocks.tile.engine;

import phoenix.rem.api.power.BaseTileEngine;

/**
 * Created by Elec332 on 8-2-2015.
 */
public class TERedstoneEngine extends BaseTileEngine {

    @Override
    protected Boolean isRunning() {
        return worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord);
    }

    @Override
     protected float maxSpeed() {
        return 30.0F;
    }

    @Override
    protected float maxTorque() {
        return 20.0F;
    }
}
