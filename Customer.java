

public class Customer {
    private int age;
    private boolean isMember;
    private String customerName;
    private String password;
    private static int custID = 0;

    public Customer() {
        Customer.custID++;
    }

    public Customer(int age, boolean isMember, String customerName, String password) {
        this.age = age;
        this.isMember = isMember;
        this.customerName = customerName;
        this.password = password;
        Customer.custID++;
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

    public static int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        custID = 0;
        Customer.custID = custID;
    }


}


