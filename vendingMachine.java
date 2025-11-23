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

import java.util.Scanner;

public class vendingMachine {
    Arm arm;
    item[] currItems;
    section leftSection;
    section rightSection;

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

    public section getSection(int type){
        if(type == 1){
            return leftSection;
        }
        else{
            return rightSection;
        }
    }

    public String[] createItem(){
        Scanner scnr = new Scanner(System.in);
        int i;
        String itemName;
        Double itemWeight;
        char answerCold;
        boolean isCold;

        System.out.println("What is your items name?");
        itemName = scnr.nextLine();
        System.out.println("What is your items weight?");
        itemWeight = scnr.nextDouble();
        System.out.println("Does your item need to be stored at a cold temperature? (please enter y or n)");
        answerCold = scnr.next().charAt(0);
        System.out.println("How many items would you like to create?");
        i = scnr.nextInt();
    }

    public void storeItems(){

    }
}
