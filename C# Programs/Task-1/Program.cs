using System;
using System.Collections;
using System.Text.RegularExpressions;
namespace Sample{
    public class Employee  
    {  
        private int empID;
        private String Name="";
        private String Department="";
        private String Designation="";
        private double Salary;
        private static int Counter = 1000;
        public Employee() {
            empID=++Counter;
        }
        
        public string EmpName{
            get{
                return Name;
            }
            set{
            while(!(Regex.IsMatch(value, @"^[a-zA-Z ]+$"))){
                Console.WriteLine("Re-enter the employee name");
                value=Console.ReadLine();
                }
            this.Name=value.Substring(0,1).ToUpper()+value.Substring(1); 
            }
        }

        public int EmpId{
            get{
                return empID;
            }
            set{
                empID = ++Counter;
                this.empID = value;  
            }
        }

        public string Dept{
            get{
                return Department;
            }
            set{
                string[] department={"Customer Service","Marketing & Sales","Resource & Development","HR"};
                while(!(Regex.IsMatch(value, @"^[1-4]$"))){
                    Console.WriteLine("Enter valid option");
                    value = Console.ReadLine();
                }
                int depNumber = Int32.Parse(value);
                this.Department=department[depNumber-1];
            }
        }

        public string Desgn{
            get {
                return Designation;
            }
            set{
                string[] designation = {"Manager","Director", "Software Developer", "Quality Analyser"};
                while(!(Regex.IsMatch(value, @"^[1-4]$"))){
                Console.WriteLine("Enter valid option ");
                value = Console.ReadLine();
            }
            int desgNumber=Int32.Parse(value);
            this.Designation=designation[desgNumber-1]; 
            }
        }
        
        public double Sal{
            get{
                return Salary ;
            }
            set{
                if(value<5000.0){
                    Console.WriteLine("Enter salary above 50000.0 ");
                    value = Console.Read();
                }
                this.Salary=value;
            }
        }

        public Employee(String EmpName, String Dept, String  Desgn, Double Sal){
            empID = ++Counter;
            this.Name=EmpName;
            this.Department=Dept;
            this.Designation=Desgn;
            this.Salary=Sal;
        }
        public void SetAllowance(){
            Console.WriteLine("  Salary is " +Salary);
            double allowanceSalary;
            if(Designation.CompareTo("Manager") == 0){
                allowanceSalary=this.Salary+((20.0/100.0)*this.Salary);
            }
            else{
                allowanceSalary=this.Salary+((10.0/100.0)*this.Salary);
            }
            Console.WriteLine("The allowance of the employee is " +String.Format("{0:0.##}", allowanceSalary));
            allowanceSalary-=this.Salary;
            Console.WriteLine("The difference is " + String.Format("{0:0.##}", allowanceSalary));
            
        }

        public override string ToString() {
            return "EMPLOYEE DETAILS \n ID = " + empID + ", Name = " +
                    Name + ", Department = " + Department + ", Designation = " + Designation + "," ;
        } 
    }  
   class TestEmployee{  
       public static void Main(string[] args)  
        {  
            string name="",departmentOption="", designationOption="", salary="";
            string choiceCount="1";
            //var employee = new List<Employee>();
            List<Employee> employee = new List<Employee>();
            while(choiceCount.CompareTo("1")==0){
                Console.WriteLine("ENTER EMPLOYEE DETAILS ");
                Console.WriteLine("EMPLOYEE NAME :  ");
                name = Console.ReadLine();
                Employee employee1 = new Employee();
                employee1.EmpName=name;
                Console.WriteLine("ENTER EMPLOYEE DEPARTMENT  ");
                Console.WriteLine(" 1. Customer Service \n 2. Marketing & Sales \n 3. Resource & Development \n 4. HR");
                departmentOption = Console.ReadLine();
                employee1.Dept=departmentOption;

                Console.WriteLine("ENTER EMPLOYEE DESIGNATION ");
                Console.WriteLine(" 1. Manager \n 2. Director \n 3. Software Developer \n 4. Quality Analyser");
                designationOption = Console.ReadLine();
                employee1.Desgn=designationOption;

                Console.WriteLine("ENTER EMPLOYEE SALARY ");
                salary = Console.ReadLine();
                while (!(Regex.IsMatch(salary, @"[0-9]([.,][0-9]{1,3})?$"))){
                    Console.WriteLine("Enter valid salary");
                    salary = Console.ReadLine();
                }
                double salaryvalue;
                salaryvalue=Convert.ToDouble(salary);
                employee1.Sal=salaryvalue;
                //Console.ReadLine();

                employee.Add(employee1);
                Console.WriteLine("Like to add employee details? If yes enter 1 else enter 0");
                choiceCount=Console.ReadLine();
                //choiceCount =Convert.ToInt32(choice);
                //Console.ReadLine();
            }
            //Console.WriteLine();
            for(int i=0; i<employee.Count; i++) {
                Console.Write(employee[i].ToString());
                employee[i].SetAllowance();
            }
        }
    }
}
    
