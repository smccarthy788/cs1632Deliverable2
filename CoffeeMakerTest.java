import CoffeeMakerRemake.*;
import org.junit.*;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class CoffeeMakerTest {

    // Newly initialized inventory tests

    // A newly initiated inventory should have all items set to false.
    // isInventoryEmpty() should be true, isInventoryFull() should be false

    // coffee should be false
    @Test
    public void newInventoryCoffee(){
        Inventory inventory = new Inventory();
        assertFalse(inventory.haveCoffee());
    }

    // cream should be false
    @Test
    public void newInventoryCream(){
        Inventory inventory = new Inventory();
        assertFalse(inventory.haveCream());
    }

    // sugar should be false
    @Test
    public void newInventorySugar(){
        Inventory inventory = new Inventory();
        assertFalse(inventory.haveSugar());
    }

    // inventory should be empty
    @Test
    public void newInventoryEmpty(){
        Inventory inventory = new Inventory();
        assertTrue(inventory.isInventoryEmpty());
    }

    // inventory should not be full
    @Test
    public void newInventoryNotFull(){
        Inventory inventory = new Inventory();
        assertFalse(inventory.isInventoryFull());
    }

    // Newly initialized Room tests /////////////////////////////////

    // New rooms should have roomAttribute, roomFurniture, northDoor, and southDoor values

    // Room without item has roomAttribute.
    @Test
    public void newRoomAttribute(){
        Room room = new Room("Att", "Furn", "North", "South");
        assertEquals("Att", room.describeRoomAttribute());
    }

    // Room without item has roomFurniture.
    @Test
    public void newRoomFuriture(){
        Room room = new Room("Att", "Furn", "North", "South");
        assertEquals("Furn", room.describeRoomFurniture());
    }

    // Room without item has northDoor.
    @Test
    public void newRoomNorthDoor(){
        Room room = new Room("Att", "Furn", "North", "South");
        assertEquals("North", room.describeNorthDoor());
    }

    // Room without item has southDoor.
    @Test
    public void newRoomSouthDoor(){
        Room room = new Room("Att", "Furn", "North", "South");
        assertEquals("South", room.describeSouthDoor());
    }

    // Room with item has roomAttribute.
    @Test
    public void newItemRoomAttribute(){
        Room room = new Room("Att", "Furn", "North", "South", "Item");
        assertEquals("Att", room.describeRoomAttribute());
    }

    // Room with item has roomFurniture.
    @Test
    public void newItemRoomFurniture(){
        Room room = new Room("Att", "Furn", "North", "South", "Item");
        assertEquals("Furn", room.describeRoomFurniture());
    }

    // Room with item has northDoor.
    @Test
    public void newItemRoomHasNorthDoor(){
        Room room = new Room("Att", "Furn", "North", "South", "Item");
        assertTrue(room.hasNorthDoor());
    }

    // Room with item has northDoor description.
    @Test
    public void newItemRoomNorthDoor(){
        Room room = new Room("Att", "Furn", "North", "South", "Item");
        assertEquals("North", room.describeNorthDoor());
    }

    // Room with item has southDoor.
    @Test
    public void newItemRoomHasSouthDoor(){
        Room room = new Room("Att", "Furn", "North", "South", "Item");
        assertTrue(room.hasSouthDoor());
    }

    // Room with item has southDoor description.
    @Test
    public void newItemRoomSouthDoor(){
        Room room = new Room("Att", "Furn", "North", "South", "Item");
        assertEquals("South", room.describeSouthDoor());
    }

    // Room with item has item.
    @Test
    public void newItemRoomItem(){
        Room room = new Room("Att", "Furn", "North", "South", "Item");
        assertEquals("Item", room.describeItem());
    }

    // Newly initialized CoffeeMaker tests /////////////////////////////////

    // rooms should have 6 members, 3 of which should contain items.
    // inventory should be created.

    // CoffeeMaker room membership test.
    // rooms should have 6 members.
    @Test
    public void coffeeMakerInitializedRoomsTest(){
        CoffeeMaker cm = new CoffeeMaker();
        Room[] rooms = cm.initializeRooms();
        assertEquals(6, rooms.length);
    }

    // CoffeeMaker room item test.
    // 3 rooms should have items.
    @Test
    public void coffeeMakerInitializedItemTest(){
        Room[] rooms = CoffeeMaker.initializeRooms();
        int counter = 0;
        for(int i = 0; i < 6; i++){
            if(rooms[i].describeItem() != null){
                counter++;
            }
        }
        assertEquals(3, counter);
    }

    // CoffeeMaker.initializeInventory() should return a new inventory.
    @Test
    public void coffeeMakerInitializeInventoryTest(){
        Inventory inventory = CoffeeMaker.initializeInventory();
        assertTrue(inventory instanceof Inventory );
    }

    // initializeInventory() should return empty inventory.
    @Test
    public void coffeeMakerInitializeEmptyInventoryTest(){
        Inventory inventory = CoffeeMaker.initializeInventory();
        assertTrue(inventory.isInventoryEmpty());
    }

    // initializeInventory() should return empty inventory.
    @Test
    public void coffeeMakerInitializeNonFullInventoryTest(){
        Inventory inventory = CoffeeMaker.initializeInventory();
        assertFalse(inventory.isInventoryFull());
    }

    // Gameplay tests ///////////////////////////////////////////

    // Inventory should be able to find items.

    // When foundCoffee() is executed, haveCoffee should be true
    @Test
    public void foundCoffeeTest(){
        Inventory inventory = new Inventory();
        inventory.foundCoffee();
        assertTrue(inventory.haveCoffee());
    }

    // When foundCream() is executed, haveCream should be true
    @Test
    public void foundCreamTest(){
        Inventory inventory = new Inventory();
        inventory.foundCream();
        assertTrue(inventory.haveCream());
    }

    // When foundSugar() is executed, haveSugar should be true
    @Test
    public void foundSugarTest(){
        Inventory inventory = new Inventory();
        inventory.foundSugar();
        assertTrue(inventory.haveSugar());
    }

    // When items are found, isInventoryFull() should be false until all items are found

    // When only inventory item is coffee, isInventoryFull() should return false
    @Test
    public void onlyCoffeeNotFullTest(){
        Inventory inventory = new Inventory();
        inventory.foundCoffee();
        assertFalse(inventory.isInventoryFull());
    }

    // When only inventory item is coffee, isInventoryFull() should return false
    @Test
    public void onlyCreamNotFullTest(){
        Inventory inventory = new Inventory();
        inventory.foundCream();
        assertFalse(inventory.isInventoryFull());
    }

    // When only inventory item is coffee, isInventoryFull() should return false
    @Test
    public void onlySugarNotFullTest(){
        Inventory inventory = new Inventory();
        inventory.foundSugar();
        assertFalse(inventory.isInventoryFull());
    }

    // When only inventory item is coffee, isInventoryFull() should return false
    @Test
    public void onlyCoffeeNotEmptyTest(){
        Inventory inventory = new Inventory();
        inventory.foundCoffee();
        assertFalse(inventory.isInventoryEmpty());
    }

    // When only inventory item is coffee, isInventoryFull() should return false
    @Test
    public void onlyCreamNotEmptyTest(){
        Inventory inventory = new Inventory();
        inventory.foundCream();
        assertFalse(inventory.isInventoryEmpty());
    }

    // When only inventory item is coffee, isInventoryFull() should return false
    @Test
    public void onlySugarNotEmptyTest(){
        Inventory inventory = new Inventory();
        inventory.foundSugar();
        assertFalse(inventory.isInventoryEmpty());
    }


    // look() should find an item in a room with an item
    @Test
    public void lookFindItemTest(){
        Room mockRoom = mock(Room.class);
        when(mockRoom.describeItem()).thenReturn("Coffee");

        Inventory mockInventory = mock(Inventory.class);
        verify(mockInventory, times(1)).foundCoffee();
        verify(mockInventory, never()).foundCream();
        verify(mockInventory, never()).foundSugar();
    }

    // look() should not find an item in a room without an item
    @Test
    public void lookNoItemTest(){
        Room mockRoom = mock(Room.class);
        when(mockRoom.describeItem()).thenReturn(null);

        Inventory mockInventory = mock(Inventory.class);
        verify(mockInventory, never()).foundCoffee();
        verify(mockInventory, never()).foundCream();
        verify(mockInventory, never()).foundSugar();
    }


    // drink() should win if all items are found.

    @Test
    public void drinkWinTest(){
        Inventory mockInventory = mock(Inventory.class); // doubled Inventory Class
        when(mockInventory.haveCoffee()).thenReturn(true);
        when(mockInventory.haveCream()).thenReturn(true);
        when(mockInventory.haveSugar()).thenReturn(true);
        CoffeeMaker.drink(mockInventory);


    }



    /*
    / Each class should have certain properties upon creation:
    /
    /Inventory
        - All items should be false
        - isInventoryFull() should return false
        - isInventoryEmpty() should return true
        - checkInventory() should return "YOU HAVE NO [item]" etc. (x3)
    /
    /Room
        - roomAttribute, roomFurniture, northDoor, and southDoor are not NULL
        - iff Room isn't created with item, there is no item field
    /
    /CoffeeMaker
        - rooms[] & inventory
    /
    / Methods which are used during gameplay:
      - Room
        - describes, hasDoors, look()
      - Inventory
        - founds, checkInventory(for all combinations), isFull/Empty
      - CoffeeMaker
        - initializeRooms(), drink(), printHelp()

    initializeRooms[], drink(), & printHelp()
    /
    /
    */









}