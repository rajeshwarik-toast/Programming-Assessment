import java.util.ArrayList;
import java.util.Scanner;
public class TestEmployee {
    static ArrayList<Employee> employee = new ArrayList<>();
    static AttendanceMaster attendanceMaster = new AttendanceMaster();
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String choiceCount="a";
        String Name,departmentOption, designationOption, Salary;
        while(choiceCount.matches("[a]")){
            System.out.println(">>> ENTER EMPLOYEE DETAILS ");
            System.out.println("EMPLOYEE NAME :  ");
            Name = sc.nextLine();
            Employee employee1 = new Employee();
            employee1.setEmpName(Name);

            System.out.println("ENTER EMPLOYEE DEPARTMENT  ");
            System.out.println(" 1. Customer Service \n 2. Marketing & Sales \n 3. Resource & Development \n 4. HR");
            departmentOption = sc.nextLine();
            employee1.setDept(departmentOption);

            System.out.println("ENTER EMPLOYEE DESIGNATION ");
            System.out.println(" 1. Manager \n 2. Director \n 3. Software Developer \n 4. Quality Analyser");
            designationOption = sc.nextLine();
            employee1.setDesg(designationOption);

            System.out.println("ENTER EMPLOYEE SALARY ");
            Salary = sc.nextLine();
            employee1.setSal(Salary);

            employee.add(employee1);
            System.out.println("Like to add employee details? If yes enter a else enter b");
            choiceCount=sc.nextLine();
            sc.nextLine();

        }
        System.out.println();
        System.out.println("Like to add attendance ? if yes press 1 else press 0");
        String option = sc.nextLine();
        while(option.matches("[1]")) {
            if (employee.size() <= 0) {
                break;
            }
            else {
                for (int i = 0; i < employee.size(); i++) {
                    attendanceMaster.getAttendance();
                    attendanceMaster.showEligibleList();
                }
            }
        }
        while(option.matches("[b]")){
            break;
        }
    }
}
