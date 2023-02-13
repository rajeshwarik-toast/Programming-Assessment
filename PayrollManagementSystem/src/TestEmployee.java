import java.util.ArrayList;
import java.util.Scanner;
public class TestEmployee {
    public static int counter = 1000;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int choiceCount=1;
        ArrayList<Employee> employee = new ArrayList<>();
        String Department[]={"IT","Admin","R&D","HR"};
        String Designation[] = {"Manager", "Software Engineer", "Developer", "Query Analyser"};
        String Name,departmentOption, designationOption;
        double Salary;
        while(choiceCount==1){
            System.out.println("ENTER EMPLOYEE DETAILS ");
            System.out.println("EMPLOYEE NAME :  ");
            Name = sc.nextLine();
            while(!(Name.matches("[A-Za-z ]{3,20}+") )){
                System.out.println("Re-enter the employee name");
                Name=sc.nextLine();
            }

            System.out.println("ENTER EMPLOYEE DEPARTMENT  ");
            System.out.println("1. Customer Service \n 2. Marketing & Sales \n 3. Resource & Development \n 4.HR");
            departmentOption = sc.nextLine();
            while(!(departmentOption.matches("[1-4]"))){
                System.out.println("Enter valid option");
                departmentOption = sc.nextLine();
            }

            System.out.println("ENTER EMPLOYEE DESIGNATION ");
            System.out.println("1. Manager \n 2. Director \n 3. Software Developer \n 4. Quality Analyser");
            designationOption = sc.nextLine();
            while(!(designationOption.matches("[1-4]"))){
                System.out.println("Enter valid option ");
                designationOption = sc.nextLine();
            }

            System.out.println("ENTER EMPLOYEE SALARY ");
            Salary = sc.nextDouble();
            String salaryValue=String.valueOf(Salary);
            while (!((salaryValue.matches("([0-9]*)\\.([0-9]*)")) & Salary>5000.0 )){
                System.out.println("Enter salary above 50000.0 ");
                Salary = sc.nextDouble();
            }
            sc.nextLine();

            int depNumber=Integer.parseInt(departmentOption);
            int desgNumber=Integer.parseInt(designationOption);
            employee.add(new Employee(Name, Department[depNumber-1], Designation[desgNumber-1], Salary));
            System.out.println("Like to add employee details? If yes enter 1 else enter 0");
            choiceCount=sc.nextInt();
            sc.nextLine();
        }
        System.out.println();
        for(int i=0; i<employee.size(); i++) {
            System.out.print(employee.get(i).ToString());
            employee.get(i).SetAllowance();
        }
    }
}



