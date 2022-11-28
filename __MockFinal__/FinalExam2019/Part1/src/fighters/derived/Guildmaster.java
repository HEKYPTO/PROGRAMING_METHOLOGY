package fighters.derived;

import fighters.base.Attackable;
import fighters.base.Guardable;
import fighters.base.Unit;
import logic.BattleUtils;

public class Guildmaster extends Unit implements Attackable, Guardable{
	public Guildmaster(int maxHealth, int speed, int power, int defense, int location) {
		super("Guildmaster", "G", maxHealth, speed, location, false);
		super.setRange(1);
		super.setPower(power);
		super.setDefense(defense);
	}
	
	public boolean move(int spaces) {
		return super.move(-1);
	}
	
	public void guard() {
		
	}
	
	public int attack(Unit e) {
		return (!sameTeam(e) && BattleUtils.validRange(this.range, this.location, e.getLocation())) ? BattleUtils.calculateDamage(power, e): -1;
	}
}
