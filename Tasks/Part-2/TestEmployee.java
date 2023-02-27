import java.util.ArrayList;
import java.util.Scanner;

public class TestEmployee {
    static ArrayList<Employee> employee = new ArrayList<>();
    static AttendanceMaster attendanceMaster = new AttendanceMaster();
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        boolean flag=true;
        while(flag) {
            System.out.println("ENTER THE OPTION\n >>> 1. ADD EMPLOYEE\n >>> 2. ADD ATTENDANCE\n >>> 3. UPDATE ATTENDANCE \n >>> 4. DISPLAY DETAILS \n >>> 5. EXIT \n");
            String choice = sc.nextLine();
            String name, departmentOption, designationOption, salary;
            while (!(choice.matches("[1-5]"))) {
                System.out.println(" ***   ENTER VALID OPTION   ***");
                choice = sc.nextLine();
            }
            switch (choice) {
                case "1": {
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
                    break;
                }
                case "2": {
                    if(employee.isEmpty()){
                        System.out.println("THE EMPLOYEE LIST IS EMPTY. \n >>> TO ADD THE EMPLOYEE DETAILS ENTER OPTION 1\n");
                        break;
                    }
                    else {
                        attendanceMaster.getAttendance(employee);
                        attendanceMaster.showEligibleList();
                        break;
                    }
                }
                case "3": {
                    if(!(attendanceMaster.dictionary.isEmpty())){
                        attendanceMaster.updateAttendance();
                        break;
                    }
                    else {
                        System.out.println("THE EMPLOYEE LIST MAYBE EMPTY OR ATTENDANCE IS NOT ADDED \n " +
                                " KINDLY PRESS OPTION 1 ADD EMPLOYEE DETAIILS" +
                                " OR PRESS OPTION 2 TO ADD ATTENDANCE");
                        break;
                    }
                }
                case "4":{
                    System.out.println("-----------------------------------------------------------------------------");
                    MasterData masterData = new MasterData(employee);
                    System.out.println("-----------------------------------------------------------------------------");
                    break;
                }
                case "5" : {
                    flag=false;
                }
            }
        }
    }
}
