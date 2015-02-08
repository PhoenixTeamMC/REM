package phoenix.rem.client.gui;

import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import phoenix.rem.helper.ConfigHelper;

/**
 * Created by Elec332 on 8-2-2015.
 */
public class ConfigGUI extends GuiConfig{
    public ConfigGUI(GuiScreen screen){
        super(screen, new ConfigElement(ConfigHelper.INSTANCE.oreConfig.getCategory(ConfigHelper.INSTANCE.test)).getChildElements(),
                "TestStringMIIIIIIIIIIIEP", false, false, GuiConfig.getAbridgedConfigPath(ConfigHelper.INSTANCE.oreConfig.toString()));
    }
}
