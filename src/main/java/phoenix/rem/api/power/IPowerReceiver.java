package phoenix.rem.api.power;

import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Elec332 on 9-2-2015.
 */
public interface IPowerReceiver {

    public int maxSpeed();

    public int maxTorque();

    public int minTorque();

    Boolean doesExplode();

    public Boolean canReceivePowerFromSide(ForgeDirection direction);

    public void setTorque(int i);

    public void setSpeed(int i);

    public int getTorque();

    public int getSpeed();
}
