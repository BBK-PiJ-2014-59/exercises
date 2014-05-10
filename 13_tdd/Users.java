public interface Users {
  boolean idExists(int ID);
  boolean nameExists(String name);
  /**
    * Returns the ID of a person for a given name in this library. If the person does not have an ID yet, 
    * a new unique ID is created and returned. Any subsequent calls to this method with the same name 
    * argument should return the same ID.
    * @return User ID 
    */
  int getID(String name);
  int count();
  boolean add(User user);
  User getUserByID(int ID);
}
