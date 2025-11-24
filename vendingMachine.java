/**
 * FIXME
 * FIXME
 * 
 * Emma Brandenburg & Andrew Asumah
 * Created: 10/6/25
 * Modified: 
 * 11/22/25 - Added methods to vendingMachine
 * 
 * Purpose: Calculate the wage of employees.
 * Copyright 2025 by Emma Brandenburg & Andrew Asumah
 *
 * Client: Professor Anwari CSC223
 * 
 * Components: FIXME
 */

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class vendingMachine {
    Arm arm;
    item[] currItems;
    section leftSection;
    section rightSection;
    section currSection;
    station fridge;
    station pickUp;
    station currStation;
    String outputData;
    int currStationNum;
    int itemCount;

    // Create machine components
    public vendingMachine(){
        // Machine components
        leftSection = new section(1);
        rightSection = new section(2);
        fridge = new station(1, 0, 0, true, false);
        pickUp = new station(0,0, -1, false, false);
        leftSection.createStations();
        rightSection.createStations();
        arm = new Arm(leftSection, rightSection, pickUp, fridge);

        // Assigning where arm should start
        currSection = leftSection;
        currStation = pickUp;

    }

    // Empty 5th station into the refrigeration container
    public String code25(){
        int i;
        station[] stationList = leftSection.getStationList();
        station coldStation = stationList[3];
        item coldItems[] = coldStation.getItemList();
        int[] coldSectionCords = {0,2};
        arm.move(coldSectionCords);
        for(i = 0; i < coldItems.length; i++){
            arm.grabItem(coldItems[i]);
            arm.move(fridge.getCords());
            arm.setCurrStation(fridge.getCords());
            int slot = arm.findSlot(arm.getCurrStation());

            if(slot == -1){
                return "Fridge is full. Could not place the rest of the refrigeratables.\n";
            }
            arm.placeItem(slot - 1);
            arm.move(coldSectionCords);
        }

        return "The cold section has been emptied into the fridge with code 25.";

    }

    //Creates items using user input
    public String createItems(){
        try{
            StringBuffer sb = new StringBuffer();
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            int numItems;
            int i;
            String itemName;
            Double itemWeight;
            String answerCold;
            boolean isCold;

            //User inputs
            System.out.println("What is your items name?");
            itemName = br.readLine();
            sb.append("You've created " + itemName + " with a weight of ");
            System.out.println("What is your items weight?");
            itemWeight = Double.valueOf(br.readLine());
            sb.append(itemWeight).append("kg. It is ");
            System.out.println("Does your item need to be stored at a cold temperature? (please enter y or n)");
            answerCold = br.readLine();
            if (answerCold.equals("y")){
                sb.append("cold. ");
                isCold = true;
            }
            else{
                sb.append("not cold. ");
                isCold = false;
            }
            System.out.println("How many items would you like to create?");
            numItems = Integer.valueOf(br.readLine());
            sb.append("You have created ").append(numItems).append(" of them.\n");

            //Creates wanted number of items
            currItems = new item[numItems];
            for(i = 0; i < numItems; i++){
                currItems[i] = new item(itemName, isCold, itemWeight);
                itemCount += 1;
            }

            //Returns Item data to be output to a file
            System.out.println("You've created " + numItems + " " + itemName + " items");
            return String.valueOf(sb);
        }
        catch(IOException ex){
            System.out.println("Error");
            return("Error");
        }
    }

    //Stores items in their correct space
    public String storeItems(){
        int i;
        int[] cords;
        StringBuffer sb = new StringBuffer();

        for (i = 0; i < currItems.length; i++){
            arm.grabItem(currItems[i]);
            item currItem = currItems[i];
            station targetStation;

            // For cold Items
            if(currItem.coldCheck()){
                targetStation = leftSection.getStationList()[2];
                cords = targetStation.getCords();
                arm.move(cords);
                arm.setCurrStation(cords);

                int slot = arm.findSlot(targetStation);
                if(slot == -1){
                    sb.append("Station " + targetStation.getStationNum() + " is full\n");
                    sb.append(code25());
                    slot = arm.findSlot(targetStation);
                    if(slot == -1){
                        break;
                    }
                }
            item placedItem = arm.placeItem(slot - 1);
            sb.append("The arm placed " + placedItem.getItemName() + " in station " + arm.getCurrStation().getStationNum() + " in item slot " + slot + "\n");
            }

            //For non-cold items
            else{
                arm.findItemSection(leftSection, rightSection);
                targetStation = arm.getStation();
                if(targetStation == null){
                    arm.findNextStation();
                    station nextStation = arm.getStation();
                    if(nextStation == null){
                        sb.append("No station available for " + currItem.getItemName() + "\n");
                        continue;
                    }
                
                    arm.move(targetStation.getCords());
                    arm.setCurrStation(targetStation.getCords());
                }
                int slot = arm.findSlot(targetStation);
                if(slot == -1){
                    sb.append("Station " + targetStation.getStationNum() + " is full\n");
                    arm.findNextStation();
                    continue;
                }

                item placedItem = arm.placeItem(slot - 1);
                sb.append("The arm placed " + placedItem.getItemName() + " in station " + arm.getCurrStation().getStationNum() + " in item slot " + slot + "\n");
            }
        }
        String storingData = String.valueOf(sb);
        return storingData;
    }

    // Writes machine data to a file
    public void writeData(String fileName, String data){
        try{
            FileWriter fw = new FileWriter(fileName, true);
            fw.write(data);
            fw.close();
        }
        // Catch if there is an error
        catch (IOException ex3){
            System.out.println("Error");
        }
    }

    public Arm getArm(){
        return arm;
    }

    public static void main(String[] args){
        StringBuffer sb = new StringBuffer();
        boolean continueInput = true;
        vendingMachine myMachine = new vendingMachine();
        Arm currArm = myMachine.getArm();

        try{
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            // While the user wants to add more items
            while(continueInput == true){
                System.out.println("Would you like to add items? (please enter y or n)");
                String userChoice = br.readLine();
                if(userChoice.equals("y")){
                    sb.append(myMachine.createItems());
                    sb.append(myMachine.storeItems());
                }
                else{
                    // Output file created if user is finished
                    String fullData = String.valueOf(sb);
                    myMachine.writeData("machineOutput.txt", fullData);
                    continueInput = false;
                }
            }
        }
        catch(IOException ex){
            System.out.println("Error");
        }


    }
}
