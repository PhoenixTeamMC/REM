package phoenix.rem.main;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import elec332.repack.core.helper.FileHelper;
import elec332.repack.core.helper.MCModInfo;
import elec332.repack.core.helper.ModInfoHelper;
import elec332.repack.core.modBaseUtils.ModBase;
import phoenix.rem.data.ModInfo;
import phoenix.rem.init.BlockRegist;
import phoenix.rem.init.ItemRegist;
import phoenix.rem.proxies.CommonProxy;

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

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        this.modID = ModInfoHelper.getModID(event);
        this.cfgFile = FileHelper.getConfigFileElec(event);
        loadConfiguration();
        if (developmentEnvironment) {
            info("Running in Dev enviroment, enabling dev features.");
        } else { runUpdateCheck(event, "https://raw.githubusercontent.com/PhoenixTeamMC/REM/master/gradle.properties"); }
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



        notifyEvent(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){



        notifyEvent(event);
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
