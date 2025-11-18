import java.util.Random;

public class Item {
    int serialNum;
    boolean coldCheck;
    double weight;
    Random random = new Random();

    // Default constructor
    public Item(){
        coldCheck = false;
        weight = 0.0;
        serialNum = 0000;
    }

    // Constructor with inputs
    public Item(boolean cold, double kilograms){
        coldCheck = cold;
        weight = kilograms;

        // If Item is set to cold, then first num in serialNum is set to 5
        if( cold == true){
            int tempID = random.nextInt(900) + 100;
            String stringID = String.valueOf(tempID);
            String combindID = "5" + stringID;
            int finalID = Integer.valueOf(combindID);
            serialNum = finalID;
        }
        
        // If Item is not cold
        else{
            
            // Finding first digit and making sure its not 5.
            int firstNum = random.nextInt(9) + 1;
            while(firstNum == 5){
                firstNum = random.nextInt(9) + 1;
            }

            //Fiding and appeneding the rest of the digits
            int tempID = random.nextInt(900) + 100;
            String stringID = String.valueOf(tempID);
            String combindID = firstNum + stringID;
            int finalID = Integer.valueOf(combindID);
            serialNum = finalID;
            
            serialNum = random.nextInt(9000) + 1000;
        }

    }

    // Item methods
    public int getSerialNum(){
        return serialNum;
    }

    public double getWeight(){
        return weight;
    }
}


