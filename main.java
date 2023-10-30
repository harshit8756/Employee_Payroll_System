import java.util.ArrayList;

abstract class Employee
{
      private String name;
      private int id;

      // make constructor of this class
     public Employee(String name , int id)
     {
         this.name=name;
         this.id=id;
     }
     public String getName()  // user access or to check the variable , bina uske variable ko directly access kiye by encapsulation
     {
         return name;
     }
     public int getId()
     {
         return id;
     }

     public abstract double calculateSalary(); // abstract keyword

    @Override
    public String toString()
    {
       return "Employee[name="+ name+" , id="+id+" , salary="+calculateSalary()+"]";
    }
}

// second class
class fullTimeEmployee extends Employee
{
    private double monthlySalary;


    public fullTimeEmployee(String name , int id , double monthlySalary)
    {
        super(name , id);
        this.monthlySalary =  monthlySalary;
    }

    @Override
    public double  calculateSalary()
    {
        return monthlySalary;
    }
}

// third class
class partTimeEmployee extends Employee
{
    private int hourlyWorked;
    public  double hourlyRated;
    // make constructor
    public partTimeEmployee(String name , int id , int hourlyWorked , double hourlyRated)
    {
        super(name , id);
        this.hourlyWorked = hourlyWorked;
        this.hourlyRated = hourlyRated;
    }

    @Override
    public double calculateSalary()
    {
        return hourlyWorked * hourlyRated;
    }
}

// fourth class
class payRollSystem
{
    private ArrayList<Employee> employeeList ;
    public payRollSystem()
    {
        employeeList = new ArrayList<>();
    }
    // make a method
    public  void addEmployee(Employee employee)
    {
        employeeList.add(employee);
    }

    public void removeEmployee(int id)
    {
        Employee employeeToRemove = null;
        for(Employee employee : employeeList)
        {
            if(employee.getId() == id)
            {
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove != null)
        {
            employeeList.remove(employeeToRemove);
        }
    }

    // display the employee
    public void displayEmployee()
    {
        for(Employee employee : employeeList)
        {
            System.out.println(employee);
        }
    }
}


public class main {
    public static void main(String[] args) {
        payRollSystem pay = new payRollSystem();
        fullTimeEmployee emp1 = new fullTimeEmployee("Harshit" , 1 , 70000.0);
        partTimeEmployee emp2 = new partTimeEmployee("Ashutosh" , 2 , 40 , 100);
        // add the employee in the list
        pay.addEmployee(emp1);
        pay.addEmployee(emp2);

        System.out.println("Initial Employee Details : ");
        pay.displayEmployee();

        System.out.println("Removing employees");
        pay.removeEmployee(2);

        System.out.println("Remaining Employee Details : ");
        pay.displayEmployee();


    }
}
