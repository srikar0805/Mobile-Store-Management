package Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.SAXParseException;

import ConnectionFactory.ConnectionFactory;
import Mobile.MobileDAO;

public class CustomerDAO {
    public static void createCustomerTable() throws SAXParseException{
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "create table Customer(Name varchar(50),Age int,Address varchar(100),ProductBought varchar(60),Gender varchar(10),ContactNo varchar(15),emailid varchar(30),PurchaseNo int unique)";
        try(PreparedStatement stmt = con.prepareStatement(SQL)){
            stmt.executeUpdate();
            System.out.println("Customer Table created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void createCustomer(Customer cust) {
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "insert into customer values(?,?,?,?,?,?,?,?)";
        try(PreparedStatement stmt = con.prepareStatement(SQL)) {
            stmt.setString(1,cust.getName());
            stmt.setInt(2,cust.getAge());
            stmt.setString(3,cust.getAddress());
            stmt.setObject(4,cust.getProductBought());
            stmt.setString(5,cust.getGender());
            stmt.setString(6,cust.getContactNo());
            stmt.setString(7,cust.getEmailId());
            stmt.setInt(8,cust.getPurchaseNo());
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected+ " customer rows created.");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void updateCustomerContact(Customer cust,String update,String updated ) {
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "update customer set "+update+" = ? where purchaseNo = ?";
        try(PreparedStatement stmt = con.prepareStatement(SQL)) {
            if (update == "age" || update == "purchaseNo") {
                stmt.setInt(1,Integer.parseInt(updated));
            }else{
                stmt.setString(1,updated);
            }
            stmt.setInt(2,cust.getPurchaseNo());
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected + "customer rows updated.");
        }catch(SQLException e) { 
            e.printStackTrace();
        }
    }

    public static void deleteCustomer(Customer cust) {
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "delete from customer where purchaseNo = ?";
        try(PreparedStatement stmt = con.prepareStatement(SQL)) {
            stmt.setInt(1,cust.getPurchaseNo());
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected+" customer rows deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Customer> getAllCustomer() {
        List<Customer> Customers = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "select * from customer";
        try(PreparedStatement stmt = con.prepareStatement(SQL)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Customer cust = new Customer(rs.getString("name"),rs.getInt("age"),rs.getString("address"),MobileDAO.getMobile("model",rs.getString("productBought")).get(0),rs.getString("gender"),rs.getString("contactno"),rs.getString("emailid"),rs.getInt("purchaseNo"));
                Customers.add(cust);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Customers; 
    }

    public static List<Customer> getCustomer(int purchaseNo){
        List<Customer> customers = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "select * from customer where purchaseno = ?";
        try(PreparedStatement stmt = con.prepareStatement(SQL)){
            stmt.setInt(1, purchaseNo);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Customer cust = new Customer(rs.getString("name"),rs.getInt("age"),rs.getString("address"),MobileDAO.getMobile("model",rs.getString("productBought")).get(0),rs.getString("gender"),rs.getString("contactno"),rs.getString("emailid"),rs.getInt("purchaseNo"));
                customers.add(cust);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return customers;
    }
    
    public static List<Customer> getCustomer(String attribute,String value){
        List<Customer> customers = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "select * from customer where "+attribute+" = ?";
        
        try(PreparedStatement stmt = con.prepareStatement(SQL)){
            if (attribute == "age" || attribute == "purchaseNo") {
                stmt.setInt(1,Integer.parseInt(value));
            }else{
                stmt.setString(1,value);
            }
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Customer cust = new Customer(rs.getString("name"),rs.getInt("age"),rs.getString("address"),MobileDAO.getMobile("model",rs.getString("productBought")).get(0),rs.getString("gender"),rs.getString("contactno"),rs.getString("emailid"),rs.getInt("purchaseNo"));
                customers.add(cust);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return customers;
    }
}