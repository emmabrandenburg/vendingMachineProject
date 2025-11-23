/**
 * FIXME
 * FIXME
 * 
 * Emma Brandenburg & _____
 * Created: 10/6/25
 * Modified: 
 * 11/22/25 - Added methods to vendingMachine
 * 
 * Purpose: Calculate the wage of employees.
 * Copyright 2025 by Emma Brandenburg & ____
 *
 * Client: Professor Anwari CSC223
 * 
 * Components: FIXME
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class vendingMachine {
    Arm arm;
    item[] currItems;
    section leftSection;
    section rightSection;
    String outputData;


    // Create machine components
    public vendingMachine(){
        arm = new Arm();
        leftSection = new section(1);
        rightSection = new section(2);
        leftSection.createStations();
        rightSection.createStations();
    }

    // Empty 5th station into the refrigeration container
    public void code25(){
        /*
        
        */
    }

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

    public void storeItems(){

    }
}
