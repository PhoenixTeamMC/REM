package phoenix.rem.blocks.test;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import phoenix.rem.api.wrench.IRotatable;
import phoenix.rem.data.IConData;

/**
 * Created by Elec332 on 7-2-2015.
 */
public class TestBlockTE extends TileEntity implements IRotatable{

    private int outputPowerSide = 3;
    protected ForgeDirection powerOutput = ForgeDirection.getOrientation(outputPowerSide);

    @Override
    public Boolean rotateBlock(World world, int x, int y, int z) {
        switch (outputPowerSide) {
            case 2:
                this.outputPowerSide = 5;
                world.setBlockMetadataWithNotify(x, y, z, 5, 2);
                return true;
            case 5:
                this.outputPowerSide = 3;
                world.setBlockMetadataWithNotify(x, y, z, 3, 2);
                return true;
            case 3:
                this.outputPowerSide = 4;
                world.setBlockMetadataWithNotify(x, y, z, 4, 2);
                return true;
            case 4:
                this.outputPowerSide = 2;
                world.setBlockMetadataWithNotify(x, y, z, 2, 2);
                return true;
        }
        return false;
    }

    @Override
    public IIcon getTexture(int i) {
        return IConData.IconRegistry.get("test_" + i);
    }
}
