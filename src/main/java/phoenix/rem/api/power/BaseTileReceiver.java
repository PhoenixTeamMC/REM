package phoenix.rem.api.power;

import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.util.IIcon;
import phoenix.rem.api.wrench.BaseTileRotatable;

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
                }
            } else if (torque >= minTorque()) {
                this.speed = 0;
                this.torque = 0;
                return true;
            }
        }
        return false;
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

    @Override
    public IIcon getTexture(int Side) {
        return null;
    }
}
