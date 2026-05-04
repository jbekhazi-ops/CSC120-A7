/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements {
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

   /**
    * Constructor
    * @param name
    * @param address
    * @param nFloors
    * @param initialnCoffeeOunces
    * @param initialnSugarPackets
    * @param initialnCreams
    * @param initialnCups
    */
    public Cafe(String name, String address, int nFloors, int initialnCoffeeOunces, int initialnSugarPackets, int initialnCreams, int initialnCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = initialnCoffeeOunces;
        this.nSugarPackets =  initialnSugarPackets;
        this.nCreams = initialnCreams;
        this.nCups = initialnCups; 
        System.out.println("You have built a cafe: ☕");
    }

    /** 
     * Method that decreases the remaining inventory when the `Cafe` sells a cup of coffee
     * @param size The size in coffee ounces of the drink being sold
     * @param nSugarPackets The amount of sugar packets used to make this coffee
     * @param nCreams The amount of creams used to make this coffee
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (this.nCoffeeOunces >= size && this.nSugarPackets >= nSugarPackets && this.nCreams >= nCreams && this.nCups >= 1){
        this.nCoffeeOunces -= size;
        this.nSugarPackets -=  nSugarPackets;
        this.nCreams -=  nCreams;
        this.nCups -= 1;
        } else {
            restock(size, nSugarPackets, nCreams, 1);
            this.nCoffeeOunces -= size;
            this.nSugarPackets -=  nSugarPackets;
            this.nCreams -=  nCreams;
            this.nCups -= 1;
        }
    }

    /** Method that allows us to restock the cafe when necessary 
     * private method since we don't want some random person forcefully restocking the shelves! 
     * @param nCoffeeOunces  The amount of coffee ounces we are restocking for 
     * @param nSugarPackets The amount of sugar packets we are restocking for 
     * @param nCreams The amount of creams we are restocking for 
     * @param nCups The amount of cups we are restocking for 
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets +=  nSugarPackets;
        this.nCreams +=  nCreams;
        this.nCups += nCups;
    }

    /**
     * returns the stock 
     */
    public String toString(){
        return ("Remaining amount in stock: " + this.nCoffeeOunces +  " Coffee Ounces, " + this.nSugarPackets + " Sugar Packets, " + this.nCreams + " Creams, " + this.nCups + " nCups.");
    }

    
    public static void main(String[] args) {
        Cafe campusCafe = new Cafe("CC Cafe", "100 Elm St", 1, 100, 100, 100, 100);
        campusCafe.sellCoffee(3, 5, 7);
        System.out.println(campusCafe);

    }
    
}


