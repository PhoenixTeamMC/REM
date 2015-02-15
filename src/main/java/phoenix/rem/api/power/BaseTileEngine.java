package phoenix.rem.api.power;

import net.minecraft.tileentity.TileEntity;
import phoenix.rem.api.wrench.BaseTileRotatable;
import phoenix.rem.helper.DirectionHelper;

/**
 * Created by Elec332 on 9-2-2015.
 */
public abstract class BaseTileEngine extends BaseTileRotatable{

    @Override
    public void updateEntity(){
        if (isRunning()) {
            if (getPowerReceiver() instanceof IPowerReceiver) {
                tryToEmitPower((IPowerReceiver) getPowerReceiver());
            }
        }
        //worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }

    protected abstract Boolean isRunning();

    protected abstract float maxSpeed();

    protected abstract float maxTorque();

    protected float calculateTorque(float speed) {
        return maxTorque()-(maxTorque()*speed)/maxSpeed();
    }

    protected float calculateSpeed(float loadTorque) {
        return maxSpeed()*(maxTorque()-loadTorque)/maxTorque();
    }

    protected float powerFromTorque(float torque) {
        return torque * calculateSpeed(torque);
    }

    protected float powerFromSpeed(float speed) {
        return speed * calculateTorque(speed);
    }

    protected float maxPower() {
        float optimalSpeed = speedForMaxPower();
        return optimalSpeed * calculateTorque(optimalSpeed);
    }

    protected float speedForMaxPower() {
        return maxSpeed()/2;
    }

    public void tryToEmitPower(IPowerReceiver powerReceiver){
        if (powerReceiver.canReceivePowerFromSide(DirectionHelper.getOppositeSide(getFacing()))) {
            float loadTorque = powerReceiver.getTorque();
            powerReceiver.setSpeed(calculateSpeed(loadTorque));
            powerReceiver.setTorque(Math.min(loadTorque, maxTorque()));
        }
    }

    public TileEntity getPowerReceiver(){
        switch (getFacing()){
            case SOUTH:
                return worldObj.getTileEntity(xCoord, yCoord, zCoord + 1);
            case WEST:
                return worldObj.getTileEntity(xCoord - 1, yCoord, zCoord);
            case NORTH:
                return worldObj.getTileEntity(xCoord, yCoord, zCoord - 1);
            case EAST:
                return worldObj.getTileEntity(xCoord + 1, yCoord, zCoord);
            default:
                return null;
        }
    }
}
