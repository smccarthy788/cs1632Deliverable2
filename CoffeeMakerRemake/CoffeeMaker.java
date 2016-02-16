package CoffeeMakerRemake;

import java.util.Scanner;

public class CoffeeMaker {

    public static Inventory initializeInventory(){
        return new Inventory();
    }
    
    public static Room[] initializeRooms(){
        Room[] rooms = new Room[6];
        String[] adjs = {"Small", "Funny", "Refinanced", "Dumb", "Bloodthirsty", "Rough"};
        String[] furns = {"Quaint sofa", "Sad record player", "Tight pizza", "Flat energy drink", "Beautiful bag of money", "Perfect air hockey table"};
        String[] northDoors = {"Magenta", "Beige", "Dead", "Vivacious", "Purple", "DNE"};
        String[] southDoors = {"DNE", "Massive", "Smart", "Slim", "Sandy", "Minimalist"};
        String[] items = {"caffinated coffee", "sweet sugar", "creamy cream"};
        
        int itemCount = 0;
        
        for(int i = 0; i < 6; i++){
            if(i%2 == 0){
                rooms[i] = new Room(adjs[i], furns[i], northDoors[i], southDoors[i], items[itemCount]);
                itemCount++;
            } else {
                rooms[i] = new Room(adjs[i], furns[i], northDoors[i], southDoors[i]);
            }
        }
        
        return rooms;
    }
    
    public static void drink(Inventory inventory){ // True if win, False if lose
        if(inventory.isInventoryFull()){
            // win
            System.out.println("You drink the beverage and are ready to study!");
            System.out.println("You win!");
            System.exit(0);
        } else {
            if(inventory.isInventoryEmpty()){
                System.out.println("You drink the air, as you have no coffee, sugar, or cream.");
                System.out.println("The air is invigorating, but not invigorating enough. You cannot study.");
                System.out.println("You lose.");
                System.exit(1);
            }
            else {
                System.out.println("You drink some combination of uninvigorating ingredients.");
                System.out.println("Why!? Why would you do this?!? Oh the humanity!!!");
                System.out.println("You lose.");
                System.exit(1);
            }
        }
    }
    
    public static void printHelp(){
        System.out.println("HELP!\n");
        System.out.println("You have the follow options:");
        System.out.println("N or n : Go North. Pass through the door to the north.");
        System.out.println("S or s : Go South. Pass through the door to the south.");
        System.out.println("L or l : Look. Check a room for any items. You will pickup an item if found.");
        System.out.println("I or i : Check your inventory. List what items are in, and not in, your inventory.");
        System.out.println("D or d : Drink. Drink whatever items you may have. Drink at your own peril!\n");
    }
    
    public static void main(String[] args){
        // initialize inventory and rooms
        Inventory inventory = initializeInventory();
        
        Room[] rooms = initializeRooms();
        
        int currentRoom = 0;
        
        // game loop
        while(true){
            // Describe Room & Furniture
            System.out.println("\nYou see a " + rooms[currentRoom].describeRoomAttribute() + " room.");
            System.out.println("It has a " + rooms[currentRoom].describeRoomFurniture() + ".");
            
            if(rooms[currentRoom].hasNorthDoor()){
                System.out.println("A " + rooms[currentRoom].describeNorthDoor() + " door leads North.");
            }
            if(rooms[currentRoom].hasSouthDoor()){
                System.out.println("A " + rooms[currentRoom].describeSouthDoor() + " door leads South.");
            }
            
            // List commands
            System.out.println("\nINSTRUCTIONS (N,S,L,I,D,H) >\n");

            // Accept command
            String command;
            try { // This will work when CoffeeMaker is run from console.
                command = System.console().readLine();
            } catch(Exception e) { // This will work within IDEs.
                Scanner sc = new Scanner(System.in);
                command = sc.next();
            }

            // Handle command
            switch(command){
                case "N": case "n":
                    if( rooms[currentRoom].hasNorthDoor() ){
                        currentRoom++;
                    } else {
                        System.out.println("There's no door there!");
                    }
                    break;
                    
                case "S": case "s":
                    if( rooms[currentRoom].hasSouthDoor() ){
                        currentRoom--;
                    } else {
                        System.out.println("There's no door there!");
                    }
                    break;
                    
                case "L": case "l":
                    rooms[currentRoom].look(inventory);
                    break;
                    
                case "I": case "i":
                    inventory.checkInventory();
                    break;
                    
                case "D": case "d":
                    drink(inventory);
                    break;
                    
                case "H": case "h":
                    printHelp();
                    break;
                    
                default:
                    System.out.println("What?");
                    break;
            }
        }
    }
}