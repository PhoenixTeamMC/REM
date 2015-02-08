package phoenix.rem.helper;

import elec332.repack.core.config.ConfigCore;
import phoenix.rem.data.WorldGenInfo;
import phoenix.rem.main.REMMod;

/**
 * Created by Elec332 on 8-2-2015.
 */
public class ConfigHelper {
    public static ConfigHelper INSTANCE = new ConfigHelper();
    ConfigCore oreConfig = REMMod.RemConfig("WorldGen");;

    public WorldGenInfo ConfigurableWorldGen(String oreName, int i){
        boolean s = oreConfig.getBoolean("Should_gen", oreName, true, "Sets if the ore should generate in the world or not");
        int m = oreConfig.getInt("Generation_multiplier", oreName, 100, 0, 1000, "Sets how many times REM will attempt to generate ores per chunk (In % from the default value)");
        int c = oreConfig.getInt("ClusterSize", oreName, i, 0, 30, "Sets the max cluster size for this ore");
        oreConfig.syncConfiguration();
        return new WorldGenInfo().setGenerationMultiplier((m/100)).setShouldGen(s).setClusterSize(c);
    }
}
