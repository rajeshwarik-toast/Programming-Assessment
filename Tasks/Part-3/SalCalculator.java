import java.util.LinkedHashMap;
import java.util.Set;
public class SalCalculator {
    public void calculateSalary(LinkedHashMap<Employee,Integer> employeeHashMap){
        double pf,gross,net;
        Set<Employee> entrySet = employeeHashMap.keySet();
        for (Employee employee : entrySet) {
            pf = (10 * employee.getSal())/100;
            gross = employee.getSal()+employee.initialSalary();
            net = gross - pf;
            System.out.printf("| %-10s | %-8s | %-20s | %-20s | %-10s |%n", "ID", "NAME", "DEPARTMENT","DESIGNATION","SALARY");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------");
            for(int i=0;i<employeeHashMap.size();i++) {
                System.out.println(employee.toString());
            }
            System.out.println("    ALLOWANCE " + String.format("%.2f", employee.initialSalary()));
            System.out.println("    GROSS     " + String.format("%.2f",gross));
            System.out.println("    PF        " + String.format("%.2f",pf));
            System.out.println("    NET       " + String.format("%.2f",net));
        }
    }
}
