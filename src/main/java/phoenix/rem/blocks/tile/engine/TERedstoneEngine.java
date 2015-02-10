package phoenix.rem.blocks.tile.engine;

import phoenix.rem.api.power.BaseTileEngine;
import phoenix.rem.api.power.IPowerReceiver;

/**
 * Created by Elec332 on 8-2-2015.
 */
public class TERedstoneEngine extends BaseTileEngine {

    @Override
    public void updateEntity(){
        if (worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord)) {
            if (getPowerReceiver() instanceof IPowerReceiver) {
                tryToEmitPower((IPowerReceiver) getPowerReceiver());
            }
        }
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }

    int speed = 30;
    int torque = 20;

    public void tryToEmitPower(IPowerReceiver powerReceiver){
        if (powerReceiver.canReceivePowerFromSide(output)) {
            powerReceiver.setSpeed(speed);
            powerReceiver.setTorque(torque);
        }
    }
}