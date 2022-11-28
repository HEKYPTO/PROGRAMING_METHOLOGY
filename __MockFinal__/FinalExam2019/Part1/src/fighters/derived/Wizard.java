package fighters.derived;

import fighters.base.Attackable;
import fighters.base.Unit;
import logic.BattleUtils;

public class Wizard extends Unit implements Attackable {
	public Wizard(int maxHealth, int speed, int power, int location) {
		super("Wizard", "w", maxHealth, speed, location, true);
		super.setPower(power);
		super.setRange(2);
	}
	
	public int attack(Unit e) {
		return (!sameTeam(e) && BattleUtils.validRange(this.range, this.location, e.getLocation())) ? this.getPower(): -1;
	}
}
