package phoenix.rem.client.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import phoenix.rem.REMMod;
import cpw.mods.fml.client.config.GuiConfig;

/**
 * Created by Elec332 on 8-2-2015.
 */
public class ConfigGUI extends GuiConfig{

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ConfigGUI(GuiScreen screen) {
		super(screen, new ConfigElement(REMMod.config.getCategory("TestOre")).getChildElements(), "TestStringMIIIIIIIIIIIEP", false, false, GuiConfig.getAbridgedConfigPath(REMMod.config.toString()));
	}
}
