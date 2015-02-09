package phoenix.rem.api.power;

/**
 * Created by Elec332 on 9-2-2015.
 */
public interface IPowerReceiver {
    public Integer minSpeedRequired();

    public Integer maxSpeed();

    Boolean doesExplode();

    //Unrealistic and for testing purposes only
    //-Elec332
    public Integer InternalSpeedStored();
    public void setSpeedStored(int i);
}
