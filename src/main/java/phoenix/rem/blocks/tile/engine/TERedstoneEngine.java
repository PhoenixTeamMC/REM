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
     protected int maxSpeed() {
        return 30;
    }

    @Override
    protected int maxTorque() {
        return 20;
    }
}
