package phoenix.rem.api.wrench;

import net.minecraft.item.ItemStack;

/**
 * Created by Elec332 on 5-2-2015.
 */
public interface IWrenchable{

    public ItemStack ItemDropped();

    public void onWrenched();
}
