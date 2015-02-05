package phoenix.REM.Main;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

/**
 * Created by Elec332 on 5-2-2015.
 */
public class CreativeTabs {
    public static net.minecraft.creativetab.CreativeTabs TabMain = new net.minecraft.creativetab.CreativeTabs("TabMain") {
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem()
        {
            return Item.getItemFromBlock(Blocks.anvil);
        }
    };
}
