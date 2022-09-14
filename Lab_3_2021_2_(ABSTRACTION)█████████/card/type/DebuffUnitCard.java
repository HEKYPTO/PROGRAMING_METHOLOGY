package card.type;

import card.base.UnitCard;
import player.Player;

//You CAN modify the first line
public class DebuffUnitCard extends UnitCard {	

	private int debuffPower;
	
	public DebuffUnitCard(String name, String flavorText, int bloodCost, int power, int health, int debuffPower) {
		super(name, flavorText, bloodCost, power, health);
		setDebuffPower(debuffPower);
		
	}	

	@Override
	public int attackUnit(UnitCard unitCard) {
		int dmg = (unitCard.getHealth() < this.getPower() ? unitCard.getHealth(): this.getPower());
		unitCard.setHealth(unitCard.getHealth() - this.getPower());
		unitCard.setPower(unitCard.getPower() - this.getDebuffPower());
		return dmg; 
	}

	public int getDebuffPower() {
		return this.debuffPower;
	}

	public void setDebuffPower(int debuffPower) {
		this.debuffPower = (debuffPower < 0 ? 0: debuffPower);
	}
}
