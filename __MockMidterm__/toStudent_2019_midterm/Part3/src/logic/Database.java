package logic;

import java.util.ArrayList;

public class Database {
	private static ArrayList<Employee> employees;
	
	public Database() {
		employees = new ArrayList<Employee>();
	}
	
	public Employee getEmployeeById(int id) {
		for(Employee e: employees) {
			if(e.getId()==id) {
				return e;
			}
		}
		return null;
	}
	
	public Employee getEmployeeByIndex(int index) {
		return employees.get(index);
	}
	
	public boolean addEmployee(Employee e) {
		if(getEmployeeById(e.getId())==null) {
		employees.add(e);
		return true;
		}
		return false;
	}
	
	
	public boolean removeEmployeeById(int id) {
		Employee e = getEmployeeById(id);
		if(e!=null) {
			employees.remove(e);
			return true;
		}
		return false;
	}
	
	public ArrayList<String> getAllEmployeeDescriptions(){
		/* FILL CODES*/
		ArrayList s = new ArrayList<String>();
		for (Employee e: employees) {
			if (e instanceof OfficeWorker) {
				s.add(BackEndAPI.getOfficeWorkerDescription(e.getId(), e.getName(), ((OfficeWorker) e).getDepartment(), e.getBonus()));
			} else if (e instanceof Janitor) {
				s.add(BackEndAPI.getJanitorDescription(e.getId(),e.getName(), ((Janitor) e).getArea(), e.getBonus()));
			}
		}

		return s;
	}
	
	public int calculateAllSalary() {
		/* FILL CODES*/
		int wage = 0;
		for (Employee e: employees) {
			wage += e.computeSalary();
		}
		return wage;
	}
	
	public int getTotalEmployeeCount() {
		return employees.size();
	}
}
