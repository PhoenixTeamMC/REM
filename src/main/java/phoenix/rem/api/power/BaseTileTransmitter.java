package phoenix.rem.api.power;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import phoenix.rem.api.wrench.BaseTileRotatable;
import phoenix.rem.helper.DirectionHelper;

/**
 * Created by Elec332 on 9-2-2015.
 */
public abstract class BaseTileTransmitter extends BaseTileRotatable implements IPowerReceiver{

    public TileEntity getPowerReceiver(){
        switch (output){
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

    public Boolean isBroken = false;
    public Integer speed = 0;
    public Integer torque = 0;

    public void setSpeed(int i){
        this.speed = i;
    }

    public void setTorque(int i){
        this.torque = i;
    }

    public Integer getSpeed() {
        return speed;
    }

    public Integer getTorque() {
        return torque;
    }

    public Boolean canReceivePowerFromSide(ForgeDirection direction) {
        if (direction == DirectionHelper.getOppositeSide(output))
            return true;
        if (direction == output) {
            setRotation(DirectionHelper.getOppositeSide(output));
            return true;
        }
        return false;
        //return direction == DirectionHelper.getOppositeSide(output);
    }
}
