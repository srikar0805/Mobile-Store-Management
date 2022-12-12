package Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.SAXParseException;

import ConnectionFactory.ConnectionFactory;


public class EmployeeDAO {

    public static void createEmployeeTable() throws SAXParseException{
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "CREATE TABLE Employee(empId INT UNIQUE,salary DOUBLE,age INT,name VARCHAR(30),gender VARCHAR(10),DOJ VARCHAR(20),designation VARCHAR(20),phonenumber VARCHAR(11),emailId VARCHAR(40))";
        try(PreparedStatement stmt = con.prepareStatement(SQL)){
            System.out.println("Employee Table created.");
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createEmployee(Employee emp) throws SAXParseException{
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "insert into employee values(?,?,?,?,?,?,?,?,?)";
        try(PreparedStatement stmt = con.prepareStatement(SQL)){
            stmt.setInt(1, emp.getEmpId());
            stmt.setDouble(2, emp.getSalary());
            stmt.setInt(3, emp.getAge());
            stmt.setString(4, emp.getName());
            stmt.setString(5, emp.getGender());
            stmt.setString(6, emp.getDOJ());
            stmt.setString(7, emp.getDesignation());
            stmt.setString(8, emp.getPhoneNumber());
            stmt.setString(9, emp.getEmailId());
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected+" Employee row created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateEmployee(Employee stud,String update,String updated ) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "update employee set "+update+" = ? where empid = ?";
        try(PreparedStatement stmt = con.prepareStatement(SQL)){
            stmt.setString(1,update);
            if (update == "salary") {
                stmt.setDouble(1, Double.parseDouble(updated));
            }else if (update == "empId"||update == "age"){
                stmt.setInt(1, Integer.parseInt(updated));
            }else{
                stmt.setString(1, updated);
            }
            stmt.setInt(2, stud.getEmpId());
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected+" Employee row updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteEmployee(int empid ) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "delete from employee where empid = ?";
        try(PreparedStatement stmt = con.prepareStatement(SQL)){
            stmt.setInt(1, empid);
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected+" Employee row deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> getAllEmployee(){
        List<Employee> Employees = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "select * from employee";
        try(PreparedStatement stmt = con.prepareStatement(SQL)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Employee emp = new Employee(rs.getInt("empid"),rs.getDouble("salary"),rs.getInt("age"),rs.getString("name"),rs.getString("gender"),rs.getString("doj"),rs.getString("designation"),rs.getString("phonenumber"),rs.getString("emailid"));
                Employees.add(emp);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return Employees;
    }

    public static List<Employee> getEmployee(String attribute, String value){
        List<Employee> employees = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "select * from employee where "+attribute+" = ?";
        try(PreparedStatement stmt = con.prepareStatement(SQL)){
            if (attribute == "salary") {
                stmt.setDouble(1, Double.parseDouble(value));
            }else if (attribute == "empId"||attribute == "age"){
                stmt.setInt(1, Integer.parseInt(value));
            }else{
                stmt.setString(1, value);
            }
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Employee emp = new Employee(rs.getInt("empid"),rs.getDouble("salary"),rs.getInt("age"),rs.getString("name"),rs.getString("gender"),rs.getString("doj"),rs.getString("designation"),rs.getString("phonenumber"),rs.getString("emailid"));
                employees.add(emp);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return employees;
    }
    
        
}
