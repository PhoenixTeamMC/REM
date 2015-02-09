package phoenix.rem.blocks.tile;

import net.minecraft.util.IIcon;
import phoenix.rem.api.power.IPowerProvider;

/**
 * Created by Elec332 on 8-2-2015.
 */
public class TEDCEngine extends BaseTileRotatable implements IPowerProvider{

    @Override
    public void updateEntity(){
        if (worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord))
            this.active = true;
        else
            this.active = false;
    }

    boolean active = false;

    @Override
    public IIcon getTexture(int Side) {
        return null;
    }

    @Override
    public Integer Speed() {
        return 3;
    }

    @Override
    public Boolean isActive() {
        return active;
    }
}
