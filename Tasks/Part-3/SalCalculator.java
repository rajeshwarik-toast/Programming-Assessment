import java.util.LinkedHashMap;
import java.util.Set;
public class SalCalculator {
    public void calculateSalary(LinkedHashMap<Employee,Integer> employeeHashMap){
        double pf,gross,net;
        Set<Employee> entrySet = employeeHashMap.keySet();
        for (Employee employee : entrySet) {
            pf = (10 * employee.getSal())/100;
            gross = employee.getSal()+employee.setAllowance();
            net = gross - pf;
            System.out.println(employee.toString());
            System.out.println("    ALLOWANCE " + String.format("%.2f", employee.setAllowance()));
            System.out.println("    PF        " + pf);
            System.out.println("    NET       " + net);
        }
    }
}
