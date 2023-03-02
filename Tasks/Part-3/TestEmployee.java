import java.util.ArrayList;
import java.util.Scanner;
public class TestEmployee {
    static ArrayList<Employee> employee = new ArrayList<>();
    static AttendanceMaster attendanceMaster = new AttendanceMaster();
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        boolean flag=true;
        boolean optionflag=false;
        System.out.printf("-----------------------------------------------------------------------------------------------------------%n");
        System.out.printf("                                     PAYROLL MANAGEMENT SYSTEM                                             %n");
        System.out.printf("-----------------------------------------------------------------------------------------------------------");
        while(flag) {
            System.out.println("\n-> CHOOSE AN OPTION\n    >>> 1. ADD EMPLOYEE\n    >>> 2. ADD ATTENDANCE\n    >>> " +
                    "3. UPDATE ATTENDANCE \n    >>> 4. SORT \n    >>> 5. FILTER EMPLOYEE LIST \n    >>> 6. CALCULATE SALARY \n    >>> 7. DISPLAY DETAILS \n    >>> 8. EXIT \n  ENTER THE OPTION  :");
            String choice = sc.nextLine();
            String name, departmentOption, designationOption, salary;
            while (!(choice.matches("[1-8]"))) {
                System.out.println(" ***   ENTER CHOICES FROM 1 TO 8   ***");
                System.out.println("\n-> CHOOSE THE OPTION\n    >>> 1. ADD EMPLOYEE\n    >>> 2. ADD ATTENDANCE\n    >>> " +
                        "3. UPDATE ATTENDANCE \n    >>> 4. SORT \n    >>> 5. FILTER EMPLOYEE LIST \n    >>> 6. CALCULATE SALARY \n    >>> 7. DISPLAY DETAILS \n    >>> 8. EXIT \n  ENTER THE OPTION  :");
                choice = sc.nextLine();
            }
            switch (choice) {
                case "1": {
                    System.out.println("\n-------------------- ENTER EMPLOYEE DETAILS --------------------");
                    System.out.println(">>>  EMPLOYEE NAME :  ");
                    name = sc.nextLine();
                    Employee employee1 = new Employee();
                    employee1.setEmpName(name);
                    System.out.println(">>>  ENTER EMPLOYEE DEPARTMENT  ");
                    System.out.println("    1. Customer Service \n    2. Marketing & Sales \n    3. Resource & Development \n    4. IT");
                    departmentOption = sc.nextLine();
                    employee1.setDept(departmentOption);
                    System.out.println(">>>  ENTER EMPLOYEE DESIGNATION ");
                    System.out.println("    1. Manager \n    2. Director \n    3. Software Developer \n    4. Accountant");
                    designationOption = sc.nextLine();
                    employee1.setDesg(designationOption);
                    System.out.println(">>>  ENTER EMPLOYEE SALARY ");
                    salary = sc.nextLine();
                    employee1.setSal(salary);
                    employee1.setAllowance();
                    employee.add(employee1);
                    break;
                }
                case "2": {
                    if(employee.isEmpty()){
                        System.out.println("***  THE EMPLOYEE LIST IS EMPTY !!! TO ADD THE EMPLOYEE DETAILS ENTER OPTION 1  ***");
                        break;
                    }
                    else {
                        attendanceMaster.getAttendance(employee);
                        attendanceMaster.showEligibleList();
                        break;
                    }
                }
                case "3": {
                    AttendanceMaster attendanceMaster = new AttendanceMaster();
                    if(!(attendanceMaster.employeeMap.isEmpty())){
                        attendanceMaster.updateAttendance();
                        optionflag=false;
                        break;
                    }
                    else if(employee.isEmpty()){
                        System.out.println("***  THE EMPLOYEE LIST IS EMPTY !!! KINDLY PRESS OPTION 1 ADD EMPLOYEE DETAILS  ***");
                        break;
                    }
                    else if(attendanceMaster.employeeMap.isEmpty()){
                        System.out.println("***  ATTENDANCE HAS NOT BEEN ADDED !!! KINDLY PRESS OPTION 2 TO ADD ATTENDANCE  ***");
                        break;
                    }
                }
                case "4":{
                    if(!(employee.isEmpty())){
                        System.out.println("##--------------------- SORTING ---------------------## \n    1. SORT BY ID\n    2. SORT BY NAME\n    3. SORT BY DEPARTMENT\n    4. SORT BY DESIGNATION\n    5. SORT BY SALARY\n" +
                                " ENTER THE OPTION ");
                        String option = sc.nextLine();
                        while (!(option.matches("[1-5]"))) {
                            System.out.println("***  ENTER VALID OPTION  ***\n   1. SORT BY ID\n    2. SORT BY NAME\n    3. SORT BY DEPARTMENT\n    4. SORT BY DESIGNATION\n    5. SORT BY SALARY\n   ENTER THE OPTION ");
                            option = sc.nextLine();
                        }
                        System.out.println(" TO SORT IN \n >>>> 1. ASCENDING ORDER\n >>>> 2. DESCENDING ORDER \n ENTER THE OPTION");
                        String sortoption = sc.nextLine();
                        while (!(sortoption.matches("[1-2]"))) {
                            System.out.println("***  ENTER VALID OPTION  ***\n >>>> 1. ASCENDING ORDER\n >>>> 2. DESCENDING ORDER \n ENTER THE OPTION");
                            sortoption = sc.nextLine();
                        }
                        MasterData employeedata = new MasterData(employee);
                        employeedata.employeeSort(option,sortoption);
                        break;
                    }
                    else {
                        System.out.println("***  THE EMPLOYEE LIST IS EMPTY!!  KINDLY PRESS OPTION 1 ADD EMPLOYEE DETAILS  ***");
                        break;
                    }
                }
                case "5": {
                    if(!(attendanceMaster.employeeMap.isEmpty())){
                        attendanceMaster.filterEmployeeList();
                        optionflag=true;
                        break;
                    }
                    else if(employee.isEmpty()){
                        System.out.println("***  THE EMPLOYEE LIST IS EMPTY !!! KINDLY PRESS OPTION 1 ADD EMPLOYEE DETAILS  ***");
                        break;
                    }
                    else if(attendanceMaster.employeeMap.isEmpty()){
                        System.out.println("***  ATTENDANCE HAS NOT BEEN ADDED !!! KINDLY PRESS OPTION 2 TO ADD ATTENDANCE  ***");
                        break;
                    }
                }
                case "6":{
                    SalCalculator salCalculator = new SalCalculator();
                    if(!(attendanceMaster.employeeMap.isEmpty())){
                        if(optionflag==true) {
                            salCalculator.calculateSalary(attendanceMaster.employeeMap);
                            break;
                        }
                        else{
                            System.out.println("***  THE EMPLOYEE LIST IS NOT FILTERED!! KINDLY CHOOSE OPTION 5 TO FILTER THE EMPLOYEE LIST !!!");
                            break;
                        }
                    }
                    else if(employee.isEmpty()){
                        System.out.println("***  THE EMPLOYEE LIST IS EMPTY !!! KINDLY PRESS OPTION 1 ADD EMPLOYEE DETAILS  ***");
                        break;
                    }
                    else if(attendanceMaster.employeeMap.isEmpty()){
                        System.out.println("***  NO EMPLOYEE FOUND TO CALCULATE SALARY !!!  ***");
                        break;
                    }
                }
                case "7":{
                    if(!(employee.isEmpty())){
                        MasterData masterData = new MasterData(employee);
                        masterData.displayDetails();
                        break;
                    }
                    else{
                        System.out.println("***  THE EMPLOYEE LIST IS EMPTY !!! KINDLY PRESS OPTION 1 ADD EMPLOYEE DETAILS  ***");
                        break;
                    }
                }
                case "8" : {
                    flag=false;
                }
            }
        }
    }
}
