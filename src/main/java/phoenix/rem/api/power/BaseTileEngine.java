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

    protected abstract Integer maxSpeed();

    protected abstract Integer maxTorque();

    protected Integer calculateSpeed(int loadTorque) {
        return maxSpeed()*(maxTorque()-loadTorque)/maxTorque();
    }

    protected Integer maxPower() {
        int optimalSpeed = speedFormaxPower();
        return optimalSpeed * calculateTorque(optimalSpeed);
    }

    protected Integer speedFormaxPower() {
        return maxSpeed()/2;
    }

    protected Integer calculateTorque(int speed) {
        return maxTorque()-(maxTorque()*speed)/maxSpeed();
    }

    public void tryToEmitPower(IPowerReceiver powerReceiver){
        if (powerReceiver.canReceivePowerFromSide(DirectionHelper.getOppositeSide(getFacing()))) {
            int loadTorque = powerReceiver.getTorque();
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
