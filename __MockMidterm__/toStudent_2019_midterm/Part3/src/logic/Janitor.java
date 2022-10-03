package logic;

public class Janitor extends Employee {
    private String area;

    public Janitor(String name, int id, String area) {
        super(name, id, 15);
        setArea(area);
    }

    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public int computeSalary() {
        return calculateMonthlySalary(getBaseSalary(), getBonus(), 30);
    }

    public String getDiscription() {
        return getOfficeWorkerDescription(getId(), getName(), getArea(), getBonus());
    }

}
