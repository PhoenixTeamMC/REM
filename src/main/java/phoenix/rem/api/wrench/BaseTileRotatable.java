package phoenix.rem.api.wrench;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Elec332 on 9-2-2015.
 */
public abstract class BaseTileRotatable extends TileEntity implements IRotatable {

    public ForgeDirection output  = ForgeDirection.SOUTH;

    @Override
    public Boolean rotateBlock(World world, int x, int y, int z) {
        switch (output){
            case SOUTH:
                this.output = ForgeDirection.WEST;
                break;
            case WEST:
                this.output = ForgeDirection.NORTH;
                break;
            case NORTH:
                this.output = ForgeDirection.EAST;
                break;
            case EAST:
                this.output = ForgeDirection.SOUTH;
                break;
        }
        world.markBlockForUpdate(x, y, z);
        return true;
    }
}
