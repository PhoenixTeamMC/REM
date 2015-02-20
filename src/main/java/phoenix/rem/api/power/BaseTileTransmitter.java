package phoenix.rem.api.power;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import phoenix.rem.api.wrench.BaseTileRotatable;
import phoenix.rem.helper.DirectionHelper;
import phoenix.rem.util.ExplosionHelper;

/**
 * Created by Elec332 on 9-2-2015.
 */
public abstract class BaseTileTransmitter extends BaseTileRotatable implements IPowerReceiver{

	public boolean isBroken = false;

	boolean oiled = true; // TODO: this should be set on whether there is oil in
							// the internal buffer or not

	public ForgeDirection output; // = getFacing();

	public int speed = 0;
	public int torque = 0;

	@Override
	public boolean canReceivePowerFromSide(ForgeDirection direction){
		if (direction == DirectionHelper.getOppositeSide(this.getFacing())){
			this.output = this.getFacing();
			return true;
		}else if (direction == this.getFacing()){
			this.output = DirectionHelper.getOppositeSide(this.getFacing());
			return true;
		}
		return false;
	}

	protected int frictionWhenOiled(boolean oiled){
		return (oiled ? 3 : 20) * this.speed / this.maxSpeed();
	}

	public TileEntity getPowerReceiver(){
		switch (this.output) {
		case SOUTH:
			return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord + 1);
		case WEST:
			return this.worldObj.getTileEntity(this.xCoord - 1, this.yCoord, this.zCoord);
		case NORTH:
			return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord - 1);
		case EAST:
			return this.worldObj.getTileEntity(this.xCoord + 1, this.yCoord, this.zCoord);
		default:
			return null;
		}
	}

	@Override
	public int getSpeed(){
		return this.speed;
	}

	@Override
	public int getTorque(){
		return this.torque;
	}

	@Override
	public void recievePower(int torque, int speed){
		this.speed = speed;
		this.torque = torque;
	}

	public void tryToEmitPower(IPowerReceiver powerReceiver){
		if (powerReceiver.canReceivePowerFromSide(this.output)){ // DirectionHelper.getOppositeSide(output)))
			// {
			float friction = ((100f - this.frictionWhenOiled(this.oiled)) / 100f); // make
			// it
			// semi-precise
			powerReceiver.recievePower(Float.floatToIntBits(this.torque * friction), Float.floatToIntBits(this.speed * friction));
		}
	}

	@Override
	public void updateEntity(){
		if (!this.isBroken){
			if (this.speed >= this.maxSpeed() || this.torque >= this.maxTorque()){
				if (this.doesExplode()){
					ExplosionHelper.explodeBlock(this.worldObj, this.xCoord, this.yCoord, this.zCoord, 4);
				}else{
					this.isBroken = true; // TODO: make wrench fix machine when
					// broken with fancy gui 'n stuff
				}
			}else if (this.speed >= 0 && this.torque >= this.minTorque()){
				if (this.getPowerReceiver() instanceof IPowerReceiver){
					this.tryToEmitPower((IPowerReceiver) this.getPowerReceiver());
				}
				this.speed = 0;
				this.torque = 0;
			}
		}
	}
}
