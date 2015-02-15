package phoenix.rem.blocks.tile.transmitter;

import phoenix.rem.api.power.BaseTileTransmitter;

/**
 * Created by Elec332 on 10-2-2015.
 */
public class TEIronStraight extends BaseTileTransmitter {
    @Override
    public float maxSpeed() {
        return 700.0F;
    }

    @Override
    public float maxTorque() {
        return 500.0F;
    }

    @Override
    public float minTorque() {
        return 5.0F;
    }

    @Override
    public Boolean doesExplode() {
        return false;
    }
}
