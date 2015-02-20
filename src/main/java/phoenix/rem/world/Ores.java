package phoenix.rem.world;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import phoenix.rem.data.WorldGenInfo;
import phoenix.rem.helper.ConfigHelper;
import phoenix.rem.init.BlockRegister;

import java.util.Random;

/**
 * Created by Elec332 on 8-2-2015.
 */
public class Ores implements IWorldGenerator {

    static WorldGenInfo TestInfo = ConfigHelper.configurableWorldGen("TestOre", 6, 60, 10);

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.dimensionId){
            case 1:
                break;
            case 0:
                generateOverworld(world, random, chunkX, chunkZ, TestInfo, BlockRegister.TestOre);
                break;
            case -1:
                break;
        }
    }

    private void generateEnd(World world, Random random, int chunkX, int chunkZ, WorldGenInfo info, Block block) {
        if (info.getShouldGen()){
            for (int i = 0; i < info.timesPerChunk * info.getGenerationMultiplier(); i++) {
                int xCoord = chunkX + random.nextInt(16);
                int yCoord = random.nextInt(info.yLevelMax); //Max Y value, should we make this configurable aswell?
                int zCoord = chunkZ + random.nextInt(16);
                (new WorldGenMinable(block, 0, info.getClusterSize(), Blocks.end_stone)).generate(world, random, xCoord, yCoord, zCoord);
            }
        }
    }

    private void generateNether(World world, Random random, int chunkX, int chunkZ, WorldGenInfo info, Block block) {
        if (info.getShouldGen()){
            for (int i = 0; i < info.timesPerChunk * info.getGenerationMultiplier(); i++) {
                int xCoord = chunkX + random.nextInt(16);
                int yCoord = random.nextInt(info.yLevelMax); //Max Y value, should we make this configurable aswell?
                int zCoord = chunkZ + random.nextInt(16);
                (new WorldGenMinable(block, 0, info.getClusterSize(), Blocks.netherrack)).generate(world, random, xCoord, yCoord, zCoord);
            }
        }
    }

    private void generateOverworld(World world, Random random, int chunkX, int chunkZ, WorldGenInfo info, Block block) {
        if (info.getShouldGen()){
            for (int i = 0; i < info.timesPerChunk * info.getGenerationMultiplier(); i++) {
                int xCoord = chunkX + random.nextInt(16);
                int yCoord = random.nextInt(info.yLevelMax); //Max Y value, should we make this configurable aswell?
                int zCoord = chunkZ + random.nextInt(16);
                (new WorldGenMinable(block, 0, info.getClusterSize(), Blocks.stone)).generate(world, random, xCoord, yCoord, zCoord);
            }
        }
    }
}
