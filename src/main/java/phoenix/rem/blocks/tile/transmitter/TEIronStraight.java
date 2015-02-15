package phoenix.rem.blocks.tile.transmitter;

import phoenix.rem.api.power.BaseTileTransmitter;

/**
 * Created by Elec332 on 10-2-2015.
 */
public class TEIronStraight extends BaseTileTransmitter {
    @Override
    public Integer maxSpeed() {
        return 700;
    }

    @Override
    public Integer maxTorque() {
        return 500;
    }

    @Override
    public Integer minTorque() {
        return 5;
    }

    @Override
    public Boolean doesExplode() {
        return false;
    }
}
