package card.base;

import player.Player;

//You CAN modify the first line
public abstract class UnitCard extends Card  {

	//Fields
	private int power;
	private int health;
		
	public UnitCard(String name, String flavorText, int bloodCost, int power, int health) {
		super(name, flavorText, bloodCost);
		setPower(power);
		setHealth(health);
	}

	public abstract int attackUnit(UnitCard u);
	

	public int attackPlayer(Player opponent) {
		/*
		 Hint:
			Use takeDamage(int)
			from Player class
		 */
		opponent.takeDamage(getPower());
		return getPower();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.getName() + "\tCost: " + this.getBloodCost() +"\t(POW: " + this.getPower() + ", HP: " + this.getHealth() + ")";
	}

	//GETTERS SETTERS

	public int getPower() {
		return this.power;
	}

	//
	public void setPower(int power) {
		this.power = (power < 0 ? 0: power);
	}

	public int getHealth() {
		return this.health;
	}

	public void setHealth(int health) {
		this.health = (health < 0 ? 0: health);
	}

}
