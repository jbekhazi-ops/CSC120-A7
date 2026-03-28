/* This is a stub for the House class */

import java.util.ArrayList;

public class House extends Building{

  private ArrayList<Student> residents;  // The <Student> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;


  public House(String name, String address, int nFloors, boolean DiningRoom){
    super(name, address, nFloors);
    this.hasDiningRoom = DiningRoom;
    this.residents = new ArrayList<Student>();
    System.out.println("You have built a house: 🏠");
  }

  /** Accessor for hasDiningRoom attribute
   * @return bool, whether or not the house has a dining hall
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }
  
  /** Accessor for nResidents attributes 
   * @return the number of residents in the house
   */
  public int nResidents(){
    return this.residents.size();
  } 

  /**
   * Updates the `ArrayList` of `residents` every time someone moves in.
   * @param s The student being added to the residents list.
   */
  public void moveIn(Student s){
    if (this.residents.contains(s) == false){
      this.residents.add(s);
    } else{
      throw new RuntimeException("This resident is already in the house");
    }
  }

  /**
   * Updates the `ArrayList` of `residents` every time someone moves out.
   * @param s The student being removed from the residents list.
   * @return  returns the Student who moved out
   */
  public Student moveOut(Student s){ 
    if (this.residents.contains(s)){
      this.residents.remove(s);
    } else{
      //s = null; //IS THIS GOOD??
      throw new RuntimeException("This resident does not live in this house");
    }
    return s; //What is the purpose of this? I feel like a statement lile Student s has moved out would be more useful (like the one at the end)
  } 

  /** For security reasons, we don't want to provide direct access to the entire list of residents
   * This method tells us whether or not a given person is a resident of the `House` 
   * @param s The student we are checking for 
   * @return boolean, returns true if the student is in the house, false otherwise 
   */
  public boolean isResident(Student s){
    boolean booleanResident;
    if (this.residents.contains(s)){
      booleanResident = true;
    } else{
      booleanResident = false;
    }
    return booleanResident;
  }


  public static void main(String[] args) {
    House chaseHouse = new House("Chase House", "41 elm Street" , 3, true);
    Student Juliane = new Student("Juliane","12345",2027);
    System.out.println(chaseHouse.isResident(Juliane));
    chaseHouse.moveIn(Juliane);
    //System.out.println(chaseHouse.moveOut(Juliane));
    System.out.println(chaseHouse.nResidents());
  }
}
