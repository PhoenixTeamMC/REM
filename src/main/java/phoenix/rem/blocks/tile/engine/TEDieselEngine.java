package phoenix.rem.blocks.tile.engine;

import phoenix.rem.api.power.BaseTileEngine;

/**
 * Created by Elec332 on 10-2-2015.
 */
@SuppressWarnings("JavadocReference")
public class TEDieselEngine extends BaseTileEngine{ //} implements IFluidTank{
    @Override
    protected Boolean isRunning() {
        return false; //TODO: Fancy fluid stuff accenting some kind of fuel/diesel/biofuel/whatever
    }

    @Override
    protected Integer maxSpeed() {
        return 150;
    }

    @Override
    protected Integer maxTorque() {
        return 200;
    }
}
