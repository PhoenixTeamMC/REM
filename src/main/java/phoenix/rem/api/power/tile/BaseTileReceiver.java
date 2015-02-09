package phoenix.rem.api.power.tile;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import phoenix.rem.api.power.IPowerProvider;
import phoenix.rem.api.power.IPowerReceiver;
import phoenix.rem.blocks.tile.BaseTileRotatable;

/**
 * Created by Elec332 on 9-2-2015.
 */
public abstract class BaseTileReceiver extends BaseTileRotatable implements IPowerReceiver{
    public boolean canWork(){
        TileEntity tile = getPowerProvider();
        if (tile instanceof IPowerProvider){
            if (((IPowerProvider) tile).isActive()){
                if (((IPowerProvider) tile).Speed() >= minSpeedRequired()){
                    if (((IPowerProvider) tile).Speed() > maxSpeed()){
                        if (doesExplode()){
                            //Insert code for explosion here
                        }
                    }else {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public TileEntity getPowerProvider(){
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

    @Override
    public IIcon getTexture(int Side) {
        return null;
    }
}
