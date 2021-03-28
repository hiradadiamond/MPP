package lab3.day2;

import java.util.ArrayList;
import java.util.List;

public class Department {
	private String name;
	private String location;
	private List<Position> positions;
	private Company company;

	Department(String name, String location, Company company) {
		this.name = name;
		this.location = location;
		this.positions = new ArrayList<Position>();
		this.company = company;
	}

	public void addPosition(Position aPosition) {
		this.positions.add(aPosition);
	}

	public void print() {
		this.positions.forEach(p -> p.print());
	}

	public double getSalary() {
		double totalSalary = 0;
		for (Position p : positions) {
			totalSalary += p.getSalary();
		}
		return totalSalary;
	}


	public boolean isTopExecutive(Position p) {
		if (!(p.getDepartment().equals(this))) {
			return true;
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((positions == null) ? 0 : positions.hashCode());
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
		Department other = (Department) obj;
		if(!this.getName().equals(other.getName()))
			return false;
		if(!this.getLocation().equals(other.getLocation()))
			return false;	
		return true;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Position getDepartmentHead() {
		for (Position p : this.positions) {
			Position superior = p.getSuperior();
			if (superior == null) {
				return p;
			} else {
				Department superiorDepartment = superior.getDepartment();
				Department myDepartment = p.getDepartment();
				if (!(myDepartment.equals(superiorDepartment))) {
					return p;
				}
			}
		}
		return null;
	}

}
