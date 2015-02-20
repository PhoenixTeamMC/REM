package phoenix.rem.api.power;

import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Elec332 and chbachman on 9-2-2015.
 */
public interface IPowerReceiver {

    int maxSpeed();

    int maxTorque();

    int minTorque();

    boolean doesExplode();

    boolean canReceivePowerFromSide(ForgeDirection direction);

    void recievePower(int torque, int speed);
    
    int getTorque();

    int getSpeed();
}
