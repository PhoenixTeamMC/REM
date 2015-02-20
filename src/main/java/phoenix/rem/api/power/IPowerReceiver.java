package phoenix.rem.api.power;

import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Elec332 and chbachman on 9-2-2015.
 */
public interface IPowerReceiver {

    boolean canReceivePowerFromSide(ForgeDirection direction);

    boolean doesExplode();

    int getSpeed();

    int getTorque();

    int maxSpeed();

    int maxTorque();
    
    int minTorque();

    void recievePower(int torque, int speed);
}
