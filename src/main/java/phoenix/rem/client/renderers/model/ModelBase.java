package phoenix.rem.client.renderers.model;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import phoenix.rem.api.wrench.BaseTileRotatable;

/**
 * Created by Elec332 on 9-2-2015.
 */
public class ModelBase extends net.minecraft.client.model.ModelBase {
    public Integer getRotation(TileEntity entity){
        if (entity instanceof BaseTileRotatable){
            ForgeDirection pointing = ((BaseTileRotatable) entity).output;
            switch (pointing){
                case SOUTH:
                    return 0;
                case WEST:
                    return 90;
                case NORTH:
                    return 180;
                case EAST:
                    return 270;
                default:
                    return 0;
            }
        }
        return 0;
    }
}
