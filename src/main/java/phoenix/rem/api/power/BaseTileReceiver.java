package phoenix.rem.api.power;

import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraftforge.common.util.ForgeDirection;
import phoenix.rem.api.wrench.BaseTileRotatable;
import phoenix.rem.helper.DirectionHelper;

/**
 * Created by Elec332 on 9-2-2015.
 */
public abstract class BaseTileReceiver extends BaseTileRotatable implements IPowerReceiver{
    public boolean canWork(){
        if (!isBroken){
            if (speed >= maxSpeed() || torque >= maxTorque()) {
                if (doesExplode()) {
                    EntityTNTPrimed boom = new EntityTNTPrimed(worldObj, xCoord, yCoord, zCoord, null);
                    boom.fuse = 0;
                    worldObj.spawnEntityInWorld(boom);
                } else this.isBroken = true; //TODO: make wrench fix machine when broken with fancy gui 'n stuff
            } else if ( speed >= 0 && torque >= minTorque()) {
                this.speed = 0.0F;
                this.torque = 0.0F;
                return true;
            }
        }
        return false;
    }

    public Boolean isBroken = false;
    public Float speed = 0.0F;
    public Float torque = 0.0F;

    public void setSpeed(Float i){
        this.speed = i;
    }

    public void setTorque(Float i){
        this.torque = i;
    }

    @Override
    public Float getSpeed() {
        return speed;
    }

    @Override
    public Float getTorque() {
        return torque;
    }

    @Override
    public Boolean canReceivePowerFromSide(ForgeDirection direction) {
        return DirectionHelper.getOppositeSide(getFacing()) == direction;
    }
}
