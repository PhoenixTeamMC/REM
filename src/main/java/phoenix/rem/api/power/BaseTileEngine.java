package phoenix.rem.api.power;

import net.minecraft.tileentity.TileEntity;
import phoenix.rem.api.wrench.BaseTileRotatable;

/**
 * Created by Elec332 on 9-2-2015.
 */
public abstract class BaseTileEngine extends BaseTileRotatable{

    public TileEntity getPowerReceiver(){
        switch (output){
            case SOUTH:
                return worldObj.getTileEntity(xCoord, yCoord, zCoord + 1);
            case WEST:
                return worldObj.getTileEntity(xCoord - 1, yCoord, zCoord);
            case NORTH:
                return worldObj.getTileEntity(xCoord, yCoord, zCoord - 1);
            case EAST:
                return worldObj.getTileEntity(xCoord + 1, yCoord, zCoord);
        }
        return null;
    }
}
