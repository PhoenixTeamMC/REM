package phoenix.rem.helper;

import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Elec332 on 10-2-2015.
 */
public class DirectionHelper {
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

    public static ForgeDirection getFacingOnPlacement(float yaw){
        if (yaw <= 90.0f)
            return ForgeDirection.NORTH;
        if (yaw > 90.0f && yaw <= 180.0f)
            return ForgeDirection.EAST;
        if (yaw > 180.0f && yaw <= 270.0f)
            return ForgeDirection.SOUTH;
        if (yaw > 270.0f && yaw <= 360f)
            return ForgeDirection.WEST;
        return ForgeDirection.UNKNOWN;
    }
}
