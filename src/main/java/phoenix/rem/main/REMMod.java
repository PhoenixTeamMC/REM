package phoenix.rem.main;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import elec332.repack.core.config.ConfigCore;
import elec332.repack.core.helper.MCModInfo;
import elec332.repack.core.helper.ModInfoHelper;
import elec332.repack.core.modBaseUtils.ModBase;
import phoenix.rem.data.ModInfo;
import phoenix.rem.init.BlockRegist;
import phoenix.rem.init.ItemRegist;
import phoenix.rem.proxies.CommonProxy;
import phoenix.rem.world.Ores;

import java.io.File;

/**
 * Created by Elec332 on 5-2-2015.
 */
@Mod(modid = "REM", name = "REM", dependencies = ModInfo.DEPENDENCIES,
        acceptedMinecraftVersions = ModInfo.ACCEPTEDMCVERSIONS, useMetadata = true, canBeDeactivated = true)
public class REMMod extends ModBase {

    @SidedProxy(clientSide = ModInfo.CLIENTPROXY, serverSide = ModInfo.COMMONPROXY)
    public static CommonProxy proxy;

    @Mod.Instance("REM")
    public static REMMod instance;
    public static File baseFolder;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        this.modID = ModInfoHelper.getModID(event);
        this.baseFolder = new File(event.getModConfigurationDirectory(), "REM");
        this.cfgFile = new File(baseFolder, "REM.cfg");
        loadConfiguration();
        if (developmentEnvironment) { info("Running in Dev enviroment, enabling dev features."); }
        else { runUpdateCheck(event, "https://raw.githubusercontent.com/PhoenixTeamMC/REM/master/gradle.properties"); }
        proxy.registerHandlers();


        MCModInfo.CreateMCModInfo(event, "Created by Elec332 & chbachman", "Description",
                "Loading URL...", "assets/rem/logo.png", new String[] {"Elec332", "chbachman"});
        notifyEvent(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.registerTileEntities();
        ItemRegist.instance.init();
        BlockRegist.instance.init();
        GameRegistry.registerWorldGenerator(new Ores(), 1000);


        loadConfiguration();
        notifyEvent(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){


        loadConfiguration();
        notifyEvent(event);
    }

    public static ConfigCore RemConfig(String s){
        return new ConfigCore(new File(baseFolder, s + ".cfg"));
    }

    File cfgFile;
    public static String modID;

    @Override
    protected File configFile() {
        return cfgFile;
    }

    @Override
    public String modID() {
        return modID;
    }
}
