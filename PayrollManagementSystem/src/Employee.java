public class Employee {
        private int empID;
        private String Name;
        private String Department;
        private String Designation;
        private Double Salary;

        public Employee() {}

        public static int getCounter(){
            return TestEmployee.counter;
        }

        public void setEmpID(int empID){
            this.empID = empID;
        }
        public int getEmpId(){
            return empID;
        }

        public void setEmpName(String Name){
            this.Name = Name;
        }
        public String getEmpName(){
            return Name;
        }

        public void setDept(String Department){
            this.Department = Department;
        }
        public String getDept(){
            return Department;
        }

        public void setDesg(String Designation){
            this.Designation = Designation;
        }
        public String getDesg(){
            return Designation;
        }
        public void setSal(Double Salary){
            this.Salary = Salary;
        }
        public Double getSal(){
            return Salary;
        }

        public Employee(String EmpName, String Dept, String  Desgn, Double Sal){
            empID = ++TestEmployee.counter;
            this.Name=EmpName;
            this.Department=Dept;
            this.Designation=Desgn;
            this.Salary=Sal;
        }
        public void SetAllowance(){
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
        public String ToString() {
            return "EMPLOYEE DETAILS \n ID = " + empID + ", Name = " +
                    Name.substring(0,1).toUpperCase()+Name.substring(1) + ", Designation = "
                    + Designation + ", Department = " + Department + "," ;
        }
}
