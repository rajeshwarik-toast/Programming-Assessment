import java.util.*;
public class AttendanceMaster {
    LinkedHashMap<Employee, Integer> dictionary = new LinkedHashMap<>();
    public void getAttendance(ArrayList<Employee> employees){
        Scanner sc = new Scanner(System.in);
        String noOfdays;
        for(Employee employee: employees ){
            System.out.println(">>>  ENTER THE NO OF DAYS OF " + employee.getEmpId() );
            noOfdays=sc.nextLine();
            while(!(noOfdays.matches("[0-9]+"))){
                System.out.println("Enter valid number of days");
                noOfdays = sc.nextLine();
            }
            int value = Integer.parseInt(noOfdays);
            dictionary.put(employee, value);
        }
    }
    public void showEligibleList() {
        Set<Map.Entry<Employee, Integer>> entrySet = dictionary.entrySet();
        for (Map.Entry<Employee, Integer> entry1 : entrySet) {
            if(entry1.getValue()>10){
                System.out.println("###----------   ELIGIBLE LIST   ----------###");
                System.out.print(entry1.getKey().toString());
                entry1.getKey().setAllowance();
                System.out.println("    Attendance = " +entry1.getValue());
                System.out.println("--------------------------------------------------");
            }
        }
    }
}
