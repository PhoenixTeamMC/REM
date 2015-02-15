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
        if (powerReceiver.canReceivePowerFromSide(output)){ //DirectionHelper.getOppositeSide(output))) {
            float friction = ((100f-frictionWhenOiled(oiled))/100f);  //make it semi-precise
            powerReceiver.setSpeed(Float.floatToIntBits(speed*friction));
            powerReceiver.setTorque(Float.floatToIntBits(torque*friction));
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

    public ForgeDirection output; // = getFacing();
    public Boolean isBroken = false;
    public int speed = 0;
    public int torque = 0;
    Boolean oiled = true; //TODO: this should be set on weather there is oil in the internal buffer or not

    public void setSpeed(int i){
        this.speed = i;
    }

    public void setTorque(int i){
        this.torque = i;
    }

    public int getSpeed() {
        return speed;
    }

    public int getTorque() {
        return torque;
    }

    protected int frictionWhenOiled(boolean oiled){
        return (oiled ? 3 : 20)*speed/maxSpeed();
    }

    public Boolean canReceivePowerFromSide(ForgeDirection direction) {
        if (direction == DirectionHelper.getOppositeSide(getFacing())) {
            this.output = getFacing();
            return true;
        } else if (direction == getFacing()) {
            this.output = DirectionHelper.getOppositeSide(getFacing());
            return true;
        }
        return false;
    }
}
