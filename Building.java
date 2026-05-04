public class Building implements BuildingRequirements {

    protected String name = "<Name Unknown>";
    protected String address = "<Address Unknown>";
    protected int nFloors = 1;

    /**
     * Constructor 
     * @param name
     * @param address
     * @param nFloors
     */
    public Building(String name, String address, int nFloors) {
        if (name != null) { this.name = name; }
        if (address != null) { this.address = address; } 
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
        this.nFloors = nFloors;
    }

    /**
     * Accessor for the name attribute of the Building
     * @return String name of Building
     */
    public String getName() {
        return this.name;
    }

    /**
     * Accessor for the adress attribute of the Building
     * @return String address of building
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Accessor for the nFloors attribute of the Building
     * @return int number of floors in building 
     */
    public int getFloors() {
        return this.nFloors;
    }

    /** Pretty Print function
     * @return String returns a String that prints description/attributes of the object
     */
    public String toString() {
        return this.name + " is a " + this.nFloors + "-story building located at " + this.address;
    }

    public static void main(String[] args) {
        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        System.out.println(fordHall);
    }

}
