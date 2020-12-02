package Doors;

import Items.*;

public class LockedDoor extends Door implements Unlockable, UsableBy {

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
		this.describe();

		if(this.isLocked)
			System.out.println("This door is locked!");

		else
			System.out.println("This door is unlocked!");
	}

	public void open()
	{
		if(!isLocked)
			super.open();

		else
			System.out.println("This door is locked!");
	}

	@Override
	public void unlock(Pass p)
	{
		if(this.passType == p.getPassType())
		{
			this.isLocked = false;
			System.out.println("Vous venez de déverrouiller la porte!");
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
	}
}