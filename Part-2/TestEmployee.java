import java.util.ArrayList;
import java.util.Scanner;
public class TestEmployee {
    static ArrayList<Employee> employee = new ArrayList<>();
    static AttendanceMaster attendanceMaster = new AttendanceMaster();
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String choiceCount="a";
        String name,departmentOption, designationOption, salary;
        while(choiceCount.matches("[A|a]")){
            System.out.println("---------- ENTER EMPLOYEE DETAILS ----------");
            System.out.println(">>>  EMPLOYEE NAME :  ");
            name = sc.nextLine();
            Employee employee1 = new Employee();
            employee1.setEmpName(name);

            System.out.println(">>>  ENTER EMPLOYEE DEPARTMENT  ");
            System.out.println(" 1. Customer Service \n 2. Marketing & Sales \n 3. Resource & Development \n 4. HR");
            departmentOption = sc.nextLine();
            employee1.setDept(departmentOption);

            System.out.println(">>>  ENTER EMPLOYEE DESIGNATION ");
            System.out.println(" 1. Manager \n 2. Director \n 3. Software Developer \n 4. Quality Analyser");
            designationOption = sc.nextLine();
            employee1.setDesg(designationOption);

            System.out.println(">>>  ENTER EMPLOYEE SALARY ");
            salary = sc.nextLine();
            employee1.setSal(salary);

            employee.add(employee1);
            System.out.println("Like to add employee details ? \n If YES enter 'a' if NO press any key ");
            choiceCount=sc.nextLine();
        }
        System.out.println("-----------------------------------------------------------------------------");
        MasterData masterEmployee = new MasterData(employee);
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Like to add attendance ? \n If YES press '1' if NO press '0'");
        String option = sc.nextLine();
        while(!(option.matches("[0-1]"))) {
            System.out.println("Enter valid option");
            option = sc.nextLine();
        }
        if(option.matches("1")){
                attendanceMaster.getAttendance(employee);
                attendanceMaster.showEligibleList();
        }
    }
}
