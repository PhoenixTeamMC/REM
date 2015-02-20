package phoenix.rem.util;

import net.minecraft.world.World;


public class ExplosionHelper{
	
	public void explodeBlock(World world, int x, int y, int z, float power){
		float f = 4.0F;
        world.createExplosion(this, x, y, z, power, true);
	}

}
