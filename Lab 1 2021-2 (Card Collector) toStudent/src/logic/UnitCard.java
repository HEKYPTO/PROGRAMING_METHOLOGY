package logic;

public class UnitCard {
	private String name;
	private int bloodCost;
	private int power;
	private int health;
	private String flavorText;
	
	//constructor
	public UnitCard(String name, int bloodCost, int power, int health, String flavorText) {
		this.name = name;
		this.bloodCost = bloodCost;
		this.power = power;
		this.health = health;
		this.flavorText = flavorText;
	}
	
	//Methods
	//Setter
	public void setName(String Name) {
		this.name = Name.isBlank() ? Name: "Creature"; 
	}
	public void setBloodCost(int bloodCost) {
		this.bloodCost = (bloodCost < 0) ? 0: bloodCost;
	}
	public void setPower(int power) {
		this.power = (power < 0) ? 0: power;
	}
	//write?
	public void setHealth(int health) {
		this.health = (health < 1) ? 1: health; 
	}
	public void setFlavorText(String flavorText) {
		this.flavorText = flavorText;
	}
	
	//Getter
	public String getName() {
		return name;
	}
	public int getBloodCost() {
		return bloodCost;
	}
	public int getPower() {
		return power;
	}
	//write?
	public int getHealth() {
		return health;
	}
	//
	public String getFlavorText() {
		return flavorText;
	}
	
	public boolean equals(UnitCard other) {
		if (this.name.equals(other.name)) {
			return true;
		}
		return false;
	}
	//
	public String toString() {
		return this.getName() + " (POW: " + this.getPower() + ", HP: " + this.getHealth() + ")";
	}
	
}
