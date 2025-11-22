import java.util.Random;

public class Item {
    String itemName;
    int serialNum;
    boolean coldCheck;
    double weight;
    String statusCode;

    // Default constructor
    public Item(){
        itemName = null;
        coldCheck = false;
        weight = 0.0;
        serialNum = 0000;
        statusCode = null;
    }

    // Constructor with inputs
    public Item(String name, boolean cold, double kilograms){
        itemName = name;
        coldCheck = cold;
        weight = kilograms;

        // If Item is set to cold, then first serial digit is set to 5
        if( cold == true){
            serialNum = serialGenerator(true);
        }

        // If Item is not cold, first serial digit is not 5
        else{
            serialNum = serialGenerator(false);
        }

        statusCode = findStatusCode(serialNum);
    }

    // public Item methods
    public String getItemName(){
        return itemName;
    }

    public int getSerialNum(){
        return serialNum;
    }

    public double getWeight(){
        return weight;
    }

    public String getStatusCode(){
        return statusCode;
    }

    public boolean coldCheck(){
        return coldCheck;
    }

    public String getItemData(){
        String[] itemArrayData = new String[4];
        itemArrayData[0] = itemName;
        itemArrayData[1] = String.valueOf(serialNum);
        itemArrayData[2] = weight + "kg";
        if(coldCheck == true){
            itemArrayData[3] = "cold";
        }
        else{
            itemArrayData[3] = "room-temp";
        }

        String ItemData = String.join(", ", itemArrayData);

        return ItemData;
    }

    // private Item method
    private int serialGenerator(boolean ifCold){
        Random random = new Random();
        // If the Item is cold
        if(ifCold == true){
            int tempID = random.nextInt(900) + 100;
            String stringID = String.valueOf(tempID);
            String combindID = "5" + stringID;
            int finalID = Integer.valueOf(combindID);
            int serialNum = finalID;
            return serialNum;
        }

        // If the Item is not cold
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
            int serialNum = finalID;
            return serialNum;
        }
    }
    //find status code based off of serialNum
    private String findStatusCode(int serial){
        if(serial % 2 == 0){
            return "s1";
        }

        else{
            return "s2";
        }
    }
}



