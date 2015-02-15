package phoenix.rem.api.power;

import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Elec332 on 9-2-2015.
 */
public interface IPowerReceiver {

    public float maxSpeed();

    public float maxTorque();

    public float minTorque();

    Boolean doesExplode();

    public Boolean canReceivePowerFromSide(ForgeDirection direction);

    public void setTorque(float i);

    public void setSpeed(float i);

    public float getTorque();

    public float getSpeed();
}
