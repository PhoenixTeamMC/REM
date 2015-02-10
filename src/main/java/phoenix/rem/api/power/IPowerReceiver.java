package phoenix.rem.api.power;

import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Elec332 on 9-2-2015.
 */
public interface IPowerReceiver {

    public Integer maxSpeed();

    public Integer maxTorque();

    public Integer minTorque();

    Boolean doesExplode();

    public Boolean canReceivePowerFromSide(ForgeDirection direction);

    public void setTorque(int i);

    public void setSpeed(int i);

    public Integer getTorque();

    public Integer getSpeed();
}
