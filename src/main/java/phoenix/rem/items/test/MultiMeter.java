package phoenix.rem.items.test;

import elec332.repack.core.helper.RegisterHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import phoenix.rem.api.power.BaseTileReceiver;
import phoenix.rem.api.power.IPowerReceiver;
import phoenix.rem.data.ModInfo;
import phoenix.rem.main.CTabs;

/**
 * Created by Elec332 on 9-2-2015.
 */
//I know this is unrealistic, don't bug me about it, its for testing purposes.
public class MultiMeter extends Item{
    public MultiMeter(String name) {
        setCreativeTab(CTabs.TabMain);
        setUnlocalizedName(ModInfo.MODID + "." + name);
        setTextureName(ModInfo.MODID + ":" + name);
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
        if (tileEntity instanceof IPowerReceiver && !world.isRemote) {
            player.addChatComponentMessage(new ChatComponentText("Speed : " + ((IPowerReceiver) tileEntity).getSpeed()));
            player.addChatComponentMessage(new ChatComponentText("Torque : " + ((IPowerReceiver) tileEntity).getTorque()));
            player.addChatComponentMessage(new ChatComponentText("Can receive power from clicked side : " + ((IPowerReceiver) tileEntity).canReceivePowerFromSide(ForgeDirection.getOrientation(side))));
            return true;
        }
        return false;
    }
}
