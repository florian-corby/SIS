package Items;


public class Pass extends Item implements UsableOn {

	PassType passType;

	public Pass(String tag, String description, PassType p) {
		super(tag, description);
		this.passType = p;
	}

	public PassType getPassType() {
		return this.passType;
	}


	@Override
	public void isUsed() {
		System.out.println("vous ne pouvez pas utiliser un carte seule !");
	}
}

