package Customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.xml.sax.SAXParseException;

import Mobile.Mobile;
import Mobile.MobileDAO;
import Operations.Operations;

public class Customer extends Operations {
    private String name;
    private int age;
    private String address;
    private Mobile productBought;
    private String gender;
    private String contactNo;
    private String emailId;
    private int purchaseNo;

    public int getPurchaseNo() {
        return purchaseNo;
    }

    public void setPurchaseNo(int purchaseNo) {
        this.purchaseNo = purchaseNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProductBought() {
        return productBought.getModelName();
    }

    public void setProductBought(String productBought) {
        this.productBought.setModelName(productBought);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Customer(String name, int age, String address, Mobile productBought,
            String gender, String contactNo, String emailId, int purchaseNo) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.productBought = productBought;
        this.gender = gender;
        this.contactNo = contactNo;
        this.emailId = emailId;
        this.purchaseNo = purchaseNo;
    }

    public Customer() {
    }

    public Customer(String cusLine) {
        String values[] = cusLine.split(",");
        this.name = values[0];
        this.age = Integer.parseInt(values[1]);
        this.address = values[2];
        this.productBought = MobileDAO.getMobile("model",values[3]).get(0);
        this.gender = values[4];
        this.contactNo = values[5];
        this.emailId = values[6];
        this.purchaseNo = Integer.parseInt(values[7]);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + age;
        result = prime * result + ((contactNo == null) ? 0 : contactNo.hashCode());
        result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((productBought == null) ? 0 : productBought.hashCode());
        result = prime * result + purchaseNo;
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
        Customer other = (Customer) obj;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (age != other.age)
            return false;
        if (contactNo == null) {
            if (other.contactNo != null)
                return false;
        } else if (!contactNo.equals(other.contactNo))
            return false;
        if (emailId == null) {
            if (other.emailId != null)
                return false;
        } else if (!emailId.equals(other.emailId))
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
        if (productBought == null) {
            if (other.productBought != null)
                return false;
        } else if (!productBought.equals(other.productBought))
            return false;
        if (purchaseNo != other.purchaseNo)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "\nCustomer Name\t:\t" + name
                 +"\nPurchaseNo\t:\t" + purchaseNo
                 + "\nProductBought\t:\t" + productBought.getBrandName()+" "+productBought.getModelName()
                 + "\ncontactNo\t:\t" + contactNo
                 + "\nemailId\t\t:\t" + emailId
                 + "\ngender\t\t:\t" + gender
                 + "\nAge\t\t:\t" + age
                 + "\nAddress\t\t:\t" + address + "\n";
    }

    @Override
    public void createTable(){
        try {
            CustomerDAO.createCustomerTable();
        } catch (SAXParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addData(String S) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(S));
            String cusLine;
            while ((cusLine = reader.readLine()) != null) {
                CustomerDAO.createCustomer(new Customer(cusLine));
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String purchaseNO,String update,String updated) {
        int purchaseNo = Integer.parseInt(purchaseNO);
        Customer customer = CustomerDAO.getCustomer(purchaseNo).get(0);
        CustomerDAO.updateCustomerContact(customer, update,updated);
    }

    @Override
    public void updateInBulk(String file){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String cusLine;
            while ((cusLine = reader.readLine()) != null) {
                String values[]=cusLine.split(",");
                this.update(values[0],values[1],values[2]);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String purchaseNO) {
        int purchaseNo = Integer.parseInt(purchaseNO);
        Customer customer = CustomerDAO.getCustomer(purchaseNo).get(0);
        CustomerDAO.deleteCustomer(customer);
    }

    @Override
    public void printAll() {
        List<Customer> allCustomers = CustomerDAO.getAllCustomer();
        allCustomers.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void printByAttribute(String attribute, String value) {
        Customer customer = CustomerDAO.getCustomer(attribute, value).get(0);
        System.out.println(customer);
    }

    @Override
    public void search(String attribute, String value){
        List<Customer> customers = CustomerDAO.getCustomer(attribute, value);
        customers.forEach(System.out::println);
        System.out.println();
    }
}
