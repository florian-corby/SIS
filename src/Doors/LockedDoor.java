package Doors;

import Items.*;

import java.io.Serializable;

public class LockedDoor extends Door implements Unlockable, UsableBy, Serializable {

	PassType passType;
	private boolean isLocked;

	public LockedDoor(String tag, PassType p)
	{
		super(tag);
		this.passType = p;
		this.isLocked = true;
	}

	public void describe()
	{
		if(this.isLocked)
			System.out.println("This door is locked! A letter " + this.passType.toString() + " is written on it...");

		else
			System.out.println("This door is unlocked!");
	}

	public void open()
	{
		if(!isLocked)
			super.open();

		else
			System.out.println("This door is locked! A letter " + this.passType.toString() + " is written on it...");
	}

	@Override
	public void unlock(Pass p)
	{
		if(this.passType == p.getPassType())
		{
			this.isLocked = false;
			System.out.println("You have unlocked the door!");
		}

		else
		{
			System.out.println("You can't unlock this door with this pass.");
		}
	}

	@Override
	public void isUsedBy(UsableOn u)
	{
		if(u instanceof Pass)
		{
			Pass p = (Pass) u;
			this.unlock(p);
		}

		else
		{
			System.out.println("This object can't be used to open this door.");
		}
	}
}