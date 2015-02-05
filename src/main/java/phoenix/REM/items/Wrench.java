package phoenix.REM.items;

import elec332.core.helper.RegisterHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import phoenix.REM.API.wrench.IWrenchable;
import phoenix.REM.Main.CreativeTabs;
import phoenix.REM.Main.REMMod;

/**
 * Created by Elec332 on 5-2-2015.
 */
public class Wrench extends Item {
    public Wrench(String name) {
        setCreativeTab(CreativeTabs.TabMain);
        setUnlocalizedName(REMMod.modID + "." + name);
        setTextureName(REMMod.modID + ":" + name);
        setContainerItem(this);
        setNoRepair();
        setMaxDamage(72);
        setMaxStackSize(1);
        RegisterHelper.registerItem(this, name);
    }

    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack) {
        return false;
    }

    public ItemStack getContainerItem(ItemStack itemStack) {
        return new ItemStack(this, 1, itemStack.getItemDamage() + 1);
    }

    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float HitX, float HitY, float HitZ) {
        Block block = world.getBlock(x, y, z);
        if (block instanceof IWrenchable){
            if (player.isSneaking()) {
                world.setBlockToAir(x, y, z);
                new EntityItem(world, HitX, HitY, HitZ, ((IWrenchable) block).ItemDropped());
                return true;
            } else {
                ((IWrenchable) block).onWrenched();
                return  true;
            }
        }
        return false;
    }
}
