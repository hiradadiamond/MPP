package lab3.day2;

import java.util.ArrayList;
import java.util.List;

public class Company {
	private String name;
	private List<Department> departments;
	
	Company(String name){
		this.name = name;
		this.departments = new ArrayList<Department>();
	}
	
	public void addDeparment(Department aDepartment) {
		this.departments.add(aDepartment);
	}
	
	public void print() {
		for(Department d: departments)
			d.print();
	}
	
	public double getSlary() {
		double totalSalary = 0;
		for(Department d: departments) {
			totalSalary += d.getSalary();
		}
		return totalSalary;
	}
	
	public void printReportingHierarchy() {
		StringBuilder printReports = new StringBuilder();
		Position topExecutive= getTopExecutive();
		topExecutive.printDownLine(0);
		
	}
		
	public Position getTopExecutive() {
		List<Position> allDepartmentHeads = new ArrayList<Position>();
		for(Department d: this.departments) {
			allDepartmentHeads.add(d.getDepartmentHead());
		}
		for(Position p: allDepartmentHeads) {
			if(isTopExecutive(p))
				return p;			
		}
		return null;
	}
	
	public boolean isTopExecutive(Position p) {
		return p.getSuperior()== null;
	}
}
