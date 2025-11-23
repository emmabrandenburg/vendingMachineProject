public class Arm {
    int currX;
    int currY;
    Item currItem;

    // Constructor
    Arm(){
        currX = 0;
        currY = 0;
        currItem = null;
    }

    // Methods
    // Moves the machine arm
    public String move(int newX, int newY){
        StringBuffer sb = new StringBuffer();
        String moveData;
        int spacesMovedX;
        int spacesMovedY;

        //Moving back to Pickup Station
        if((newX == 0) && (newY == 0)){
            currX = newX;
            currY = newY;
            return "The arm moved back to the pickup station";
        }

        //Moving to the cooler
        if((newX == 1) && (newY == 0)){
            currX = newX;
            currY = newY;
            return "The arm moved to the cooler";
        }

        //Moving right or left
        if (currX > newX){
            spacesMovedX = currX - newX;
            sb.append("The arm moved " + spacesMovedX + " station left & ");
        }
        else if (newX > currX){
            spacesMovedX = newX - currX;
            sb.append("The arm moved " + spacesMovedX + " station right & ");
        }

        //Moving up or down
        if (currY > newY){
            spacesMovedY = currY - newY;
            sb.append("The arm moved " + spacesMovedY + " station(s) down");
        }
        else if (newY > currY){
            spacesMovedY = newY - currY;
            sb.append("The arm moved " + spacesMovedY + " station(s) up");
        }

        // Set X and Y to new positions
        currX = newX;
        currY = newY;

        //Return movement data
        moveData = sb.toString();
        sb = null;
        return moveData;
    }

    public void grabItem(Item grabbedItem){
        move(0,0);
        currItem = grabbedItem;
    }

    public Item placeItem(){
        Item placedItem = currItem;
        currItem = null;
        return placedItem;
    }

    public int findItemSection(){
        String status = currItem.getStatusCode();

        // Item belongs in left section
        if (status.equals("s1")){
            return 1;
        }

        // Item belongs in right section
        else{
            return 2;
        }
    }
    /*
    public int findItemStation(){
        // possibly boolean coldSpace = stationCold.numItemCheck()
        // possibly boolean weightSpace = stationLight.numItemCheck()
        int i;
        String currItemName = currItem.getItemName();
        boolean isCold = currItem.coldCheck();
        double weight = currItem.getWeight();
        int itemSection = findItemSection();

        // Item belongs in cold station
        if (isCold == true){
            return 5;
        }

        // Item belongs in light weight station
        else if(weight < 50){
            return 7;
        }

        else if (itemSection == 1){
          
            // Checks if a station is full, and place an item if it's not
            if (section1.numItemCheck() == true){
                itemSlot = station.findItemSlot();
                return 1;
            }

            else if(section3.numItemCheck() == true){
                itemSlot = station.findItemSlot();
                return 3;
            }

            else if(section5.numItemCheck() == true){
                itemSlot = station.findItemSlot();
                return 5;
            }
        
        }

        else if (itemSection == 2){
          
            // Checks if a station is full, returns section if its not
            if (section2.numItemCheck() == false){
                itemSlot = station.findItemSlot();
                return 2;
            }

            else if(section4.numItemCheck() == false){
                itemSlot = station.findItemSlot();
                return 4;
            }

            else if(section6.numItemCheck() == false){
                itemSlot = station.findItemSlot();
                return 6;
            }

            else if(section8.numItemCheck() == false){
                itemSlot = station.findItemSlot();
                return 8;
            }
        
        }

        // Returns -1 if there are no slots available for an item
        else{
            System.out.println("There is no slot left for your item.");
            return -1;
        }
    }
    */
}
