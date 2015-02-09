package phoenix.rem.items.test;

import elec332.repack.core.helper.RegisterHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import phoenix.rem.api.power.IPowerReceiver;
import phoenix.rem.api.wrench.IWrenchable;
import phoenix.rem.blocks.tile.BaseTileRotatable;
import phoenix.rem.main.CTabs;
import phoenix.rem.main.REMMod;

/**
 * Created by Elec332 on 9-2-2015.
 */
//I know this is unrealistic, don't bug me about it, its for testing purposes.
public class MultiMeter extends Item{
    public MultiMeter(String name) {
        setCreativeTab(CTabs.TabMain);
        setUnlocalizedName(REMMod.modID + "." + name);
        setTextureName(REMMod.modID + ":" + name);
        setContainerItem(this);
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
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity instanceof IPowerReceiver) {
            player.addChatComponentMessage(new ChatComponentText("Speed stored: " + ((IPowerReceiver) tileEntity).InternalSpeedStored()));
            return true;
        }
        return false;
    }
}
