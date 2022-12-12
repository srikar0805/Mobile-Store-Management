package Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.xml.sax.SAXParseException;

import Operations.Operations;

public class Employee extends Operations {
    private int empId;
    private double salary;
    private int age;
    private String name;
    private String gender;
    private String DOJ;
    private String designation;
    private String phoneNumber;
    private String emailId;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDOJ() {
        return DOJ;
    }

    public void setDOJ(String dOJ) {
        DOJ = dOJ;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((DOJ == null) ? 0 : DOJ.hashCode());
        result = prime * result + age;
        result = prime * result + ((designation == null) ? 0 : designation.hashCode());
        result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
        result = prime * result + empId;
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
        long temp;
        temp = Double.doubleToLongBits(salary);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (DOJ == null) {
            if (other.DOJ != null)
                return false;
        } else if (!DOJ.equals(other.DOJ))
            return false;
        if (age != other.age)
            return false;
        if (designation == null) {
            if (other.designation != null)
                return false;
        } else if (!designation.equals(other.designation))
            return false;
        if (emailId == null) {
            if (other.emailId != null)
                return false;
        } else if (!emailId.equals(other.emailId))
            return false;
        if (empId != other.empId)
            return false;
        if (gender == null) {
            if (other.gender != null)
                return false;
        } else if (!gender.equals(other.gender))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (phoneNumber == null) {
            if (other.phoneNumber != null)
                return false;
        } else if (!phoneNumber.equals(other.phoneNumber))
            return false;
        if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
            return false;
        return true;
    }

    public Employee(int empId, double salary, int age, String name, String gender, String dOJ, String designation,
            String phoneNumber, String emailId) {
        this.empId = empId;
        this.salary = salary;
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.DOJ = dOJ;
        this.designation = designation;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
    }

    public Employee() {
    }

    public Employee(String empline) {
        String values[] = empline.split(",");
        this.empId = Integer.parseInt(values[0]);
        this.salary = Double.parseDouble(values[1]);
        this.age = Integer.parseInt(values[2]);
        this.name = values[3];
        this.gender = values[4];
        this.DOJ = values[5];
        this.designation = values[6];
        this.phoneNumber = values[7];
        this.emailId = values[8];
    }

    @Override
    public String toString() {
        return "\nEmployeeId\t\t:\t" + empId 
                + "\nEmployee Name\t\t:\t" + name 
                + "\nAge\t\t\t:\t" + age
                + "\nDesignation\t\t:\t" + designation
                + "\nEmailId\t\t\t:\t" + emailId
                + "\nPhonenumber\t\t:\t" + phoneNumber
                + "\nGender\t\t\t:\t" + gender
                + "\nSalary\t\t\t:\t" + salary
                + "\nDate Of Joining\t\t:\t" + DOJ + "\n";
    }

    @Override
    public void createTable(){
        try {
            EmployeeDAO.createEmployeeTable();
        } catch (SAXParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addData(String file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String empLine;
            while ((empLine = reader.readLine()) != null) {
                try {
                    EmployeeDAO.createEmployee(new Employee(empLine));
                } catch (SAXParseException e) {
                    e.printStackTrace();
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String employeeID, String update, String updated) {
        Employee employee = EmployeeDAO.getEmployee("empId",employeeID).get(0);
        try {
            EmployeeDAO.updateEmployee(employee, update, updated);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateInBulk(String file){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String empLine;
            while ((empLine = reader.readLine()) != null) {
                String values[]=empLine.split(",");
                this.update(values[0],values[1],values[2]);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String employeeID) {

        int empId = Integer.parseInt(employeeID);
        try {
            EmployeeDAO.deleteEmployee(empId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printAll() {
        List<Employee> allEmployees = EmployeeDAO.getAllEmployee();
        allEmployees.forEach(System.out::println);
        System.out.println();

    }

    @Override
    public void printByAttribute(String attribute, String value) {
        Employee employee = EmployeeDAO.getEmployee(attribute, value).get(0);
        System.out.println(employee);
    }

    @Override
    public void search(String attribute, String value){
        List<Employee> employees = EmployeeDAO.getEmployee(attribute, value);
        employees.forEach(System.out::println);
    }
}
