package logic;

public class OfficeWorker extends Employee {
    private String department;


    public OfficeWorker(String name, int id, String department) {
        super(name, id, 30);
        this.department = department;
    }

    @Override
    public int computeSalary() {
        return calculateMonthlySalary(getBaseSalary(), getBonus(), 20);
    }

    public String getDiscription() {
        return getOfficeWorkerDescription(getId(), getName(), getDepartment(), getBonus());
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
}
