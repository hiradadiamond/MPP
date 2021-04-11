package week3.lab3.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Company implements Cloneable{
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public double getSlary() {	

		return departments.stream().mapToDouble(Department::getSalary).reduce(0, (x,y)-> (x+y));
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
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Company [name=" + name + ", departments=" + departments + "]";
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		return (Company) super.clone();	
	}
}
