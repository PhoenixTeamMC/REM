package phoenix.rem.blocks.test;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import phoenix.rem.blocks.BlockMachineBase;

/**
 * Created by Elec332 on 5-2-2015.
 */
public class TestBlock extends BlockMachineBase{
    public TestBlock(String name) {
        super(Material.circuits, name);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int var2) {
        return new TestBlockTE();
    }
}

