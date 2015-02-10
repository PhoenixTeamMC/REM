package phoenix.rem.api.power;

import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import phoenix.rem.api.wrench.BaseTileRotatable;
import phoenix.rem.helper.DirectionHelper;

/**
 * Created by Elec332 on 9-2-2015.
 */
public abstract class BaseTileTransmitter extends BaseTileRotatable implements IPowerReceiver{

    @Override
    public void updateEntity(){
        if (!isBroken){
            if (speed >= maxSpeed() || torque >= maxTorque()) {
                if (doesExplode()) {
                    EntityTNTPrimed boom = new EntityTNTPrimed(worldObj, xCoord, yCoord, zCoord, null);
                    boom.fuse = 0;
                    worldObj.spawnEntityInWorld(boom);
                } else this.isBroken = true; //TODO: make wrench fix machine when broken with fancy gui 'n stuff
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
        if (powerReceiver.canReceivePowerFromSide(DirectionHelper.getOppositeSide(output))) {
            powerReceiver.setSpeed(speed); //*((100-frictionWhenOiled(oiled))/100));
            powerReceiver.setTorque(torque); //*((100-frictionWhenOiled(oiled))/100));
        }
    }

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
    Boolean oiled = true; //TODO: this should be set on weather there is oil in the internal buffer or not

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

    protected Integer frictionWhenOiled(boolean oiled){
        return oiled ? 3 : 20;
    }

    public Boolean canReceivePowerFromSide(ForgeDirection direction) {
        if (direction == DirectionHelper.getOppositeSide(output))
            return true;
        if (direction == output) {
            setRotation(DirectionHelper.getOppositeSide(output));
            return true;
        }
        return false;
    }
}
