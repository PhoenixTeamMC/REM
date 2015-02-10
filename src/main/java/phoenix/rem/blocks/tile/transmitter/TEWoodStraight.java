package phoenix.rem.blocks.tile.transmitter;

import net.minecraft.entity.item.EntityTNTPrimed;
import phoenix.rem.api.power.BaseTileTransmitter;
import phoenix.rem.api.power.IPowerReceiver;

/**
 * Created by Elec332 on 10-2-2015.
 */
public class TEWoodStraight extends BaseTileTransmitter {

    @Override
    public void updateEntity(){
        if (!isBroken){
            if (speed >= maxSpeed() || torque >= maxTorque()) {
                if (doesExplode()) {
                    EntityTNTPrimed boom = new EntityTNTPrimed(worldObj, xCoord, yCoord, zCoord, null);
                    boom.fuse = 0;
                    worldObj.spawnEntityInWorld(boom);
                } else this.isBroken = true; //TODO: make wrench fix machine when broken
            } else if ( speed >= 0 && torque >= minTorque()) {
                if (getPowerReceiver() instanceof IPowerReceiver) {
                    tryToEmitPower((IPowerReceiver) getPowerReceiver());
                }
                this.speed = 0;
                this.torque = 0;
            }
        }
    }

    public void tryToEmitPower(IPowerReceiver powerReceiver){
        if (powerReceiver.canReceivePowerFromSide(output)) {
            powerReceiver.setSpeed(speed);
            powerReceiver.setTorque(torque);
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
