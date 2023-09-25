import java.util.ArrayList;

public abstract class Menu {

    //cache input just in case when needed
    private char userInput;
    private boolean exit = false;
    private int optionsCount;
    private ArrayList<String> options = new ArrayList<>();

    public Menu() {

    }

    public Menu(ArrayList<String> options) {
        optionsCount = options.size();
        this.options = options;
    }

    public char getUserInput() {
        return userInput;
    }

    public void setUserInput(char userInput) {
        this.userInput = userInput;
    }

    public int getOptionsCount() {
        return optionsCount;
    }

    public void setOptionsCount(int optionsCount) {
        this.optionsCount = optionsCount;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public void displayOptions(boolean isPrevLoopValid) {
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }

        if (!isPrevLoopValid) {
            System.out.println("\nInvalid Input! Try again\nInput : ");
        } else {
            System.out.println("\nInput : ");
        }
    }

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    
    
    //if need to convert String to other datatypes for validation, use something like Double.parseDouble(string) or Integer.parseInt(string)
    public boolean validateOption(Object obj, int validationStage) {
        //no need optionStage cuz only one type of validation
        String userEntered = (String)obj;
        
        if (userEntered.length() > 1) {
            return false;
        }

        setUserInput(userEntered.charAt(0));

        if (Character.isDigit(getUserInput())) {
            //convert char to ASCII int values then by minusing 48 to get raw value (refer ASCII table)
            //To a teammate who wants to implement this but still dont understand this,
            //you can just Character.getNumericValue('1'), this example will result to returning int 1
            return ((int) getUserInput() - 48 <= getOptionsCount() && (int) getUserInput() - 48 > 0);
        } else {
            return false;
        }

    }
    
 
    public abstract void doMenuTask(Object input);

}
