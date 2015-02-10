package phoenix.rem.blocks.test;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import phoenix.rem.api.power.BaseTileReceiver;

/**
 * Created by Elec332 on 7-2-2015.
 */
public class TestBlockTE extends BaseTileReceiver{

    @Override
    public void updateEntity(){
        if (!worldObj.isRemote) {
            if (canWork()) {
                worldObj.spawnEntityInWorld(new EntityItem(worldObj, xCoord, yCoord + 2, zCoord, new ItemStack(Items.baked_potato)));
                //worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
            }
        }
    }

    @Override
    public Integer maxSpeed() {
        return 200;
    }

    @Override
    public Integer maxTorque() {
        return 100;
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
