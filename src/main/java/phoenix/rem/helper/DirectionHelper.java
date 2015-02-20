package phoenix.rem.helper;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Elec332 on 10-2-2015.
 */
public class DirectionHelper {
    public static ForgeDirection getFacingOnPlacement(EntityLivingBase entityLivingBase){
        int i = MathHelper.floor_double((double) (entityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        switch (i){
            case 0:
                return ForgeDirection.NORTH;
            case 1:
                return ForgeDirection.EAST;
            case 2:
                return ForgeDirection.SOUTH;
            case 3:
                return ForgeDirection.WEST;
            default:
                return ForgeDirection.UNKNOWN;
        }
    }

    public static ForgeDirection getOppositeSide(ForgeDirection direction){
        switch (direction){
            case SOUTH:
                return ForgeDirection.NORTH;
            case WEST:
                return ForgeDirection.EAST;
            case NORTH:
                return ForgeDirection.SOUTH;
            case EAST:
                return ForgeDirection.WEST;
            case UP:
                return ForgeDirection.DOWN;
            case DOWN:
                return ForgeDirection.UP;
            default:
                return ForgeDirection.UNKNOWN;
        }
    }
}
