
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Customer.*;
import Employee.*;
import Mobile.*;

public class App {
  public static void printHelp() {
    System.out.println();
    try {
      BufferedReader reader = new BufferedReader(
          new FileReader("src\\help.txt"));
      String line;
      try {
        while ((line = reader.readLine()) != null) {
          System.out.println(line);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {

    Mobile Mobile = new Mobile();
    Employee Employee = new Employee();
    Customer Customer = new Customer();

    switch (args[0]) {
      case "-createtable":
        switch (args[1]) {
          case "-m":
            Mobile.createTable();
            break;
          case "-e":
            Employee.createTable();
            break;
          case "-c":
            Customer.createTable();
            break;
          default:
            System.out.println("Invalid operation\nType '-h' for help");
        }
        break;
      case "-add":
        switch (args[1]) {
          case "-m":
            Mobile.addData("src\\Mobile\\MobileData.csv");
            break;
          case "-e":
            Employee.addData("src\\Employee\\EmployeeData.csv");
            break;
          case "-c":
            Customer.addData("src\\Customer\\CustomerData.csv");
            break;
          default:
            System.out.println("Invalid operation\nType '-h' for help");
        }
        break;
      case "-update":
        switch (args[1]) {
          case "-m":
            Mobile.update(args[2], args[3], args[4]);
            break;
          case "-e":
            Employee.update(args[2], args[3], args[4]);
            break;
          case "-c":
            Customer.update(args[2], args[3], args[4]);
            break;
          default:
            System.out.println("Invalid operation\nType '-h' for help");
        }
        break;
      case "-updateInBulk":
        switch (args[1]) {
          case "-m":
            Mobile.updateInBulk("src\\Mobile\\MobileUpdate.csv");
            break;
          case "-e":
            Employee.updateInBulk("src\\Employee\\EmployeeUpdate.csv");
            break;
          case "-c":
            Customer.updateInBulk("src\\Customer\\CustomerUpdate.csv");
            break;
          default:
            System.out.println("Invalid operation\nType '-h' for help");
        }
        break;
      case "-delete":
        switch (args[1]) {
          case "-m":
            Mobile.delete(args[2]);
            break;
          case "-e":
            Employee.delete(args[2]);
            break;
          case "-c":
            Customer.delete(args[2]);
            break;
          default:
            System.out.println("Invalid operation\nType '-h' for help");
        }
        break;
      case "-print":
        switch (args[1]) {
          case "-m":
            Mobile.printAll();
            break;
          case "-e":
            Employee.printAll();
            break;
          case "-c":
            Customer.printAll();
            break;
          default:
            System.out.println("Invalid operation\nType '-h' for help");
        }
        break;
      case "-search":
        switch (args[1]) {
          case "-m":
            Mobile.search(args[2], args[3]);
            break;
          case "-e":
            Employee.search(args[2], args[3]);
            break;
          case "-c":
            Customer.search(args[2], args[3]);
            break;
          default:
            System.out.println("Invalid operation\nType '-h' for help");
        }
        break;
      case "-h":
        printHelp();
        break;
    }

  }
}
