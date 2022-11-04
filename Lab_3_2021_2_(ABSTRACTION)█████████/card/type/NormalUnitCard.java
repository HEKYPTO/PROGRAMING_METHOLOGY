package card.type;

import card.base.UnitCard;
import player.Player;

//You CAN modify the first line
public class NormalUnitCard extends UnitCard {
	
	public NormalUnitCard(String name, String flavorText, int bloodCost, int power, int health) {
			super(name, flavorText, bloodCost, power, health);
	}

	@Override
	public int attackUnit(UnitCard unitCard) {
		int dmg = (unitCard.getHealth() < this.getPower() ? unitCard.getHealth(): this.getPower());
		unitCard.setHealth(unitCard.getHealth() - this.getPower()); //case < 0
		return dmg;
	}	
	
}

