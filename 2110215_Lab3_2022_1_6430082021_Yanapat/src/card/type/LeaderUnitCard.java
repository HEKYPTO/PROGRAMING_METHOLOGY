package card.type;

import card.base.UnitCard;

import java.util.Objects;

//You CAN modify the first line
public class LeaderUnitCard extends UnitCard {

	private int buffPower;
	private int buffHealth;
	
	public LeaderUnitCard(String name, String flavorText, int bloodCost, int power, int health, int buffPower, int buffHealth) {
		super(name, flavorText, bloodCost, power, health);
		setBuffPower(buffPower);
		setBuffHealth(buffHealth);
	}

	@Override
	public int attackUnit(UnitCard unitCard) {
		int dmg = unitCard.getHealth() < this.getPower() ? unitCard.getHealth() : this.getPower();
		unitCard.setHealth(unitCard.getHealth() - this.getPower());
		return dmg;
	}

	public void buffUnit(UnitCard[] alliesCards) {
		for (UnitCard card: alliesCards) {
			if (!Objects.isNull(card)) {
				card.setPower(card.getPower() + getBuffPower());
				card.setHealth(card.getHealth() + getBuffHealth());
			}
		}
	}

	public int getBuffPower() {
		return this.buffPower;
	}

	public void setBuffPower(int buffPower) {
		this.buffPower = buffPower < 0 ? 0: buffPower;
	}

	public int getBuffHealth() {
		return this.buffHealth;
	}

	public void setBuffHealth(int buffHealth) {
		this.buffHealth = buffHealth < 0 ? 0: buffHealth;
	}
	
	@Override
	public String toString() {
		return super.getName() + " (POW: " + super.getPower() + ", HP: " + super.getHealth() + 
				" | POW Inc: "+ this.getBuffPower() + ", HP Inc: " + this.getBuffHealth() + ")";
	}

}