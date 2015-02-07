package phoenix.rem.api.wrench;

import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * Created by Elec332 on 7-2-2015.
 */
public interface IRotatable {
    public Boolean rotateBlock(World world, int x, int y, int z);

    public IIcon getTexture(int Side);
}
