package phoenix.rem.blocks;

import elec332.repack.core.helper.RegisterHelper;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import phoenix.rem.blocks.test.TestBlockTE;
import phoenix.rem.main.CTabs;
import phoenix.rem.main.REMMod;

import java.util.Random;

/**
 * Created by Elec332 on 5-2-2015.
 */
public class TestBlock extends BaseBlockRotatable implements ITileEntityProvider{
    public TestBlock(String name) {
        super(Material.circuits, name);
        setBlockName(REMMod.modID + "." + name);
        setCreativeTab(CTabs.TabMain);
        RegisterHelper.registerBlock(this, name);
    }

    @Override
    public int quantityDropped(Random random){
        return 0;
    }

    @Override
    public Item getItemDropped(int par1, Random rand, int par2){
        return null;
    }

    @Override
    public ItemStack ItemDropped() {
        return new ItemStack(this);
    }

    @Override
    public void onWrenched(World world, int x, int y, int z, ForgeDirection direction) {
        this.rotateBlock(world, x, y, z, direction);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int var2) {
        return new TestBlockTE();
    }
}

