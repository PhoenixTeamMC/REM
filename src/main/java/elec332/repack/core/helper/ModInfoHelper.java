package elec332.repack.core.helper;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Elec332 on 20-12-2014.
 */
public class ModInfoHelper {

    public static String getModID(FMLPreInitializationEvent event){
        return event.getModMetadata().modId;
    }

    @Deprecated
    public static String getModName(FMLPreInitializationEvent event){
        return event.getModMetadata().name;
    }

    public static String getModVersion(FMLPreInitializationEvent event){
        return event.getModMetadata().version;
    }
}
