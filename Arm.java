public class Arm {
    int currX;
    int currY;
    item currItem;
    int selectedSectionType;
    section currSection;

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

    // Moves to pickup and grabs a specified Item
    public void grabItem(item grabbedItem){
        move(0,0);
        currItem = grabbedItem;
    }

    // Places a specified Item
    public item placeItem(){
        item placedItem = currItem;
        currItem = null;
        return placedItem;
    }

    // Finds the right section for the Item
    public int findItemSection(){
        String status = currItem.getStatusCode(section section1, section section2);

        // Item belongs in left section
        if ((status.equals("s1")) || (currItem.coldCheck() == true) || (currItem.getWeight() < 50)){

            currSection = section1;
        }

        // Item belongs in right section
        else{
            currSection = section2;
        }
        return currSection;
    }

/* FIXME

    public int findItemStation(){
        //Section and stationList info
        section currSection =
        station currStationlist[] = currItemSection.getStationList();

        //Item Info
        String currItemName = currItem.getItemName();
        boolean isCold = currItem.coldCheck();
        double weight = currItem.getWeight();

        // If the section is the left section (stations 1, 3, 5, & 7)
        if(currSection.getSectionType() == 1){
            boolean coldSpace = currStationlist[5].numItemCheck();
            boolean weightSpace = currStationlist[7].numItemCheck();
        }
        

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
