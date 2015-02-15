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

    protected abstract Float maxSpeed();

    protected abstract Float maxTorque();

    protected Float calculateTorque(Float speed) {
        return maxTorque()-(maxTorque()*speed)/maxSpeed();
    }

    protected Float calculateSpeed(Float loadTorque) {
        return maxSpeed()*(maxTorque()-loadTorque)/maxTorque();
    }

    protected Float powerFromTorque(Float torque) {
        return torque * calculateSpeed(torque);
    }

    protected Float powerFromSpeed(Float speed) {
        return speed * calculateTorque(speed);
    }

    protected Float maxPower() {
        Float optimalSpeed = speedForMaxPower();
        return optimalSpeed * calculateTorque(optimalSpeed);
    }

    protected Float speedForMaxPower() {
        return maxSpeed()/2;
    }

    public void tryToEmitPower(IPowerReceiver powerReceiver){
        if (powerReceiver.canReceivePowerFromSide(DirectionHelper.getOppositeSide(getFacing()))) {
            Float loadTorque = powerReceiver.getTorque();
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
