
import java.util.ArrayList;
import java.util.Scanner;

public class MemberMenu extends Menu {

    private ArrayList<Customer> memberArr = new ArrayList<>();
    private Customer loggedInCust;

    public MemberMenu() {
        super(new ArrayList<>() {
            {
                add("Sign Up");
                add("Log In");
                add("Exit");
            }
        });
        this.memberArr = (new ArrayList<>() {
            {
                add(new Customer(19, false, "Bob", "696969"));
                add(new Customer(69, false, "Beep", "111"));
                add(new Customer(1, false, "Grognak, Destroyer of Worlds", "1"));
            }
        });

    }

    public ArrayList<Customer> getMemberArr() {
        return memberArr;
    }

    public void setMemberArr(ArrayList<Customer> memberArr) {
        this.memberArr = memberArr;
    }

    public Customer getLoggedInCust() {
        return loggedInCust;
    }

    public void setLoggedInCust(Customer loggedInCust) {
        this.loggedInCust = loggedInCust;
    }

   
    @Override
    public void doMenuTask(Object input) {
        char menuInput = (Character) input;
        Customer cust = new Customer();
        // menuInput == 1 for sign up
        // menuInput == 2 for log in
        Scanner s = new Scanner(System.in);

         switch (menuInput) {
            case '1':
                boolean valid = true;
                do {
                    System.out.println("Enter your username:");
                    cust.setCustomerName(s.nextLine());
                    for (int i = 0; i < getMemberArr().size(); i++) {
                        valid = !cust.getCustomerName().equals(memberArr.get(i).getCustomerName());
                        if (valid == false) {
                            break;
                        }
                    }
                    if (valid == false) {
                        System.out.println("Username has been used, please enter again");
                    }
                } while (valid == false);

                System.out.println("Create a password:");
                cust.setPassword(s.nextLine());

                System.out.println("Enter age:");
                cust.setAge(s.nextInt());

                cust.setIsMember(true);

                System.out.println("Sign up successful");

                this.memberArr.add(cust); // Add the Customer object
                ticket tick = new ticket();
                tick.setCustomer(Customer.getCustID());
                break;

            case '2':
                boolean loginSuccessful = false;

                do {
                    System.out.println("Enter your username:");
                    cust.setCustomerName(s.nextLine());
                    System.out.println("Enter your password:");
                    cust.setPassword(s.nextLine());

                    for (int i = 0; i < getMemberArr().size(); i++) {
                        if ((memberArr.get(i).getCustomerName().equals(cust.getCustomerName())) && (memberArr.get(i).getPassword().equals(cust.getPassword()))) {
                            loginSuccessful = true;
                            setLoggedInCust(memberArr.get(i));
                            break;
                        }
                    }

                    if (loginSuccessful) {
                        System.out.println("Log in successful");
                    } else {
                        System.out.println("Invalid username or password");
                    }

                } while (loginSuccessful != true);

                break;

            case '3':
                setExit(true);
                break;

            default:
                System.out.println("Invalid parameter in doMenuTask()");
        }
        s.close();
    }
}