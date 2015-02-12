package phoenix.rem.api.wrench;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Elec332 on 9-2-2015.
 */
public abstract class BaseTileRotatable extends TileEntity implements IRotatable {

    ForgeDirection facing = ForgeDirection.SOUTH;

    @Override
    public Boolean rotateBlock(World world, int x, int y, int z) {
        switch (facing){
            case SOUTH:
                this.facing = ForgeDirection.WEST;
                break;
            case WEST:
                this.facing = ForgeDirection.NORTH;
                break;
            case NORTH:
                this.facing = ForgeDirection.EAST;
                break;
            case EAST:
                this.facing = ForgeDirection.SOUTH;
                break;
        }
        //world.markBlockForUpdate(x, y, z);
        return true;
    }

    @Override
    public ForgeDirection getFacing() {
        return facing;
    }

    public void setRotation(ForgeDirection direction){
        this.facing = direction;
    }
}
