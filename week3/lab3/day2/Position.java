package week3.lab3.day2;

import java.util.ArrayList;
import java.util.List;

public class Position implements Cloneable {
	private String title;
	private String description;
	private Employee emp;
	private Position superior;
	private List<Position> inferiorLists;
	private Department department;

	Position(String title, String description, Position superior, Department d) {
		this.title = title;
		this.description = description;
		this.emp = null;
		this.superior = superior;
		this.department = d;
		this.inferiorLists = new ArrayList<Position>();

	}

	public void fillPosition(Employee e) {
		this.emp = e;
	}

	public void printDownLine(int spaceIndentation) {
		for (int i = 0; i < spaceIndentation; i++) {
			System.out.print(" ");
		}
		this.print();
		for (Position p : inferiorLists) {
			p.printDownLine(spaceIndentation + 2);
		}
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void addInferirorPositions(Position p) {
		this.inferiorLists.add(p);
	}

	public void print() {
		if (this.emp == null)
			System.out.println("For this " + this.title + " Positon, There is no Employee!!");
		else {
			this.emp.print();
		}
	}

	public double getSalary() {
		if (this.emp == null)
			return 0;
		return this.emp.getSalary();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public Position getSuperior() {
		return superior;
	}

	public void setSuperior(Position superior) {
		this.superior = superior;
	}

	public List<Position> getInferiorLists() {
		return inferiorLists;
	}

	public void setInferiorLists(List<Position> inferiorLists) {
		this.inferiorLists = inferiorLists;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((superior == null) ? 0 : superior.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Position other = (Position) obj;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (superior == null) {
			if (other.superior != null)
				return false;
		} else if (!superior.equals(other.superior))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append(" Title: " + this.getTitle());
		output.append(",  "+ this.emp + "\n");
		return output.toString();
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Position copyPosition = (Position) super.clone();
		copyPosition.department = (Department) department.clone();
		copyPosition.emp = (Employee) emp.clone();	
		return copyPosition;		
	}
	
	

}
