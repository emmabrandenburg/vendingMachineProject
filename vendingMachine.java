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
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class vendingMachine {
    Arm arm;
    item[] currItems;
    section leftSection;
    section rightSection;
    station fridge;
    String outputData;
    int itemCount;
    int[] pickupStationCords = {0, 0};
    int[] fridgeStationCords = {0,1};

    // Create machine components
    public vendingMachine(){
        arm = new Arm();
        leftSection = new section(1);
        rightSection = new section(2);
        fridge = new station(1, 0, 0, true, false);
        leftSection.createStations();
        rightSection.createStations();
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
            arm.move(fridgeStationCords);
            int slot = arm.findSlot(arm.getCurrStation());
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
            sb.append(itemName).append(", with a weight of");
            System.out.println("What is your items weight?");
            itemWeight = Double.valueOf(br.readLine());
            sb.append(itemWeight).append("kg, and it is ");
            System.out.println("Does your item need to be stored at a cold temperature? (please enter y or n)");
            answerCold = br.readLine();
            if (answerCold.equals("y")){
                sb.append("cold.");
                isCold = true;
            }
            else{
                sb.append("not cold.");
                isCold = false;
            }
            sb.append(br.readLine()).append(", ");
            System.out.println("How many items would you like to create?");
            numItems = Integer.valueOf(br.readLine());

            //Creates wanted number of items
            currItems = new item[numItems];
            for(i = 0; i < numItems; i++){
                currItems[i] = new item(itemName, isCold, itemWeight);
                itemCount += 1;
            }

            isr.close();
            br.close();
            //Returns Item data to be output to a file
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
            arm.findItemSection(leftSection, rightSection);
            cords = arm.findItemStation();
            int slot = arm.findSlot(arm.getCurrStation());
            arm.move(cords);
            item placedItem = arm.placeItem(slot - 1);
            station currStation = arm.getCurrStation();
            sb.append("The arm placed " + placedItem.getItemName() + " in station " + currStation.getStationNum() + " in item slot " + slot + "\n");
            arm.move(pickupStationCords);  
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
            while(continueInput == true){
                System.out.println("Would you like to add items? (please enter y or n)");
                String userChoice = br.readLine();
                if(userChoice.equals("y")){
                    sb.append(myMachine.createItems());
                    sb.append(myMachine.storeItems());
                    /* FIXME - call code25 if cooler is full
                    if(currArm.checkCooler(currArm.move()) == false){
                        myMachine.code25();
                    }
                        */
                }
                else{
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
