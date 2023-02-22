import java.util.ArrayList;
public class MasterData {
    private ArrayList<Employee> masterData = new ArrayList<>();
    MasterData(ArrayList<Employee> employee){
        for(Employee employees : employee){
            masterData.add(employees);
            System.out.print(employees.toString());
            employees.setAllowance();
        }
    }
}
