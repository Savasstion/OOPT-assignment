//Get Food Id, name,price,size,quantity
public class Order {
    private FoodItem foodItem;
    private int size;  
    private int quantity;

    public Order(FoodItem foodItem, int size,int quantity) {
        this.foodItem = foodItem;
        this.size = size;
        this.quantity = quantity;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
        
    }

}
