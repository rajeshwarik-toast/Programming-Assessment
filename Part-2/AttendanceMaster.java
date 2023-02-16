import java.util.*;

public class AttendanceMaster {
    Dictionary<Employee, Integer> dictionary = new Hashtable();
    public void getAttendance(){
        System.out.println("Enter the no of days present");
        Scanner sc = new Scanner(System.in);
        int noOfdays=0;
        for(Employee employee: TestEmployee.employee ){
            noOfdays=sc.nextInt();
            dictionary.put(employee,noOfdays);
        }
    }
    public void showEligibleList(){
    }
}
