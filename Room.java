package CoffeeMakerRemake;

public class Room{
    private String roomAttribute;
    private String roomFurniture;
    
    private String northDoor;
    private String southDoor;
    
    private String item;
    
    public Room(String att, String furn, String north, String south){
        roomAttribute = att;
        roomFurniture = furn;
        northDoor = north;
        southDoor = south;
    }
    
    public Room(String att, String furn, String north, String south, String i){
        roomAttribute = att;
        roomFurniture = furn;
        northDoor = north;
        southDoor = south;
        
        item = i;
    }
    
    public String describeRoomAttribute(){
        return roomAttribute;
    }
    
    public String describeRoomFurniture(){
        return roomFurniture;
    }
    
    public boolean hasNorthDoor(){
        return (northDoor != "DNE");
    }
    
    public String describeNorthDoor(){
        return northDoor;
    }
    
    public boolean hasSouthDoor(){
        return (southDoor != "DNE");
    }
    
    public String describeSouthDoor(){
        return southDoor;
    }
    
    public void look(Inventory inventory){
        if(item != null){
            System.out.println("There might be something here...");
            System.out.println("You found some " + item + "!");
            
            if(item == "caffinated coffee"){
                inventory.foundCoffee();
            } else if(item == "sweet sugar"){
                inventory.foundSugar();
            } else if(item == "creamy cream"){
                inventory.foundCream();
            } else {
                System.out.println("Holy Moth-Balls Batman! You found something you shouldn't have!");
            }
        } else {
            System.out.println("You don't see anything out of the ordinary.");
        }
        
    }
}