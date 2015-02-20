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
import org.apache.logging.log4j.Logger;
import phoenix.rem.data.ModInfo;
import phoenix.rem.helper.ConfigHelper;
import phoenix.rem.init.BlockRegister;
import phoenix.rem.init.ItemRegister;
import phoenix.rem.proxies.CommonProxy;
import phoenix.rem.util.ConfigHandler;
import phoenix.rem.world.Ores;

import java.io.File;

/**
 * Created by Elec332 on 5-2-2015.
 */
@Mod(modid = "REM", name = "REM", dependencies = ModInfo.DEPENDENCIES, acceptedMinecraftVersions = ModInfo.ACCEPTEDMCVERSIONS, useMetadata = true, canBeDeactivated = true, guiFactory = "phoenix.rem.client.gui.GUIFactory")
public class REMMod extends ModBase{

	public static File baseFolder;

	public static ConfigHandler config;
	@Instance("REM")
	public static REMMod instance;
	public static Logger log;
	@SidedProxy(clientSide = ModInfo.CLIENTPROXY, serverSide = ModInfo.COMMONPROXY)
	public static CommonProxy proxy;
	public static String version;
	
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		proxy.registerTileEntities();
		ItemRegister.instance.init();
		BlockRegister.instance.init();
		if (config.get("I_wanna_crash_on_startup", "enable", false)){
			log.info("Attempting to crash your game with broken render stuff...");
			proxy.registerRenderer();
			log.info("Seems like the rendering works, please proceed loading the game...");
		}
		

		GameRegistry.registerWorldGenerator(new Ores(), 1000);
		config.sync();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event){

		config.sync();
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		version = ModInfoHelper.getModVersion(event);
		baseFolder = new File(event.getModConfigurationDirectory(), "REM");
		config = ConfigHelper.getConfig("REM");
		log = event.getModLog();
		
		if (developmentEnvironment){
			log.info("Running in Dev environment, enabling dev features.");
		}else{
			runUpdateCheck(event, "https://raw.githubusercontent.com/PhoenixTeamMC/REM/master/gradle.properties");
		}
		
		proxy.registerHandlers();
		config.sync();
		MCModInfo.CreateMCModInfo(event, "Created by Elec332 & chbachman", "Description", "Loading URL...", "assets/rem/logo.png", new String[] { "Elec332", "chbachman", "InfinityRaider" });
	}
}
