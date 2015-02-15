package phoenix.rem.blocks.tile.transmitter;

import phoenix.rem.api.power.BaseTileTransmitter;

/**
 * Created by Elec332 on 10-2-2015.
 */
public class TEWoodStraight extends BaseTileTransmitter {

    @Override
    public Integer maxSpeed() {
        return 100;
    }

    @Override
    public Integer maxTorque() {
        return 50;
    }

    @Override
    public Integer minTorque() {
        return 1;
    }

    @Override
    public Boolean doesExplode() {
        return false;
    }
}
