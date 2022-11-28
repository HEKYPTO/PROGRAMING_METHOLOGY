package fighters.derived;
import fighters.base.*;

public class Tank extends Unit implements Guardable {

	public Tank(int maxHealth, int speed, int defense, int location) {
		super("Tank", "t", maxHealth, speed, location, true);
		super.setDefense(defense);
	}
	
	public void guard() {
		super.setOnGuard(true);
	}
	
	public boolean move(int spaces) {
		super.setOnGuard(false);
		return super.move(spaces);
	}
	
}
