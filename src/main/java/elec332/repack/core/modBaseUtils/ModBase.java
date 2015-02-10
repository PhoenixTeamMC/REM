package elec332.repack.core.modBaseUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import net.minecraft.launchwrapper.Launch;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import elec332.repack.core.handler.UpdateHandler;
import elec332.repack.core.helper.ModInfoHelper;

/**
 * Created by Elec332.
 */
public abstract class ModBase{

    boolean outdated = false;
    boolean uptodate = false;
    String onlineVer;

    public static boolean developmentEnvironment = (Boolean) Launch.blackboard.get("fml.deobfuscatedEnvironment");

    protected void runUpdateCheck(FMLPreInitializationEvent event, String versionURL){
        String modID_V = ModInfoHelper.getModID(event);
        String versionInternal = ModInfoHelper.getModVersion(event);
        event.getModLog().info("Starting version check");
        ArrayList<String> updateInfo = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(versionURL).openStream()));
                this.onlineVer = reader.readLine().replace("mod_version=", "");
            reader.close();
            //this.onlineVer ="1.3.0";

        String[] unparsed= onlineVer.replace(".", " ").split(" ");
        String qr[] = versionInternal.replace(".", " ").split(" ");
        if (unparsed.length == qr.length) {
            for (int i = 0; i < unparsed.length; i++) {
                String mr = qr[i];
                String nr = unparsed[i];
                int v = Integer.parseInt(nr);
                if (!versionInternal.equalsIgnoreCase(onlineVer)) {
                    if (v < Integer.parseInt(mr))
                        this.uptodate = true;
                    if (!uptodate)
                        if (v > Integer.parseInt(mr))
                            this.outdated = true;
                }
            }
        }else {
            event.getModLog().warn("The online version length and the internal version length differs, report this to the mod author!");
            event.getModLog().warn("Assuming you are using an outdated version");
            this.outdated = true;
        }
        if (outdated) {
            updateInfo.add(versionInternal);
            updateInfo.add(onlineVer);
            event.getModLog().info("Marking as outdated");
            UpdateHandler.outdatedModList.add(modID_V);
            UpdateHandler.Updates.put(modID_V, updateInfo);
        }else
            event.getModLog().info("Marking as up-to-date");
        event.getModLog().info("Version check complete");
        }catch (Exception e){
            event.getModLog().warn("Couldn't run VersionCheck: ", e);
        }
    }
}