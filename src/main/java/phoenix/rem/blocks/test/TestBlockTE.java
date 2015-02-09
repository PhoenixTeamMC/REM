package phoenix.rem.blocks.test;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import phoenix.rem.api.power.IPowerReceiver;
import phoenix.rem.api.power.tile.BaseTileReceiver;

/**
 * Created by Elec332 on 7-2-2015.
 */
public class TestBlockTE extends BaseTileReceiver implements IPowerReceiver{

    @Override
    public void updateEntity(){
        if (canWork()) {
            if (!worldObj.isRemote) {
                worldObj.spawnEntityInWorld(new EntityItem(worldObj, xCoord, yCoord, zCoord, new ItemStack(Items.baked_potato)));
            }
        }
    }

    @Override
    public Integer minSpeedRequired() {
        return 1;
    }

    @Override
    public Integer maxSpeed() {
        return 4;
    }

    @Override
    public Boolean doesExplode() {
        return false;
    }

    @Override
    public Integer InternalSpeedStored() {
        return speedstored;
    }

    int speedstored;

    @Override
    public void setSpeedStored(int i) {
        this.speedstored = i;
    }

}
