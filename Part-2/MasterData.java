import java.util.ArrayList;
public class MasterData {
    private ArrayList<Employee> masterData = new ArrayList<>();
    MasterData(ArrayList<Employee> employees){

        for(Employee employee : employees){
            masterData.add(employee);
            System.out.print(employee.toString());
            employee.setAllowance();
        }
    }
}
