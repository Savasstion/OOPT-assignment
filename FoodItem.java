

//Get food Id, name and price
public class FoodItem {
    private String foodID;
    private String foodName;
    private double price;

    public FoodItem(String foodID, String foodName, double price) {
        this.foodID = foodID;
        this.foodName = foodName;
        this.price = price;
    }

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

