package logic;

public abstract class Employee extends BackEndAPI {
    private String name;
    private int id;
    private int baseSalary;
    private int bonus;


    public Employee(String name, int id, int baseSalary) {
        setName(name);
        setId(id);
        setBaseSalary(baseSalary);
        setBonus(bonus);
        
    }

    public abstract int computeSalary();

    public String getDescription() {
        return id + " " + name + " [Bonus: " + bonus + "$]";
    }


    public void setName(String name) {
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public int getBaseSalary() {
        return this.baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary < 0 ? 0: baseSalary;
    }

    public int getBonus() {
        return this.bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus < 0 ? 0 : bonus;
    }

}
