package card.base;

//You CAN modify the first line
public abstract class SpellCard extends Card {

	//Fields
	private boolean isBurstSpeed;

	public SpellCard(String name, String flavorText, int bloodCost, boolean isBurstSpeed) {
		super(name, flavorText, bloodCost);
		setIsBurstSpeed(isBurstSpeed);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getName() + "\tCost: " + this.getBloodCost() +
				"\t(" + (this.getFlavorText()) + ")";
	}

	public abstract void castSpell(UnitCard unitCard);


	public boolean isBurstSpeed() {
		return this.isBurstSpeed;
	}

	public void setIsBurstSpeed(boolean isBurstSpeed) {
		this.isBurstSpeed = isBurstSpeed;
	}
}
