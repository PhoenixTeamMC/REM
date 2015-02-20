package elec332.repack.core.modBaseUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import net.minecraft.launchwrapper.Launch;

import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import elec332.repack.core.handler.UpdateHandler;
import elec332.repack.core.helper.ModInfoHelper;

/**
 * Created by Elec332.
 */
public abstract class ModBase{

	public static boolean developmentEnvironment = (Boolean) Launch.blackboard.get("fml.deobfuscatedEnvironment");
	String onlineVer;
	boolean outdated = false;

	//boolean uptodate = false;

	protected void runUpdateCheck(FMLPreInitializationEvent event, String versionURL){
		String modid = ModInfoHelper.getModID(event);
		String currentVersion = ModInfoHelper.getModVersion(event);
		ArrayList<String> updateInfo = new ArrayList<String>();
		Logger log = event.getModLog();

		log.info("Starting version check");

		try{

			BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(versionURL).openStream()));

			this.onlineVer = reader.readLine().replace("mod_version=", "");
			reader.close();

			String[] unparsed = onlineVer.replace(".", " ").split(" ");
			String[] qr = currentVersion.replace(".", " ").split(" ");

			if (unparsed.length == qr.length){
				log.warn("The online version length and the internal version length differs, report this to the mod author!");
				log.warn("Assuming you are using an outdated version");
				this.outdated = true;
			}else{
				
				for (int i = 0; i < unparsed.length; i++){
					if (!currentVersion.equalsIgnoreCase(onlineVer)){
						if (Integer.parseInt(unparsed[i]) > Integer.parseInt(qr[i])){
							this.outdated = true;
						}
					}
				}
				
			}

			if (outdated){
				updateInfo.add(currentVersion);
				updateInfo.add(onlineVer);
				log.info("Marking as outdated");
				UpdateHandler.updates.put(modid, updateInfo);
			}else{
				log.info("Marking as up-to-date");
			}
				
			log.info("Version check complete");
		}catch (Exception e){
			log.warn("Couldn't run VersionCheck: ", e);
		}
	}
}