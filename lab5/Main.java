package lab5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		Employee eHourly = new Hourly(25, 130);
		Employee eSalary = new Salaried(10000);
		Employee eCommission1 = new Commissioned(2000);
		Employee eCommission2 = new Commissioned(2000);

		//created different dates
		LocalDate date1 = LocalDate.of(2021, 1, 10);
		LocalDate date2 = LocalDate.of(2021, 1, 20);
		LocalDate date3 = LocalDate.of(2021, 2, 20);
		LocalDate date4 = LocalDate.of(2021, 3, 28);
		LocalDate date5 = LocalDate.of(2021, 3, 28);
		LocalDate date6 = LocalDate.of(2021, 4, 28);
		
		//Multiple orders form jan - april
		Order o1 = new Order(200, date1);
		Order o2 = new Order(100, date2);
		Order o3 = new Order(500, date3);
		Order o4 = new Order(1000, date4);
		Order o5 = new Order(1000, date5);
		Order o6 = new Order(1000, date6);

		((Commissioned) eCommission1).addOrders(o1);
		((Commissioned) eCommission1).addOrders(o2);
		((Commissioned) eCommission2).addOrders(o2);
		

		List<Employee> empList = new ArrayList<Employee>();
		empList.add(eHourly);
		empList.add(eSalary);
		empList.add(eCommission1);
		empList.add(eCommission2);

		// Create paycheck for Jan 2021
		for (Employee e : empList) {
			PayCheck payCheckForJan = e.calcCompensation(1, 2021);
		}

		((Hourly) eHourly).setHourlyWage(150);
		((Hourly) eHourly).setHoursPerWeek(130);
		

		// Create paycheck for Feb,2021
		for (Employee e : empList) {
			PayCheck payCheckForFeb = e.calcCompensation(2, 2021);
		}

		((Hourly) eHourly).setHourlyWage(35);
		((Hourly) eHourly).setHoursPerWeek(160);
		((Commissioned) eCommission2).addOrders(o3);
		((Commissioned) eCommission2).addOrders(o4);
		((Commissioned) eCommission2).addOrders(o5);
		

		// Create paycheck for March,2021
		for (Employee e : empList) {
			PayCheck payCheckForMarch = e.calcCompensation(3, 2021);
		}
		
		((Hourly) eHourly).setHourlyWage(40);
		((Hourly) eHourly).setHoursPerWeek(140);
		((Commissioned) eCommission2).addOrders(o6);
		((Commissioned) eCommission1).addOrders(o6);

		
		// Create paycheck for April,2021
				for (Employee e : empList) {
					PayCheck payCheckForMarch = e.calcCompensation(4, 2021);
				}

		//Result of all PayCheck from Jan - April for each employee
		for (Employee e : empList) {
			System.out.println();
			System.out.println(e.getClass().getSimpleName() + " Employee");
			for (PayCheck p : e.getPaychecks()) {
				p.print();

			}
		}

	}

}
