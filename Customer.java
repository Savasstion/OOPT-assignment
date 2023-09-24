
import java.util.Scanner;


public class Customer {
    private int age;
    private boolean isMember;
    private String customerName;
    private String password;
    private int custID;
    private static int customerCount = 0;

    public Customer() {
        customerCount += 1;
        this.custID = customerCount;
    }

    public Customer(int age, boolean isMember, String customerName, String password) {
        this.age = age;
        this.isMember = isMember;
        this.customerName = customerName;
        this.password = password;
        customerCount += 1;
        this.custID = customerCount;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMember() {
        return isMember;
    }

    public void setIsMember(boolean isMember) {
        this.isMember = isMember;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }
    
 
}
