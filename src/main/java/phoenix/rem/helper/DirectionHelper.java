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
}
