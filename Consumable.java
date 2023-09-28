
import java.util.ArrayList;
import java.util.Scanner;
    

public class Consumable {
        private static double foodTotal = 0;
    static Scanner scan = new Scanner(System.in);

    public static void main() {
        //ArrayList to store food menu
        ArrayList<FoodItem> menu = new ArrayList<>();
        menu.add(new FoodItem("F001", "Popcorn", 5.50));
        menu.add(new FoodItem("F002", "Hotdog", 8.30));
        menu.add(new FoodItem("F003", "Chips", 7.20));
        menu.add(new FoodItem("F004", "Salad", 4.60));
        menu.add(new FoodItem("F005", "Fries", 2.50));
        menu.add(new FoodItem("D001", "100Plus", 1.50));
        menu.add(new FoodItem("D002", "Pepsi", 2.80));
        menu.add(new FoodItem("D003", "Coke", 3.10));

        //ArrayList to store customer order
        ArrayList<Order> orders = new ArrayList<>();

        menu(menu, orders);
    }
                                         //menu list, order list
    public static void menu(ArrayList<FoodItem> menu, ArrayList<Order> orders) {
        int choice;
        do {
            System.out.println("~~~~~~~~~~~~~Ordering Food~~~~~~~~~~~");
            System.out.println("\t1. View Menu");
            System.out.println("\t2. Place an Order");
            System.out.println("\t3. View Orders");
            System.out.println("\t4. Remove Orders");
            System.out.println("\t5. Exit");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("--------------------------------------");
                    viewMenu(menu);
                    break;
                    
                case 2:
                    System.out.println("--------------------------------------");
                    placeOrder(menu, orders);   //call placeOrder
                    break;
                
                case 3:
                    System.out.println("--------------------------------------");
                    viewOrders(orders);         //call viewOrder
                    break;
                
                case 4:                    
                    System.out.println("--------------------------------------");
                    removeOrders(orders);       //call removeOrder
                    break;
                    
                case 5:                    
                    System.out.println("--------------------------------------");
                    System.out.println("Thank you for ordering");
                    System.out.println("--------------------------------------");
                    System.out.println("*~~~~~~~~~~~~~~~~TICKET*MENU~~~~~~~~~~~~~~~~~~~~*");
                    //call ticketMenu
                    ticketMenu menu2 = new ticketMenu();
                    boolean userInputIsValid = true;
                    do {
            menu2.displayOptions(userInputIsValid);
            String userInput = scan.nextLine();
            if (menu2.validateOption(userInput,1)) {
                menu2.doMenuTask(userInput.charAt(0));
                userInputIsValid = true;
            } else {
                userInputIsValid = false;
            }}while (userInputIsValid == false);
                    break;
                
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);
    }

    //Display the food menu list
    public static void viewMenu(ArrayList<FoodItem> menu) {
        System.out.println("~~~~~~~~~~~~~~~Food Menu~~~~~~~~~~~~~~");
        System.out.println("Food ID\t\t Food Name\t Price(RM)");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for (FoodItem item : menu) {
            System.out.println(item.getFoodID() + "\t\t" + item.getFoodName() + "\t\t" + item.getPrice());
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("F = food    D = drink");
        System.out.println("1 for Small, 2 for Medium, 3 for Large");
        System.out.println();
    }

    public static void placeOrder(ArrayList<FoodItem> menu, ArrayList<Order> orders) {
        viewMenu(menu);     //display food menu list
        System.out.println("Place an Order...........");
        System.out.print("Enter Food ID : ");
        String foodID = scan.next();
        
        //check whether it is null
        FoodItem selectedFood = null; 
        for (FoodItem item : menu) {
            if (item.getFoodID().equals(foodID)) { 
                selectedFood = item;    //compare inputed food ID with the one in array, if found the selected
                break;
            }
        }
        
        //input size and quantity of order
        if (selectedFood != null) {
            int size;
            do {
                System.out.print("Enter Size : ");
                size = scan.nextInt();
                if (size < 1 || size > 3) {
                    System.out.println("Invalid size. Please enter 1, 2, or 3.");
                }
            } while (size < 1 || size > 3);
        
            int quantity;
            do{
                System.out.print("Enter Quantity : ");
                quantity = scan.nextInt();
                if (quantity < 1){
                    System.out.println("Invalid input, Pkese enter again...");
                
                }
            }while (quantity < 1);
            //save it into order array 
            Order order = new Order(selectedFood, size,quantity);
            orders.add(order);
            System.out.println("Order placed successfully!");
        } else {
            //invalid food ID will loop to enter again 
                System.out.println("Invalid Food ID. Please try again.");
                placeOrder(menu,orders);
            }
        }

    //remove order function
    public static void removeOrders(ArrayList<Order> orders) {
        //check order array alrdy has food save in it or not,if not display below 
        if (orders.isEmpty()) {
            System.out.println("There are no orders to remove.");
            return;
        }

    // Display the current orders list
        System.out.println("~~~~~~~~~~~~~~~Current Order~~~~~~~~~~~~~~");
        System.out.println("OrderNo\tFood Name\t Size\t Price\tQuantity \tTotal");

        //loop for printing and calulate the amount inside of order array 
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            FoodItem foodItem = order.getFoodItem();
            double total = foodItem.getPrice() * order.getSize()*order.getQuantity();

            System.out.println(i + "\t" + foodItem.getFoodName() + "\t\t" + order.getSize() + "\tRM" + foodItem.getPrice()+ "\t\t"+order.getQuantity()+"\tRM" + total);
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    // ask user to input order no of the order to remove
        System.out.print("Enter the Order No. of the order to remove: ");
        int orderNo = scan.nextInt();

        if (orderNo >= 0 && orderNo < orders.size()) {
        // Remove the selected order
            orders.remove(orderNo);
            System.out.println("Order removed successfully!");
        } else {
            System.out.println("Invalid No. No order removed.");
        }
    }
    
    //display view order function
    public static void viewOrders(ArrayList<Order> orders) {
        System.out.println("~~~~~~~~~~~~~~~Yours Order~~~~~~~~~~~~~~");
        System.out.println("Food Name\t Size\t Price\t Quantity\tTotal");
        foodTotal = 0;
//loop for printing and calulate the amount inside of order array 
        for (Order order : orders) {                              
            FoodItem foodItem = order.getFoodItem();              
            
            
            //price multiple size(s = ori price, medium = double price, large = triple price)multiple quantity
            double total = foodItem.getPrice() * order.getSize()*order.getQuantity();        
            System.out.println(foodItem.getFoodName() + "\t\t" + order.getSize()+ "\tRM" + foodItem.getPrice()+"\t\t" +order.getQuantity() + "\tRM" + total); 
            foodTotal += total;                                  //total is add one by one 
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
         
        System.out.println("Total Amount of your order : RM " + foodTotal);
        System.out.println();
    }

    public static double getFoodTotal(){
        return foodTotal;
    }
}

 
