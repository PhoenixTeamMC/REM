package phoenix.rem.api.power;

/**
 * Created by Elec332 on 9-2-2015.
 */
public class PowerRequirements {
    public PowerRequirements(){
    }

    int minRot = 1;
    boolean doesExplode = true;
    int maxRot = 0;


    //Sets worldGen info
    public PowerRequirements setMinRotation(int i){
        this.minRot = i;
        return this;
    }

    public PowerRequirements setDoesExplode(boolean b){
        this.doesExplode = b;
        return this;
    }

    public PowerRequirements setMaxRotation(int i){
        this.maxRot = i;
        return this;
    }

    //Gets worldGen info
    public Integer getMinRotation(){
        return minRot;
    }

    public Boolean getDoesExplode(){
        return doesExplode;
    }

    public Integer getMaxRotation(){
        return maxRot;
    }
}
