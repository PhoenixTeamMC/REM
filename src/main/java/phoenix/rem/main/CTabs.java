package phoenix.rem.main;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import phoenix.rem.data.ModInfo;
import phoenix.rem.init.BlockRegist;

/**
 * Created by Elec332 on 5-2-2015.
 */
public class CTabs {
    public static CreativeTabs TabMain = new CreativeTabs(localise("TabMain")) {
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem()
        {
            return Item.getItemFromBlock(BlockRegist.RedstoneEngine);
        }
    };

    static String localise(String name){
        return ModInfo.MODID + name;
    }
}
