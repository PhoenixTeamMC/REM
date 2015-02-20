package phoenix.rem.util;

import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.world.World;


public class ExplosionHelper{
	
	public static void explodeBlock(World world, int x, int y, int z, float power){
        EntityTNTPrimed p = new EntityTNTPrimed(world);
        p.setPosition(x, y, z);
        world.createExplosion(p, x, y, z, power, true);
        
	}

}
