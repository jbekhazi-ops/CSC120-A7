/* This is a stub for the Library class */

import java.util.Hashtable;

public class Library extends Building implements LibraryRequirements{
  private Hashtable<String, Boolean>  collection;

    /**
     * Constructor
     * @param name
     * @param address
     * @param nFloors
     */
    public Library(String name, String address, int nFloors){
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>(); // initialized to an empty `Hashtable<String, Boolean>
      System.out.println("You have built a library: 📖");
    }

    /**
     * Updates the `Hashtable` containing the `collection` every time we add a title.
     * This function also marks the book added as available 
     * @param title of the book we are adding to the collection
     */
    public void addTitle(String title){
      if (this.collection.containsKey(title) == false ){
        this.collection.put(title,true);
      } else{
        throw new RuntimeException("This book is already in the collection");
      }
    }

    /**
     * Updates the `Hashtable` containing the `collection` every time we remove a title.
     * @param title of the book being removed from the collection
     * @return the title of the book removed 
     */
    public String removeTitle(String title){
      if (this.collection.containsKey(title)){
        this.collection.remove(title);
      } else{
        throw new RuntimeException("This book does not exist in the collection");
      }
      return title;
    }

    /** Check out a book
     * Changes the value of the book in the Hashtable to false
     * @param title of the book being checked out
     */
    public void checkOut(String title){
      if (this.collection.containsKey(title) && this.collection.get(title) == true){
      this.collection.replace(title, true, false); //replace(K key, V oldValue, V newValue)
      } else if (this.collection.containsKey(title) && this.collection.get(title) == false){
        throw new RuntimeException("This book is already checked out.");
      } else{
      throw new RuntimeException("We do not have this book in our collection.");
      } 

    }

    /** Check in a book (book is returned to collection)
     * Changes the value of the book in the Hashtable to true
     * @param title of the book being checked in
     */
    public void returnBook(String title){
      if (this.collection.containsKey(title)){
      this.collection.replace(title, false, true); //replace(K key, V oldValue, V newValue)
      } else {
      throw new RuntimeException("This book does not belong to our collection.");
    }
  }
    
    
    /** returns true if the title appears as a key in the Libary's collection, false otherwise
     * @param title of the book we are checking for
     * @return boolean true: if book in inventory, false if it isnt
     */
    public boolean containsTitle(String title){
      return this.collection.containsKey(title);
    }

    /**
     * returns true if the title is currently available, false otherwise
     * @param title of the book being checked for availability.
     * @return true if book is available, false if it isnt 
     */
    public boolean isAvailable(String title){
      boolean returnBool;
      if (this.collection.containsKey(title)){
      returnBool = this.collection.get(title);
      } else {
        throw new RuntimeException("We do not have this book in our collection");
      }
      return returnBool; //what is it gonna return if it runs into RuntimeException??/
    }

    /**
     * prints out the entire collection in an easy-to-read way (including checkout status)
     */
    public void printCollection(){
      System.out.println(this.collection.toString()); // is this easy to read?
    }
  
    public static void main(String[] args) {
      Library myLibrary = new Library("Hillyer Library", "22 Elm St", 3);
      myLibrary.addTitle("Les bonnes by Jean Genet");
      myLibrary.printCollection();
      try{
      myLibrary.removeTitle("Les bonnes ");
      } catch(Exception e){
        System.out.println(e.getLocalizedMessage());
      }
      myLibrary.printCollection();
    }
  
  }