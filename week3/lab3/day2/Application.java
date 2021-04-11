package week3.lab3.day2;

public class Application {

	public static void main(String[] args) throws CloneNotSupportedException {
		Company company = new Company("DiamondMall");
		Department salesDepartment = new Department("SalesDepartment", "Florida", company);
		Department marketingDepartment = new Department("Marketing Department", "IOWA", company);
		Department executiveDepartment = new Department("ExecutiveMemebers", "Chicago", company);

		Position ceoPosition = new Position("CEO", "Chief-Executive-Officer", null, executiveDepartment);
		Position salesDeptHeadPosition = new Position("SalesDepartment-Head", "HEAD", ceoPosition, salesDepartment);
		Position seniorSalesManPosition1 = new Position("Senior-SalesMan1", "Senior-SalesMAN", salesDeptHeadPosition,
				salesDepartment);
		Position seniorSalesManPosition2 = new Position("Senior-SalesMan2", "Senior-SalesMAN", salesDeptHeadPosition,
				salesDepartment);
		Position salesManPosition1 = new Position("SalesMan1", "SalesPerson", seniorSalesManPosition1, salesDepartment);
		Position salesManPosition2 = new Position("SalesMan2", "SalesPerson", seniorSalesManPosition1, salesDepartment);
		Position salesManPosition3 = new Position("SalesMan3", "SalesPerson", seniorSalesManPosition1, salesDepartment);
		Position salesManPosition4 = new Position("SalesMan4", "SalesPerson", seniorSalesManPosition2, salesDepartment);
		Position salesManPosition5 = new Position("SalesMan5", "SalesPerson", seniorSalesManPosition2, salesDepartment);
		Position salesManPosition6 = new Position("SalesMan6", "SalesPerson", seniorSalesManPosition2, salesDepartment);
		Position salesManPosition7 = new Position("SalesMan7", "SalesPerson", seniorSalesManPosition2, salesDepartment);

		
		Position marketingDeptHeadPosition = new Position("MarketingDepartment-Head", "HEAD", ceoPosition,
				executiveDepartment);
		Position seniorMarketerPosition = new Position("Senior-Marketing-Person", "Senior-Marketing-Person",
				marketingDeptHeadPosition, marketingDepartment);

		Employee ceoPerson = new Employee("Lyle", "", "", "3 July 1995", "2340-2353", 100000, ceoPosition);
		Employee deptHeadSalesPerson = new Employee("Ron", "", "", "3 July 1995", "2340-2353", 90000,
				salesDeptHeadPosition);
		Employee seniorSalesPerson1 = new Employee("Stan", " ", "", "1 dec 1993", "2333-44112", 8000,
				seniorSalesManPosition1);
		Employee seniorSalesPerson2 = new Employee("Peter", " ", "", "1 dec 1993", "2333-44112", 8000,
				seniorSalesManPosition2);
		Employee salesPerson1 = new Employee("Tom", "", "", "10 Jan 1988", "1210-3348", 900, salesManPosition1);
		Employee salesPerson2 = new Employee("Sue", "", "", "1 Feb 1990", "1213-3345", 900, salesManPosition2);
		Employee salesPerson3 = new Employee("Marc", "", "", "2 Aug 1991", "222-3348", 900, salesManPosition3);
		Employee salesPerson4 = new Employee("Bill", "", "", "1 March 1992", "123-3545", 900, salesManPosition4);
		Employee salesPerson5 = new Employee("Dan", "", "", "1 Jan 1993", "222-3345", 900, salesManPosition5);
		Employee salesPerson6 = new Employee("Dan", "", "", "1 Jan 1993", "222-3345", 900, salesManPosition5);

		Employee deptHeadMarketingPerson = new Employee("Anne", "", "", "3 July 1995", "2340-2353", 90000,
				marketingDeptHeadPosition);
		Employee seniorMarketingPerson = new Employee("Gary", " ", "", "1 dec 1993", "2333-44112", 8000,
				seniorMarketerPosition);

		company.addDeparment(salesDepartment);
		company.addDeparment(marketingDepartment);
		company.addDeparment(executiveDepartment);

		executiveDepartment.addPosition(ceoPosition);
		salesDepartment.addPosition(salesDeptHeadPosition);
		salesDepartment.addPosition(seniorSalesManPosition1);
		salesDepartment.addPosition(seniorSalesManPosition2);
		salesDepartment.addPosition(salesManPosition1);
		salesDepartment.addPosition(salesManPosition2);
		salesDepartment.addPosition(salesManPosition3);
		salesDepartment.addPosition(salesManPosition4);
		salesDepartment.addPosition(salesManPosition5);
		salesDepartment.addPosition(salesManPosition6);

		marketingDepartment.addPosition(marketingDeptHeadPosition);
		marketingDepartment.addPosition(seniorMarketerPosition);

		ceoPosition.fillPosition(ceoPerson);
		salesDeptHeadPosition.fillPosition(deptHeadSalesPerson);
		seniorSalesManPosition1.fillPosition(seniorSalesPerson1);
		seniorSalesManPosition2.fillPosition(seniorSalesPerson2);
		salesManPosition1.fillPosition(salesPerson1);
		salesManPosition2.fillPosition(salesPerson2);
		salesManPosition3.fillPosition(salesPerson3);
		salesManPosition4.fillPosition(salesPerson4);
		salesManPosition5.fillPosition(salesPerson5);

		marketingDeptHeadPosition.fillPosition(deptHeadMarketingPerson);
		seniorMarketerPosition.fillPosition(seniorMarketingPerson);

		ceoPosition.addInferirorPositions(salesDeptHeadPosition);
		ceoPosition.addInferirorPositions(marketingDeptHeadPosition);
		salesDeptHeadPosition.addInferirorPositions(seniorSalesManPosition1);
		salesDeptHeadPosition.addInferirorPositions(seniorSalesManPosition2);
		seniorSalesManPosition1.addInferirorPositions(salesManPosition1);
		seniorSalesManPosition1.addInferirorPositions(salesManPosition2);
		seniorSalesManPosition1.addInferirorPositions(salesManPosition3);

		seniorSalesManPosition2.addInferirorPositions(salesManPosition4);
		seniorSalesManPosition2.addInferirorPositions(salesManPosition5);

		marketingDeptHeadPosition.addInferirorPositions(seniorMarketerPosition);
		
//		System.out.println("Level-3.1 - print()");
//		company.print();
//		System.out.println();
		System.out.println("Level-3.2 - getSalary()");
		System.out.println("Total Salary is: "+ company.getSlary());
//		System.out.println();
//		System.out.println("Level-3.3 - printReportingHierarchy() ");
//		company.printReportingHierarchy();

		// check EqualsMethod
		// check EqualsMethod
		
		
	}

}
