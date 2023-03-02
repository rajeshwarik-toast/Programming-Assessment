import java.util.*;
public class AttendanceMaster {
    LinkedHashMap<Employee, Integer> employeeMap = new LinkedHashMap<>();
    Scanner sc = new Scanner(System.in);
    public void getAttendance(ArrayList<Employee> employees) {
        String noOfdays;
        for (Employee employee : employees) {
            if(!(employeeMap.containsKey(employee))){
                System.out.println(">>>  ENTER THE NO OF DAYS OF " + employee.getEmpId());
                noOfdays = sc.nextLine();
                while (!(noOfdays.matches("[0-9]+"))) {
                    System.out.println("*** ENTER THE VALID NO OF DAYS ***");
                    noOfdays = sc.nextLine();
                }
                int attendance = Integer.parseInt(noOfdays);
                employeeMap.put(employee, attendance);
            }
        }
    }
    public void showEligibleList() {
        Set<Map.Entry<Employee, Integer>> entrySet = employeeMap.entrySet();
        System.out.println("\n------------------------------------------>>> ELIGIBLE LIST <<<------------------------------------------");
        System.out.printf("| %-8s | %-15s | %-30s | %-20s | %-10s | %-10s |%n", "ID", "NAME", "DEPARTMENT","DESIGNATION","SALARY","ATTENDANCE");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        for (Map.Entry<Employee, Integer> entry1 : entrySet) {
            if (entry1.getValue() > 10) {
                System.out.print(entry1.getKey().toString());
                System.out.printf(" %-10s |",entry1.getValue());
                System.out.println();
            }
        }
    }
    public void updateAttendance() {
        String employee_id, attendance;
        Employee employee = new Employee();
        System.out.println(">>>  ENTER THE ID OF THE EMPLOYEE TO UPDATE ATTENDANCE");
        employee_id = sc.nextLine();
        ArrayList<Integer> availableIdList = new ArrayList<>();
        for (Map.Entry entry : employeeMap.entrySet()) {
            Employee e = (Employee) entry.getKey();
            availableIdList.add(e.getEmpId());
        }
        while (!((employee_id.matches("[0-9]+")) && availableIdList.contains(Integer.parseInt(employee_id)))) {
            System.out.println("*** EITHER ID IS NOT IN THE ATTENDANCE LIST OR NOT IN CORRECT FORMAT ***\n");
            employee_id = sc.nextLine();
        }
        for (Employee employees : TestEmployee.employee) {
            if (employees.getEmpId() == Integer.valueOf(employee_id)) {
                employee = employees;
            }
        }
        System.out.println(">>>  ENTER THE ATTENDANCE TO BE UPDATED");
        attendance = sc.nextLine();
        while (!(attendance.matches("[0-9]+"))) {
            System.out.println("*** ENTER VALID ATTENDANCE ***\n");
            attendance = sc.nextLine();
        }
        int updateAttendance = Integer.parseInt(attendance);
        employeeMap.replace(employee, updateAttendance);
        System.out.println("\n-------------------------------------------->>> UPDATED LIST <<<------------------------------------------");
        System.out.printf("| %-8s | %-15s | %-30s | %-20s | %-10s | %-10s |%n", "ID", "NAME", "DEPARTMENT","DESIGNATION","SALARY","ATTENDANCE");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        for (Map.Entry entry : employeeMap.entrySet()) {
            System.out.print(entry.getKey());
            System.out.printf(" %-10s |",entry.getValue());
            System.out.println();
        }
    }
    public void filterEmployeeList() {
        ArrayList<Employee> employeeArrayList = new ArrayList<>(employeeMap.keySet());
        for(Employee employee : employeeArrayList){
            if(this.employeeMap.get(employee)<10){
                employeeMap.remove(employee);
            }
        }
        if(!(employeeMap.isEmpty())) {
            showEligibleList();
        }
        else{
            System.out.println("***  ELIGIBLE LIST IS EMPTY  ***");
        }
    }
}
