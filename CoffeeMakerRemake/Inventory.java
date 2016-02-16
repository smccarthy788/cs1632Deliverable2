package CoffeeMakerRemake;

public class Inventory {
    private boolean coffee;
    private boolean sugar;
    private boolean cream;
    
    public Inventory(){
        coffee = false;
        sugar = false;
        cream = false;
    }
    
    public void foundCoffee(){
        coffee = true;
    }
    
    public void foundSugar(){
        sugar = true;
    }
    
    public void foundCream(){
        cream = true;
    }

    public boolean haveCoffee() {return coffee;}

    public boolean haveCream() {return cream;}

    public boolean haveSugar() {return sugar;}
    
    public void checkInventory(){
        if(coffee){
            System.out.println("You have a cup of delicious coffee.");
        } else {
            System.out.println("YOU HAVE NO COFFEE!");
        }
        if(cream){
            System.out.println("You have some fresh cream.");
        } else {
            System.out.println("YOU HAVE NO CREAM!");
        }
        if(sugar){
            System.out.println("You have some tasty sugar.");
        } else {
            System.out.println("YOU HAVE NO SUGAR!");
        }
    }
    
    public boolean isInventoryFull(){
        return(coffee && sugar && cream);
    }
    
    public boolean isInventoryEmpty(){
        return(!coffee && !sugar && !cream);
    }
}