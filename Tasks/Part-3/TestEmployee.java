import java.util.ArrayList;
import java.util.Scanner;
public class TestEmployee {
    static ArrayList<Employee> employee = new ArrayList<>();
    static AttendanceMaster attendanceMaster = new AttendanceMaster();
    static MasterData masterData = new MasterData(employee);
    static SalCalculator salCalculator = new SalCalculator();
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        boolean flag=true;
        System.out.printf("----------------------------------------------------------------------------------------------------------%n");
        System.out.printf("                                        PAYROLL MANAGEMENT                                                %n");
        System.out.printf("----------------------------------------------------------------------------------------------------------%n");
        while(flag) {
            System.out.println("\nEMPLOYEE DETAILS\n    >>> 1. ADD EMPLOYEE\n    >>> 2. ADD ATTENDANCE\n    >>> " +
                    "3. UPDATE ATTENDANCE \n    >>> 4. SORT \n    >>> 5. FILTER EMPLOYEE LIST \n    >>> 6. CALCULATE SALARY \n    >>> 7. DISPLAY DETAILS \n    >>> 8. EXIT \n  ENTER THE OPTION  :");
            String choice = sc.nextLine();
            String name, departmentOption, designationOption, salary;
            while (!(choice.matches("[1-8]"))) {
                System.out.println(" ***   ENTER VALID OPTION   ***");
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
                    System.out.println("    1. Manager \n    2. Director \n    3. Software Developer \n    4. Quality Analyser");
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
                    if(!(attendanceMaster.employeeMap.isEmpty())){
                        attendanceMaster.updateAttendance();
                        break;
                    }
                    else {
                        System.out.println("THE EMPLOYEE LIST MAYBE EMPTY OR ATTENDANCE IS NOT ADDED \n " +
                                " KINDLY PRESS OPTION 1 ADD EMPLOYEE DETAILS OR PRESS OPTION 2 TO ADD ATTENDANCE");
                        break;
                    }
                }
                case "4":{
                    if(!(employee.isEmpty())){
                        System.out.println("##--------------------- SORTING ---------------------## \n    1. ID Sorting\n    2. Name Sorting\n    3. Department Sorting\n    4. Designation Sorting\n    5. Salary Sorting\n" +
                                " ENTER THE OPTION ");
                        String option = sc.nextLine();
                        System.out.println();
                        while (!(option.matches("[1-5]"))) {
                            System.out.println(" >>> ENTER VALID OPTION\n");
                            option = sc.nextLine();
                        }
                        //masterData.quick_sort(employee, 0, employee.size() - 1, option);
                        System.out.println(" TO SORT IN \n >>>> 1. ASCENDING ORDER\n >>>> 2. DESCENDING ORDER ");
                        String sortoption = sc.nextLine();
                        while (!(sortoption.matches("[1-2]"))) {
                            System.out.println(" >>> ENTER VALID OPTION\n");
                            sortoption = sc.nextLine();
                        }
                        //masterData.employeeSort(option,sortoption);

                        switch (option){
                            case "1": {
                                if (sortoption.compareTo("1")==0) {
                                    employee.sort((Employee e1, Employee e2)->e1.getEmpId()-e2.getEmpId());
                                }
                                if(sortoption.compareTo("2")==0){
                                    employee.sort((Employee e1, Employee e2)->e2.getEmpId()-e1.getEmpId());
                                }
                                break;
                            }
                            case "2": {
                                if (sortoption.compareTo("1")==0) {
                                    employee.sort((Employee e1, Employee e2)->e1.getEmpName().compareTo(e2.getEmpName()));
                                }
                                if(sortoption.compareTo("2")==0){
                                    employee.sort((Employee e1, Employee e2)->e2.getEmpName().compareTo(e1.getEmpName()));
                                }
                                break;
                            }
                            case "3": {
                                if (sortoption.compareTo("1")==0) {
                                    employee.sort((Employee e1, Employee e2)->e1.getDept().compareTo(e2.getDept()));
                                }
                                if(sortoption.compareTo("2")==0){
                                    employee.sort((Employee e1, Employee e2)->e2.getDept().compareTo(e1.getDept()));
                                }
                                break;
                            }
                            case "4": {
                                if (sortoption.compareTo("1")==0) {
                                    employee.sort((Employee e1, Employee e2)->e1.getDesg().compareTo(e2.getDesg()));
                                }
                                if(sortoption.compareTo("2")==0){
                                    employee.sort((Employee e1, Employee e2)->e2.getDesg().compareTo(e1.getDesg()));
                                }
                                break;
                            }
                            case "5": {
                                if (sortoption.compareTo("1")==0) {
                                    employee.sort((Employee e1, Employee e2)->e1.getSal().compareTo(e2.getSal()));
                                }
                                if(sortoption.compareTo("2")==0){
                                    employee.sort((Employee e1, Employee e2)->e2.getSal().compareTo(e1.getSal()));
                                }
                                break;
                            }
                        }
                        System.out.printf("| %-10s | %-8s | %-30s | %-20s | %-10s |%n", "ID", "NAME", "DEPARTMENT", "DESIGNATION", "SALARY");
                        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                        for (Employee employee1 : employee) {
                            System.out.println(employee1.toString());
                        }break;
                    }
                    else {
                        System.out.println("THE EMPLOYEE LIST IS EMPTY!!\n KINDLY PRESS OPTION 1 ADD EMPLOYEE DETAILS");
                        break;
                    }
                }
                case "5": {
                    if(!(attendanceMaster.employeeMap.isEmpty())){
                        attendanceMaster.filterEmployeeList();
                        break;
                    }
                    else {
                        System.out.println("EITHER EMPLOYEE LIST IS EMPTY OR ATTENDANCE HAS NOT BEEN ADDED");
                        break;
                    }
                }
                case "6":{
                    if(!(attendanceMaster.employeeMap.isEmpty())){
                        salCalculator.calculateSalary(attendanceMaster.employeeMap);
                        break;
                    }
                    else {
                        System.out.println("FILTER THE EMPLOYEE LIST AND ENTER THE OPTION");
                        break;
                    }
                }
                case "7":{
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                    System.out.printf("| %-10s | %-8s | %-30s | %-20s | %-10s |%n", "ID", "NAME", "DEPARTMENT","DESIGNATION","SALARY");
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                    MasterData masterData = new MasterData(employee);
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                    break;
                }
                case "8" : {
                    flag=false;
                }
            }
        }
    }
}
