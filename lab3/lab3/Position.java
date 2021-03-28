package lab3.lab3;

import java.util.ArrayList;
import java.util.List;

public class Position {
	private String title;
	private String description;
	private Employee emp;
	private Position superior;
	private List<Position> inferiorLists;
	private Department department;
	
	
	Position(String title, String description, Position superior, Department d){
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
		for(int i = 0; i < spaceIndentation; i++) {
			System.out.print(" ");
		}
		this.print();
		for(Position p : inferiorLists) {
			p.printDownLine(spaceIndentation+2);
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
		if(this.emp == null)
			System.out.println("For this "+ this.title+ " Positon, There is no Employee!!");
		else{
			this.emp.print();
		}
	}
	
	public double getSalary() {
		if(this.emp == null)
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
	


}
