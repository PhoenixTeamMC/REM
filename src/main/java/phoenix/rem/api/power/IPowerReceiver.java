package phoenix.rem.api.power;

import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Elec332 on 9-2-2015.
 */
public interface IPowerReceiver {

    public Float maxSpeed();

    public Float maxTorque();

    public Float minTorque();

    Boolean doesExplode();

    public Boolean canReceivePowerFromSide(ForgeDirection direction);

    public void setTorque(Float i);

    public void setSpeed(Float i);

    public Float getTorque();

    public Float getSpeed();
}
