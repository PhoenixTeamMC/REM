package phoenix.rem.helper;

import net.minecraftforge.common.config.Configuration;
import phoenix.rem.REMMod;
import phoenix.rem.data.WorldGenInfo;
import phoenix.rem.util.ConfigHandler;

import java.io.File;

/**
 * Created by Elec332 on 8-2-2015.
 */
public class ConfigHelper {

    static ConfigHandler oreConfiguration = getConfig("ores");

    public static WorldGenInfo configurableWorldGen(String oreName, int clusterSize, int maxY, int timesPerChunk){
        oreConfiguration.load();
        boolean s = oreConfiguration.modConfiguration.getBoolean("Should_gen", oreName, true, "Sets if the ore should generate in the world or not");
        int m = oreConfiguration.modConfiguration.getInt("Generation_multiplier", oreName, 100, 0, 1000, "Sets how many times REM will attempt to generate ores per chunk (In % from the default value)");
        int c = oreConfiguration.modConfiguration.getInt("ClusterSize", oreName, clusterSize, 0, 30, "Sets the max cluster size for this ore");
        oreConfiguration.save();
        return new WorldGenInfo(maxY, timesPerChunk).setGenerationMultiplier((m/100)).setShouldGen(s).setClusterSize(c);
    }

    public static ConfigHandler getConfig(String name) {
        return new ConfigHandler(REMMod.version).setConfiguration(new Configuration(new File(REMMod.baseFolder, name + ".cfg")));
    }
}
