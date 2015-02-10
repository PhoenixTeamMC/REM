package phoenix.rem;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import elec332.repack.core.helper.MCModInfo;
import elec332.repack.core.helper.ModInfoHelper;
import elec332.repack.core.modBaseUtils.ModBase;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Logger;
import phoenix.rem.data.ModInfo;
import phoenix.rem.init.BlockRegist;
import phoenix.rem.init.ItemRegist;
import phoenix.rem.proxies.CommonProxy;
import phoenix.rem.util.ConfigHandler;
import phoenix.rem.world.Ores;

import java.io.File;

/**
 * Created by Elec332 on 5-2-2015.
 */
@Mod(modid = "REM", name = "REM", dependencies = ModInfo.DEPENDENCIES, acceptedMinecraftVersions = ModInfo.ACCEPTEDMCVERSIONS, useMetadata = true, canBeDeactivated = true, guiFactory = "phoenix.rem.client.gui.GUIFactory")
public class REMMod extends ModBase{

	@SidedProxy(clientSide = ModInfo.CLIENTPROXY, serverSide = ModInfo.COMMONPROXY)
	public static CommonProxy proxy;

	@Instance("REM")
	public static REMMod instance;
	public static File baseFolder;
	public static ConfigHandler config;
	public static Logger log;
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		baseFolder = new File(event.getModConfigurationDirectory(), "REM");
		config = new ConfigHandler(ModInfoHelper.getModVersion(event)).setConfiguration(new Configuration(new File(baseFolder, "REM.cfg")));
		log = event.getModLog();
		
		if (developmentEnvironment){
			log.info("Running in Dev enviroment, enabling dev features.");
		}else{
			runUpdateCheck(event, "https://raw.githubusercontent.com/PhoenixTeamMC/REM/master/gradle.properties");
		}
		
		proxy.registerHandlers();

		MCModInfo.CreateMCModInfo(event, "Created by Elec332 & chbachman", "Description", "Loading URL...", "assets/rem/logo.png", new String[] { "Elec332", "chbachman" });
	}

	@EventHandler
	public void init(FMLInitializationEvent event){
		proxy.registerTileEntities();
		
		if (config.get("I_wanna_crash_on_startup", "enable", false)){
			log.info("Attempting to crash your game with broken render stuff...");
			proxy.registerRenderer();
			log.info("Seems like the rendering works, please proceed loading the game...");
		}
		
		ItemRegist.instance.init();
		BlockRegist.instance.init();
		GameRegistry.registerWorldGenerator(new Ores(), 1000);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}

}
