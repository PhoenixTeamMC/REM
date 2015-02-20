package phoenix.rem.api.power;

import net.minecraft.tileentity.TileEntity;
import phoenix.rem.api.wrench.BaseTileRotatable;
import phoenix.rem.helper.DirectionHelper;

/**
 * Created by Elec332 on 9-2-2015.
 */
public abstract class BaseTileEngine extends BaseTileRotatable{

    protected int calculateSpeed(int loadTorque) {
        return maxSpeed()*(maxTorque()-loadTorque)/maxTorque();
    }

    protected int calculateTorque(int speed) {
        return maxTorque()-(maxTorque()*speed)/maxSpeed();
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

    protected abstract Boolean isRunning();

    protected int maxPower() {
        int optimalSpeed = speedForMaxPower();
        return optimalSpeed * calculateTorque(optimalSpeed);
    }

    protected abstract int maxSpeed();

    protected abstract int maxTorque();

    protected int powerFromSpeed(int speed) {
        return speed * calculateTorque(speed);
    }

    protected int powerFromTorque(int torque) {
        return torque * calculateSpeed(torque);
    }

    protected int speedForMaxPower() {
        return maxSpeed()/2;
    }

    public void tryToEmitPower(IPowerReceiver powerReceiver){
        if (powerReceiver.canReceivePowerFromSide(DirectionHelper.getOppositeSide(getFacing()))) {
            int loadTorque = powerReceiver.getTorque();
            powerReceiver.recievePower(Math.min(loadTorque, maxTorque()), (calculateSpeed(loadTorque)));
        }
    }

    @Override
    public void updateEntity(){
        if (isRunning()) {
            if (getPowerReceiver() instanceof IPowerReceiver) {
                tryToEmitPower((IPowerReceiver) getPowerReceiver());
            }
        }
        //worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }
}
