import java.util.Arrays;

public class Arm {
    int currX;
    int currY;
    item currItem;
    section currItemSection;
    station currStation;

    // Constructor
    Arm(){
        currX = 0;
        currY = 0;
        currItem = null;
    }

    // Methods
    // Moves the machine arm
    public String move(int[] cords){

        int newX = cords[0];
        int newY = cords[1];
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

    // Moves to pickup and grabs a specified Item
    public void grabItem(item grabbedItem){
        currItem = grabbedItem;
    }

    // Places a specified Item
    public item placeItem(int itemSlot){
        item placedItem = currItem;
        currStation.addItem(currItem, itemSlot);
        currItem = null;
        return placedItem;
    }

    // Finds the right section for the Item
    public void findItemSection(section section1, section section2){
        String status = currItem.getStatusCode();

        // Item belongs in left section
        if ((status.equals("s1")) || (currItem.coldCheck() == true) || (currItem.getWeight() < 50)){

            currItemSection = section1;
        }

        // Item belongs in right section
        else{
            currItemSection = section2;
        }
    }

    // Returns coordinates of a station
    public int[] findItemStation(){
        //Section and stationList info
        station stationOptions[] = currItemSection.getStationList();

        //Item Info
        boolean isCold = currItem.coldCheck();
        double weight = currItem.getWeight();
        int[] nextCords = new int[2];

        // Item belongs in cold station
        if (isCold == true && stationOptions[2].numItemCheck()){
            nextCords = stationOptions[2].getCords();
        }

        // Item belongs in light weight station
        else if(weight < 50 && stationOptions[3].numItemCheck()){
            nextCords = stationOptions[3].getCords();
        }

        //Item belongs in any other station
        else if (currItemSection.getSectionType() == 1){
          
            if (stationOptions[0].numItemCheck() == true){
                nextCords = stationOptions[0].getCords();
            }

            else if(stationOptions[1].numItemCheck() == true){
                nextCords = stationOptions[1].getCords();
            }
        }

        else if (currItemSection.getSectionType() == 2){
          
            // Checks if a station is full, returns section if its not
            if (stationOptions[0].numItemCheck() == true){
                nextCords = stationOptions[0].getCords();
            }

            else if(stationOptions[1].numItemCheck() == true){
                nextCords = stationOptions[1].getCords();
            }

            else if(stationOptions[2].numItemCheck() == true){
                nextCords = stationOptions[2].getCords();
            }

            else if(stationOptions[3].numItemCheck() == true){
                nextCords = stationOptions[3].getCords();
            }
        }

        // Sets the direction to the pickup station if there is no room for your item
        else{
            System.out.println("There is no slot left for your item.");
            Arrays.fill(nextCords, 0);
        }

        return nextCords;
    }

    // Finds an item slot in a station
    public int findSlot(station selectedStation){
        int currSlot;
        currStation = selectedStation;
        currSlot = currStation.findItemSlot();
        return currSlot;
    }

    public station getCurrStation(){
        return currStation;
    }

    public void setCurrStation(int[] cords){
        for(station curr : currItemSection.getStationList()){
            int[] stationCords = curr.getCords();
            if(stationCords[0] == cords[0] && stationCords[1] == cords[1]){
                currStation = curr;
            }
       }
    }

    // Returns true if the cooler is full
    public boolean checkCooler(station cooler){
        int[] coolerCords = {0,1};
        move(coolerCords);
        setCurrStation(coolerCords);
        
        boolean isSpace = currStation.numItemCheck();
        if(isSpace == true){
            return true;
        }
        else{
            return false;
        }
    }
}
