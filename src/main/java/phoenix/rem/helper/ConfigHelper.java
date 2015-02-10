package phoenix.rem.helper;

import phoenix.rem.data.WorldGenInfo;

import static phoenix.rem.REMMod.config;

/**
 * Created by Elec332 on 8-2-2015.
 */
public class ConfigHelper {

    public static WorldGenInfo configurableWorldGen(String oreName, int i){
        boolean s = config.get("Should_gen", oreName, true, "Sets if the ore should generate in the world or not");
        int m = config.modConfiguration.getInt("Generation_multiplier", oreName, 100, 0, 1000, "Sets how many times REM will attempt to generate ores per chunk (In % from the default value)");
        int c = config.modConfiguration.getInt("ClusterSize", oreName, i, 0, 30, "Sets the max cluster size for this ore");
        
        return new WorldGenInfo().setGenerationMultiplier((m/100)).setShouldGen(s).setClusterSize(c);
    }
}
