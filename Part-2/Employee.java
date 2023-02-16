import java.util.Scanner;
public class Employee {
        private int empID;
        private String Name;
        private String Department;
        private String Designation;
        private Double Salary;
        private static int counter = 1000;
        public Employee() {
            empID=++counter;
        }

        Scanner sc=new Scanner(System.in);
        public void setEmpID(int empID){
            empID = ++counter;
            this.empID = empID;
        }
        public int getEmpId(){
            return empID;
        }
        public void setEmpName(String Name){
            while(!(Name.matches("[A-Za-z ]{3,20}+") )){
                System.out.println("Re-enter the employee name");
                Name=sc.nextLine();
            }
            this.Name=Name.substring(0,1).toUpperCase()+Name.substring(1);
        }
        public String getEmpName(){
            return Name;
        }
        public void setDept(String departmentOption){
            String Department[]={"Customer Service","Marketing & Sales","Resource & Development","HR"};
            while(!(departmentOption.matches("[1-4]"))){
                System.out.println("Enter valid option");
                departmentOption = sc.nextLine();
            }
            int depNumber = Integer.parseInt(departmentOption);
            this.Department=Department[depNumber-1];
        }
        public String getDept(){
            return Department;
        }
        public void setDesg(String designationOption){
            String Designation[] = {"Manager","Director", "Software Developer", "Quality Analyser"};
            while(!(designationOption.matches("[1-4]"))){
                System.out.println("Enter valid option ");
                designationOption = sc.nextLine();
            }
            int desgNumber=Integer.parseInt(designationOption);
            this.Designation=Designation[desgNumber-1];
        }
        public String getDesg(){
            return Designation;
        }
        public void setSal(String Salary){
            while (!((Salary.matches("([0-9]*)\\.([0-9]+)")) )){
                    System.out.println("Enter valid salary");
                    Salary = sc.nextLine();
            }
            if(Double.parseDouble(Salary)<5000.0){
                System.out.println("Enter salary above 50000.0 ");
                Salary = sc.nextLine();
            }
            this.Salary=Double.parseDouble(Salary);
        }
        public Double getSal(){ return Salary;}
        public Employee(String EmpName, String Dept, String  Desgn, Double Sal){
            empID = ++counter;
            this.Name=EmpName;
            this.Department=Dept;
            this.Designation=Desgn;
            this.Salary=Sal;
        }
        public void setAllowance(){
            System.out.println("  Salary is " +Salary);
            double AllowanceSalary;
            if(Designation.compareTo("Manager") == 0){
                AllowanceSalary=this.Salary+((20.0/100.0)*this.Salary);
            }
            else{
                AllowanceSalary=this.Salary+((10.0/100.0)*this.Salary);
            }
            System.out.println("The allowance of the employee is " +String.format("%.2f", AllowanceSalary));
            AllowanceSalary-=this.Salary;
            System.out.println("The difference is " + String.format("%.2f", AllowanceSalary));
        }
        public String toString() {
            return "EMPLOYEE DETAILS \n ID = " + empID + ", Name = " +
                    Name + ", Department = " + Department + ", Designation = " + Designation + "," ;
        }
}
