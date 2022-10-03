package card.type;

import card.base.UnitCard;
import player.Player;

//You CAN modify the first line
public class VenomUnitCard extends UnitCard {
	
	public VenomUnitCard(String name, String flavorText, int bloodCost, int power, int health) {
		super(name, flavorText, bloodCost, power, health);
	}

	@Override
	public int attackUnit(UnitCard unitCard) {
		int before = unitCard.getHealth();
		unitCard.setHealth(0);
		return before;
	}

	public int dead(Player player) {
		player.takeDamage(this.getPower()); //?
		return this.getPower();
	}
	
}
