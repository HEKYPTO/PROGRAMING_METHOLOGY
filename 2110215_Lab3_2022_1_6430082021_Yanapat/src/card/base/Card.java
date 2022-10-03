package card.base;

//You CAN modify the first line
public abstract class Card implements Cloneable {
	
	//Fields
	private String name;
	private String flavorText;
	private int bloodCost;

	/// You can modify code below ///
	public Card(String name, String flavorText, int bloodCost) {
		setName(name);
		setFlavorText(flavorText);
		setBloodCost(bloodCost);
	}
		
	public abstract String toString();
	

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlavorText() {
		return this.flavorText;
	}

	public void setFlavorText(String flavorText) {
		this.flavorText = flavorText;
	}

	public int getBloodCost() {
		return this.bloodCost;
	}

	public void setBloodCost(int bloodCost) {
		this.bloodCost = (bloodCost < 0 ? 0: bloodCost);
	}
	
	
	/// You can modify code above ///
	
	public boolean equals(UnitCard other) {
		return this.getName().equals(other.getName());
	}
	public Object clone()throws CloneNotSupportedException{  
		return super.clone();  
		}  

	
}