import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class Employee 
{
   public String empName;
   public Integer empAge;
   public Integer empSalary;

   public Employee(String empName, Integer empAge, Integer empSalary) {
      this.empName = empName;
      this.empAge = empAge;
      this.empSalary = empSalary;
   }
   
   @Override
   public String toString(){
      return "Employee Name : "+empName+", Employee Age : "+empAge+", Employee Salary : "+empSalary;
   }
}

public class BODemo2
{
	public static void main(String[] args) 
	{
		BinaryOperator<Employee> getMaxSal = BinaryOperator.maxBy((Employee e1, Employee e2) -> e1.empSalary-e2.empSalary);
		Employee emp1 = new Employee("Joe", 23, 20000);
		Employee emp2 = new Employee("Jay", 29, 30000);
		Employee empMaxSal = getMaxSal.apply(emp1, emp2);
		System.out.println("\nEmployee : "+ empMaxSal.empName+", has the higher salary : "+empMaxSal.empSalary);

		System.out.println("-----------------------------------------------------------------------");

		BinaryOperator<Employee> getMinAge = BinaryOperator.minBy((Employee e1, Employee e2) -> e1.empAge-e2.empAge);
		Employee empMinAge = getMinAge.apply(emp1, emp2);
		System.out.println("Employee : "+ empMinAge.empName+", has the minimum age : "+empMinAge.empAge);


		// BiFunction
        BiFunction<Integer, Integer, Integer> func = (x1, x2) -> x1 + x2;
        Integer result = func.apply(2, 3);
        System.out.println(result);
	}
}