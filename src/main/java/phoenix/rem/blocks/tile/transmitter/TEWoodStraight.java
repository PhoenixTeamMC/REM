package phoenix.rem.blocks.tile.transmitter;

import phoenix.rem.api.power.BaseTileTransmitter;

/**
 * Created by Elec332 on 10-2-2015.
 */
public class TEWoodStraight extends BaseTileTransmitter {

    @Override
    public float maxSpeed() {
        return 100.0F;
    }

    @Override
    public float maxTorque() {
        return 50.0F;
    }

    @Override
    public float minTorque() {
        return 1.0F;
    }

    @Override
    public Boolean doesExplode() {
        return false;
    }
}
