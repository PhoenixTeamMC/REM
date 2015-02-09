package phoenix.rem.api.power;

/**
 * Created by Elec332 on 9-2-2015.
 */
public interface IPowerReceiver {

    public Integer maxSpeed();

    public Integer maxTorque();

    public Integer minTorque();

    Boolean doesExplode();

    public void setTorque(int i);

    public void setSpeed(int i);
}
