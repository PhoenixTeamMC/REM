package phoenix.rem.data;

/**
 * Created by Elec332 on 8-2-2015.
 */
public class WorldGenInfo {
    public WorldGenInfo(){
    }

    int multiplier = 1;
    boolean shouldGen = true;
    int clusterSize = 0;


    //Sets worldGen info
    public WorldGenInfo setGenerationMultiplier(int i){
        this.multiplier = i;
        return this;
    }

    public WorldGenInfo setShouldGen(boolean b){
        this.shouldGen = b;
        return this;
    }

    public WorldGenInfo setClusterSize(int i){
        this.clusterSize = i;
        return this;
    }

    //Gets worldGen info
    public Integer getGenerationMultiplier(){
        return multiplier;
    }

    public Boolean getShouldGen(){
        return shouldGen;
    }

    public Integer getClusterSize(){
        return clusterSize;
    }
}
